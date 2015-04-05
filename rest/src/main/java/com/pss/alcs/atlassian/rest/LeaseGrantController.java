package com.pss.alcs.atlassian.rest;

import com.pss.alcs.atlassian.domain.AtlassianTool;
import com.pss.alcs.atlassian.service.ILeaseService;
import com.pss.alcs.atlassian.service.IToolService;
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

    @Autowired
    private IToolService toolService;


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Fetches the Hello World", produces = "application/json")
    public @ResponseBody String helloWorld() {
        return "hello world";
    }


    @RequestMapping(value = "/rest/lease/grant/{userId}/{duration}/{nameOfTool}", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Grants the Administrator Privileges", produces = "application/json")
    public @ResponseBody
    boolean grantAdministratorPrivilege(@PathVariable("userId") String userId,@PathVariable("duration") String duration,
                                        @PathVariable("nameOfTool") String nameOfTool)
    {
        AtlassianTool tool = toolService.findToolByName(nameOfTool);
        double durationValue = Double.parseDouble(duration);
        return leaseService.grantLease(userId,durationValue,tool);
    }

    @RequestMapping(value = "/rest/lease/revoke/{userId}/{nameOfTool}", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Grants the Administrator Privileges", produces = "application/json")
    public @ResponseBody
    boolean revokeAdministratorPrivilege(@PathVariable("userId") String userId,@PathVariable("nameOfTool") String nameOfTool)
    {
        AtlassianTool tool = toolService.findToolByName(nameOfTool);
        return leaseService.revokeLease(userId,tool);
    }

}
