package com.aiResumeApplication.ai_resume_system.service;

import com.aiResumeApplication.ai_resume_system.model.Resume;
import com.aiResumeApplication.ai_resume_system.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    public Resume saveResume(Resume resume) {

        return resumeRepository.save(resume);
    }
}
