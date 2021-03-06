package com.pss.alcs.atlassian.service;

import com.pss.alcs.atlassian.dao.IToolDAO;
import com.pss.alcs.atlassian.domain.AtlassianTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public AtlassianTool findToolByName(String name)
    {
        return toolDAO.findAtlassianToolByName(name);
    }

    @Override
    public List<AtlassianTool> findAtlassianToolsByType(String type) {
        return toolDAO.findAtlassianToolByType(type);
    }

    @Override
    public List<AtlassianTool> findAtlassianTools() {
        return toolDAO.findAtlassianTools();
    }

}
