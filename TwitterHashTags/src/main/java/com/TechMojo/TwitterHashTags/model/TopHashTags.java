package com.TechMojo.TwitterHashTags.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Access(AccessType.FIELD)
@Table(name = "top_hash_Tags")
public class TopHashTags {

    @javax.persistence.Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "hash_tag")
    @NotNull
    private String hastTag;

    @Column(name="frequency")
    @NotNull
    private Long frequency;
}