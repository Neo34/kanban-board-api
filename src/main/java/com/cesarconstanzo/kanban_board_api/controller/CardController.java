package com.cesarconstanzo.kanban_board_api.controller;

import com.cesarconstanzo.kanban_board_api.model.Card;
import com.cesarconstanzo.kanban_board_api.service.CardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest controller for managing Cards.
 */
@RestController
@RequestMapping("/cards")
public class CardController {
    private final CardService service;

    public CardController(CardService service) {
        this.service = service;
    }

    /**
     * Create a new Card
     */
    @PostMapping
    public Card create(@RequestBody Card card) {
        return service.create(card);
    }

    /**
     * List all cards
     */
    @GetMapping
    public List<Card> findAll() {
        return service.findAll();
    }

    /**
     * Block a Card
     */
    @PutMapping("{id}/block")
    public Card block(@PathVariable Long id) {
        return service.block(id);
    }

    /**
     * Unblock a card
     */
    @PutMapping("/{id}/unblock")
    public Card unblock(@PathVariable Long id) {
        return service.unblock(id);
    }

    /**
     * Move card to another column
     */
    @PutMapping("/{id}/move/{columnId}")
    public Card move(@PathVariable Long id, @PathVariable Long columnId) {
        return service.move(id, columnId);
    }

    /**
     * Delete a Card
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
