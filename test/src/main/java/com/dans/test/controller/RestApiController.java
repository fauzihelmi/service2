package com.dans.test.controller;

import com.dans.test.dto.JobListResponse;
import com.dans.test.service.JobListService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rest")
@RequiredArgsConstructor
public class RestApiController {

    @Autowired
    JobListService jobListService;

    @GetMapping("/jobList")
    public ResponseEntity<JobListResponse[]> register() {
        return ResponseEntity.ok(jobListService.getJobList());
    }

    @GetMapping("/jobById")
    public ResponseEntity<JobListResponse> register(@RequestParam String id) {
        return ResponseEntity.ok(jobListService.getJobById(id));
    }

}
