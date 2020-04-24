package Util;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ResultBean<T> implements Serializable {

    private String statusCode;
    private T data;
    private String msg;

    public static <T> ResultBean error(String msg) {
        return new ResultBean("400",null,msg);
    }

    public static <T> ResultBean success(T data) {
        return new ResultBean("200",data,"返回成功");
    }

    public static  ResultBean success(String msg) {
        return new ResultBean("200",null,msg);
    }
}