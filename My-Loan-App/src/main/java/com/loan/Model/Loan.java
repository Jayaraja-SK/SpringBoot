package com.loan.Model;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

@Entity
public class Loan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;
    
    @Column(nullable = false)
    private String status;
    
    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private String purpose;
    
    @Column(nullable = false)
    private int emiMonths;
    
    @Column(nullable = false)
    private float interest;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

  /*public Loan(UUID id, String status, double amount, String purpose, int emiMonths, float intrest, User user) {
    this.id = id;
    this.status = status;
    this.amount = amount;
    this.purpose = purpose;
    this.emiMonths = emiMonths;
    this.intrest = intrest;
    this.user = user;
  }

  public Loan() {

  }*/

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public int getEmiMonths() {
        return emiMonths;
    }

    public void setEmiMonths(int emiMonths) {
        this.emiMonths = emiMonths;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float intrest) {
        this.interest = interest;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;

    }
}
