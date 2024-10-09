package com.educache.backend.services;

import com.educache.backend.models.LessonReport;
import com.educache.backend.repositories.LessonReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonReportService {

    @Autowired
    private LessonReportRepository lessonReportRepository;

    public List<LessonReport> getAllLessonReports() {
        return lessonReportRepository.findAll();
    }

    public Optional<LessonReport> getLessonReportById(Long id) {
        return lessonReportRepository.findById(id);
    }

    public LessonReport saveLessonReport(LessonReport lessonReport) {
        return lessonReportRepository.save(lessonReport);
    }

    public void deleteLessonReport(Long id) {
        lessonReportRepository.deleteById(id);
    }
}
