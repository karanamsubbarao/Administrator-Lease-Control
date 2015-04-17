package com.pss.alcs.atlassian.service;


/**
 * Created by skaranam on 4/10/2015.
 */
public interface IEmailService {

    public boolean sendEmail(String from, String subject, String contents, String toAddressList);
}
