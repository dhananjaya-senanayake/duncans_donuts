/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kln.se.duncans.service.order;

import edu.kln.se.duncans.dao.order.OrderDao;
import edu.kln.se.duncans.dto.order.OrderDto;
import edu.kln.se.duncans.model.order.PlaceOrder;
import edu.kln.se.duncans.util.DtoEntityMapper;
import edu.kln.se.duncans.util.OrderStatus;
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
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderDao orderDao ;
    
    @Autowired
    DtoEntityMapper dtoEntityMapper;
    
    @Autowired
    ResponseMessage responseMessage;
    
    
    @Override
    public List<OrderDto> readAllOrders() {
        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
        List<OrderDto> orderDtos = new ArrayList<>();
        try {
            List<PlaceOrder> placeOrders = orderDao.getAllOrders();
            
            if(placeOrders != null && !placeOrders.isEmpty()){
                
                for(PlaceOrder po : placeOrders){
                    orderDtos.add( dtoEntityMapper.convertPlaceOrderEntityToDto(po));
                }
                
            }
            
        } catch (Exception ex) {
            System.out.println(ex.toString());
            Logger.getLogger(OrderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return  orderDtos;
    }

    @Override
    @Transactional
    public OrderDto getOrder(Integer orderId) {
        
        try {
            PlaceOrder order = orderDao.getOrderById(orderId);            
            return dtoEntityMapper.convertPlaceOrderEntityToDto(order);
            
            
        } catch (Exception ex) {
            Logger.getLogger(OrderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.toString());
            return  null ;
        }
        
    }

    
    @Override
    @Transactional
    public ResponseMessage cancelOrder(Integer orderId) {
        try {
            PlaceOrder deleteOrder = orderDao.getOrderById(orderId);
            orderDao.deleteOrder(deleteOrder);
            responseMessage.setResponseMessage("Successfully Cancelled");
        } catch (Exception ex) {
            Logger.getLogger(OrderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            responseMessage.setResponseMessage("Couldn't Cancel the Order "+ex.toString());
        }
        
        return responseMessage;
    }

    @Override
    @Transactional
    public ResponseMessage changeOrder(OrderDto orderDto) {
        
        try {
            PlaceOrder placeOrder = dtoEntityMapper.convertOrderDtoToEntity(orderDto);
            orderDao.updateOrder(placeOrder);
            responseMessage.setResponseMessage("Successfully Changed");
        } catch (Exception ex) {
            Logger.getLogger(OrderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            responseMessage.setResponseMessage("Couldn't Change the Order "+ex.toString());
        }
        
        return responseMessage;
    }

    @Override
    @Transactional
    public ResponseMessage placeOrder(OrderDto orderDto) {
        
        
        
        try {
            //setting the order id
            int orderId = this.generateOrderId();
            orderDto.setOrderId(orderId);
            PlaceOrder placeOrder = dtoEntityMapper.convertOrderDtoToEntity(orderDto);
            
            System.out.println(placeOrder.getOrderId());
            orderDao.saveOrder(placeOrder);
            responseMessage.setResponseMessage(String.valueOf(orderId));
        } catch (Exception ex) {
            Logger.getLogger(OrderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            responseMessage.setResponseMessage("Couldn't Place Order Successfully "+ex.toString());
        }
        
        return responseMessage;
    }
    
    private int generateOrderId() throws Exception{
        
        try {
            return  orderDao.getHighestOrderId()+1;
        } catch (NullPointerException nEx) {
            return 1 ;
        } 
        
    }

    @Override
    @Transactional
    public boolean changeOrderStatus(Integer orderId, String orderStatus) {
        try {
            PlaceOrder changeOrder = orderDao.getOrderById(orderId);
            
            if (changeOrder != null){
                changeOrder.setStatus(OrderStatus.getOrderStatusEnum(orderStatus));
                orderDao.updateOrder(changeOrder);
            }
            return true ;
        } catch (Exception ex) {
            System.err.println(ex.toString());
            Logger.getLogger(OrderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false ;
        }
    }
    
}
