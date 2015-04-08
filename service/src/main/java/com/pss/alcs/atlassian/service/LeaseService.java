package com.pss.alcs.atlassian.service;

import com.pss.alcs.atlassian.domain.AtlassianTool;
import com.pss.atlassian.tools.jira.JiraClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by skaranam on 4/3/2015.
 */
@Service
public class LeaseService implements ILeaseService{

    public static final String JIRA_URL = "http://localhost:9000";

    @Autowired
    private IToolService toolService;

    @Override
    public String helloLease(String userId, double duration) {
        System.out.println("In the Hello Lease Method");
        return "Hello Lease";
    }

    @Override
    public boolean grantLease(String userId, double duration,String nameOfTool)
    {
        AtlassianTool tool = toolService.findToolByName(nameOfTool);
        JiraClient client  = new JiraClient(tool.getApiEndPoint());
        return client.addUserToAdministratorGroup(userId);
    }

    @Override
    public boolean revokeLease(String userId,String nameOfTool)
    {
        AtlassianTool tool = toolService.findToolByName(nameOfTool);
        JiraClient client  = new JiraClient(tool.getApiEndPoint());
        return client.removeUserFromAdministrator(userId);
    }
}
