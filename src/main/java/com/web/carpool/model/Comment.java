package com.web.carpool.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "postId")
    private Integer postId;

    // @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    private Integer userId;

    // @Column(name = "createTime")
    // private Date createTime;

    @Column(name="comment")
    private String comment;

    @Column(name="rate")
    private Integer rate;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer PostId) {
        this.postId = postId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    // public Date getCreateTime() {
    //     return createTime;
    // }

    // public void setCreateTime(Date createTime) {
    //     this.createTime = createTime;
    // }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}