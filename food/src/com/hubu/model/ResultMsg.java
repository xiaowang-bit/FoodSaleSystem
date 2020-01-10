package com.hubu.model;

/**
 * @author star
 * @date 2020/1/10 11:25
 * @description 带对象和信息的返回类
 */
public class ResultMsg {
    private String msg;
    private boolean flag;
    private Object obj;

    public ResultMsg(String msg, boolean flag, Object obj) {
        this.msg = msg;
        this.flag = flag;
        this.obj = obj;
    }

    public ResultMsg() {
        super();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "ResultMsg{" +
                "msg='" + msg + '\'' +
                ", flag=" + flag +
                ", obj=" + obj +
                '}';
    }
}
