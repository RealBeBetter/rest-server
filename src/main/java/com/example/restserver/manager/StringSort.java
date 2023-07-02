package com.example.restserver.manager;

import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wei.song
 * @since 2023/7/2 23:26
 */
@Service
@SuppressWarnings("rawtypes")
public class StringSort extends RestServerSort {

    @Override
    protected <T> List sort(List<T> args, Boolean naturalOrder) {
        if (ObjectUtil.isNull(naturalOrder)) {
            throw new IllegalArgumentException("String sort error, please set comparing order..");
        }
        if (ObjectUtil.isNull(args)) {
            return Collections.emptyList();
        }

        List<String> strings = new ArrayList<>();
        for (T arg : args) {
            if (arg instanceof String) {
                strings.add((String) arg);
            }
        }

        return super.sortCollection(strings, naturalOrder);
    }

}
