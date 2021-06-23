package com.awslamda.demo.model;

import java.util.Map;

/**
 * The type Request.
 */
public class GateWayRequest {
    private String body;
    private String httpMethod;
    private Map<Object, Object> headers;

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
     * Gets http method.
     *
     * @return the http method
     */
    public String getHttpMethod() {
        return httpMethod;
    }

    /**
     * Sets http method.
     *
     * @param httpMethod the http method
     */
    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
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

    @Override
    public String toString() {
        return "Request{" +
                "body=" + body +
                ", httpMethod='" + httpMethod + '\'' +
                ", headers=" + headers +
                '}';
    }
}
