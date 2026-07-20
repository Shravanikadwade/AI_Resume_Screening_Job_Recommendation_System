package com.aiResumeApplication.ai_resume_system.service;

import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class SkillExtractionService {

    private static final List<String> PREDEFINED_SKILLS = Arrays.asList(

            // Programming Languages
            "Java",
            "Python",
            "C",
            "C++",
            "JavaScript",
            "TypeScript",

            // Frontend
            "HTML",
            "CSS",
            "React",
            "Angular",
            "Vue",

            // Backend
            "Spring",
            "Spring Boot",
            "Hibernate",
            "JPA",
            "Node.js",
            "Express.js",

            // Database
            "MySQL",
            "SQL",
            "MongoDB",
            "Oracle",

            // Tools
            "Git",
            "GitHub",
            "Docker",
            "Kubernetes",
            "Postman",

            // Cloud
            "AWS",
            "Azure",
            "GCP",

            // Concepts
            "REST API",
            "Microservices",
            "OOP",
            "DSA",
            "JWT"

    );

    public String extractSkills(String resumeText) {

        StringBuilder extractedSkills = new StringBuilder();

        for (String skill : PREDEFINED_SKILLS) {

            if (resumeText.toLowerCase().contains(skill.toLowerCase())) {

                extractedSkills.append(skill).append(", ");

            }

        }

        if (extractedSkills.length() > 0) {

            extractedSkills.setLength(extractedSkills.length() - 2);

        }

        return extractedSkills.toString();

    }

}