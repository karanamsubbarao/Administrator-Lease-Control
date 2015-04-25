package com.pss.alcs.atlassian.rest;

import com.pss.alcs.atlassian.domain.AtlassianTool;
import com.pss.alcs.atlassian.service.LeaseService;
import com.pss.alcs.atlassian.service.ToolService;
import org.hibernate.annotations.SourceType;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriUtils;

import java.net.URI;
import java.net.URLEncoder;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by skaranam on 4/17/2015.
 */
public class ToolServiceControllerUnitTest {

    private ToolService toolService;

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception
    {
        MockitoAnnotations.initMocks(this);
        toolService = mock(ToolService.class);
        ToolServiceController instance = new ToolServiceController(toolService);
        this.mockMvc = MockMvcBuilders.standaloneSetup(instance).build();
    }

    @Test
    public void testRegisterTool() throws  Exception
    {
        AtlassianTool tool = new AtlassianTool(ToolFixture.TOOL_TYPE,ToolFixture.TOOL_NAME,ToolFixture.TOOL_URL,ToolFixture.TOOL_API_URL,ToolFixture.APPROVER_EMAIL_ADDRESS);
        when(toolService.saveTool(tool)).thenReturn(tool);
        mockMvc.perform(post("/rest/register/tool/JIRA/LOCAL-JIRA?approverEmailAddress=xyz@gmail.com&url=http//prod.csftools.services.gs.com:9000/test&apiEndPoint=http//prod.csftools.services.gs.com:9000/test").
                contentType(MediaType.APPLICATION_FORM_URLENCODED).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

}
