package com.tck.jnidemo.jnicalculator;

/**
 * <p>description:</p>
 * <p>created on: 2019/4/17 11:18</p>
 *
 * @author tck
 * @version 3.3
 */
public class JniCalculatorUtils {

    static {
        System.loadLibrary("calculator_lib");
    }

    /**
     * 加法
     * @param a
     * @param b
     * @return
     */
    public static native int plus(int a, int b);
}
