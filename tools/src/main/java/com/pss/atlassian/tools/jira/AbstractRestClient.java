package com.pss.atlassian.tools.jira;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by skaranam on 3/28/2015.
 */
@Configuration
@PropertySource("application.properties")
public class AbstractRestClient {

    protected String username;
    protected String password;
    protected String endPoint;

    public AbstractRestClient()
    {

    }

    public AbstractRestClient(String endPoint) {
        this.endPoint =endPoint;

    }

    public WebResource webResource(String endpoint , String url)
    {
        Client client = Client.create();
        WebResource resource = client.resource(endpoint + url);
        return resource;
    }

}
