/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kln.se.duncans.dao.message;

import edu.kln.se.duncans.dao.AbstractDao;
import edu.kln.se.duncans.model.message.FeedbackMessage;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author senanayake
 */
@Repository
public class MessageDaoImpl extends AbstractDao<Integer, FeedbackMessage> implements MessageDao {

    @Override
    public List<FeedbackMessage> getAllMessage() throws Exception {
        return (List<FeedbackMessage>)(List<?>)hibernateTemplate.find("from FeedbackMessage");
    }

    @Override
    public FeedbackMessage getMessageById(Integer messageId) throws Exception {
        return getByKey(messageId);
    }

    @Override
    public void deleteMessage(FeedbackMessage feedbackMessage) throws Exception {
        delete(feedbackMessage);
    }

    @Override
    public void updateMessage(FeedbackMessage feedbackMessage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveMessage(FeedbackMessage feedbackMessage) throws Exception {
        save(feedbackMessage);
    }
    
}
