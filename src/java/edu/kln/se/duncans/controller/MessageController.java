/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kln.se.duncans.controller;

import edu.kln.se.duncans.dto.message.MessageDto;
import edu.kln.se.duncans.exception.CustomGenericException;
import edu.kln.se.duncans.service.message.MessageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author senanayake
 */
@Controller
@EnableWebMvc
public class MessageController {
    @Autowired
    MessageService messageService ;
    
    @Autowired
    MessageDto messageDto ;
    
    @RequestMapping(value = {"/admin/viewMessagesMore/","/admin/removeMessage/"}, method = RequestMethod.GET)
    public ModelAndView errorPageNotHavingPathVariables()throws Exception{
      
        throw new CustomGenericException("400","Please Include a Path Variable Value","/admin");
    
    }
    
    @RequestMapping(value = "/admin/removeMessage/{messageId}", method = RequestMethod.GET)
    public ModelAndView removeMessage(@PathVariable("messageId") String messageIdStr) throws Exception{
        try {
            int messageId = Integer.parseInt(messageIdStr);
            messageService.removeMessage(messageId);

            ModelAndView model = this.viewMessagePage("delete");
            return model;
        } catch (NumberFormatException ex) {
            System.out.println("Error : " + ex.toString());
            throw new CustomGenericException("400", "Please Include an integer for Path Variable Value", "/admin");
        }
    }
    
    @RequestMapping(value = "/admin/viewMessagesMore/{messageId}", method = RequestMethod.GET)
    public ModelAndView viewMessageMoreInfoPage(@PathVariable("messageId") String messageIdStr)throws Exception{
      
        try {
            int messageId = Integer.parseInt(messageIdStr);
            
            MessageDto message = messageService.readMessage(messageId);

            ModelAndView model = new ModelAndView();
            model.addObject("message", message);
            model.addObject("messageId", messageId);
            model.setViewName("messages/view_messages_more_info");
            return model;
        } catch (NumberFormatException ex) {
            System.out.println("Error : " + ex.toString());
            throw new CustomGenericException("400", "Please Include an integer for Path Variable Value", "/admin");
        }
     
    }
    
    @RequestMapping(value = {"/admin/viewMessages/{option}"}, method = RequestMethod.GET)
    public ModelAndView viewMessagePage(@PathVariable("option") String option)throws Exception{
      
        List<MessageDto> messages = messageService.readAllMessages();
        
        ModelAndView model = new ModelAndView();
        model.addObject("messages", messages);
        
        if(option.equalsIgnoreCase("info")){
            model.addObject("option", "info");
        }else if(option.equalsIgnoreCase("delete")){
            model.addObject("option", "delete");
        }else{
            throw new CustomGenericException("400", "Path Variable Should be either 'info','update' or 'delete", "/admin");
        }
        
        model.setViewName("messages/view_messages");
        return model;
    }
}
