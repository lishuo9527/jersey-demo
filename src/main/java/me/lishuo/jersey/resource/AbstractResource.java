package me.lishuo.jersey.resource;

import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.lishuo.domain.Fields;
import me.lishuo.service.UsrService;
import me.lishuo.util.JsonUtil;

public class AbstractResource implements Fields {

	static Logger logger = LoggerFactory.getLogger(AbstractResource.class);
	static UsrService usrService = new UsrService();


	public static MultivaluedMap<String, String> buildRequest(UriInfo info, MultivaluedMap<String, String> req) {
		logger.info("request url-> {} req-> {}", info.getPath(), JsonUtil.toJson(req));
		return req;
	}

	public static Response buildRespouse(Map<String, Object> rsp) {
		logger.info("response -> {}", JsonUtil.toJson(rsp));
		return Response.ok(JsonUtil.toJson(rsp), MediaType.APPLICATION_JSON).status(Status.OK)
				.header("Access-Control-Allow-Origin", "*").build();
	}
}
