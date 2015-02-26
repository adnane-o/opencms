package com.ginf.cms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by Adnane on 30/01/2015.
 */
@Entity
public class Article extends Post {
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
        this.setContent(((Article) post).getContent());
    }

    @Override
    public boolean isDifferentFrom(Post post) {
        return super.isDifferentFrom(post) || !content.equals(((Article) post).content);
    }
}
