package com.example.zwj.mvpdemo.http.api;
/**
 * <b>创建时间</b> 17/5/26 <br>
 *
 * @author zhouwenjun
 */

public class ApiResponse<T> {

    public String code;
    public String message;
    public T results;
    public boolean result;
    private boolean error;

}