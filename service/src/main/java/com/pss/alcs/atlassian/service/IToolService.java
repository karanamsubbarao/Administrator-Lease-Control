package com.pss.alcs.atlassian.service;

import com.pss.alcs.atlassian.domain.AtlassianTool;

import java.util.List;

/**
 * Created by skaranam on 4/4/2015.
 */
public interface IToolService {

    public String saveTool();
    public AtlassianTool saveTool(AtlassianTool tool);
    public boolean deleteTool(AtlassianTool tool);
    public boolean updateTool(AtlassianTool tool);

    public AtlassianTool findToolByName(String name);

    public List<AtlassianTool> findAtlassianToolsByType(String name);

    public List<AtlassianTool> findAtlassianTools();


}
