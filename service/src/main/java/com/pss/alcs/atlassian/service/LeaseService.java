package com.pss.alcs.atlassian.service;

import com.pss.alcs.atlassian.dao.ILeaseDAO;
import com.pss.alcs.atlassian.domain.AtlassianTool;
import com.pss.alcs.atlassian.domain.Lease;
import com.pss.atlassian.tools.jira.JiraClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by skaranam on 4/3/2015.
 */
@Service
public class LeaseService implements ILeaseService{

    @Autowired
    private IToolService toolService;

    @Autowired
    private INotificationService notificationService;

    @Autowired
    private ILeaseDAO leaseDAO;

    @Override
    public boolean requestLease(String userId, int duration,String reason,String nameOfTool)
    {
        AtlassianTool tool = toolService.findToolByName(nameOfTool);
        Date date = new Date();
        Lease lease = new Lease(userId,duration,reason,tool,false,date,null,null);
        Lease leaseFromDB = leaseDAO.createLeaseRequest(lease);
        return notificationService.notifyForLeaseRequest(leaseFromDB);
    }

    @Override
    public boolean grantLease(Long leaseId) {
        Lease currentLease =  leaseDAO.findLeaseById(leaseId);
        if(!currentLease.isActive())
        {
            currentLease.setApprovedTimeStamp(new Date());
            currentLease.setActive(true);
            leaseDAO.updateLeaseRequest(currentLease);

            AtlassianTool tool =currentLease.getTool();
            JiraClient client  = new JiraClient(tool.getApiEndPoint());
            return client.addUserToAdministratorGroup(currentLease.getUserId());
        }
        return false;
    }

    @Override
    public boolean revokeLease(long leaseId) {
        Lease currentLease =  leaseDAO.findLeaseById(leaseId);
        if(!currentLease.isActive())
        {
            currentLease.setTerminatedTimeStamp(new Date());
            currentLease.setActive(false);
            leaseDAO.updateLeaseRequest(currentLease);

            AtlassianTool tool =currentLease.getTool();
            JiraClient client  = new JiraClient(tool.getApiEndPoint());
            return client.removeUserFromAdministrator(currentLease.getUserId());
        }

        return false;
    }

    @Override
    public boolean revokeLease(Lease currentLease)
    {
        if(!currentLease.isActive())
        {
            currentLease.setTerminatedTimeStamp(new Date());
            currentLease.setActive(false);
            leaseDAO.updateLeaseRequest(currentLease);

            AtlassianTool tool =currentLease.getTool();
            JiraClient client  = new JiraClient(tool.getApiEndPoint());
            return client.removeUserFromAdministrator(currentLease.getUserId());
        }
        return false;
    }

    @Override
    public boolean grantLease(String userId, int duration,String nameOfTool)
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
