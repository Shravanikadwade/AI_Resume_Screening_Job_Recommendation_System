package com.aiResumeApplication.ai_resume_system.controller;

import com.aiResumeApplication.ai_resume_system.model.Resume;
import com.aiResumeApplication.ai_resume_system.service.ResumeService;
import com.aiResumeApplication.ai_resume_system.service.SkillExtractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

@RestController
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    private SkillExtractionService skillExtractionService;

    @Autowired
    private ResumeService resumeService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadResume(
            @RequestParam("file") MultipartFile file,
            @RequestParam("candidateName") String candidateName
    ) {

        try {

            String uploadDir = System.getProperty("user.dir") + "/uploads/";

            File directory = new File(uploadDir);

            if (!directory.exists()) {
                directory.mkdirs();
            }

            String filePath = uploadDir + File.separator + file.getOriginalFilename();
            // Step 1: Save PDF
            file.transferTo(new File(filePath));
            // Step 2: Open PDF
            PDDocument document = PDDocument.load(new File(filePath));
            // Step 3: Create PDFTextStripper
            PDFTextStripper stripper = new PDFTextStripper();
            //Step 4: Extract Text  ← ADD THIS HERE
            String extractedText = stripper.getText(document);
            // Step 5: Close PDF
            document.close();

            // Step 6: Extract Skills
            String skills = skillExtractionService.extractSkills(extractedText);
            // Step 7: Save into Database
            Resume resume = new Resume();

            resume.setCandidateName(candidateName);
            resume.setFileName(file.getOriginalFilename());
            resume.setFilePath(filePath);
            resume.setExtractedText(extractedText);
            resume.setSkills(skills);

            resumeService.saveResume(resume);

            return ResponseEntity.ok("Resume uploaded successfully");

        } catch (IOException e) {

            return ResponseEntity.internalServerError()
                    .body("File upload failed");
        }
    }
}

