package com.test.demo.transferTest;

import com.test.demo.dto.TransferRequest;
import com.test.demo.model.Card;
import com.test.demo.repository.CardRepository;
import com.test.demo.service.TransferService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransferServiceTest {
    @Mock
    private CardRepository cardRepository;

    @InjectMocks
    private TransferService transferService;

    @Test
    void testInitiateTransfer_InsufficientBalance() {
        TransferRequest request = new TransferRequest();
        request.setSourceCardNumber("1234567890123456");
        request.setDestinationCardNumber("9876543210987654");
        request.setAmount(1000.0);

        Card sourceCard = new Card();
        sourceCard.setCardNumber("1234567890123456");
        sourceCard.setBalance(500.0);

        Card destinationCard = new Card();
        destinationCard.setCardNumber("9876543210987654");

        when(cardRepository.findByCardNumber("1234567890123456")).thenReturn(Optional.of(sourceCard));
        when(cardRepository.findByCardNumber("9876543210987654")).thenReturn(Optional.of(destinationCard));

        assertThrows(RuntimeException.class, () -> transferService.initiateTransfer(request));
    }
}
