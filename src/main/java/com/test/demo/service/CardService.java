package com.test.demo.service;

import com.test.demo.dto.CardDto;
import com.test.demo.model.Card;
import com.test.demo.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    public List<CardDto> getUserCards(Long userId) {
        return cardRepository.findByUserId(userId).stream().map(card -> {
            CardDto dto = new CardDto();
            dto.setCardNumber(card.getCardNumber());
            dto.setBalance(card.getBalance());
            dto.setTransferLimit(card.getTransferLimit());
            dto.setBankName(card.getBank().getName());
            dto.setUserFullName(card.getUser().getFullName());
            return dto;
        }).collect(Collectors.toList());
    }

    public void updateTransferLimit(String cardNumber, Double newLimit) {
        Card card = cardRepository.findByCardNumber(cardNumber)
                .orElseThrow(() -> new RuntimeException("Card not found"));
        card.setTransferLimit(newLimit);
        cardRepository.save(card);
    }
}
