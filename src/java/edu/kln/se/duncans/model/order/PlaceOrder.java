/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kln.se.duncans.model.order;

import edu.kln.se.duncans.util.OrderStatus;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author senanayake
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Entity
@Table(name = "place_order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlaceOrder.findAll", query = "SELECT p FROM PlaceOrder p")
    , @NamedQuery(name = "PlaceOrder.findByOrderId", query = "SELECT p FROM PlaceOrder p WHERE p.orderId = :orderId")
    , @NamedQuery(name = "PlaceOrder.findByOrderDate", query = "SELECT p FROM PlaceOrder p WHERE p.orderDate = :orderDate")
    , @NamedQuery(name = "PlaceOrder.findByOrderTime", query = "SELECT p FROM PlaceOrder p WHERE p.orderTime = :orderTime")
    , @NamedQuery(name = "PlaceOrder.findByOrderDueDate", query = "SELECT p FROM PlaceOrder p WHERE p.orderDueDate = :orderDueDate")
    , @NamedQuery(name = "PlaceOrder.findByStatus", query = "SELECT p FROM PlaceOrder p WHERE p.status = :status")
    , @NamedQuery(name = "PlaceOrder.findBySubTotal", query = "SELECT p FROM PlaceOrder p WHERE p.subTotal = :subTotal")
    , @NamedQuery(name = "PlaceOrder.findByTax", query = "SELECT p FROM PlaceOrder p WHERE p.tax = :tax")})
public class PlaceOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "order_id")
    private Integer orderId;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_date")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_time")
    @Temporal(TemporalType.TIME)
    private Date orderTime;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_due_date")
    @Temporal(TemporalType.DATE)
    private Date orderDueDate;
    
    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private OrderStatus status;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "sub_total")
    private float subTotal;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "tax")
    private float tax;
    
    @Autowired
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "placeOrder", fetch = FetchType.EAGER)
    private OrderDetail orderDetail;
    
    @Autowired
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "placeOrder", fetch = FetchType.EAGER)
    private Customer customer;

    public PlaceOrder() {
    }

    public PlaceOrder(Integer orderId) {
        this.orderId = orderId;
    }

    public PlaceOrder(Integer orderId, Date orderDate, Date orderTime, Date orderDueDate, OrderStatus status, float subTotal, float tax) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.orderDueDate = orderDueDate;
        this.status = status;
        this.subTotal = subTotal;
        this.tax = tax;
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

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
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

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlaceOrder)) {
            return false;
        }
        PlaceOrder other = (PlaceOrder) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ijse.absd.duncans.model.PlaceOrder[ orderId=" + orderId + " ]";
    }
    
}
