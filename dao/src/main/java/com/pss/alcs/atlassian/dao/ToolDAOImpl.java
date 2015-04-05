package com.pss.alcs.atlassian.dao;

import com.pss.alcs.atlassian.domain.AtlassianTool;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("toolDao")
@Transactional
public class ToolDAOImpl extends AbstractDAO implements IToolDAO
{

    @Override
    public void saveTool(AtlassianTool tool)
    {
        save(tool);
    }

    @Override
    public void deleteTool(AtlassianTool tool) {
        delete(tool);
    }

    public List<AtlassianTool> findAllTools() {
        Criteria criteria = getSession().createCriteria(AtlassianTool.class);
        return (List<AtlassianTool>) criteria.list();
    }

    public List<AtlassianTool> findAtlassianToolByType(String type)
    {
        Criteria criteria = getSession().createCriteria(AtlassianTool.class);
        criteria.add(Restrictions.eq("type", type));
        return (List<AtlassianTool>) criteria.list();
    }

    public AtlassianTool findAtlassianToolByURL(String url){
        Criteria criteria = getSession().createCriteria(AtlassianTool.class);
        criteria.add(Restrictions.eq("url", url));
        return (AtlassianTool)criteria.uniqueResult();
    }
}
