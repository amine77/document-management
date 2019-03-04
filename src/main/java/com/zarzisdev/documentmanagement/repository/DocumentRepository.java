package com.zarzisdev.documentmanagement.repository;

import com.zarzisdev.documentmanagement.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
}
