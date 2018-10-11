/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kln.se.duncans.util;

/**
 *
 * @author senanayake
 */
public enum OrderStatus {
    PENDING,IN_PROGRESS,IN_DELIVERY;
    
    public static String getOrderStatusString(OrderStatus orderStatus){
        
        switch(orderStatus){
            case PENDING : return "Pending";
            case IN_PROGRESS : return "In Progress";
            case IN_DELIVERY : return "In Delivery";
            default: return null ;
        }

    }
    
    public static OrderStatus getOrderStatusEnum(String orderStatus){
        switch(orderStatus){
            case "Pending" : return  OrderStatus.PENDING;
            case "In Progress" : return OrderStatus.IN_PROGRESS;
            case "In Delivery" : return  OrderStatus.IN_DELIVERY;
            default: return null ;
        }
    }
    
    @Override
    public String toString(){
        switch(this){
            case PENDING : return "Pending";
            case IN_PROGRESS : return "In Progress";
            case IN_DELIVERY : return "In Delivery";
            default: return null ;
        }
    }
    
}
