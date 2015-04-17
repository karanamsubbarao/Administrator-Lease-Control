package com.pss.alcs.atlassian.rest;

import com.pss.alcs.atlassian.domain.AtlassianTool;
import com.pss.alcs.atlassian.service.IToolService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by skaranam on 4/4/2015.
 */
@RestController
public class ToolServiceController {

    @Autowired
    private IToolService toolService;

    @RequestMapping(value = "/rest/register/tool/{type}/{name}/{url}/{apiEndPoint}/{approverEmailAddress}", method = RequestMethod.POST)
    @ApiOperation(httpMethod = "POST", value = "Registers the new Atlassian tool", produces = "application/json")
    public @ResponseBody ResponseEntity<AtlassianTool> registerTool(@PathVariable("type") String type, @PathVariable("name")  String name,
                                              @PathVariable("url") String url, @PathVariable("apiEndPoint") String apiEndPoint,
                                              @PathVariable("approverEmailAddress") String approverEmailAddress)
    {
        AtlassianTool tool = new AtlassianTool(type,name,url,apiEndPoint,approverEmailAddress);
        AtlassianTool toolFromDB = toolService.saveTool(tool);
        return new ResponseEntity<AtlassianTool>(toolFromDB,HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/tools/{type}", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Returns tools of type", produces = "application/json")
    public @ResponseBody ResponseEntity<List<AtlassianTool>>  registerTool(@PathVariable("type") String type)
    {
        List<AtlassianTool> allToolsOfType =  toolService.findAtlassianToolsByType(type);
        return new ResponseEntity<List<AtlassianTool>>(allToolsOfType, HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/tools", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Returns all tools", produces = "application/json")
    public @ResponseBody ResponseEntity<List<AtlassianTool>> allTools()
    {
        List<AtlassianTool> allTools =  toolService.findAtlassianTools();
        return new ResponseEntity<List<AtlassianTool>>(allTools, HttpStatus.OK);
    }



}
