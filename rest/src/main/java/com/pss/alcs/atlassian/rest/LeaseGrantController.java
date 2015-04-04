package com.pss.alcs.atlassian.rest;

import com.pss.alcs.atlassian.service.ILeaseService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by skaranam on 4/4/2015.
 */
@RestController
public class LeaseGrantController {

    @Autowired
    private ILeaseService leaseService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Fetches the Hello World", produces = "application/json")
    public @ResponseBody String helloWorld() {
        return "hello world";
    }



    @RequestMapping(value = "/rest/lease/grant/{userId}/{duration}", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Grants the Administrator Privileges", produces = "application/json")
    public @ResponseBody
    String grantAdministratorPrivilege(@PathVariable("userId") String userId,@PathVariable("duration") String duration)
    {
        double durationValue = Double.parseDouble(duration);
        return leaseService.helloLease(userId,durationValue);
    }

}
