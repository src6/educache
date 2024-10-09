package com.educache.backend.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "lesson_reports")
public class LessonReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String report;
    private Date dateCreated;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    // Set the lastModified field before the entity is updated
    @PreUpdate
    protected void onUpdate() {
        lastModified = new Date();              // Set lastModified to the current date and time.
    }

    // Getters and setters for all the fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
