/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kln.se.duncans.controller;

import edu.kln.se.duncans.dto.order.OrderDto;
import edu.kln.se.duncans.exception.CustomGenericException;
import edu.kln.se.duncans.service.order.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author senanayake
 */
@Controller
@EnableWebMvc
public class OrderController {
    
    @Autowired
    OrderDto orderDto;
    
    @Autowired
    OrderService orderService ;
    
    @RequestMapping(value = {"/admin/viewOrderMore/","/admin/removeOrder/"}, method = RequestMethod.GET)
    public ModelAndView errorPageNotHavingPathVariables()throws Exception{
      
        throw new CustomGenericException("400","Please Include a Path Variable Value","/admin");
    
    }
    
    @RequestMapping(value = "/admin/searchOrder", method = RequestMethod.GET)
    public ModelAndView searchOrderPage(){
        ModelAndView mav = new ModelAndView("orders/search_order");
        
        return mav;
    }
    
    @RequestMapping(value = "/admin/searchOrder", method = RequestMethod.POST)
    public ModelAndView searchOrder(@RequestParam("orderId") String orderIdStr){
        
        try{
            int orderId = Integer.parseInt(orderIdStr);
            OrderDto orderDto = orderService.getOrder(orderId);
            
            ModelAndView mav = new ModelAndView("orders/search_order");
            mav.addObject("order", orderDto);
            mav.addObject("orderId", orderId);
            mav.addObject("showNotFound", true);
            
            return mav;
            
        }catch(NumberFormatException ex){
            System.err.println(ex.toString());
            throw new CustomGenericException("400", "OrderId Should be an Integer", "/admin/searchOrder");
        }
        
    }
    
    @RequestMapping(value = "/admin/viewOrders/{option}", method = RequestMethod.GET)
    public ModelAndView viewOrdersPage(@PathVariable("option") String option)throws Exception{
        List<OrderDto> orders =  orderService.readAllOrders();
        
        ModelAndView model = new ModelAndView();
        model.addObject("orders", orders);
        
        if(option.equalsIgnoreCase("info")){
            model.addObject("option", "info");
        }else if(option.equalsIgnoreCase("delete")){
            model.addObject("option", "delete");
        }else if(option.equalsIgnoreCase("update")){
            model.addObject("option", "update");
        }else{
            throw new CustomGenericException("400", "Path Variable Should be either 'info','update' or 'delete", "/admin");
        }
        
        
        model.setViewName("orders/view_orders");
        return model;
    }
    
    
    
    @RequestMapping(value = "/admin/removeOrder/{orderId}", method = RequestMethod.GET)
    public ModelAndView removeOrder(@PathVariable("orderId") String orderIdStr) throws Exception{
        try {
            int orderId = Integer.parseInt(orderIdStr);
            orderService.cancelOrder(orderId);

            ModelAndView model = this.viewOrdersPage("delete");
            return model;
        } catch (NumberFormatException ex) {
            System.out.println("Error : " + ex.toString());
            throw new CustomGenericException("400", "Please Include an integer for Path Variable Value", "/admin");
        }
    }
    
    @RequestMapping(value = "/admin/updateOrderStatus",method = RequestMethod.POST)
    public ModelAndView updateOrderStatus(@RequestParam(value = "orderId",required = false) String orderIdStr,@RequestParam(value = "orderStatus",required = false) String orderStatus) throws Exception{
        if(null == orderIdStr || null == orderStatus){
            throw new CustomGenericException("400","Please pass appropriate Vales for Parameters","/admin");
        }else{
            try {
                int orderId = Integer.parseInt(orderIdStr);
                boolean result = orderService.changeOrderStatus(orderId, orderStatus);
                
                ModelAndView mav = this.updateOrderStatusPage(orderIdStr);
                mav.addObject("message", "Successfully Changed Order Status of "+orderIdStr);
                return mav;
                
            } catch (NumberFormatException ex) {
                System.out.println("Error : " + ex.toString());
                throw new CustomGenericException("400", "Please pass an Integer as Order Id in Parameters", "/admin");
            }
        }
    }
    
    @RequestMapping(value = "/admin/viewUpdateOrderStatus/{orderId}", method = RequestMethod.GET)
    public ModelAndView updateOrderStatusPage(@PathVariable("orderId") String orderIdStr)throws Exception{
        
        
        try {
            int orderId = Integer.parseInt(orderIdStr);
            OrderDto orderDto = orderService.getOrder(orderId);

            ModelAndView model = new ModelAndView();
            model.addObject("order", orderDto);
            model.addObject("orderId", orderId);
            model.setViewName("orders/view_order_status_change");
            return model;
        } catch (NumberFormatException ex) {
            System.out.println("Error : " + ex.toString());
            throw new CustomGenericException("400", "Please Include an integer for Path Variable Value", "/admin");
        }
     
    }
    
    @RequestMapping(value = "/admin/viewOrderMore/{orderId}", method = RequestMethod.GET)
    public ModelAndView viewOrderMoreInfoPage(@PathVariable("orderId") String orderIdStr)throws Exception{
        
        
        try {
            int orderId = Integer.parseInt(orderIdStr);
            OrderDto orderDto = orderService.getOrder(orderId);

            ModelAndView model = new ModelAndView();
            model.addObject("order", orderDto);
            model.addObject("orderId", orderId);
            model.setViewName("orders/view_order_more_info");
            return model;
        } catch (NumberFormatException ex) {
            System.out.println("Error : " + ex.toString());
            throw new CustomGenericException("400", "Please Include an integer for Path Variable Value", "/admin");
        }
     
    }
}
