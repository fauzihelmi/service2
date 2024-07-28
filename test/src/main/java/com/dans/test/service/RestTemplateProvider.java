package com.dans.test.service;

import com.dans.test.dto.JobListResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateProvider implements JobListService {

    RestTemplate rest = new RestTemplate();

    @Override
    public JobListResponse[] getJobList() {
        ResponseEntity<JobListResponse[]> response =
                rest.getForEntity(
                        "https://dev6.dansmultipro.com/api/recruitment/positions.json",
                        JobListResponse[].class);
        return response.getBody();
    }

    @Override
    public JobListResponse getJobById(String id) {
        ResponseEntity<JobListResponse> response =
                rest.getForEntity(
                        "https://dev6.dansmultipro.com/api/recruitment/positions/{id}",
                        JobListResponse.class, id);
        return response.getBody();
        }

}
