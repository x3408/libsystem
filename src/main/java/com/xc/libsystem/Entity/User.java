package com.xc.libsystem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@JsonIgnoreProperties(value = "books")
public class User {

    private Integer uid;
    private String account;
    private String username;
    private String password;
    private Set<Book> books = new HashSet<>();

    @Id
    @GeneratedValue
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Column
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Column
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_book",
            joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "uid")},
            inverseJoinColumns = {
            @JoinColumn(name = "book_id", referencedColumnName = "bid")})
    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
