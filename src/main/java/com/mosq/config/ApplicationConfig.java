package com.mosq.config;

import com.mosq.controller.TaskRestService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.*;

/**
 * Created by Serg on 01.10.2019.
 */
@ApplicationPath("/rs/*")
public class ApplicationConfig extends Application {

//    private final Set<Class<?>> classes;
//
//    public ApplicationConfig() {
//        HashSet<Class<?>>c=new HashSet<>();
//        c.add(TaskRestService.class);
//        this.classes = Collections.unmodifiableSet(c);
//    }
//
//    @Override
//    public Set<Class<?>> getClasses() {
//        return classes;
//    }
//
//        @Override
//    public Map<String, Object> getProperties() {
//        System.out.println("App config ... ");
//        Map<String,Object>properties=new HashMap<>();
//        properties.put("jersey.config.server.provider.packages","com.mosq");
//        return properties;
//    }
}
