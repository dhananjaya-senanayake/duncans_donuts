/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kln.se.duncans.model.message;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "feedback_message")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FeedbackMessage.findAll", query = "SELECT f FROM FeedbackMessage f")
    , @NamedQuery(name = "FeedbackMessage.findByMessageId", query = "SELECT f FROM FeedbackMessage f WHERE f.messageId = :messageId")
    , @NamedQuery(name = "FeedbackMessage.findByUserName", query = "SELECT f FROM FeedbackMessage f WHERE f.userName = :userName")
    , @NamedQuery(name = "FeedbackMessage.findByMessageSubject", query = "SELECT f FROM FeedbackMessage f WHERE f.messageSubject = :messageSubject")
    , @NamedQuery(name = "FeedbackMessage.findByEMail", query = "SELECT f FROM FeedbackMessage f WHERE f.eMail = :eMail")
    , @NamedQuery(name = "FeedbackMessage.findByMessage", query = "SELECT f FROM FeedbackMessage f WHERE f.message = :message")})
public class FeedbackMessage implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "message_id")
    private Integer messageId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "user_name")
    private String userName;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "message_subject")
    private String messageSubject;
    
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "e_mail")
    private String eMail;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 600)
    @Column(name = "message")
    private String message;

    public FeedbackMessage() {
    }

    public FeedbackMessage(Integer messageId) {
        this.messageId = messageId;
    }

    public FeedbackMessage(Integer messageId, String userName, String messageSubject, String eMail, String message) {
        this.messageId = messageId;
        this.userName = userName;
        this.messageSubject = messageSubject;
        this.eMail = eMail;
        this.message = message;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessageSubject() {
        return messageSubject;
    }

    public void setMessageSubject(String messageSubject) {
        this.messageSubject = messageSubject;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (messageId != null ? messageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FeedbackMessage)) {
            return false;
        }
        FeedbackMessage other = (FeedbackMessage) object;
        if ((this.messageId == null && other.messageId != null) || (this.messageId != null && !this.messageId.equals(other.messageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ijse.absd.duncans.model.message.FeedbackMessage[ messageId=" + messageId + " ]";
    }
    
}
