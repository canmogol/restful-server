package com.fererlab.core.model;


import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;
import org.hibernate.envers.RevisionEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@RevisionEntity(UserRevisionEntityListener.class)
public class UserRevisionEntity {

    @Id
    @GeneratedValue
    @RevisionNumber
    private int id;

    @RevisionTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    private String username;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
