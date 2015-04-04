package com.pss.alcs.atlassian.service;

import com.pss.alcs.atlassian.dao.AtlassianTool;

/**
 * Created by skaranam on 4/3/2015.
 */
public interface ILeaseService {
    public String helloLease(String userId,double duration);
    public boolean grantLease(String userId,double duration);
    public boolean revokeLease(String userId);
}
