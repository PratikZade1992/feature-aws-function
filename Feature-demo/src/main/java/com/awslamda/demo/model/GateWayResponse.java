package com.awslamda.demo.model;

import java.util.Map;

/**
 * GateWayResponse : It is used to send response of the api request
 */
public class GateWayResponse {

    private Integer statusCode;
    private String body;
    private Map<Object, Object> headers;
    private final Boolean isBase64Encoded = false;

    /**
     * Gets status code.
     *
     * @return the status code
     */
    public Integer getStatusCode() {
        return statusCode;
    }

    /**
     * Sets status code.
     *
     * @param statusCode the status code
     */
    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * Gets body.
     *
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets body.
     *
     * @param body the body
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Gets headers.
     *
     * @return the headers
     */
    public Map<Object, Object> getHeaders() {
        return headers;
    }

    /**
     * Sets headers.
     *
     * @param headers the headers
     */
    public void setHeaders(Map<Object, Object> headers) {
        this.headers = headers;
    }

    /**
     * Gets base 64 encoded.
     *
     * @return the base 64 encoded
     */
    public Boolean getBase64Encoded() {
        return isBase64Encoded;
    }

    @Override
    public String toString() {
        return "GateWayResponse{" +
                "statusCode=" + statusCode +
                ", body='" + body + '\'' +
                ", headers=" + headers +
                ", isBase64Encoded=" + isBase64Encoded +
                '}';
    }
}
