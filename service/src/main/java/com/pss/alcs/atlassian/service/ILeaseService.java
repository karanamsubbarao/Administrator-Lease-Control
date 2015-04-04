package com.pss.alcs.atlassian.service;

/**
 * Created by skaranam on 4/3/2015.
 */
public interface ILeaseService {
    public String helloLease(String userId,double duration);
    public boolean grantLease(String userId,double duration);
    public boolean revokeLease(String userId);
}
