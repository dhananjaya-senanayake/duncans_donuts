/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kln.se.duncans.service.message;


import edu.kln.se.duncans.dto.message.MessageDto;
import edu.kln.se.duncans.util.ResponseMessage;
import java.util.List;

/**
 *
 * @author senanayake
 */
public interface MessageService {
    public List<MessageDto> readAllMessages();
    public MessageDto readMessage(Integer messageId);
    public ResponseMessage subscribeMessage(MessageDto messageDto);
    public ResponseMessage removeMessage(Integer messageId );
    public ResponseMessage changeMessage(MessageDto messageDto);
}
