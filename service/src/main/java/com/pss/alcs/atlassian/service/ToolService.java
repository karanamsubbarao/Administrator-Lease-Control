package com.pss.alcs.atlassian.service;

import com.pss.alcs.atlassian.dao.AtlassianTool;
import com.pss.alcs.atlassian.dao.IToolDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by skaranam on 4/4/2015.
 */
@Service
public class ToolService implements IToolService
{

    @Autowired
    public IToolDAO toolDAO;

    public String saveTool() {
        return "Hello Save Tool";
    }


    @Override
    public boolean saveTool(AtlassianTool tool) {
        toolDAO.saveTool(tool);
        return false;
    }

    @Override
    public boolean deleteTool(AtlassianTool tool) {
        return false;
    }

    @Override
    public boolean updateTool(AtlassianTool tool) {
        return false;
    }
}