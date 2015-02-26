package com.ginf.cms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by Adnane on 30/01/2015.
 */
@Entity
public class Note extends Post {
    @Column
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void copyFrom(Post post) {
        super.copyFrom(post);
        this.content = ((Note) post).content;
    }

    @Override
    public boolean isDifferentFrom(Post post) {
        return super.isDifferentFrom(post) || !content.equals(((Note) post).content);
    }
}
