package com.TechMojo.TwitterHashTags.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TweetResponse {

    @NotNull
    private String username;

    @NotNull
    private String tweet;
}
