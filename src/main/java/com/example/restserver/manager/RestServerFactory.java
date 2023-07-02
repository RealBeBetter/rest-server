package com.example.restserver.manager;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author wei.song
 * @since 2023/7/2 23:59
 */
@Component
public class RestServerFactory implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public static <T> RestServerSort getInstance(Class<T> clazz) {
        if (clazz == Integer.class) {
            return getBean(IntegerSort.class);
        } else if (clazz == String.class) {
            return getBean(StringSort.class);
        } else if (clazz == BigDecimal.class) {
            return getBean(BigDecimalSort.class);
        }

        throw new IllegalArgumentException("RestServer错误，需要为 BigDecimal、String、Integer 其中之一！");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        RestServerFactory.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> tClass) {
        return applicationContext.getBean(tClass);
    }
}
