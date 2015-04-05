package com.pss.alcs.atlassian.service;

import com.pss.alcs.atlassian.domain.AtlassianTool;
import com.pss.alcs.atlassian.dao.IToolDAO;
import org.springframework.beans.factory.annotation.Autowired;
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
    public AtlassianTool saveTool(AtlassianTool tool) {
        toolDAO.saveTool(tool);
        return toolDAO.findAtlassianToolByURL(tool.getUrl());
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
