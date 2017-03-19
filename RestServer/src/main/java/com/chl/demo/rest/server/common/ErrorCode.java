package com.chl.demo.rest.server.common;

/**
 * 错误码（自定义）
 * Created by caodongdong on 2017-02-07.
 */
public enum ErrorCode {

    /**
     * {@code 510 Not Extended}
     *
     * @see <a href="http://tools.ietf.org/html/rfc2774#section-7">HTTP Extension Framework</a>
     */
    NOT_EXTENDED(510, "Not Extended"),
    /**
     * {@code 511 Network Authentication Required}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc6585#section-6">Additional HTTP Status Codes</a>
     */
    NETWORK_AUTHENTICATION_REQUIRED(511, "Network Authentication Required");


    private final int retCode;

    private final String retMsg;


    private ErrorCode(int retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    /**
     * Return the integer retCode of this status code.
     */
    public int value() {
        return this.retCode;
    }

    /**
     * Return the reason phrase of this status code.
     */
    public String getRetMsg() {
        return retMsg;
    }


    /**
     * Return a string representation of this status code.
     */
    @Override
    public String toString() {
        return Integer.toString(retCode);
    }


}
