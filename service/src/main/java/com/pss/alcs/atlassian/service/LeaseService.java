package com.pss.alcs.atlassian.service;

import com.pss.alcs.atlassian.dao.AtlassianTool;
import com.pss.atlassian.tools.jira.JiraClient;
import org.springframework.stereotype.Service;

/**
 * Created by skaranam on 4/3/2015.
 */
@Service
public class LeaseService implements ILeaseService{

    @Override
    public String helloLease(String userId, double duration) {
        System.out.println("In the Hello Lease Method");
        return "Hello Lease";
    }

    @Override
    public boolean grantLease(String userId, double duration)
    {
        JiraClient client  = new JiraClient("http://localhost:8080");
        return client.addUserToAdministratorGroup(userId);
    }

    @Override
    public boolean revokeLease(String userId)
    {
        JiraClient client  = new JiraClient("http://localhost:8080");
        return client.removeUserFromAdministrator(userId);
    }
}
