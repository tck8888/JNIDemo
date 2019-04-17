package com.tck.jnidemo.jniencryption;

/**
 * <p>description:</p>
 * <p>created on: 2019/4/17 11:00</p>
 *
 * @author tck
 * @version 3.3
 */
public class JniEncryptionUtils {

    static {
        System.loadLibrary("encryption-lib");
    }

    /**
     * 需要加密的内容
     *
     * @param content
     * @return
     */
    public static native String encryption(String content);
}
