package com.educache.backend.repositories;

import com.educache.backend.models.LessonReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonReportRepository extends JpaRepository<LessonReport, Long> {
}
