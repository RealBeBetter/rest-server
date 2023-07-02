package com.example.restserver.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.restserver.entity.RestServer;
import com.example.restserver.manager.RestServerFactory;
import com.example.restserver.manager.RestServerSort;
import com.example.restserver.mapper.RestServerMapper;
import com.example.restserver.service.RestServerService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wei.song
 * @description 针对表【rest_server】的数据库操作Service实现
 * @createDate 2023-07-02 23:04:41
 */
@Service
public class RestServerServiceImpl extends ServiceImpl<RestServerMapper, RestServer>
        implements RestServerService {

    @Override
    public <T> List<T> sort(List<T> args, Boolean naturalOrder) {
        if (ObjectUtil.isNull(naturalOrder)) {
            throw new IllegalArgumentException("Data sort error, please set comparing order.");
        }

        RestServerSort instance = null;

        for (T arg : args) {
            if (ObjectUtil.isNotNull(arg)) {
                T t = args.get(0);
                Class<?> clazz = t.getClass();
                instance = RestServerFactory.getInstance(clazz);
                break;
            }
        }

        if (ObjectUtil.isNull(instance)) {
            log.error("Data sort error, please set comparing data.");
            return args;
        }

        return instance.sortBeforeSave(args, naturalOrder);
    }

}




