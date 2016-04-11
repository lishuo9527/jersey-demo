package me.lishuo.jersey.resource;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import me.lishuo.domain.ResponseMoudle;
import me.lishuo.domain.TestMsg;
import me.lishuo.jersey.exception.DaoException;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
public class TestResouce{

	@GET @Path("/getit")
	public String getIt() {
		return "got it!";
	}
	
	@GET @Path("/getit2")
	public String getIt2() {
		return "got it2!";
	}

	@GET @Path("/getmsg")
	public TestMsg getMsg(@DefaultValue("1") @QueryParam("id") String id) {
		TestMsg ts = new TestMsg(id,"aa");
		return ts;
	}
	
	@GET @Path("getmap")
	public ResponseMoudle getMap(){
		ResponseMoudle rm = new ResponseMoudle();
		Map<String, String> map =new HashMap<String,String>();
		map.put("testKey", "testValue");
		rm.setRspMap(map);
		return rm;
	}
	@GET @Path("excption")
	public String testException(){
		throw new DaoException("test exception");
	}

}
