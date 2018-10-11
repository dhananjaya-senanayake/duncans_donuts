/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kln.se.duncans.service.message;


import edu.kln.se.duncans.dao.message.MessageDao;
import edu.kln.se.duncans.dto.message.MessageDto;
import edu.kln.se.duncans.model.message.FeedbackMessage;
import edu.kln.se.duncans.util.DtoEntityMapper;
import edu.kln.se.duncans.util.ResponseMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author senanayake
 */
@Service 
public class MessageServiceImpl implements MessageService{

    @Autowired
    MessageDao messageDao ;
    
    @Autowired
    ResponseMessage responseMessage;
    
    @Autowired
    DtoEntityMapper dtoEntityMapper;
    
    @Override
    public List<MessageDto> readAllMessages() {
        List<MessageDto> messages = new ArrayList<>();
        
        try {
            List<FeedbackMessage> feedbackMessages = messageDao.getAllMessage();
            
            for(FeedbackMessage fm : feedbackMessages){
                messages.add(dtoEntityMapper.convertFeedbackEntitytoDto(fm));
            }
        } catch (Exception ex) {
            System.err.println(ex.toString());
            Logger.getLogger(MessageServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return messages;
    }

    @Override
    @Transactional
    public MessageDto readMessage(Integer messageId) {
        
        try {
            FeedbackMessage feedbackMessage = messageDao.getMessageById(messageId);
            if(feedbackMessage == null){
                return null ;
            }else{
                MessageDto messageDto = dtoEntityMapper.convertFeedbackEntitytoDto(feedbackMessage);
                
                return messageDto ;
            }
        } catch (Exception ex) {
            Logger.getLogger(MessageServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null ;
        }
        
        
    }

    @Override
    @Transactional
    public ResponseMessage subscribeMessage(MessageDto messageDto) {
        
        FeedbackMessage feedbackMessage = dtoEntityMapper.convertMessageDtoToEntity(messageDto);
        
       
        try {
            messageDao.saveMessage(feedbackMessage);
            responseMessage.setResponseMessage("Succesfully Subscribed");
            
        } catch (Exception ex) {
            Logger.getLogger(MessageServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            responseMessage.setResponseMessage(ex.toString());
            
        }
        
        return responseMessage ;
    }

    @Override
    @Transactional
    public ResponseMessage removeMessage(Integer messageId) {
        
        try {
            FeedbackMessage deleteMessage = messageDao.getMessageById(messageId);
            messageDao.deleteMessage(deleteMessage);
            responseMessage.setResponseMessage("Successfully Removed");
        } catch (Exception ex) {
            System.err.println("Error : "+ex.toString());
            responseMessage.setResponseMessage(ex.toString());
            Logger.getLogger(MessageServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return responseMessage;
    }

    @Override
    public ResponseMessage changeMessage(MessageDto messageDto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
