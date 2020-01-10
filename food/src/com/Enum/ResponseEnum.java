package com.hubu.Enum;

//处理返回类的枚举类
public enum ResponseEnum {
      Success(200,"success"),   //成功
       Fail(400,"fail"),          //失败
       Null(300,"null"),   //类别不存在
       Repetition(500,"repetition"),     //重复
        NullAndRepetition(800,"nullAndRepetition");  //类别不存在且重复
      private int code;
      private String message;

    ResponseEnum(int code, String message) {
        this.code=code;
        this.message=message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
