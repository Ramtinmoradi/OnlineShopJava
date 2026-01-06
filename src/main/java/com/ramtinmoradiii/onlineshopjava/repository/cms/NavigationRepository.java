package com.ramtinmoradiii.onlineshopjava.repository.cms;

import com.ramtinmoradiii.onlineshopjava.entity.cms.Navigation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NavigationRepository extends JpaRepository<Navigation, Long> {
    List<Navigation> findAllByEnableTrueOrderByOrderNumberAsc();
}
