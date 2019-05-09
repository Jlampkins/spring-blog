package com.codeup.blog.models;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "text")
    private String body;

    @OneToOne
    private User user;

    //used for Create (C)
    public Post(){
    }

    //used EDIT (U)
    public Post(String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.user = user;
    }

    //used for READ (R)
    public Post(long id, String title, String body, User user){
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
    }

    //used for Delete (D) -- this is done by CRUDRepo
    public Post(long id){
        this.id = id;
    }





    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public User getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(User author) {
//        this.author = author;
//    }
}




