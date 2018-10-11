/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kln.se.duncans.controller.rest;


import edu.kln.se.duncans.dto.message.MessageDto;
import edu.kln.se.duncans.service.message.MessageService;
import edu.kln.se.duncans.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author senanayake
 */
@RestController
@EnableWebMvc
public class MessageRestController {
    
    @Autowired
    MessageService messageService ;
    
    @Autowired
    MessageDto messageDto ;
    
    
    @RequestMapping(value = {"api/v1/messages"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity subscribeMessage(@RequestBody MessageDto messageDto) {
       
        ResponseMessage responseMessage = messageService.subscribeMessage(messageDto);
        if(responseMessage.getResponseMessage().equals("Succesfully Subscribed")){
            return new ResponseEntity(responseMessage, HttpStatus.OK);
        }else{
            return new ResponseEntity(responseMessage, HttpStatus.BAD_REQUEST);
            
        }
        
    }
    
}
    