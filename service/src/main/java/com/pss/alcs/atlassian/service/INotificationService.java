package com.pss.alcs.atlassian.service;

import com.pss.alcs.atlassian.domain.Lease;

/**
 * Created by skaranam on 4/4/2015.
 */
public interface INotificationService {

    public boolean notifyForLeaseRequest(String userId, double duration, String reason, String nameOfTool);

    public boolean notifyForLeaseRequest(Lease lease);

}

