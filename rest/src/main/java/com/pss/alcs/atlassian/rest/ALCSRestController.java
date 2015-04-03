package com.pss.alcs.atlassian.rest;

/**
 * Created by skaranam on 4/3/2015.
 */

import com.pss.alcs.atlassian.service.ILeaseService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
@Api(value = "/rest", description = "Swagger Online Documentation")
public class ALCSRestController {

    @Autowired
    private ILeaseService leaseService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Fetches the Hello World", produces = "application/json")
    public @ResponseBody String helloWorld() {
        return "hello world";
    }


    @RequestMapping(value = "/administrator/grant/{userId}/{duration}", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "", produces = "application/json")
    public @ResponseBody String grantAdministratorPrivilege(@PathVariable("userId") String userId,@PathVariable("duration") String duration)
    {
        double durationValue = Double.parseDouble(duration);
        return leaseService.helloLease(userId,durationValue);
    }



}
