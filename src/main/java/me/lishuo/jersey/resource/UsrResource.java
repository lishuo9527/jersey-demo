package me.lishuo.jersey.resource;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import me.lishuo.domain.HttpConstant;

/**
 * 
 * @Description: usrService resource
 * @author lis
 * @date 2016年4月12日
 * @version V1.0
 */

@Path(HttpConstant.P_USR)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public class UsrResource extends AbstractResource {
	@Context
	HttpServletRequest request;

	@Context
	HttpServletResponse response;

	@Context
	ServletConfig servletConfig;

	@Context
	ServletContext servletContext;

	@Context
	HttpHeaders header;

	@Context
	UriInfo info;

	@POST
	@Path(HttpConstant.P_TEST)
	public Response test(MultivaluedMap<String, String> req) throws Exception {
		Map<String, Object> rsp = new HashMap<String, Object>();
		usrService.test(rsp, buildRequest(info, req));
		return buildRespouse(rsp);
	}
	
}
