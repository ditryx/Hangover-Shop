package com.ditryx.hangover.entities;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="orders")
public class Order extends BaseEntity{

    private User user;
    private Set<OrderPosition> orderPositionList;
    private double totalCoast;

    public Order() {
    }

    public Order(User user, Set<OrderPosition> orderPositionList, double totalCoast) {
        this.user = user;
        this.orderPositionList = orderPositionList;
        this.totalCoast = totalCoast;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany
    public Set<OrderPosition> getOrderPositionList() {
        return orderPositionList;
    }

    public void setOrderPositionList(Set<OrderPosition> orderPositionList) {
        this.orderPositionList = orderPositionList;
    }

    @Column
    public double getTotalCoast() {
        return totalCoast;
    }

    public void setTotalCoast(double totalCoast) {
        this.totalCoast = totalCoast;
    }
}
