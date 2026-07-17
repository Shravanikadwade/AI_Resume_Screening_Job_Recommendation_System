package com.aiResumeApplication.ai_resume_system.service;

import com.aiResumeApplication.ai_resume_system.model.Job;
import com.aiResumeApplication.ai_resume_system.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public Job addJob(Job job) {

        return jobRepository.save(job);
    }

    public List<Job> getAllJobs() {

        return jobRepository.findAll();
    }
}
