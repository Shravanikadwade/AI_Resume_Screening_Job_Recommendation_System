package com.aiResumeApplication.ai_resume_system.controller;


import com.aiResumeApplication.ai_resume_system.model.Job;
import com.aiResumeApplication.ai_resume_system.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping("/add")
    public Job addJob(@RequestBody Job job) {

        return jobService.addJob(job);
    }

    @GetMapping("/all")
    public List<Job> getAllJobs() {

        return jobService.getAllJobs();
    }
}
