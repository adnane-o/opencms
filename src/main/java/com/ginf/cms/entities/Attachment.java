package com.ginf.cms.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Adnane on 30/01/2015.
 */
@Entity
public class Attachment {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String url;

    @ManyToMany(mappedBy = "attachments")
    private List<Post> posts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

}