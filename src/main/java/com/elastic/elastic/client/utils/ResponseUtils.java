package com.elastic.elastic.client.utils;

import org.springframework.stereotype.Component;

@Component
public class ResponseUtils {

	public static <T> ApiResponse<T> getFailApiResponse(String message) {
		ApiResponse<T> response = new ApiResponse<T>();
		response.setSuccess(false);
		response.setCode(ElasticConstant.RES_CODE_500);
		response.setMessage(message);
		return response;
	}
	
	public static <T> ApiResponse<T> getFailApiBodyResponse(String message, T body) {
		ApiResponse<T> response = new ApiResponse<T>();
		response.setSuccess(false);
		response.setCode(ElasticConstant.RES_CODE_500);
		response.setMessage(message);
		response.setBody((T) message);
		return response;
	}

	public static <T> ApiResponse<T> getSuccessApiResponse(String message) {
		ApiResponse<T> response = new ApiResponse<T>();
		response.setSuccess(true);
		response.setCode(ElasticConstant.RES_CODE_200);
		response.setMessage(message);
		// response.setBody(body);
		return response;
	}

	public static <T> ApiResponse<T> getSuccessApiResponse(String message, T body) {
		ApiResponse<T> response = new ApiResponse<T>();
		response.setSuccess(true);
		response.setCode(ElasticConstant.RES_CODE_200);
		response.setMessage(message);
		response.setBody(body);
		return response;
	}
	
	public static <T> ApiResponse<T> getFailApiResponse(String message, String errorCode, T body) {
		ApiResponse<T> response = new ApiResponse<T>();
		response.setSuccess(false);
		response.setCode(errorCode);
		response.setMessage(message);
		response.setBody(body);
		return response;
	}
	
	public static <T> ApiResponse<T> getFailApiResponse(String message, String errorCode) {
		ApiResponse<T> response = new ApiResponse<T>();
		response.setSuccess(false);
		response.setCode(errorCode);
		response.setMessage(message);
		return response;
	}

}
