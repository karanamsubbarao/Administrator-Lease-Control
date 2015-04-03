package com.pss.alcs.atlassian.dao;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by skaranam on 3/28/2015.
 */

@Entity
@Table(name="TOOL")
public class AtlassianTool {

    private String type;
    private String name;
    private String url;
    private String apiEndPoint;
    private String approverEmailAddress;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getApiEndPoint() {
        return apiEndPoint;
    }

    public void setApiEndPoint(String apiEndPoint) {
        this.apiEndPoint = apiEndPoint;
    }

    public String getApproverEmailAddress() {
        return approverEmailAddress;
    }

    public void setApproverEmailAddress(String approverEmailAddress) {
        this.approverEmailAddress = approverEmailAddress;
    }

    public AtlassianTool(String type, String name, String url, String apiEndPoint, String approverEmailAddress) {

        this.type = type;
        this.name = name;
        this.url = url;
        this.apiEndPoint = apiEndPoint;
        this.approverEmailAddress = approverEmailAddress;
    }
}
