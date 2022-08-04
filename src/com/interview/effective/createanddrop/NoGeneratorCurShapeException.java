package com.interview.effective.createanddrop;

/**
 * @author json.yang
 * @Description 不能创建当前形状异常
 * @Date 2020-06-21
 */
public class NoGeneratorCurShapeException extends RuntimeException{

    public NoGeneratorCurShapeException(String message) {
        super(message);
    }
}