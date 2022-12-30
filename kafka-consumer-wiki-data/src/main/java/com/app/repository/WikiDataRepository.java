package com.app.repository;

import com.app.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikiDataRepository extends JpaRepository<WikimediaData,Long> {
}
