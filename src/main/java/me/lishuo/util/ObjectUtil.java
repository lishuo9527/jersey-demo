/**
 * 
 */
package me.lishuo.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ws.rs.core.MultivaluedMap;

import me.lishuo.jersey.exception.ExceptionCode;
import me.lishuo.jersey.exception.ServiceException;

public class ObjectUtil {
	private static final String MOBILE = "^(1[3|4|5|7|8][0-9])\\d{8}$";

	/**
	 * 
	 * @param obj
	 * @return true if obj is not empty,else is false
	 */
	public static boolean notEmpty(Object obj) {
		return (obj == null || "".equals(obj)) ? false : true;
	}

	public static boolean isEmpty(Object obj) {
		return obj == null || "".equals(obj);
	}

	public static boolean checkPattern(String pattern, String mobiles) {
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(mobiles);
		return m.matches();

	}

	/**
	 * @return the mobile
	 */
	public static String getMobile() {
		return MOBILE;
	}

	public Map<String, String> readConfig(String fileName) {
		Properties props = new Properties();
		Map<String, String> map = new HashMap<String, String>();
		try {
			InputStream in = getClass().getResourceAsStream("/" + fileName + ".properties");
			props.load(in);
			Enumeration<?> en = props.propertyNames();
			while (en.hasMoreElements()) {
				String key = (String) en.nextElement();
				String property = props.getProperty(key);
				map.put(key, property);
			}
		} catch (IOException e) {
			throw new ServiceException(e, ExceptionCode.READ_CONFIG_FAILED);
		}
		return map;
	}

	public static <K, V> void setDefault(MultivaluedMap<K, V> map, K key, V defVal) {
		if (!map.containsKey(key)) {
			map.add(key, defVal);
		}
	}

}
