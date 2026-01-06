package com.ramtinmoradiii.onlineshopjava.repository.common;

import com.ramtinmoradiii.onlineshopjava.entity.common.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
}
