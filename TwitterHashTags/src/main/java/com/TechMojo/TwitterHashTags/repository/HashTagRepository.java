package com.TechMojo.TwitterHashTags.repository;


import com.TechMojo.TwitterHashTags.model.TopHashTags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HashTagRepository extends JpaRepository<TopHashTags, Long> {

    @Query(value = "SELECT * FROM top_hash_tags t where t.hash_tag = ?1",nativeQuery = true)
    TopHashTags findTag(String tag);

    @Query(value = "SELECT t.hash_tag FROM top_hash_Tags t ORDER BY t.frequency DESC limit 0,10",nativeQuery = true)
    List<String> topTenHashTags ();
}
