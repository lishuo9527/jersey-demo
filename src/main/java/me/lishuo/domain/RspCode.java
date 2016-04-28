package me.lishuo.domain;

import java.util.Map;

/**   
*  
* @author lis   
* @date 2016年4月12日
* @version V1.0   
*/
public enum RspCode {
	
    SUCCESS("00", "成功"), FAIL_UNKNOWN("-1", "未知错误"),

    /******************************* 核心服务[1,100) ********************************/
    NET_EXCEPTION("1", "网络连接异常"), PUSH_TYPE_ERROR("2", "推送类型异常"), PUSH_NOT_FOUND("3", "非法推送类型"), SERVICE_EXCEPTION("4",
            "服务异常"), RECORD_NOT_FOUND("5", "未找到记录"), API_PRIVILEGE_NOT_ALLOWED("6",
                    "API权限不允许"), 

    /******************************* HTTP相关[100,200) *****************************/
    HTTP_CONTENT_SIGN("100", "内容验证错误"), HTTP_HEAD_TOKEN("101", "ACCESS TOKEN失效"), HTTP_REQ_MUST_EMPTY(
            "102", "缺失必要参数"), HTTP_PATH_INVALID("103", "非法请求路径"),
    /******************************* 验证相关[200,300) ***********************************************/
    VCODE_INVALID("200", "验证码错误"),VCODE_TOO_FREQ("201", "验证码请求频繁"), MOBILE_INVALID("202","手机号码格式有误"),
    PASSWD_INVALID("203","密码长度应为8-16位"),PASSWD_NOT_CORRECT("204","密码错误"),
    /******************************* 数据库相关[300,400) *****************************/

    /******************************* 用户相关[1000,2000) *************************************************/

    

    ;

    public String code;
    public String desc;

    private RspCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    
    public static Map<String, Object> setRspCode(Map<String, Object> rsp, RspCode rc) {
        rsp.put(Fields.F_rspCode, rc.code);
        rsp.put(Fields.F_rspDesc, rc.desc);
		return rsp;
    }
}
