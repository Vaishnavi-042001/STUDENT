package com.example.recruitment.controller;

import com.example.recruitment.model.Candidate;
import com.example.recruitment.model.Job;
import com.example.recruitment.repository.CandidateRepository;
import com.example.recruitment.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RecruitmentController {

    @Autowired
    private CandidateRepository candidateRepo;

    @Autowired
    private JobRepository jobRepo;

    // ----- Web UI -----
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/candidates")
    public String listCandidates(Model model) {
        model.addAttribute("candidates", candidateRepo.findAll());
        return "candidates";
    }

    @GetMapping("/jobs")
    public String listJobs(Model model) {
        model.addAttribute("jobs", jobRepo.findAll());
        return "jobs";
    }

    // ----- REST API (same as before) -----
    @GetMapping("/api/candidates")
    @ResponseBody
    public List<Candidate> getCandidates() {
        return candidateRepo.findAll();
    }

    @PostMapping("/api/candidates")
    @ResponseBody
    public ResponseEntity<?> addCandidate(@Valid @RequestBody Candidate candidate) {
        candidateRepo.save(candidate);
        return ResponseEntity.status(HttpStatus.CREATED).body("Candidate added");
    }

    @GetMapping("/api/jobs")
    @ResponseBody
    public List<Job> getJobs() {
        return jobRepo.findAll();
    }

    @PostMapping("/api/jobs")
    @ResponseBody
    public ResponseEntity<?> addJob(@Valid @RequestBody Job job) {
        jobRepo.save(job);
        return ResponseEntity.status(HttpStatus.CREATED).body("Job added");
    }
}