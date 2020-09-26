package com.ditryx.hangover.entities;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Timestamp;

import static javax.persistence.GenerationType.IDENTITY;

@MappedSuperclass
public class BaseEntity {

    private long id;
    private Timestamp createDate;
    private Timestamp updateDate;
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
        if(createDate == null)
            createDate = currentTimestamp;
        if(updateDate == null)
            updateDate = currentTimestamp;
        if(status == null)
            status = Status.ACTIVE ;
    }

    @CreatedDate
    @Column(name = "create_date", nullable = false)
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp create_date) {
        this.createDate = create_date;
    }

    @LastModifiedDate
    @Column(name = "update_date", nullable = false)
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
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
