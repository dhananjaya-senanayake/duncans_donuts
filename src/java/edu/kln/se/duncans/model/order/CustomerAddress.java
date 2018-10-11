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
import javax.validation.constraints.Size;
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
@Table(name = "customer_address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerAddress.findAll", query = "SELECT c FROM CustomerAddress c")
    , @NamedQuery(name = "CustomerAddress.findByHouseNo", query = "SELECT c FROM CustomerAddress c WHERE c.houseNo = :houseNo")
    , @NamedQuery(name = "CustomerAddress.findByStreet", query = "SELECT c FROM CustomerAddress c WHERE c.street = :street")
    , @NamedQuery(name = "CustomerAddress.findByCity", query = "SELECT c FROM CustomerAddress c WHERE c.city = :city")
    , @NamedQuery(name = "CustomerAddress.findByState", query = "SELECT c FROM CustomerAddress c WHERE c.state = :state")
    , @NamedQuery(name = "CustomerAddress.findByZipCode", query = "SELECT c FROM CustomerAddress c WHERE c.zipCode = :zipCode")
    , @NamedQuery(name = "CustomerAddress.findByCustomerOrderOrderId", query = "SELECT c FROM CustomerAddress c WHERE c.customerOrderOrderId = :customerOrderOrderId")})
public class CustomerAddress implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "house_no")
    private String houseNo;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "street")
    private String street;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "city")
    private String city;
    
    @Size(max = 45)
    @Column(name = "state")
    private String state;
    
    @Size(max = 45)
    @Column(name = "zip_code")
    private String zipCode;
    
    @Id
    @Basic(optional = false)
    @Column(name = "customer_order_order_id")
    private Integer customerOrderOrderId;
    
    @JoinColumn(name = "customer_order_order_id", referencedColumnName = "customer_order_id", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Customer customer;

    public CustomerAddress() {
    }

    public CustomerAddress(Integer customerOrderOrderId) {
        this.customerOrderOrderId = customerOrderOrderId;
    }

    public CustomerAddress(Integer customerOrderOrderId, String houseNo, String street, String city) {
        this.customerOrderOrderId = customerOrderOrderId;
        this.houseNo = houseNo;
        this.street = street;
        this.city = city;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
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

    public Integer getCustomerOrderOrderId() {
        return customerOrderOrderId;
    }

    public void setCustomerOrderOrderId(Integer customerOrderOrderId) {
        this.customerOrderOrderId = customerOrderOrderId;
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
        hash += (customerOrderOrderId != null ? customerOrderOrderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerAddress)) {
            return false;
        }
        CustomerAddress other = (CustomerAddress) object;
        if ((this.customerOrderOrderId == null && other.customerOrderOrderId != null) || (this.customerOrderOrderId != null && !this.customerOrderOrderId.equals(other.customerOrderOrderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ijse.absd.duncans.model.CustomerAddress[ customerOrderOrderId=" + customerOrderOrderId + " ]";
    }
    
}
