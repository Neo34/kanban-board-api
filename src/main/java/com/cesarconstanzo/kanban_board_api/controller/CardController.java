package com.cesarconstanzo.kanban_board_api.controller;

import com.cesarconstanzo.kanban_board_api.dto.CardDTO;
import com.cesarconstanzo.kanban_board_api.model.BoardColumn;
import com.cesarconstanzo.kanban_board_api.model.Card;
import com.cesarconstanzo.kanban_board_api.repository.BoardColumnRepository;
import com.cesarconstanzo.kanban_board_api.service.CardService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardService service;
    private final BoardColumnRepository columnRepository;

    public CardController(CardService service, BoardColumnRepository columnRepository) {
        this.service = service;
        this.columnRepository = columnRepository;
    }

    @PostMapping
    public Card create(@Valid @RequestBody CardDTO dto) {

        BoardColumn column = columnRepository.findById(dto.getColumnId())
                .orElseThrow(() -> new RuntimeException("Column not found"));

        Card card = Card.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .column(column)
                .blocked(false)
                .build();

        return service.create(card);
    }
}