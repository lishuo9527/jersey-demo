package me.lishuo.jersey.config;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;

public class APIApplication  extends ResourceConfig {
    public APIApplication() {
        //服务类所在的包路径  
        packages("me.lishuo.jersey.resource");  
        //注册JSON转换器  
        register(JacksonJsonProvider.class);  
    }
}
