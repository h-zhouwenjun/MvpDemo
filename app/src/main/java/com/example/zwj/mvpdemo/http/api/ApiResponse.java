package com.example.zwj.mvpdemo.http.api;

public class ApiResponse<T> {
    private String code;
    private String message;
    private T data;
    private boolean result;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return message;
    }

    public void setMsg(String msg) {
        this.message = msg;
    }

    public T getDatas() {
        return data;
    }

    public void setDatas(T datas) {
        this.data = datas;
    }

}