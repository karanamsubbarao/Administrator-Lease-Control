package com.pss.alcs.atlassian.dao;

import com.pss.alcs.atlassian.domain.AtlassianTool;

import java.util.List;

/**
 * Created by skaranam on 3/28/2015.
 */
public interface IToolDAO
{
    public void saveTool(AtlassianTool tool);

    public void deleteTool(AtlassianTool tool);

    public AtlassianTool findAtlassianToolByURL(String url);

    public List<AtlassianTool> findAtlassianToolByType(String type);

}
