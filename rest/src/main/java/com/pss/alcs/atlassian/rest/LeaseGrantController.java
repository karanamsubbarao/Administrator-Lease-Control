package com.pss.alcs.atlassian.rest;

import com.pss.alcs.atlassian.service.ILeaseService;
import com.pss.alcs.atlassian.service.INotificationService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller which will receive REST requests for Lease Operations such as Grant and revoke
 */

@RestController
public class LeaseGrantController {

    @Autowired
    private ILeaseService leaseService;

    @RequestMapping(value = "/rest/requestLease/{userId}/{duration}/{reason}/{nameOfTool}", method = RequestMethod.POST)
    @ApiOperation(httpMethod = "POST", value = "API to initiate the lease request for Administrator")
    public @ResponseBody ResponseEntity notifyLeaseRequest(@PathVariable("userId") String userId,@PathVariable("duration") String duration,
                               @PathVariable("reason") String reason,@PathVariable("nameOfTool") String nameOfTool)
    {
        int durationValue = Integer.parseInt(duration);
        boolean leaseRequestSent  = leaseService.requestLease(userId, durationValue, reason, nameOfTool);
        if(leaseRequestSent)
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @RequestMapping(value = "/rest/lease/grant/{leaseId}", method = RequestMethod.POST)
    @ApiOperation(httpMethod = "POST", value = "Grants the Administrator Privileges", produces = "application/json")
    public @ResponseBody
    ResponseEntity grantAdministratorPrivilege(@PathVariable("leaseId") String leaseId)
    {
        long leaseIdentifier = Long.parseLong(leaseId);
        boolean leaseGrantSucceeded =  leaseService.grantLease(leaseIdentifier);
        if(leaseGrantSucceeded)
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/rest/lease/revoke/{userId}/{nameOfTool}", method = RequestMethod.POST)
    @ApiOperation(httpMethod = "POST", value = "Revokes the Administrator Privileges", produces = "application/json")
    public @ResponseBody
    ResponseEntity revokeAdministratorPrivilege(@PathVariable("userId") String userId,@PathVariable("nameOfTool") String nameOfTool)
    {
        boolean revokeGrantSucceeded =  leaseService.revokeLease(userId,nameOfTool);
        if(revokeGrantSucceeded)
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
