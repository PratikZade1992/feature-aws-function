package com.awslamda.demo.utils;

import com.awslamda.demo.model.Feature;
import com.awslamda.demo.model.GateWayResponse;
import com.awslamda.demo.model.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.BiFunction;

import static org.apache.http.HttpStatus.*;

/**
 * The type Feature util.
 */
public class FeatureUtil {

    private static final Logger log = LoggerFactory.getLogger(Feature.class);

    /**
     * The Get success response.
     */
    public static final BiFunction<String, Feature, GateWayResponse> getSuccessResponse = (statusMessage, feature) -> {
        GateWayResponse gateWayResponse = new GateWayResponse();
        gateWayResponse.setStatusCode(SC_OK);
        gateWayResponse.setBody(getResponse(statusMessage, feature));
        return gateWayResponse;
    };


    /**
     * The constant getInternalErrorResponse.
     */
    public static final BiFunction<String, Feature, GateWayResponse> getInternalErrorResponse = (statusMessage, feature) -> {
        GateWayResponse gateWayResponse = new GateWayResponse();
        gateWayResponse.setStatusCode(SC_INTERNAL_SERVER_ERROR);
        gateWayResponse.setBody(getResponse(statusMessage, feature));
        return gateWayResponse;
    };


    /**
     * The constant getBadRequestResponse.
     */
    public static final BiFunction<String, Feature, GateWayResponse> getBadRequestResponse = (statusMessage, feature) -> {
        GateWayResponse gateWayResponse = new GateWayResponse();
        gateWayResponse.setStatusCode(SC_BAD_REQUEST);
        gateWayResponse.setBody(getResponse(statusMessage, feature));
        return gateWayResponse;
    };


    /**
     * The constant getRecordNotFoundResponse.
     */
    public static final BiFunction<String, Feature, GateWayResponse> getRecordNotFoundResponse = (statusMessage, feature) -> {
        GateWayResponse gateWayResponse = new GateWayResponse();
        gateWayResponse.setStatusCode(SC_NOT_FOUND);
        gateWayResponse.setBody(getResponse(statusMessage, feature));
        return gateWayResponse;
    };

    /**
     * The constant getRecordNotFoundResponse.
     */
    public static final BiFunction<String, Feature, GateWayResponse> getNotConfigureResponse = (statusMessage, feature) -> {
        GateWayResponse gateWayResponse = new GateWayResponse();
        gateWayResponse.setStatusCode(SC_FORBIDDEN);
        gateWayResponse.setBody(getResponse(statusMessage, feature));
        return gateWayResponse;
    };

    /**
     *  getResponse : to get getResponse message in json.
     */
    private static String getResponse(String statusMessage, Feature feature) {
        ObjectMapper objectMapper = new ObjectMapper();
        Response response = new Response();
        response.setStatusMessage(statusMessage);
        response.setFeature(feature);
        try {
            return objectMapper.writeValueAsString(response);// Convert message to json
        } catch (JsonProcessingException e) {
            log.error("JsonProcessingException while converting :[{}]", response);
            return response.toString();
        }
    }
}
