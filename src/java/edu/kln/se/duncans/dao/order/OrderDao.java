/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kln.se.duncans.dao.order;

import edu.kln.se.duncans.model.order.PlaceOrder;
import java.util.List;

/**
 *
 * @author senanayake
 */
public interface OrderDao {
    public List<PlaceOrder> getAllOrders() throws Exception;
    public PlaceOrder getOrderById(Integer orderId) throws Exception  ;
    public void deleteOrder(PlaceOrder order) throws Exception;
    public void updateOrder(PlaceOrder order) throws Exception;
    public void saveOrder(PlaceOrder order) throws Exception ;
    public int getHighestOrderId() throws Exception;
}
