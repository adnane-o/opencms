package com.ginf.cms.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

/**
 * Created by Adnane on 30/01/2015.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "post_type")
public abstract class Post {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();

    @Column
    private String title;

    @Column
    private boolean published = true;

    @Column
    private boolean commentsState = true;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "post_category",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories = new ArrayList<>();

    @ManyToMany(cascade = ALL)
    @JoinTable(name = "post_attachment",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "attachment_id"))
    private List<Attachment> attachments = new ArrayList<Attachment>();

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
    private List<Comment> comments = new ArrayList<Comment>();

    @OneToMany(mappedBy = "newVersion", fetch = FetchType.EAGER)
    @OrderBy(value = "date desc")
    private List<Post> oldVersions = new ArrayList<Post>();

    @ManyToOne
    @JoinColumn(name = "new")
    private Post newVersion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getAuthor() {
        return author;
    }


    public void setAuthor(User author) {
        this.author = author;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Category> getCategories() {
        return categories;
    }


    public void setCategories(List<Category> categories) {
        HashSet<Category> hs = new HashSet<Category>();
        hs.addAll(categories);
        categories.clear();
        categories.addAll(hs);
        this.categories = categories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCommentsState() {
        return commentsState;
    }

    public void setCommentsState(Boolean commentsState) {
        this.commentsState = commentsState;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public void copyFrom(Post post) {
        this.setTitle(post.getTitle());
        this.setPublished(post.getPublished());
        this.setCommentsState(post.getCommentsState());
    }

    public boolean isDifferentFrom(Post post) {
        return !post.getTitle().equals(title);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;

        Post post = (Post) o;

        if (id != null ? !id.equals(post.id) : post.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public List<Post> getOldVersions() {
        return oldVersions;
    }

    public void setOldVersions(List<Post> oldVersions) {
        this.oldVersions = oldVersions;
    }

    public Post getNewVersion() {
        return newVersion;
    }

    public void setNewVersion(Post newVersion) {
        this.newVersion = newVersion;
    }
}
