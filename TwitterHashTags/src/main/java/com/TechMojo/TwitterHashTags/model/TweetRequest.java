package com.TechMojo.TwitterHashTags.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Access(AccessType.FIELD)
@Table(name = "tweets_data")
public class TweetRequest {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name="user_name")
    @NotNull
    private String userName;

    @Column(name="tweet")
    @NotNull
    private String tweet;
}
