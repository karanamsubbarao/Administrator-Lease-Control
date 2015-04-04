package com.pss.alcs.atlassian.dao;

import com.pss.alcs.atlassian.domain.AtlassianTool;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("toolDao")
public class ToolDAOImpl extends AbstractDAO implements IToolDAO
{

    @Override
    public void saveTool(AtlassianTool tool) {
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

    public List<AtlassianTool> findByType(String type){
        Criteria criteria = getSession().createCriteria(AtlassianTool.class);
        criteria.add(Restrictions.eq("type", type));
        return (List<AtlassianTool>) criteria.list();
    }

}
