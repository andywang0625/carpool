package com.web.carpool.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "comment")
@Data
public class Comment {
    // @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "postId")
    // private long postId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    private long userId;

    @CreatedDate
    @Column(name = "createTime", nullable=false, updatable=false)
    private Calendar createTime;

    @Column(name="comment")
    @NotEmpty(message="Please provide your comment")
    private String comment;

    @Column(name="rate")
    @NotEmpty(message="Please rate your trip")
    @Max(5)
    @Min(1)
    private Integer rate;

    // @ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.ALL})
    // @JoinColumn(name="postId")
    // private Post post;
}