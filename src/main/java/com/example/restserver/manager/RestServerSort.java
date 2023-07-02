package com.example.restserver.manager;

import cn.hutool.core.util.ObjectUtil;
import com.example.restserver.entity.RestServer;
import com.example.restserver.service.RestServerService;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wei.song
 * @since 2023/7/2 23:11
 */
@Data
@Component
@SuppressWarnings("rawtypes, unchecked")
public abstract class RestServerSort {

    @Resource
    private RestServerService restServerService;

    /**
     * 排序
     *
     * @param args         args
     * @param naturalOrder 逆序or正序
     * @return {@link List}
     */
    protected abstract <T> List sort(List<T> args, Boolean naturalOrder);

    public <T> void save(List<T> args, List<T> data, String dataType) {
        RestServer restServer = RestServer.buildRestServer(args, data, dataType);
        restServerService.saveOrUpdate(restServer);
    }

    public final <T> List<T> sortBeforeSave(List<T> args, Boolean naturalOrder) {
        List<T> data = sortCollection(args, naturalOrder);
        T t = args.get(0);
        String dataType = t.getClass().toString();

        save(args, data, dataType);

        return data;
    }

    public <T> List<T> sortCollection(List<T> list, Boolean naturalOrder) {
        if (ObjectUtil.isNull(list)) {
            return Collections.emptyList();
        }

        if (naturalOrder) {
            return list.stream()
                    .sorted(Comparator.nullsLast((Comparator<? super T>) Comparator.naturalOrder()))
                    .collect(Collectors.toList());
        }

        return list.stream()
                .sorted(Comparator.nullsLast((Comparator<? super T>) Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }

}
