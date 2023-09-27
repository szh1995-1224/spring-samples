package org.szh;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo01 {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Map<String, Object> container = new HashMap<>();
        ObjectMapper om = new ObjectMapper();
//        List<BeanDefinition> beanDefinitions = om.readValue(Demo01.class.getResourceAsStream("/beans.json"), new TypeReference<List<BeanDefinition>>() {
//            @Override
//            public Type getType() {
//                return super.getType();
//            }
//        });
        List<BeanDefinition> beanDefinitions = om.readValue(Demo01.class.getResourceAsStream("/beans.json"),
                new TypeReference<List<BeanDefinition>>() {});

        for (BeanDefinition item : beanDefinitions) {
            String id = item.getId();
            String clazz = item.getClazz();
            Object bean = Class.forName(clazz).getConstructor().newInstance();
            container.put(id, bean);
        }
        System.out.println("container = " + container);

    }
}
