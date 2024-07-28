package com.dans.test.service;

import com.dans.test.dto.JobListResponse;
import org.springframework.stereotype.Service;

@Service
public interface JobListService {

    JobListResponse[] getJobList();

    JobListResponse getJobById(String id);
}
