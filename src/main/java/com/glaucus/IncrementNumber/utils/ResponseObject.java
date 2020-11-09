package com.glaucus.IncrementNumber.utils;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * This is actual format in which API gives out responses.
 *
 * @author Vipul Kumar Singh
 * @version 1.0
 * @since 2020-11-09
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseObject {

    private final Long timestamp;

    private String message;

    private Object data;

    /**
     * Set timestamp to System.currentTimeMillis().
     */
    public ResponseObject() {
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * Sets response message and timestamp.
     *
     * @param message Success/Failure message value.
     */
    public ResponseObject(String message) {
        this();
        this.message = message;
    }

    /**
     * Sets timestamp, response message and response object.
     *
     * @param message Success/Failure message value.
     * @param data Value of response object data.
     */
    public ResponseObject(String message, Object data) {
        this();
        this.message = message;
        this.data = data;
    }

    /**
     * Getter of timestamp.
     *
     * @return Value of timestamp;
     */
    public Long getTimestamp() {
        return timestamp;
    }

    /**
     * Getter of message.
     *
     * @return Value of message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setter of message.
     *
     * @param message Value of message.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Getter of data.
     *
     * @return Value of data.
     */
    public Object getData() {
        return data;
    }

    /**
     * Setter of data.
     *
     * @param data Value of data.
     */
    public void setData(Object data) {
        this.data = data;
    }
}
