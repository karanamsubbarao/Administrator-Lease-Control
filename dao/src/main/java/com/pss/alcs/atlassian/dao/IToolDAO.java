package com.pss.alcs.atlassian.dao;

import com.pss.alcs.atlassian.dao.AtlassianTool;

/**
 * Created by skaranam on 3/28/2015.
 */
public interface IToolDAO
{
    public void saveTool(AtlassianTool tool);

    public void deleteTool(AtlassianTool tool);
}
