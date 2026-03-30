package com.cesarconstanzo.kanban_board_api.service;

import com.cesarconstanzo.kanban_board_api.model.BoardColumn;
import com.cesarconstanzo.kanban_board_api.model.Card;
import com.cesarconstanzo.kanban_board_api.repository.BoardColumnRepository;
import com.cesarconstanzo.kanban_board_api.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    private final CardRepository repository;
    private final BoardColumnRepository columnRepository;

    public CardService(CardRepository repository, BoardColumnRepository columnRepository) {
        this.repository = repository;
        this.columnRepository = columnRepository;
    }

    /**
     * Create a new card
     */
    public Card create(Card card) {
        return repository.save(card);
    }

    /**
     * List all cards
     */
    public List<Card> findAll() {
        return repository.findAll();
    }

    /**
     * Find card by ID
     */
    public Card findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card not found"));
    }

    /**
     * Block a card
     */
    public Card block(Long id) {
        Card card = findById(id);
        card.setBlocked(true);
        return repository.save(card);
    }

    /**
     * Unblock a card
     */
    public Card unblock(Long id) {
        Card card = findById(id);
        card.setBlocked(false);
        return repository.save(card);
    }

    /**
     * Move card to another column
     */
    public Card move(Long cardId, Long targetColumnId) {

        Card card = findById(cardId);

        if (card.isBlocked()) {
            throw new RuntimeException("Blocked card cannot be moved");
        }

        BoardColumn targetColumn = columnRepository.findById(targetColumnId)
                .orElseThrow(() -> new RuntimeException("Target column not found"));

        card.setColumn(targetColumn);

        return repository.save(card);
    }

    /**
     * Delete a card
     */
    public void delete(Long id) {
        repository.deleteById(id);
    }
}