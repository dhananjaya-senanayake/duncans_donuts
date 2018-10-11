/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kln.se.duncans.service.order;

import edu.kln.se.duncans.dto.order.OrderDto;
import edu.kln.se.duncans.util.ResponseMessage;
import java.util.List;

/**
 *
 * @author senanayake
 */
public interface OrderService {
    public List<OrderDto> readAllOrders();
    public OrderDto getOrder(Integer orderId);
    public ResponseMessage cancelOrder(Integer orderId);
    public ResponseMessage changeOrder(OrderDto orderDto);
    public boolean changeOrderStatus(Integer orderId,String orderStatus);
    public ResponseMessage placeOrder(OrderDto orderDto);
}
