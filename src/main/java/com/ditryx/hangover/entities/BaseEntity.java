package com.ditryx.hangover.entities;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@MappedSuperclass
public class BaseEntity {

    private long id;
    private Timestamp create_date;
    private Timestamp update_date;
    private Status status;

    private static final Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

    public BaseEntity() {
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @PrePersist
    public void prePersist() {
        if(create_date == null)
            create_date = currentTimestamp;
        if(update_date == null)
            update_date = currentTimestamp;
        if(status == null)
            status = Status.ACTIVE ;
    }

    @CreatedDate
    @Column(name = "create_date", nullable = false)
    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    @LastModifiedDate
    @Column(name = "update_date", nullable = false)
    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Timestamp update_date) {
        this.update_date = update_date;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
