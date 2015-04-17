package com.pss.alcs.atlassian.service;

import com.pss.alcs.atlassian.dao.ILeaseDAO;
import com.pss.alcs.atlassian.domain.AtlassianTool;
import com.pss.alcs.atlassian.domain.Lease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by skaranam on 4/4/2015.
 */
@Service
public class NotificationService implements INotificationService{

    @Autowired
    private IEmailService emailService;

    @Autowired
    private IToolService toolService;

    public boolean notifyForLeaseRequest(Lease lease)
    {
        String contents = getContentsOfEmail(lease);
        return emailService.sendEmail("karanamsub@gmail.com", "Lease Request for JIRA", contents, "karanamsubbarao@gmail.com");
    }

    private String getContentsOfEmail(Lease lease)
    {
        AtlassianTool tool = lease.getTool();
        StringBuffer sbf = new StringBuffer();
        sbf.append(lease.getUserId() + " has requested for administrator access with following details");
        sbf.append("<table border=\"1\" style=\"border:2px solid black;width:500\">");
        sbf.append("<tbody>" + "\n");
        sbf.append("<tr><th colspan=\"2\" bgcolor=\"#c7ced4\">Lease Request Details</th></tr>\n");
        sbf.append(" <tr border=\"1\" ><td>URL :: </td><td>"  + tool.getUrl()   + "</td></tr>\n");
        sbf.append(" <tr><td>Duration ::</td><td>" + lease.getDuration()  + "</td></tr>\n");
        sbf.append(" <tr><td>Reason ::</td><td>" + lease.getReason() + "</td></tr>\n");
        sbf.append(" <tr><td>Approvers ::</td><td>" + tool.getApproverEmailAddress() + "</td></tr>\n");
        sbf.append("</tbody>");
        sbf.append("</table>");

        sbf.append("<table border=\"1\" vspace=\"30\" style=\"border:2px solid black;width:100\">");
        sbf.append("<tbody>");
        sbf.append("<tr><th colspan=\"2\" bgcolor=\"#c7ced4\">Click on</th></tr>\n");
        sbf.append("<tr><td><a href=\"http://localhost:8080/rest/lease/grant/" + lease.getLeaseId() + "\""  + ">" + "Approve" +"</a></td></tr>\n\n");
        sbf.append("</tbody>");
        sbf.append("</table>");
        return sbf.toString();
    }

    public boolean notifyForLeaseRequest(String userId, double duration, String reason,String nameOfTool)
    {

        AtlassianTool tool = toolService.findToolByName(nameOfTool);
        String contents = getContentsOfEmail(userId,tool.getUrl(),duration,reason,tool.getApproverEmailAddress());
        return emailService.sendEmail("karanamsub@gmail.com", "Lease Request for JIRA", contents, "karanamsubbarao@gmail.com");
    }



    private String getContentsOfEmail(String userId, String jiraUrl,double duration, String reason,String approversEmailAddress)
    {
        StringBuffer sbf = new StringBuffer();
        sbf.append(userId + " has requested for administrator access with following details");
        sbf.append("<table border=\"1\" style=\"border:2px solid black;width:500\">");
        sbf.append("<tbody>" + "\n");
        sbf.append("<tr><th colspan=\"2\" bgcolor=\"#c7ced4\">Lease Request Details</th></tr>\n");
        sbf.append(" <tr border=\"1\" ><td>URL :: </td><td>\" " + jiraUrl   + "</td></tr>\n");
        sbf.append(" <tr><td>Duration ::</td><td>" + duration  + "</td></tr>\n");
        sbf.append(" <tr><td>Reason ::</td><td>" + reason  + "</td></tr>\n");
        sbf.append(" <tr><td>Approvers ::</td><td>" + approversEmailAddress  + "</td></tr>\n");
        sbf.append("</tbody>");
        sbf.append("</table>");

        sbf.append("<table border=\"1\" vspace=\"30\" style=\"border:2px solid black;width:500\">");
        sbf.append("<tbody>");
        sbf.append("<tr><th colspan=\"2\" bgcolor=\"#c7ced4\">Click on</th></tr>\n");
        sbf.append("<tr><td><a href=\"http://localhost:8080/rest/lease/grant/\">Approve</a></td></tr>\n\n");
        sbf.append("<tr><td><a href=\"http://localhost:8080/rest/lease/grant/\">Revoke</a></td></tr>\n\n");
        sbf.append("</tbody>");
        sbf.append("</table>");
        return sbf.toString();
    }

}
