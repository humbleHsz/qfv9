package Util;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ResultBean<T> implements Serializable {

    private String statusCode;
    private T data;

}