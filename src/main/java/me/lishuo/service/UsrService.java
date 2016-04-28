package me.lishuo.service;

import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.lishuo.domain.RspCode;

/**
 * 
 * @author lis
 * @date 2016年4月12日
 * @version V1.0
 */
public class UsrService extends AbstractService {

	static Logger logger = LoggerFactory.getLogger(UsrService.class);

	public void test(Map<String, Object> rsp, MultivaluedMap<String, String> req){
		rsp.put(F_rspResult, req.getFirst(F_test));
		RspCode.setRspCode(rsp, RspCode.SUCCESS);
	}

}
