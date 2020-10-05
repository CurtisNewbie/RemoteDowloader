package com.curtisnewbie.io.exception;

/**
 * <p>
 * Exception that indicates the file path is illegal
 * </p>
 *
 * @author zhuangyongj
 */
public class IllegalFilePathException extends Exception {

    public IllegalFilePathException(Exception e){
        super(e);
    }

    public IllegalFilePathException(String msg){
        super(msg);
    }
}
