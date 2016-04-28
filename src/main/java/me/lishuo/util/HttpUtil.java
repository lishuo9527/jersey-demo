package me.lishuo.util;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;


public class HttpUtil {

	/**
	 * If req not contains all mustParas , then return emptyList contains empty
	 * parameter
	 * 
	 * @param req
	 *            req parameters
	 * @param mustParas
	 *            parameter must not null
	 * @return list contains empty parameters
	 */
	public static List<String> mustReq(Map<String, String> req,
			String... mustParas) {
		if (req == null) {
			return Collections.emptyList();
		}

		return Arrays
				.stream(mustParas)
                .filter(key -> !(req.containsKey(key) && ObjectUtil
						.notEmpty(req.get(key)))).collect(toList());
	}
	
	/**
	 * If req not contains all mustParas , then return emptyList contains empty
	 * parameter
	 * 
	 * @param req
	 *            req parameters
	 * @param mustParas
	 *            parameter must not null
	 * @return list contains empty parameters
	 */
	public static List<String> mustReq(MultivaluedMap<String, String> req,
			String... mustParas) {
		if (req == null) {
			return Collections.emptyList();
		}
		return Arrays
				.stream(mustParas)
                .filter(key -> !(req.containsKey(key) && ObjectUtil
						.notEmpty(req.get(key)))).collect(toList());
	}

	public static boolean anyReq(MultivaluedMap<String, String> req, String... paras) {
		if (req == null || req.isEmpty()) {
			return false;
		}

		return Arrays.stream(paras).anyMatch(
				key -> req.containsKey(key)
						&& ObjectUtil.notEmpty(req.get(key)));
	}

}
