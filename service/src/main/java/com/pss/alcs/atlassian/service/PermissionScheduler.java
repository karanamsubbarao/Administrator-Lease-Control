package com.pss.alcs.atlassian.service;

import com.pss.alcs.atlassian.dao.ILeaseDAO;
import com.pss.alcs.atlassian.domain.Lease;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

/**
 * Created by skaranam on 4/10/2015.
 */
@Configuration
@EnableScheduling
public class PermissionScheduler {

    @Autowired
    private ILeaseDAO leaseDAO;

    @Autowired
    private ILeaseService leaseService;

    @Scheduled(fixedRate=5000)
    public void processLeaseRequests()
    {
        final List<Lease> allActiveLeases = leaseDAO.findAllActiveLeases();
        for (Lease currentLease :allActiveLeases)
        {
            DateTime currentTime = DateTime.now();
            DateTime expectedLeaseEndTime  =
                    new DateTime(currentLease.getApprovedTimeStamp()).plusHours(currentLease.getDuration());
            if(currentTime.isAfter(expectedLeaseEndTime) && currentLease.isActive())
            {
                leaseService.revokeLease(currentLease);
            }
        }
    }
}
