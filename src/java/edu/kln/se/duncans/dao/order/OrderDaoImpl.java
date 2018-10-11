/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kln.se.duncans.dao.order;

import edu.kln.se.duncans.dao.AbstractDao;
import edu.kln.se.duncans.model.order.PlaceOrder;
import java.util.List;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

/**
 *
 * @author senanayake
 */
@Repository
public class OrderDaoImpl extends AbstractDao<Integer, PlaceOrder> implements OrderDao {


    
    @Override
    public List<PlaceOrder> getAllOrders() throws Exception {
        return (List<PlaceOrder>)(List<?>)hibernateTemplate.find("from PlaceOrder");
    }

    @Override
    public PlaceOrder getOrderById(Integer orderId) throws Exception {
        return getByKey(orderId);
    }

    @Override
    public void deleteOrder(PlaceOrder order) throws Exception {
        delete(order);
    }

    @Override
    public void updateOrder(PlaceOrder order) throws Exception {
        merge(order);
    }

    @Override
    public void saveOrder(PlaceOrder order) throws Exception {
        save(order);
    }

    @Override
    public int getHighestOrderId() throws Exception {
        return DataAccessUtils.intResult(hibernateTemplate.find("select max(p.orderId) from PlaceOrder p"));
    }


    
    
}
