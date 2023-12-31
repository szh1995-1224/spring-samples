package org.szh.demo;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Profiles;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

import java.util.List;

public class MyProfileCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        MultiValueMap<String, Object> allAttrs = metadata.getAllAnnotationAttributes(MyProfile.class.getName());
        if (allAttrs != null) {
            List<Object> list = allAttrs.get("value");
            for (Object value : list) {
                boolean b = context.getEnvironment().acceptsProfiles(Profiles.of((String[]) value));
                if (b) {
                    return true;
                }

            }

        }
        return false;
    }
}
