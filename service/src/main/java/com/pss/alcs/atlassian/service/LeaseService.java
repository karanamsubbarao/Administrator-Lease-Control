package com.pss.alcs.atlassian.service;

import com.pss.atlassian.tools.jira.JiraClient;
import org.springframework.stereotype.Service;

/**
 * Created by skaranam on 4/3/2015.
 */
@Service
public class LeaseService implements ILeaseService{

    public static final String JIRA_URL = "http://localhost:9000";

    @Override
    public String helloLease(String userId, double duration) {
        System.out.println("In the Hello Lease Method");
        return "Hello Lease";
    }

    @Override
    public boolean grantLease(String userId, double duration)
    {
        JiraClient client  = new JiraClient(JIRA_URL);
        return client.addUserToAdministratorGroup(userId);
    }

    @Override
    public boolean revokeLease(String userId)
    {
        JiraClient client  = new JiraClient(JIRA_URL);
        return client.removeUserFromAdministrator(userId);
    }
}
