/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kln.se.duncans.model.order;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
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
@Table(name = "order_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderDetail.findAll", query = "SELECT o FROM OrderDetail o")
    , @NamedQuery(name = "OrderDetail.findByOrderOrderId", query = "SELECT o FROM OrderDetail o WHERE o.orderOrderId = :orderOrderId")
    , @NamedQuery(name = "OrderDetail.findByNoOfCakeDonuts", query = "SELECT o FROM OrderDetail o WHERE o.noOfCakeDonuts = :noOfCakeDonuts")
    , @NamedQuery(name = "OrderDetail.findByNoOfGlazedDonuts", query = "SELECT o FROM OrderDetail o WHERE o.noOfGlazedDonuts = :noOfGlazedDonuts")})
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "order_order_id")
    private Integer orderOrderId;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "no_of_cake_donuts")
    private int noOfCakeDonuts;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "no_of_glazed_donuts")
    private int noOfGlazedDonuts;
    
    @JoinColumn(name = "order_order_id", referencedColumnName = "order_id", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private PlaceOrder placeOrder;

    public OrderDetail() {
    }

    public OrderDetail(Integer orderOrderId) {
        this.orderOrderId = orderOrderId;
    }

    public OrderDetail(Integer orderOrderId, int noOfCakeDonuts, int noOfGlazedDonuts) {
        this.orderOrderId = orderOrderId;
        this.noOfCakeDonuts = noOfCakeDonuts;
        this.noOfGlazedDonuts = noOfGlazedDonuts;
    }

    public Integer getOrderOrderId() {
        return orderOrderId;
    }

    public void setOrderOrderId(Integer orderOrderId) {
        this.orderOrderId = orderOrderId;
    }

    public int getNoOfCakeDonuts() {
        return noOfCakeDonuts;
    }

    public void setNoOfCakeDonuts(int noOfCakeDonuts) {
        this.noOfCakeDonuts = noOfCakeDonuts;
    }

    public int getNoOfGlazedDonuts() {
        return noOfGlazedDonuts;
    }

    public void setNoOfGlazedDonuts(int noOfGlazedDonuts) {
        this.noOfGlazedDonuts = noOfGlazedDonuts;
    }

    public PlaceOrder getPlaceOrder() {
        return placeOrder;
    }

    public void setPlaceOrder(PlaceOrder placeOrder) {
        this.placeOrder = placeOrder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderOrderId != null ? orderOrderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderDetail)) {
            return false;
        }
        OrderDetail other = (OrderDetail) object;
        if ((this.orderOrderId == null && other.orderOrderId != null) || (this.orderOrderId != null && !this.orderOrderId.equals(other.orderOrderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ijse.absd.duncans.model.OrderDetail[ orderOrderId=" + orderOrderId + " ]";
    }
    
}
