package me.lishuo.jersey.resource;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import me.lishuo.domain.RspCode;
import me.lishuo.util.JsonUtil;

/**   
* 
* @Description: 统一异常处理器 
* @author lis   
* @date 2016年4月12日
* @version V1.0   
*/
@Provider
public class ExceptionSupport extends AbstractResource implements ExceptionMapper<Exception> {

	
	/* 异常处理
	 * (non-Javadoc)
	 * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
	 */
	public Response toResponse(Exception exception) {
		String message = buildExceptionResponse(RspCode.SERVICE_EXCEPTION);
		Status statusCode = Status.OK;
		logger.error(message, exception);
		return Response.ok(message, MediaType.APPLICATION_JSON).status(statusCode).build();
	}

	/**
	 * @Description 构建异常响应
	 * @return
	 */
	public static String buildExceptionResponse(RspCode rspCode) {
		Map<String,Object> rsp = new HashMap<String,Object>();
		RspCode.setRspCode(rsp, rspCode);
		return JsonUtil.toJson(rsp);
	}
}
