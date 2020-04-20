package com.carrot.testspring.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String,Object> map=super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("company","atcarrot");
        Object ext=webRequest.getAttribute("ext",0);
        map.put("ext",ext);
        return map;
    }
}
