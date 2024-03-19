package com.ws.soapcalculator.endPoint;

import com.ws.soapcalculator.ws.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.ws.Action;

@Endpoint
public class CalculatorEndPoint {

    private static final String NAMESPACE_URI = "http://localhost:2026/ws";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddRequest")
    @ResponsePayload
    public AddResponse AddRequest(@RequestPayload AddRequest request){
        AddResponse response = new AddResponse();
        Integer value = request.getIntA() + request.getIntB();
        Response result = new Response();
        result.setResult(value);
        response.setAddResult(result);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SubtractRequest")
    @ResponsePayload
    public SubtractResponse SubtractRequest(@RequestPayload SubtractRequest request){
        SubtractResponse response = new SubtractResponse();
        Integer value = request.getIntA() - request.getIntB();
        Response result = new Response();
        result.setResult(value);
        response.setSubtractResult(result);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "MultiplyRequest")
    @ResponsePayload
    public MultiplyResponse MultiplyRequest(@RequestPayload MultiplyRequest request){
        MultiplyResponse response = new MultiplyResponse();
        Integer value = request.getIntA() * request.getIntB();
        Response result = new Response();
        result.setResult(value);
        response.setMultiplyResult(result);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DivideRequest")
    @ResponsePayload
    public DivideResponse DivideRequest(@RequestPayload DivideRequest request){
        DivideResponse response = new DivideResponse();
        if(request.getIntA() != 0) {
            Integer value = request.getIntA() / request.getIntB();
            Response result = new Response();
            result.setResult(value);
            response.setDivideResult(result);
        }else {
            Response result = new Response();
            result.setResult(0);
            response.setDivideResult(result);
        }
        return response;
    }
}
