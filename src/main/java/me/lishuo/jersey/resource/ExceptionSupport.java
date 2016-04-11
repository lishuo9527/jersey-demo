package me.lishuo.jersey.resource;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.lishuo.jersey.exception.BaseException;
import me.lishuo.jersey.exception.ExceptionCode;

/**
 * 统一异常处理器
 */
@Provider
public class ExceptionSupport implements ExceptionMapper<Exception> {

	private static Logger logger = LoggerFactory.getLogger(ExceptionSupport.class);

	@Context
	private HttpServletRequest request;


	/**
	 * 异常处理
	 * 
	 * @param exception
	 * @return 异常处理后的Response对象
	 */
	public Response toResponse(Exception exception) {
		String message = ExceptionCode.INTERNAL_SERVER_ERROR;
		Status statusCode = Status.INTERNAL_SERVER_ERROR;
		// 处理checked exception
		if (exception instanceof BaseException) {
			BaseException baseException = (BaseException) exception;
			String code = baseException.getCode();
			message = code;

		} else if (exception instanceof NotFoundException) {
			message = ExceptionCode.REQUEST_NOT_FOUND;
			statusCode = Status.NOT_FOUND;
		} 
		// checked exception和unchecked exception均被记录在日志里
		logger.error(message, exception);
		return Response.ok(message, MediaType.TEXT_PLAIN).status(statusCode)
				.build();
	}
}
