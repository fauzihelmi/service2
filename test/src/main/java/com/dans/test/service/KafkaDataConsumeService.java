package com.dans.test.service;

import com.dans.test.dto.TransactionDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KafkaDataConsumeService {
    List<TransactionDto> consumeDataTransaction();
}
