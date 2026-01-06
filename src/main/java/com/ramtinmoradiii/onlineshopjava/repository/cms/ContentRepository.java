package com.ramtinmoradiii.onlineshopjava.repository.cms;

import com.ramtinmoradiii.onlineshopjava.entity.cms.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {
    Optional<Content> findByName(String name);
}
