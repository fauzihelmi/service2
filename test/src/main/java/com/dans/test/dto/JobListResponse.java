package com.dans.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobListResponse {

    private String id;
    private String type;
    private String created_at;
    private String company;
    private String company_url;
    private String location;
    private String title;
    private String description;
}
