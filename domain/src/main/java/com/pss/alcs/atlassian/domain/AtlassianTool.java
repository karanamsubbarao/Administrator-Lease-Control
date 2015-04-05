package com.pss.alcs.atlassian.domain;

import javax.persistence.*;

/**
 * Created by skaranam on 3/28/2015.
 */

@Entity
@Table(name="TOOL")
public class AtlassianTool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TYPE", nullable = false)
    private String type;


    @Column(name = "NAME", nullable = false)
    private String name;


    @Column(name = "URL", unique=true, nullable = false)
    private String url;

    @Column(name = "APIENDPOINT", unique=true, nullable = false)
    private String apiEndPoint;

    @Column(name = "APPROVEREMAILADDRESS", nullable = false)
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

    public AtlassianTool() {
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
