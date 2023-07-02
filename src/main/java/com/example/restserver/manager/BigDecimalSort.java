package com.example.restserver.manager;

import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wei.song
 * @since 2023/7/2 23:50
 */
@Service
@SuppressWarnings("rawtypes")
public class BigDecimalSort extends RestServerSort {

    @Override
    protected <T> List sort(List<T> args, Boolean naturalOrder) {
        if (ObjectUtil.isNull(naturalOrder)) {
            throw new IllegalArgumentException("BigDecimal sort error, please set comparing order.");
        }

        if (ObjectUtil.isNull(args)) {
            return Collections.emptyList();
        }

        List<BigDecimal> decimals = new ArrayList<>();
        for (T arg : args) {
            if (arg instanceof BigDecimal) {
                decimals.add((BigDecimal) arg);
            }
        }

        return super.sortCollection(decimals, naturalOrder);
    }
}
