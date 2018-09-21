package com.xc.libsystem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(value = "users")
@Entity
public class Book {

    private Integer bid;
    private String bookName;

    private Set<User> users = new HashSet<>();

    @Id
    @GeneratedValue
    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    @Column
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @ManyToMany(mappedBy = "books")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
