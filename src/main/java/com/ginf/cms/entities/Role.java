package com.ginf.cms.entities;

import javax.persistence.*;

/**
 * Created by Adnane on 30/01/2015.
 */
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "authority"})})
public class Role {
    public enum Authority {
        USER_ROLE,
        ADMIN_ROLE
    }

    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;
    @Column
    private String authority;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;

        Role role = (Role) o;

        return !(authority != null ? !authority.equals(role.authority) : role.authority != null);

    }

    @Override
    public int hashCode() {
        return authority != null ? authority.hashCode() : 0;
    }
}
