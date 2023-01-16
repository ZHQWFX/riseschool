package com.zhq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenchenchen
 * @create 2023-01-16 18:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private Integer code;
    private String message;
    private T data;
    public static<T> Result<T> ok(T data){
        return new Result<>(200,"执行成功!",data);
    }
    public static<T> Result<T> fail(){
        return new Result<>(201,"执行失败!",null);
    }
    public Result<T> message(String message){
        this.message=message;
        return this;
    }
    public Result<T> code(Integer code){
        this.code=code;
        return this;
    }
}
