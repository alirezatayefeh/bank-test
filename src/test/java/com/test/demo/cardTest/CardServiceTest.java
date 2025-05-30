package com.test.demo.cardTest;

import com.test.demo.dto.CardDto;
import com.test.demo.model.Bank;
import com.test.demo.model.Card;
import com.test.demo.model.User;
import com.test.demo.repository.CardRepository;
import com.test.demo.service.CardService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CardServiceTest {
    @Mock
    private CardRepository cardRepository;

    @InjectMocks
    private CardService cardService;

    @Test
    void testGetUserCards() {
        User user = new User();
        user.setId(1L);
        user.setFullName("Ali Rezaei");

        Bank bank = new Bank();
        bank.setName("Bank A");

        Card card = new Card();
        card.setCardNumber("1234567890123456");
        card.setBalance(1000.0);
        card.setTransferLimit(500.0);
        card.setUser(user);
        card.setBank(bank);

        when(cardRepository.findByUserId(1L)).thenReturn(Collections.singletonList(card));

        List<CardDto> result = cardService.getUserCards(1L);
        assertEquals(1, result.size());
        assertEquals("Ali Rezaei", result.get(0).getUserFullName());
        assertEquals("Bank A", result.get(0).getBankName());
    }
}
