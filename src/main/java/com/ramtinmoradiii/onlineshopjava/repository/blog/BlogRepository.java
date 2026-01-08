package com.ramtinmoradiii.onlineshopjava.repository.blog;

import com.ramtinmoradiii.onlineshopjava.entity.blog.Blog;
import com.ramtinmoradiii.onlineshopjava.entity.blog.enums.BlogStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findAllByStatus(BlogStatus status);
}
