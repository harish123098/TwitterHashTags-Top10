package com.TechMojo.TwitterHashTags.controller;

import com.TechMojo.TwitterHashTags.model.TweetRequest;
import com.TechMojo.TwitterHashTags.model.TweetResponse;
import com.TechMojo.TwitterHashTags.service.TweetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/twitter")
@Slf4j
public class TweetController {
    private TweetService tweetService;

    @Autowired
    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @PostMapping(produces = "application/json",value = "/addTweet")
    public ResponseEntity<TweetResponse> addTweet(@RequestBody TweetRequest data) {
        return ResponseEntity.ok(tweetService.saveTweet(data));
    }

    @GetMapping(value="/getTopTenHashTags")
    public ResponseEntity<List<String>> getTopTenHashTags(){
        List<String> hashTags = tweetService.getTopTenHashTags();
        return ResponseEntity.ok(hashTags);
    }

}
