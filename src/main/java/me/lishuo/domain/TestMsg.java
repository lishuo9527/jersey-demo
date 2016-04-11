package me.lishuo.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TestMsg {
	public String msg;
	public String msg1;

	public TestMsg(){}
	
	public TestMsg(String msg,String msg1) {
		this.msg =msg;
		this.msg1=msg1;
	}
}
