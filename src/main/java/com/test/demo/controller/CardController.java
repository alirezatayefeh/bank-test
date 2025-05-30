package com.test.demo.controller;

import com.test.demo.dto.CardDto;
import com.test.demo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {
    @Autowired
    private CardService cardService;

    @GetMapping("/user/{userId}")
    public List<CardDto> getUserCards(@PathVariable Long userId) {
        return cardService.getUserCards(userId);
    }

    @PutMapping("/limit/{cardNumber}")
    public void updateTransferLimit(@PathVariable String cardNumber, @RequestParam Double newLimit) {
        cardService.updateTransferLimit(cardNumber, newLimit);
    }
}
