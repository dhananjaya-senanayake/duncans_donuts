/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kln.se.duncans.controller.rest;

import edu.kln.se.duncans.dto.order.OrderDto;
import edu.kln.se.duncans.service.order.OrderService;
import edu.kln.se.duncans.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
public class OrderRestController {
    
    @Autowired
    OrderDto orderDto;
    
    @Autowired
    OrderService orderService ;
    
    @RequestMapping(value = {"api/v1/orders/{orderId}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity getOrder(@PathVariable("orderId") Integer orderId) {

        orderDto = orderService.getOrder(orderId);
        if (null == orderDto) {
            
            return new ResponseEntity(orderDto, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(orderDto, HttpStatus.OK);
    }
    
    
    
    @RequestMapping(value = {"api/v1/orders"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity placeOrder(@RequestBody OrderDto orderDto) {
       
        ResponseMessage responseMessage = orderService.placeOrder(orderDto);
        
        if(responseMessage.getResponseMessage().equals("Couldn't Place Order Successfully ")){
            return new ResponseEntity(responseMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            
            return new ResponseEntity(responseMessage, HttpStatus.OK);
        }
        
    }
    
    @RequestMapping(value = {"api/v1/orders"}, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity changeOrder(@RequestBody OrderDto orderDto) {
       
        ResponseMessage responseMessage = orderService.changeOrder(orderDto);
        
        if(responseMessage.getResponseMessage().equals("Successfully Changed")){
            return new ResponseEntity(responseMessage, HttpStatus.OK);
        }else{
            return new ResponseEntity(responseMessage, HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
        
    }
    
    @RequestMapping(value = {"api/v1/orders/{orderId}"}, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity cancelOrder(@PathVariable("orderId") Integer orderId) {
       
        ResponseMessage responseMessage = orderService.cancelOrder(orderId);
        
        if(responseMessage.getResponseMessage().equals("Successfully Cancelled")){
            return new ResponseEntity(responseMessage, HttpStatus.OK);
        }else{
            return new ResponseEntity(responseMessage, HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
        
    }
}
