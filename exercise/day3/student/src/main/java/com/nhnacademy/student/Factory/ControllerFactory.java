package com.nhnacademy.student.Factory;

import com.nhnacademy.student.Controller.Command;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Slf4j
public class ControllerFactory {
    private final ConcurrentMap<String, Object> beanMap = new ConcurrentHashMap<>();

    public void init(Set<Class<?>> c){
        for(Class<?> cls : c){
            if(cls.isAnnotationPresent(RequestMapping.class)) {

                RequestMapping requestMapping = cls.getAnnotation(RequestMapping.class);
                log.debug("method, vlaue:{}{}", requestMapping.method(), requestMapping.value());
                String key = requestMapping.method() + requestMapping.value();

                try {
                    Constructor<?> constructor = cls.getConstructor();
                    beanMap.put(key, constructor.newInstance());

                } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                         InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }

        }

    }

    public Object getBean(String method, String path) {
        String key = method+path;
        return beanMap.get(key);
    }
}
