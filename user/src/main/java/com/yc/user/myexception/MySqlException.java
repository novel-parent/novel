package com.yc.user.myexception;

/**
 * @author LX
 * @date 2019/5/29 - 21:58
 */
public class MySqlException extends Exception {

    public MySqlException() {
    }

    public MySqlException(String message) {
        super(message);
    }
}
