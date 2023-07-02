package com.example.restserver.common;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONPath;
import lombok.Data;

import java.util.List;

/**
 * @author wei.song
 * @since 2023/7/2 22:18
 */
@Data
public class Return<T> {

    private T data;
    private String errorCode;
    private String errorMessage;
    private boolean hasErrors;

    public static <T> Return<T> success() {
        return success(null);
    }

    public static <T> Return<T> success(T data) {
        return success(data, null, null);
    }

    public static <T> Return<T> success(T data, String errorCode, String errorMessage) {
        return build(data, errorCode, errorMessage, false);
    }

    public static <T> Return<T> failed(String errorMessage) {
        return failed(null, null, errorMessage);
    }

    public static <T> Return<T> failed(T data, String errorCode, String errorMessage) {
        return build(data, errorCode, errorMessage, true);
    }

    public static Return<Void> failed(String errorCode, String errorMessage) {
        return build(null, errorCode, errorMessage, true);
    }

    public static Return<Void> build(boolean hasErrors) {
        return build(null, null, null, hasErrors);
    }

    public static <T> Return<T> build(boolean hasErrors, T data) {
        return build(data, null, null, hasErrors);
    }

    @SuppressWarnings("rawtypes, unchecked")
    public static <T> Return<T> build(T data, String errorCode, String errorMessage, boolean hasErrors) {
        Return ret = new Return();
        ret.data = data;
        ret.errorCode = errorCode;
        ret.errorMessage = errorMessage;
        ret.hasErrors = hasErrors;
        return ret;
    }

    public <E> T data(Class<T> clazz) {
        return JSON.parseObject(this.jsonString(), clazz);
    }

    public <E> List<T> dataList(Class<T> clazz) {
        return JSON.parseArray(this.jsonString(), clazz);
    }

    private String jsonString() {
        return this.data instanceof String ? (String) this.data : JSON.toJSONString(this.data);
    }

    private Object extract(String path) {
        return JSONPath.extract(this.jsonString(), path);
    }

    public <E> List<T> extractList(String path, Class<T> clazz) {
        return ((JSONArray) this.extract(path)).toJavaList(clazz);
    }
}
