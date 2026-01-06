package com.ramtinmoradiii.onlineshopjava.repository.user;

import com.ramtinmoradiii.onlineshopjava.entity.user.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> { }