package com.TechMojo.TwitterHashTags.repository;

import com.TechMojo.TwitterHashTags.model.TweetRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TweetRepository extends JpaRepository<TweetRequest, Long> {}

   /* @Query(value = "SELECT tweet FROM tweets_data", nativeQuery = true)
    List<String> getAllTweets();*/


