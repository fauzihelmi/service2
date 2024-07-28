package com.dans.test.service;

import com.dans.test.dto.TransactionDto;
import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class KafkaDataComsumerServiceImpl {

    private final RestTemplate restTemplate;

    public KafkaDataComsumerServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @KafkaListener(topics = "topic1", groupId = "test")
    public void consume(List<TransactionDto> transactionDto){
        System.out.println(String.format("Json message recieved -> %s", transactionDto.toString()));
        String endpointUrl = "http://localhost:8090/api/v1/kafka/consume-transaction";
        restTemplate.postForObject(endpointUrl, transactionDto, Void.class);

    }

}
