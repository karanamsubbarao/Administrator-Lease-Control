package com.pss.alcs.atlassian.rest;

import com.pss.alcs.atlassian.service.LeaseService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by skaranam on 4/17/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
public class LeaseGrantControllerUnitTest {

    private LeaseService leaseService;

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception
    {
        MockitoAnnotations.initMocks(this);
        leaseService = mock(LeaseService.class);
        LeaseGrantController instance = new LeaseGrantController(leaseService);
        this.mockMvc = MockMvcBuilders.standaloneSetup(instance).build();
    }

    @Test
    public void testNotifyLeaseRequestForSuccess() throws Exception
    {
        when(leaseService.requestLease("subbak", 1, "Change", "LOCAL-JIRA")).thenReturn(true);
        mockMvc.perform(post("/rest/requestLease/subbak/1/Change/LOCAL-JIRA").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void testNotifyLeaseRequestForFailure() throws Exception
    {
        when(leaseService.requestLease("subbak", 1, "Change", "LOCAL-JIRA")).thenReturn(false);
        mockMvc.perform(post("/rest/requestLease/subbak/1/Change/LOCAL-JIRA").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
    }

    @Test
    public void testGrantAdministratorPrivilegeForSuccess() throws Exception
    {
        when(leaseService.grantLease(1L)).thenReturn(true);
        mockMvc.perform(post("/rest/lease/grant/1")).andExpect(status().isOk());
    }


    @Test
    public void testGrantAdministratorPrivilegeForFailure() throws Exception
    {
        when(leaseService.grantLease(1L)).thenReturn(false);
        mockMvc.perform(post("/rest/lease/grant/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
    }
}
