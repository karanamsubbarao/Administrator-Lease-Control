package com.pss.alcs.atlassian.dao;

import com.pss.alcs.atlassian.domain.Lease;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by skaranam on 4/10/2015.
 */
@Repository("leaseDao")
@Transactional
public class LeaseDAOImpl extends AbstractDAO implements ILeaseDAO
{

    @Override
    public Lease findLeaseById(long id) {
        Criteria criteria = getSession().createCriteria(Lease.class);
        criteria.add(Restrictions.eq("leaseId", id));
        return (Lease)criteria.uniqueResult();
    }

    @Override
    public List<Lease> findAllActiveLeases()
    {
        Criteria criteria = getSession().createCriteria(Lease.class);
        criteria.add(Restrictions.eq("active", true));
        return (List<Lease>)criteria.list();
    }

    @Override
    public Lease createLeaseRequest(Lease lease) {
        return (Lease)save(lease);
    }

    @Override
    public Lease updateLeaseRequest(Lease lease) {
        return (Lease)update(lease);
    }

    @Override
    public void deleteLeaseRequest(Lease lease) {
        delete(lease);
    }
}
