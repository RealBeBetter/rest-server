package com.example.restserver.manager;

import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wei.song
 * @since 2023/7/2 23:19
 */
@Service
@SuppressWarnings("rawtypes")
public class IntegerSort extends RestServerSort {

    @Override
    protected <T> List sort(List<T> args, Boolean naturalOrder) {
        if (ObjectUtil.isNull(naturalOrder)) {
            throw new IllegalArgumentException("Integer sort error, please set comparing order.");
        }
        if (ObjectUtil.isNull(args)) {
            return Collections.emptyList();
        }

        List<Integer> integers = new ArrayList<>();
        for (T arg : args) {
            if (arg instanceof Integer) {
                integers.add((Integer) arg);
            }
        }

        return super.sortCollection(integers, naturalOrder);
    }


}
