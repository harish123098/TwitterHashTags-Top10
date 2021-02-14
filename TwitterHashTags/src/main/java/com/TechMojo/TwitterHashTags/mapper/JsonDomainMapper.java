package com.TechMojo.TwitterHashTags.mapper;


import com.TechMojo.TwitterHashTags.model.TopHashTags;
import com.TechMojo.TwitterHashTags.model.TweetRequest;
import com.TechMojo.TwitterHashTags.model.TweetResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonDomainMapper {
    public static TweetResponse domainToJson(TweetRequest request){
        log.info("the tweet request saved in database is :{}",request.toString());
        return TweetResponse.builder()
                .username(request.getUserName())
                .tweet(request.getTweet())
                .build();
    }
    public static TopHashTags buildTopHashTagReq(String tag,long count){
        log.info("the hashTag is:{}",tag);
        return TopHashTags.builder()
                .hastTag(tag)
                .frequency(count)
                .build();
    }


    public static TopHashTags updateHashTagRequest(String tag,long count,long id){
        log.info("the hashTag is:{}",tag);
        return TopHashTags.builder()
                .Id(id)
                .hastTag(tag)
                .frequency(count)
                .build();
    }
}
