package com.example.restserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.restserver.entity.RestServer;

import java.util.List;

/**
 * @author wei.song
 * @description 针对表【rest_server】的数据库操作Service
 * @createDate 2023-07-02 23:04:41
 */
public interface RestServerService extends IService<RestServer> {

    /**
     * 排序
     *
     * @param args         args
     * @param naturalOrder 自然秩序
     * @return {@link List}<{@link T}>
     */
    <T> List<T> sort(List<T> args, Boolean naturalOrder);

}
