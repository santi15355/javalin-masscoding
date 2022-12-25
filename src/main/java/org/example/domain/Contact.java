package org.example.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.ebean.Finder;
import io.ebean.Model;
import io.ebean.annotation.WhenCreated;
import jdk.jfr.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Entity
public class Contact extends Model {

    @Id
    private Long id;
    private String name;
    private String phoneNumber;

    public static ContactFinder find = new ContactFinder();

    @WhenCreated
    private Instant createdAt = Instant.now();

    public Contact() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Contact(Long id, String name, String phoneNumber, Instant createdAt) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
    }

    public static class ContactFinder extends Finder<Long, Contact> {
        private ContactFinder() {
            super(Contact.class);
        }

    }

}
