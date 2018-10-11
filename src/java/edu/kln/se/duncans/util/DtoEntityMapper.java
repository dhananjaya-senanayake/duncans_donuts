/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kln.se.duncans.util;

import edu.kln.se.duncans.dto.message.MessageDto;
import edu.kln.se.duncans.dto.order.OrderDto;
import edu.kln.se.duncans.model.message.FeedbackMessage;
import edu.kln.se.duncans.model.order.PlaceOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author senanayake
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DtoEntityMapper {

   

    @Autowired
    ApplicationContext context;
    
    public FeedbackMessage convertMessageDtoToEntity(MessageDto messageDto){
        FeedbackMessage feedbackMessage = context.getBean(FeedbackMessage.class);
        
        if(messageDto.getMessageId() != null){
            feedbackMessage.setMessageId(messageDto.getMessageId());
        }
        feedbackMessage.setUserName(messageDto.getUserName());
        feedbackMessage.setMessageSubject(messageDto.getMessageSubject());
        feedbackMessage.setEMail(messageDto.getUserEmail());
        feedbackMessage.setMessage(messageDto.getMessageContent());
        
        return feedbackMessage;
    }
    
    public MessageDto convertFeedbackEntitytoDto(FeedbackMessage feedbackMessage){
        MessageDto messageDto = context.getBean(MessageDto.class);
        
        messageDto.setMessageId(feedbackMessage.getMessageId());
        messageDto.setUserName(feedbackMessage.getUserName());
        messageDto.setMessageSubject(feedbackMessage.getMessageSubject());
        messageDto.setUserEmail(feedbackMessage.getEMail());
        messageDto.setMessageContent(feedbackMessage.getMessage());
        
        return messageDto;
    }

    public PlaceOrder convertOrderDtoToEntity(OrderDto orderDto) {
        
        PlaceOrder placeOrder = context.getBean(PlaceOrder.class);
        //setting place order
        placeOrder.setOrderId(orderDto.getOrderId());
        placeOrder.setOrderDate(orderDto.getOrderDate());
        placeOrder.setOrderTime(orderDto.getOrderTime());
        placeOrder.setOrderDueDate(orderDto.getOrderDueDate());
        placeOrder.setStatus(OrderStatus.getOrderStatusEnum(orderDto.getOrderStatus()));
        placeOrder.setSubTotal(orderDto.getSubTotal());
        placeOrder.setTax(orderDto.getTax());

        //setting customer details
        placeOrder.getCustomer().setCustomerOrderId(orderDto.getOrderId());
        placeOrder.getCustomer().setCustomerName(orderDto.getCustomerName());
        placeOrder.getCustomer().setCustomerEmail(orderDto.getCustomerEmail());
        placeOrder.getCustomer().setCustomerContact(orderDto.getCustomerContact());

        //setting customer address
        placeOrder.getCustomer().getCustomerAddress().setCustomerOrderOrderId(orderDto.getOrderId());
        placeOrder.getCustomer().getCustomerAddress().setHouseNo(orderDto.getHouseNumber());
        placeOrder.getCustomer().getCustomerAddress().setStreet(orderDto.getStreet());
        placeOrder.getCustomer().getCustomerAddress().setCity(orderDto.getCity());
        placeOrder.getCustomer().getCustomerAddress().setState(orderDto.getState());
        placeOrder.getCustomer().getCustomerAddress().setZipCode(orderDto.getZipCode());



        //setting order details
        placeOrder.getOrderDetail().setOrderOrderId(orderDto.getOrderId());
        placeOrder.getOrderDetail().setNoOfCakeDonuts(orderDto.getNoOfCakeDonuts());
        placeOrder.getOrderDetail().setNoOfGlazedDonuts(orderDto.getNoOfGlazedDonuts());


        return placeOrder;
    }

    public OrderDto convertPlaceOrderEntityToDto(PlaceOrder placeOrder) {
        System.out.println("OrderId" + placeOrder.getOrderId());
        
        OrderDto orderDto = context.getBean(OrderDto.class);
        
        //unwrapping customer details
        orderDto.setCustomerName(placeOrder.getCustomer().getCustomerName());
        orderDto.setCustomerContact(placeOrder.getCustomer().getCustomerContact());
        orderDto.setCustomerEmail(placeOrder.getCustomer().getCustomerEmail());

        //unwrapping  details
        orderDto.setHouseNumber(placeOrder.getCustomer().getCustomerAddress().getHouseNo());
        orderDto.setStreet(placeOrder.getCustomer().getCustomerAddress().getStreet());
        orderDto.setCity(placeOrder.getCustomer().getCustomerAddress().getCity());
        orderDto.setState(placeOrder.getCustomer().getCustomerAddress().getState());
        orderDto.setZipCode(placeOrder.getCustomer().getCustomerAddress().getZipCode());

        //unwrapping order details
        orderDto.setNoOfCakeDonuts(placeOrder.getOrderDetail().getNoOfCakeDonuts());
        orderDto.setNoOfGlazedDonuts(placeOrder.getOrderDetail().getNoOfGlazedDonuts());

        //unwrapping place order
        orderDto.setOrderId(placeOrder.getOrderId());
        orderDto.setOrderDate(placeOrder.getOrderDate());
        orderDto.setOrderTime(placeOrder.getOrderTime());
        orderDto.setOrderDueDate(placeOrder.getOrderDueDate());
        orderDto.setOrderStatus(OrderStatus.getOrderStatusString(placeOrder.getStatus()));
        orderDto.setSubTotal(placeOrder.getSubTotal());
        orderDto.setTax(placeOrder.getTax());
        orderDto.setTotal((orderDto.getSubTotal() + orderDto.getTax()));

        return orderDto;

    }
}
