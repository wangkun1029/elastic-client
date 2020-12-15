package com.elastic.elastic.client.config;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.elastic.elastic.client.utils.ApiResponse;
import com.elastic.elastic.client.utils.ElasticConstant;
import com.elastic.elastic.client.utils.InvocationLogDetail;
import com.elastic.elastic.client.utils.ResponseUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;


import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;

/**
 * 打印入参 和 出参
 */
@Aspect
@Component
public class PrintParamAspectConfig {

	private static Logger LOG = LoggerFactory.getLogger(PrintParamAspectConfig.class);

	private String disableMethodDetailedArgPattern;
	private String disableMethodDetailedReturnTypePattern;
	private String disableMethodDetailedReturnPattern;
	private String[] disableArgMethodNamePatterns;
	private String[] disableReturnMethodNamePatterns;
	private String[] disableReturnReturnTypePatterns;
	private PathMatcher matcher = new AntPathMatcher();

	@Pointcut("execution(* com.elastic.elastic.client.controller..*.*(..))")
	public void serviceApi() {
		LOG.info("=============初始化AOP===============");
	}

	@Around("serviceApi()")
	public Object log(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();

		Object[] args = pjp.getArgs();
		Object retVal = null;
		ApiResponse<?> response = null;
		try {
			retVal = pjp.proceed();
		} catch (ElasticException e) {
			LOG.warn("ElasticException！Time：{}，Reason：{}", new Date(System.currentTimeMillis()), e.getMessage());
			if(e.getErrorCode() == ElasticConstant.ERROR_CODE){
				StringBuilder str = new StringBuilder();
				str.append(e.getErrorCode());
				response = ResponseUtils.getFailApiResponse(e.getMessage(), str.toString());
			}else {
				response = ResponseUtils.getFailApiResponse(e.getMessage());
			}
		} catch (Exception e) {
			LOG.warn("Exception！Time：{}", new Date(System.currentTimeMillis()), e.getMessage(), e);
			response = ResponseUtils.getFailApiResponse(e.getMessage());
		} catch (Throwable e) {
			LOG.warn("Exception！Time：{}", new Date(System.currentTimeMillis()), e.getMessage(), e);
			response = ResponseUtils.getFailApiResponse(ElasticConstant.SYS_SERVER_ERROR);
		} finally {
			doLogging(pjp, start, retVal);
		}
		if(null == response){
			return retVal;
		}else{
			return response;
		}

	}

	private void doLogging(ProceedingJoinPoint pjp, long start, Object retVal) {
		long elapsedTimeInMillis = System.currentTimeMillis() - start;

		InvocationLogDetail logDetail = new InvocationLogDetail();

		logDetail.setElapsedTime((int) elapsedTimeInMillis);

		MethodSignature methodSig = (MethodSignature) pjp.getSignature();

		logDetail.setClassName(pjp.getTarget().toString());
		logDetail.setMethodName(methodSig.getName());

		logArguments(pjp, logDetail);

		logReturnValue(methodSig.getMethod(), retVal, logDetail);

		LOG.info(JSONObject.toJSONString(logDetail));
	}

	private void logReturnValue(Method method, Object retVal, InvocationLogDetail logDetail) {
		boolean isVoid = "void".equals(method.getReturnType().getName());

		boolean disableDetailedReturnLog = false;
		if (!isVoid) {
			disableDetailedReturnLog = isAnnotationPresentInCurrentOrInterfaces(method, DisableDetailedReturnLog.class);
			if ((null != disableMethodDetailedReturnTypePattern) && (!disableDetailedReturnLog)) {
				boolean find = matchAny(disableReturnReturnTypePatterns, method.getReturnType().getCanonicalName());
				if (find) {
					disableDetailedReturnLog = true;
				}
			}
			if ((null != disableMethodDetailedReturnPattern) && (!disableDetailedReturnLog)) {
				boolean find = matchAny(disableReturnMethodNamePatterns, method.getName());
				if (find) {
					disableDetailedReturnLog = true;
				}
			}
		}
		String retValAsString = null;
		if (isVoid) {
			retValAsString = "*(void)*";
		} else if (disableDetailedReturnLog) {
			retValAsString = "*(MASKED_VALUE)*";
		} else if (null == retVal) {
			retValAsString = "*(null)*";
		} else {
			try {
				retValAsString = JSONArray.toJSONString(retVal);
				//限制长度
				if(retValAsString.length()>1000) {
					retValAsString = retValAsString.substring(0, 1000)+"...(ignore more than 1000 characters)...";
				}

			} catch (IllegalStateException e) {
				retValAsString = "*(Error resolving return value)*";
				e.printStackTrace();
			}
		}
		logDetail.setReturnValue(retValAsString);
	}

	private void logArguments(ProceedingJoinPoint pjp, InvocationLogDetail logDetail) {
		MethodSignature methodSig = (MethodSignature) pjp.getSignature();
		Method method = methodSig.getMethod();

		boolean disableDetailedArgLog = isAnnotationPresentInCurrentOrInterfaces(method, DisableDetailedArgLog.class);
		if ((null != disableMethodDetailedArgPattern) && (!disableDetailedArgLog)) {
			boolean find = matchAny(disableArgMethodNamePatterns, method.getName());
			if (find) {
				disableDetailedArgLog = true;
			}
		}
		try {
			if (!disableDetailedArgLog) {
				
				String args = JSONArray.toJSONString(filterArgs(pjp.getArgs()));
				//限制长度
				if(args.length()>1000) {
					args = args.substring(0, 1000)+"...(ignore more than 1000 characters)...";
				}
				logDetail.setArguments(args);
			} else {
				logDetail.setArguments("*(MASKED_VALUE)*");
			}
		} catch (Exception e) {
			logDetail.setArguments("*(Error resolving arguments)*");
		}
	}
	
	//取出servletRequest，因为不能序列化ServletRequest，	ServletResponse
	private Object[] filterArgs(Object[] args)
	{
		ArrayList<Object> ret = new ArrayList<Object>();
		for(Object item : args) {
			if(item instanceof ServletRequest) {
				continue;
			}
			else if (item instanceof ServletResponse) {
				continue;
			}
			else {
				ret.add(item);
			}
		}
		return ret.toArray();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private boolean isAnnotationPresentInCurrentOrInterfaces(Method method, Class annotationCls) {
		boolean present = false;

		present = method.isAnnotationPresent(annotationCls);
		if (!present) {
			Class<?>[] interfaces = method.getDeclaringClass().getInterfaces();

			String methodName = method.getName();
			Class<?>[] parameterTypes = method.getParameterTypes();
			for (Class<?> clz : interfaces) {
				Method m = null;
				try {
					m = clz.getMethod(methodName, parameterTypes);
					if (null != m) {
						present = m.isAnnotationPresent(annotationCls);
						if (present) {
							break;
						}
					}
				} catch (NoSuchMethodException localNoSuchMethodException) {
				}
			}
		}
		return present;
	}

	private boolean matchAny(String[] patterns, String name) {
		if (null == patterns) {
			return false;
		}
		for (String pattern : patterns) {
			boolean match = matcher.match(pattern, name);
			if (match) {
				return true;
			}
		}
		return false;
	}
}
