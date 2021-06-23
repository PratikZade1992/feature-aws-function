package com.awslamda.demo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.awslamda.demo.dao.FeatureDao;
import com.awslamda.demo.model.Feature;
import com.awslamda.demo.model.GateWayRequest;
import com.awslamda.demo.model.GateWayResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static com.awslamda.demo.utils.FeatureUtil.*;

/**
 * FeatureAPI : To handle lamda function request
 */
public class FeatureAPI implements RequestHandler<GateWayRequest, GateWayResponse> {
    private static final Logger LOGGER = LoggerFactory.getLogger(FeatureAPI.class);
    /**
     * featureDao : dao class for Feature crud operation
     */
    private final FeatureDao featureDao = new FeatureDao();

    /**
     * handleRequest : To handle lamda request
     */
    @Override
    public GateWayResponse handleRequest(GateWayRequest gateWayRequest, Context context) {
        LOGGER.info("Received request is : [{}]", gateWayRequest);
        ObjectMapper objectMapper = new ObjectMapper();
        Feature requestFeature = null;
        try {
            requestFeature = objectMapper.readValue(gateWayRequest.getBody(), Feature.class);
            LOGGER.info("Feature obtain from request is : [{}]", requestFeature);
        } catch (IOException e) {
            e.printStackTrace();
        }

        GateWayResponse gateWayResponse = null;
        switch (gateWayRequest.getHttpMethod()) {
            case "GET":// to Handle get request
                Feature feature;
                feature = featureDao.getFeature(requestFeature.getCustId(), requestFeature.getFeatureCode());
                if (feature != null) {
                    gateWayResponse = getSuccessResponse.apply("Record is found", feature);
                } else {
                    gateWayResponse = getRecordNotFoundResponse.apply("Not Found for " + requestFeature.getCustId(), null);
                }
                break;
            case "PUT": // to handle put request
                gateWayResponse = featureDao.updateFeature(requestFeature);
                break;
            case "POST":// to handle post request
                gateWayResponse = featureDao.addFeature(requestFeature);
                break;
            case "default":
                gateWayResponse = getNotConfigureResponse.apply("Request is Forbidden", null);
                break;
        }
        return gateWayResponse;
    }
}
