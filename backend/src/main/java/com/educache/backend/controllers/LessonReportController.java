package com.educache.backend.controllers;

import com.educache.backend.models.LessonReport;
import com.educache.backend.services.LessonReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lesson-reports")
public class LessonReportController {

    @Autowired
    private LessonReportService lessonReportService;

    @GetMapping
    public List<LessonReport> getAllLessonReports() {
        return lessonReportService.getAllLessonReports();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LessonReport> getLessonReportById(@PathVariable Long id) {
        Optional<LessonReport> lessonReport = lessonReportService.getLessonReportById(id);
        return lessonReport.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LessonReport> createLessonReport(@RequestBody LessonReport lessonReport) {
        LessonReport savedLessonReport = lessonReportService.saveLessonReport(lessonReport);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLessonReport);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LessonReport> updateLessonReport(@PathVariable Long id, @RequestBody LessonReport lessonReport) {
        lessonReport.setId(id); // Set the ID to update
        LessonReport updatedLessonReport = lessonReportService.saveLessonReport(lessonReport);
        return ResponseEntity.ok(updatedLessonReport);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLessonReport(@PathVariable Long id) {
        lessonReportService.deleteLessonReport(id);
        return ResponseEntity.noContent().build();
    }
}
