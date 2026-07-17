package com.aiResumeApplication.ai_resume_system.repository;

import com.aiResumeApplication.ai_resume_system.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {

}
