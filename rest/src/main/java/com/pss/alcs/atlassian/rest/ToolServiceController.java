package com.pss.alcs.atlassian.rest;

import com.pss.alcs.atlassian.dao.AtlassianTool;
import com.pss.alcs.atlassian.service.ILeaseService;
import com.pss.alcs.atlassian.service.IToolService;
import com.pss.atlassian.tools.jira.JiraClient;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by skaranam on 4/4/2015.
 */
@RestController
public class ToolServiceController {

    @Autowired
    private IToolService toolService;


    @RequestMapping(value = "/rest/register/tool", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Grants the Administrator Privileges", produces = "application/json")
    public @ResponseBody String registerAtlassianTool()
    {
        return toolService.saveTool();
    }



    @RequestMapping(value = "/rest/register/tool/{type}/{name}/{url}/{apiEndPoint}/{approverEmailAddress}", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Grants the Administrator Privileges", produces = "application/json")
    public @ResponseBody boolean registerTool(@PathVariable("type") String type, @PathVariable("name")  String name,
                                              @PathVariable("url") String url, @PathVariable("apiEndPoint") String apiEndPoint,
                                              @PathVariable("approverEmailAddress") String approverEmailAddress)
    {
        AtlassianTool tool = new AtlassianTool(type,name,url,apiEndPoint,approverEmailAddress);
        return toolService.saveTool(tool);
    }



}
