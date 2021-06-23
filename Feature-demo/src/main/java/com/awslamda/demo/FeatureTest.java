package com.awslamda.demo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.awslamda.demo.model.GateWayResponse;

public class FeatureTest implements RequestHandler<Object, GateWayResponse> {
    @Override
    public GateWayResponse handleRequest(Object object, Context context) {
        GateWayResponse response = new GateWayResponse();
        response.setBody("Test Feature tested successfully");
        response.setStatusCode(200);
        return response;
    }
}
