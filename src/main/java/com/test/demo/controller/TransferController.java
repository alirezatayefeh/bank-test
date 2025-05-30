package com.test.demo.controller;

import com.test.demo.dto.TransferRequest;
import com.test.demo.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transfer")
public class TransferController {
    @Autowired
    private TransferService transferService;

    @PostMapping
    public String initiateTransfer(@RequestBody TransferRequest request) {
        return transferService.initiateTransfer(request);
    }
}
