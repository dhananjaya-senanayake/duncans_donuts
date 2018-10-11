/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kln.se.duncans.dao.message;


import edu.kln.se.duncans.model.message.FeedbackMessage;
import java.util.List;

/**
 *
 * @author senanayake
 */
public interface MessageDao {
    public List<FeedbackMessage> getAllMessage() throws Exception ;
    public FeedbackMessage getMessageById(Integer messageId) throws Exception ;
    public void deleteMessage(FeedbackMessage feedbackMessage) throws Exception ;
    public void updateMessage(FeedbackMessage feedbackMessage) throws Exception ;
    public void saveMessage(FeedbackMessage feedbackMessage) throws Exception ;
    
}
