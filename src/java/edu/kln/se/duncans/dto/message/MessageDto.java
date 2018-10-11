/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kln.se.duncans.dto.message;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author senanayake
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MessageDto {

    private Integer messageId ;
    private String userName ;
    private String userEmail ;
    private String messageSubject ;
    private String messageContent;
    
     public MessageDto() {
    }
    
    /**
     * @return the messageId
     */
    public Integer getMessageId() {
        return messageId;
    }

    /**
     * @param messageId the messageId to set
     */
    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the userEmail
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * @param userEmail the userEmail to set
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * @return the messageSubject
     */
    public String getMessageSubject() {
        return messageSubject;
    }

    /**
     * @param messageSubject the messageSubject to set
     */
    public void setMessageSubject(String messageSubject) {
        this.messageSubject = messageSubject;
    }

    /**
     * @return the messageContent
     */
    public String getMessageContent() {
        return messageContent;
    }

    /**
     * @param messageContent the messageContent to set
     */
    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public MessageDto(Integer messageId, String userName, String userEmail, String messageSubject, String messageContent) {
        this.messageId = messageId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.messageSubject = messageSubject;
        this.messageContent = messageContent;
    }
    
    

    public MessageDto(String userName, String userEmail, String messageSubject, String messageContent) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.messageSubject = messageSubject;
        this.messageContent = messageContent;
    }

   
    
    
}
