package com.aiResumeApplication.ai_resume_system.repository;

import com.aiResumeApplication.ai_resume_system.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume, Long> {

}
