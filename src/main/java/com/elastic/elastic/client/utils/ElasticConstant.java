package com.elastic.elastic.client.utils;

/**
 * @Description 常量类
 * @Author lvdi
 * @Date 15:54 2020/8/11
 **/
public class ElasticConstant {

    private ElasticConstant() {
    }

    /**
     * 默认操作人 createdBy,updatedBy
     */
    public static final String OPERATOR = "SYS";

    /**
     * 字符串分隔符-
     */
    public static final String UUID_SPLIT_STR= "-";

    /**
     * 空字符串
     */
    public static final String EMPTY_STR= "";

    /**
     * 处理时出错
     */
    public static final String RES_CODE_500 = "500";

    /**
     * 处理成功
     */
    public static final String RES_CODE_200 = "200";

	/**
	 * 调用订单dubbo接口超时
	 */
	public static final String ORDER_DUBBO_SERVER_FAIL = "调用订单dubbo接口超时";

	/**
	 * 调用ofc线路dubbo接口超时
	 */
	public static final String OFC_DUBBO_SERVER_FAIL = "调用ofc线路dubbo接口超时";

	/**
	 * 今日暂无此线路价格
	 */
	public static final String OFC_NO_ROUTE_PRICE = "今日暂无此线路价格";

	/**
	 * 您已签约该线路，请直接使用签约线路下单
	 */
	public static final String OFC_CUSTOMER_PRICE = "您已签约该线路，请直接使用签约线路下单 ";

	/**
	 * 调用临调dubbo接口超时
	 */
	public static final String LD_DUBBO_SERVER_FAIL = "调用临调dubbo接口超时";

	/**
	 * 调用定位dubbo接口超时
	 */
	public static final String GPS_DUBBO_SERVER_FAIL = "调用定位dubbo接口超时";

	/**
	 * 调用结算dubbo接口超时
	 */
	public static final String FIN_DUBBO_SERVER_FAIL = "调用结算dubbo接口超时";

	/**
	 * 调用虚拟号dubbo接口超时
	 */
	public static final String OFC_VIRTUAL_DUBBO_SERVER_FAIL = "调用虚拟号dubbo接口超时";

	/**
	 * 调用发车申请dubbo接口超时
	 */
	public static final String OFC_DEPART_NO_DUBBO_SERVER_FAIL = "调用发车申请dubbo接口超时";

	/**
	 * 调用会员接口超时
	 */
	public static final String MEMBER_DUBBO_SERVER_FAIL = "调用会员dubbo接口超时";

	/**
	 * 调用优惠卷接口超时
	 */
	public static final String FAS_DUBBO_SERVER_FAIL = "调用优惠卷dubbo接口超时";

	/**
	 * 服务器跑丢了，请稍后再试~
	 */
	public static final String SYS_SERVER_ERROR = "服务器跑丢了，请稍后再试~";

	/**
	 * 接口调用成功
	 */
	public static final String SYS_SERVER_SUCCESS = "接口调用成功";

	/**
	 * 获取城市名称失败
	 */
	public static final String CITY_NAME_SEARCH_ERROR = "城市名称获取失败";

    /**
     * 手机端异常统一返回
     */
    public static final String UT_WEB_MOBILE_ERROR_MSG = "网络异常，请刷新后重试";
    
	/**
	 * byte类型表示的true值
	 */
	public static final byte BYTE_TRUE = 1;

	/**
	 * byte类型表示的false值
	 */
	public static final byte BYTE_FALSE = 0;

	/**
	 * 逻辑删除-否
	 */
	public static final int IS_DELETE_0 = 0;

	/**
	 * 逻辑删除-是
	 */
	public static final int IS_DELETE_1 = 1;
	
	/**
	 * 逻辑删除-否
	 */
	public static final byte DELETE_0 = 0;

	/**
	 * 逻辑删除-是
	 */
	public static final byte DELETE_1 = 1;
	
	public static final int VERSION_1 = 1;

	public static final int VERSION_0 = 0;
	
	/**
	 * 字符串分隔符 ,
	 */
	public static final String SPLIT_OPERATE_TYPE1 = ",";
	/**
	 * 字符串分隔符 ;
	 */
	public static final String SPLIT_OPERATE_TYPE2 = ";";
	/**
	 * 字符串分隔符 [
	 */
	public static final String SPLIT_OPERATE_TYPE3 = "[";
	/**
	 * 字符串分隔符 ]
	 */
	public static final String SPLIT_OPERATE_TYPE4 = "]";
	/**
	 * 字符串分隔符 {
	 */
	public static final String SPLIT_OPERATE_TYPE5 = "{";
	/**
	 * 字符串分隔符 }
	 */
	public static final String SPLIT_OPERATE_TYPE6 = "}";
	/**
	 * 字符串分隔符-
	 */
	public static final String SPLIT_OPERATE_TYPE7 = "-";
	/**
	 * 字符拼接类型
	 */
	public static final String REPLACE_EMPTY_TYPE = "";

	/**
	 * 前置规则-支持装货点数
	 */
	public static final String BUSINESS_RULES_PRECHECK_SUPPORTLOAD = "business.rules.precheck.supportload";

	/**
	 * 前置规则-支持卸货点数
	 */
	public static final String BUSINESS_RULES_PRECHECK_SUPPORTUNLOAD = "business.rules.precheck.supportunload";

	/**
	 * 前置规则-吨位限制（吨）
	 */
	public static final String BUSINESS_RULES_PRECHECK_WEIGHTLIMIT = "business.rules.precheck.weightlimit";

	/**
	 * 前置规则-体积限制（方）
	 */
	public static final String BUSINESS_RULES_PRECHECK_VOLUMELIMIT = "business.rules.precheck.volumelimit";

	/**
	 * 前置规则-挂厢选择项：铝箱aluminum/定挂fixed
	 */
	public static final String BUSINESS_RULES_PRECHECK_CONTAINER = "business.rules.precheck.container";

	/**
	 * 前置规则-支持保险服务：水湿险/货运险/保价费
	 */
	public static final String BUSINESS_RULES_PRECHECK_INSURANCE = "business.rules.precheck.insurance";

	/**
	 * 前置规则-上游支付-需要预付金：X元
	 */
	public static final String BUSINESS_RULES_PRECHECK_PREPAYMENT = "business.rules.precheck.prepayment";

	/**
	 * 商务配置-水湿险 元/单
	 */
	public static final String BUSINESS_RULES_BUSINESS_WATERINSURANCE = "business.rules.business.waterinsurance";

	/**
	 * 商务配置-货运险 元/单
	 */
	public static final String BUSINESS_RULES_BUSINESS_FREIGHTINSURANCE = "business.rules.business.freightinsurance";

	/**
	 * 商务配置-保价费 元/单
	 */
	public static final String BUSINESS_RULES_BUSINESS_DAMAGEINSURANCE = "business.rules.business.damageinsurance";

	/**
	 * ios
	 */
	public static final String MOBILE_TYPE_IOS = "IOS";
	/**
	 * 出发地类型
	 */
	public static final String DEPART_TYPE = "C";

	/**
	 * 目的地类型
	 */
	public static final String ARRIVE_TYPE = "M";

	/**
	 * 卡航的校验客户下单权限返回的code
	 * -1: 没有客户关系
	 */
	public static final String KH_VALID_CUSTOMER_MINUS_ONE= "-1";

	/**
	 * 安卓
	 */
	public static final String MOBILE_TYPE_ANDROID = "ANDROID";
	/**
	 * 0: 没有被限制，也不提示
	 */
	public static final String KH_VALID_CUSTOMER_ZERO= "0";

	/**
	 * 1: 没有被限制，但有提示  （message中有具体提示信息）
	 */
	public static final String KH_VALID_CUSTOMER_ONE= "1";

	/**
	 * 2: 被限制（message中有具体限制原因）
	 */
	public static final String KH_VALID_CUSTOMER_TWO= "2";

	/**
	 * 订单状态-进行中
	 */
	public static final String ORDER_STATUS_IMG= "I";

	/**
	 * 订单状态-完成
	 */
	public static final String ORDER_STATUS_FINISH= "F";

	/**
	 * 卡航的APPCODE和PRODUCT_CODE
	 */
	public static final String KH_APP_PRODUCT_CODE = "MARSAPP";

	/**
	 * 签名字符集
	 */
	public static final String PAYMENT_SIGN_CHARSET = "UTF-8";

	/**
	 * 签名方式
	 */
	public static final String PAYMENT_SIGN_TYPE = "RSA";

	/**
	 * 支付方式---余额支付
	 */
	public static final String BALANCE = "BALANCE";

	/**
	 * 支付对象上下游类型
	 */
	public static final String PAYMENT_TARGET_CD_UP = "UP";

	/**
	 * 付款提示码（控制显示时间用）
	 */
	public static final Integer ERROR_CODE = 88888888;

	/**
	 * 下单提示code
	 */
	public static final String PROMPT_CODE = "99999999";

	/**
	 * 业务类型--临调
	 */
	public static final String BUSINESS_LD = "LD";

	/**
	 * 业务类型--卡航
	 */
	public static final String BUSINESS_KH = "KH";

	/**
	 * 卡航修改记录价格类型
	 */
	public static final String KH_PRICE_UPDATE_TYPE = "费用调整";

	/**
	 * 修改记录类型--上游
	 */
	public static final String UPDATE_RECORD_TYPE_SY = "SY";




}
