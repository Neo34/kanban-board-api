package com.cesarconstanzo.kanban_board_api.service;

import com.cesarconstanzo.kanban_board_api.model.BoardColumn;
import com.cesarconstanzo.kanban_board_api.model.Card;
import com.cesarconstanzo.kanban_board_api.repository.BoardColumnRepository;
import com.cesarconstanzo.kanban_board_api.repository.CardRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/**
 * Unit tests for CardService
 */
@ExtendWith(MockitoExtension.class)
public class CardServiceTest {
    @Mock
    private CardRepository cardRepository;

    @Mock
    private BoardColumnRepository columnRepository;

    @InjectMocks
    private CardService service;

    @Test
    void shouldNotMoveBlockdCard() {

        //current column
        BoardColumn current = BoardColumn.builder()
                .id(1L)
                .name("To Do")
                .order(1)
                .build();

        // target column
        BoardColumn target = BoardColumn.builder()
                .id(2L)
                .name("In Progress")
                .order(2)
                .build();

        //blocked card
        Card card = Card.builder()
                .id(1L)
                .title("Test Card")
                .blocked(true)
                .column(current)
                .build();
        when(cardRepository.findById(1L))
                .thenReturn(Optional.of(card));
        when(columnRepository.findById(2L))
                .thenReturn(Optional.of(target));


        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> service.move(1L, 2L)
        );
        assertEquals(
                "Blocked card cannot be moved",
                exception.getMessage()
        );
    }
}
