/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kln.se.duncans.dto.order;

import java.util.Date;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author senanayake
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class OrderDto {
    
        
    private Integer orderId;
    private Date orderDate ;
    private Date orderTime ;
    private Date orderDueDate ;
    private String orderStatus ;
    private float subTotal ;
    private float tax ;
    private float total ;
    private Integer noOfCakeDonuts;
    private Integer noOfGlazedDonuts;
    private String customerName ;
    private String customerContact ;
    private String customerEmail ;
    private String houseNumber ;
    private String street ;
    private String city ;
    private String state ;
    private String zipCode ;

    public OrderDto() {
    }

    public OrderDto(Integer orderId, Date orderDate, Date orderTime, Date orderDueDate, String orderStatus, float subTotal, float tax, float total, Integer noOfCakeDonuts, Integer noOfGlazedDonuts, String customerName, String customerContact, String customerEmail, String houseNumber, String street, String city, String state, String zipCode) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.orderDueDate = orderDueDate;
        this.orderStatus = orderStatus;
        this.subTotal = subTotal;
        this.tax = tax;
        this.total = total;
        this.noOfCakeDonuts = noOfCakeDonuts;
        this.noOfGlazedDonuts = noOfGlazedDonuts;
        this.customerName = customerName;
        this.customerContact = customerContact;
        this.customerEmail = customerEmail;
        this.houseNumber = houseNumber;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
    
    


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getOrderDueDate() {
        return orderDueDate;
    }

    public void setOrderDueDate(Date orderDueDate) {
        this.orderDueDate = orderDueDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Integer getNoOfCakeDonuts() {
        return noOfCakeDonuts;
    }

    public void setNoOfCakeDonuts(Integer noOfCakeDonuts) {
        this.noOfCakeDonuts = noOfCakeDonuts;
    }

    public Integer getNoOfGlazedDonuts() {
        return noOfGlazedDonuts;
    }

    public void setNoOfGlazedDonuts(Integer noOfGlazedDonuts) {
        this.noOfGlazedDonuts = noOfGlazedDonuts;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    
}
