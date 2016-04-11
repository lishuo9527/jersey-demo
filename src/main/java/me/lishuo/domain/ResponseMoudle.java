package me.lishuo.domain;

import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseMoudle {
	private Map<String, String> rspMap;
	
	public ResponseMoudle() {
	}
	
	public Map<String, String> getRspMap() {
		return rspMap;
	}

	public void setRspMap(Map<String, String> rspMap) {
		this.rspMap = rspMap;
	}

}
