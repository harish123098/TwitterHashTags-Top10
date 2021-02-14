package com.TechMojo.TwitterHashTags.service;

import com.TechMojo.TwitterHashTags.model.TweetRequest;
import com.TechMojo.TwitterHashTags.model.TweetResponse;

import java.util.List;

public interface TweetService {

    List<String> getTopTenHashTags();
    TweetResponse saveTweet(TweetRequest request);
}
