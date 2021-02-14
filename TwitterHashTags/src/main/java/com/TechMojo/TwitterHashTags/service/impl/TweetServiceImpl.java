package com.TechMojo.TwitterHashTags.service.impl;

import com.TechMojo.TwitterHashTags.mapper.JsonDomainMapper;
import com.TechMojo.TwitterHashTags.model.TopHashTags;
import com.TechMojo.TwitterHashTags.model.TweetRequest;
import com.TechMojo.TwitterHashTags.model.TweetResponse;
import com.TechMojo.TwitterHashTags.repository.HashTagRepository;
import com.TechMojo.TwitterHashTags.repository.TweetRepository;
import com.TechMojo.TwitterHashTags.service.TweetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Slf4j
public class TweetServiceImpl implements TweetService {

    private TweetRepository tweetRepository;
    private HashTagRepository hashTagRepository;

    private static final Pattern HASH_TAG = Pattern.compile("#(\\w+)");

    @Autowired
    public TweetServiceImpl(TweetRepository tweetRepository, HashTagRepository hashTagRepository) {
        this.tweetRepository = tweetRepository;
        this.hashTagRepository = hashTagRepository;
    }

    @Override
    public TweetResponse saveTweet(TweetRequest request) {
        Matcher findHashTags = HASH_TAG.matcher(request.toString());
        while (findHashTags.find()) {
            String hashTag = findHashTags.group();
            log.info("hashTag:{}",hashTag);
            //all operations in done asynch manner
            CompletableFuture.runAsync(() -> {
                TopHashTags topHashTags = hashTagRepository.findTag(hashTag);
                if (topHashTags !=null) {
                    Long count = topHashTags.getFrequency();
                    count++;
                    //updating the frequency of hashTag
                    hashTagRepository.save(JsonDomainMapper.updateHashTagRequest(hashTag, count,topHashTags.getId()));
                } else {
                    //saving hashTag if it is new and frequency has 1
                    hashTagRepository.save(JsonDomainMapper.buildTopHashTagReq(hashTag, 1));
                }
            });
        }
        //save original Tweet Data in the dataBase
        return JsonDomainMapper.domainToJson(tweetRepository.save(request));

    }


    @Override
    public List<String> getTopTenHashTags() {
        return hashTagRepository.topTenHashTags();
    }
}


