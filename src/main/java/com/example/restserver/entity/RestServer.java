package com.example.restserver.entity;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author wei.song
 * @TableName rest_server
 * @date 2023/07/02 23:06
 */
@Data
@TableName(value = "rest_server")
public class RestServer implements Serializable {
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 参数
     */
    private String args;

    /**
     * 排序后数据
     */
    private String data;

    /**
     * 数据类型
     */
    private String dataType;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public RestServer() {
        Date currentData = new Date();
        this.createDate = currentData;
        this.updateDate = currentData;
    }

    public static <T> RestServer buildRestServer(List<T> args, List<T> data, String dataType) {
        RestServer restServer = new RestServer();
        restServer.setArgs(JSON.toJSONString(args));
        restServer.setData(JSON.toJSONString(data));
        restServer.setDataType(dataType);
        return restServer;
    }
}
