package com.example.others;

public class Result {

    private static final String SUCCESS = "0";
    private static final String ERROR = "-1";

    private String code;
    private String msg;
    private Object data;

    public static Result success() {
        Result result = new Result();
        result.setCode(SUCCESS);
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result error(String msg) {
        Result result = new Result();
        result.setCode(ERROR);
        result.setMsg(msg);
        return result;
    }

    private void setMsg(String msg) {
        this.msg = msg;
    }

    private void setCode(String code) {
        this.code = code;
    }

    private void setData(Object data) {
        this.data = data;
    }

}