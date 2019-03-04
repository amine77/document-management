package com.zarzisdev.documentmanagement.repository;

import com.zarzisdev.documentmanagement.model.Doc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocRepository extends JpaRepository<Doc, Long> {
}
