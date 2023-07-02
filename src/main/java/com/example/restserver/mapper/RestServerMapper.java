package com.example.restserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.restserver.entity.RestServer;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wei.song
 * @description 针对表【rest_server】的数据库操作Mapper
 * @createDate 2023-07-02 23:04:41
 * @Entity com.example.restserver.entity.RestServer
 */
@Mapper
public interface RestServerMapper extends BaseMapper<RestServer> {

}




