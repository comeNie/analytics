package com.orienttech.statics.commons.utils;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class SpringHolder {
	public static WebApplicationContext getApplicationContext(){
        return ContextLoader.getCurrentWebApplicationContext();
	};
	public static <T> T getBean(Class<T> clazz) {
		return getApplicationContext().getBean(clazz);
	}
	
}
