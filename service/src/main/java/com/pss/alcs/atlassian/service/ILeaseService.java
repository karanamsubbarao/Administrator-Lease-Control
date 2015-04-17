package com.pss.alcs.atlassian.service;

import com.pss.alcs.atlassian.domain.Lease;

/**
 * Created by skaranam on 4/3/2015.
 */
public interface ILeaseService {
    public boolean requestLease(String userId, int duration,String reason,String nameOfTool);

    public boolean grantLease(Long leaseId);
    public boolean grantLease(String userId,int duration,String nameOfTool);
    public boolean revokeLease(String userId,String nameOfTool);
    public boolean revokeLease(long leaseId);
    public boolean revokeLease(Lease lease);

}
