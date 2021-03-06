package com.pss.alcs.atlassian.dao;

import com.pss.alcs.atlassian.domain.AtlassianTool;

import java.util.List;

/**
 * Interface for Operations on Tools
 */
public interface IToolDAO
{
    public void saveTool(AtlassianTool tool);

    public void deleteTool(AtlassianTool tool);

    public AtlassianTool findAtlassianToolByURL(String url);

    public List<AtlassianTool> findAtlassianToolByType(String type);

    public AtlassianTool findAtlassianToolByName(String name);

    public List<AtlassianTool>  findAtlassianTools();

}
