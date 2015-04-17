package com.pss.alcs.atlassian.dao;

import com.pss.alcs.atlassian.domain.Lease;

import java.util.List;

/**
 * Created by skaranam on 4/10/2015.
 */
public interface ILeaseDAO {

    public Lease findLeaseById(long id);

    public List<Lease> findAllActiveLeases();

    public Lease createLeaseRequest(Lease lease);

    public Lease updateLeaseRequest(Lease lease);

    public void deleteLeaseRequest(Lease lease);

}
