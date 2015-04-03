package com.pss.atlassian.tools.jira;

import com.sun.jersey.api.client.ClientResponse;

import javax.ws.rs.core.MediaType;

/**
 * Created by skaranam on 3/28/2015.
 */
public class JiraClient extends AbstractRestClient {

    private String endpoint;

    private static JiraClient instance;

    private static final String USER_TO_GROUP_URL = "/rest/api/2/group/user";

    private static final String JIRA_ADMINISTRATORS ="jira-administrators";

    public JiraClient(String endpoint) {
        super(endpoint);
        this.endpoint = endpoint;
    }

    public static JiraClient getJiraClient(String endpoint)
    {
        if(instance == null)
        {
            return new JiraClient(endpoint);
        }
        return instance;
    }

    public boolean addUserToAdministratorGroup(String userId)
    {
        String payload = "{ \"name\" : \""+userId+"\"}";
        String encodedString = new String(com.sun.jersey.core.util.Base64.encode("admin:password"));
        ClientResponse responseStatus = webResource(endpoint , USER_TO_GROUP_URL).queryParam("groupname", JIRA_ADMINISTRATORS).
                header("Authorization", "Basic " +encodedString).
                accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).post(ClientResponse.class, payload);
        if(responseStatus.getStatusInfo() ==  ClientResponse.Status.CREATED)
        {
            return true;
        }
        return false;
    }

    public ClientResponse addUserToGroup(String userId, String group)
    {
        String payload = "{ \"name\" : \""+userId+"\"}";
        String encodedString = new String(com.sun.jersey.core.util.Base64.encode("admin:password"));
        ClientResponse status = webResource(endpoint , USER_TO_GROUP_URL).queryParam("groupname", group).
                                          header("Authorization", "Basic " +encodedString).
                                          accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).post(ClientResponse.class, payload);
        return status;
    }

    public ClientResponse removeUserFromGroup(String userId, String group)
    {
        String encodedString = new String(com.sun.jersey.core.util.Base64.encode("admin:password"));
        ClientResponse status = webResource(endpoint , USER_TO_GROUP_URL).queryParam("groupname", group).queryParam("username", userId).
                header("Authorization", "Basic " +encodedString).
                accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).delete(ClientResponse.class);
        return status;
    }



    public static void main(String[] args)
    {
        JiraClient client = new JiraClient("http://localhost:8080");
        ClientResponse response = client.removeUserFromGroup("karanamsubbarao", JIRA_ADMINISTRATORS);

        System.out.println(response.getStatus());
    }


}
