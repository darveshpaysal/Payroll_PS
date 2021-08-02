package com.ps.rest.controller;

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
@RequestMapping("/psua")
public class UserAuthService extends BaseService{

    @PostMapping("/emp")
    public BaseResponse employee(@RequestBody BaseRequest request) {
        System.out.println(" -- emp -" + request.getAction() + " - " + request.getType() + " - " + request.getParam());
        long start = System.currentTimeMillis();
        BaseResponse response = new BaseResponse();
        try {
            if (RequestType.PROPERTY_DETAILS.getValue().equals(request.getType())) {
                //response = PropertyServiceSO.getInstance().getPropertyDtls(request);
            } else if (RequestType.PROPERTY_FILTER.getValue().equals(request.getType())) {
               // response = PropertyServiceSO.getInstance().getPropFilters(request);
            } else if (RequestType.NEIGHBORHOODS.getValue().equals(request.getType())) {
                //response = PropertyServiceSO.getInstance().getNeighborhoods(request);
            } else if (RequestType.SIMILER_HOMES.getValue().equals(request.getType())) {
               // response = PropertyServiceSO.getInstance().getSimilarHomes(request);
            } else if (RequestType.USER_SAVED_SEARCH.getValue().equals(request.getType())) {
               // response = PropertyServiceSO.getInstance().savedSearch(request);
            } else if (RequestType.USER_SAVED_HOMES.getValue().equals(request.getType())) {
               // response = PropertyServiceSO.getInstance().savedHomes(request);
            }else if (RequestType.PROP_PRICE_TAX_HIST.getValue().equals(request.getType())) {
                //response = PropertyServiceSO.getInstance().getPriceAndTaxHist(request);
            }else if (RequestType.PROP_SHOWING.getValue().equals(request.getType())) {
                //response = PropertyServiceSO.getInstance().propertyShowing(request);
            }

            response.setStatus("1");

        } catch (Exception ex) {
            ex.printStackTrace();
            response.setStatus("0");
            response.setStatusMessage("Request could not be processed. " + ex.getMessage());
        }
        System.out.println("-- " + request.getType() + " Response time in millis-" + (start - System.currentTimeMillis()));
        return response;
    }

   
}
