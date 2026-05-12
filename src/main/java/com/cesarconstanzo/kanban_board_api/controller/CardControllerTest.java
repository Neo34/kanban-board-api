package com.cesarconstanzo.kanban_board_api.controller;

import com.cesarconstanzo.kanban_board_api.dto.CardDTO;
import com.cesarconstanzo.kanban_board_api.model.BoardColumn;
import com.cesarconstanzo.kanban_board_api.model.Card;
import com.cesarconstanzo.kanban_board_api.repository.BoardColumnRepository;
import com.cesarconstanzo.kanban_board_api.service.CardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Controller tests for CardController
 */
@WebMvcTest(CardController.class)
public class CardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CardService service;

    @MockBean
    private BoardColumnRepository columnRepository;

    @Test
    void shouldCreateCardSuccessfully() throws Exception {

        // mock column
        BoardColumn column = BoardColumn.builder()
                .id(1L)
                .name("To Do")
                .order(1)
                .build();

        // dto
        CardDTO dto = new CardDTO();
        dto.setTitle("Test Card");
        dto.setDescription("Testing");
        dto.setColumnId(1L);

        // response card
        Card card = Card.builder()
                .id(1L)
                .title("Test Card")
                .description("Testing")
                .blocked(false)
                .column(column)
                .build();

        when(columnRepository.findById(1L))
                .thenReturn(Optional.of(column));

        when(service.create(any(Card.class)))
                .thenReturn(card);

        mockMvc.perform(post("/cards")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "title":"Test Card",
                                    "description":"Testing",
                                    "columnId":1
                                }
                                """))
                .andExpect(status().isOk());
    }
}