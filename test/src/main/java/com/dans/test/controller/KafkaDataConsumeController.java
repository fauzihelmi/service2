package com.dans.test.controller;

import com.dans.test.dto.TransactionDto;
import com.dans.test.service.KafkaDataConsumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/kafka")
@RequiredArgsConstructor
public class KafkaDataConsumeController {


   private KafkaDataConsumeService dataService;

    @PostMapping("/consume-transaction")
    public ResponseEntity<Void> transaction(@RequestBody List<TransactionDto> transactionDto) {
        System.out.println("Received transaction: " + transactionDto);
        return ResponseEntity.ok().build();
    }
}
