package com.pss.alcs.atlassian.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Domain Class for Lease Domain Object
 */

@Entity
@Table(name="LEASE")
public class Lease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long leaseId;

    @Column(name = "userId", nullable = false)
    private String userId;

    @Column(name = "reason", nullable = false)
    private String reason;

    @Column(name = "duration", nullable = false)
    private int duration;

    @OneToOne
    @JoinColumn(name="toolId")
    private AtlassianTool tool;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "createdTimeStamp", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTimeStamp;

    @Column(name = "approvedTimeStamp", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date approvedTimeStamp;

    @Column(name = "terminatedTimeStamp", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date terminatedTimeStamp;

    public Lease()
    {

    }

    public Lease(String userId, int duration, String reason,AtlassianTool tool, boolean active, Date createdTimeStamp, Date approvedTimeStamp, Date terminatedTimeStamp) {
        this.userId = userId;
        this.duration = duration;
        this.reason = reason;

        this.tool = tool;
        this.active = active;
        this.createdTimeStamp = createdTimeStamp;
        this.approvedTimeStamp = approvedTimeStamp;
        this.terminatedTimeStamp = terminatedTimeStamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public AtlassianTool getTool() {
        return tool;
    }

    public void setTool(AtlassianTool tool) {
        this.tool = tool;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getApprovedTimeStamp() {
        return approvedTimeStamp;
    }

    public void setApprovedTimeStamp(Date approvedTimeStamp) {
        this.approvedTimeStamp = approvedTimeStamp;
    }

    public Date getTerminatedTimeStamp() {
        return terminatedTimeStamp;
    }

    public void setTerminatedTimeStamp(Date terminatedTimeStamp) {
        this.terminatedTimeStamp = terminatedTimeStamp;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


    public Date getCreatedTimeStamp() {
        return createdTimeStamp;
    }

    public void setCreatedTimeStamp(Date createdTimeStamp) {
        this.createdTimeStamp = createdTimeStamp;
    }

    public long getLeaseId() {
        return leaseId;
    }

    public void setLeaseId(long leaseId) {
        this.leaseId = leaseId;
    }
}
