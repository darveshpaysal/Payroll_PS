package com.ps.rest.controller;

import com.ps.biz.service.rest.AppServiceSO;
import com.ps.common.ServConstants.*;
import com.ps.rest.request.BaseRequest;
import com.ps.rest.response.BaseResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author PS
 */
@RestController
@RequestMapping("/psa")
public class AppService extends BaseService{

    @PostMapping("/app")
    public BaseResponse appConfig(@RequestBody BaseRequest request) {
        System.out.println(" -- app -" + request.getAction() + " - " + request.getType() + " - " + request.getParam());
        long start = System.currentTimeMillis();
        BaseResponse response = new BaseResponse();
        try {
            if (RequestType.CF_STATE.getValue().equals(request.getType())) {
                response = AppServiceSO.getInstance().getStates(request);
            } else {
                response = AppServiceSO.getInstance().getCodeRefValues(request);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            response.setStatus("0");
            response.setStatusMessage("Request could not be processed. " + ex.getMessage());
        }
        System.out.println("-- " + request.getType() + " Response time in millis-" + (start - System.currentTimeMillis()));
        return response;
    }

   
}
