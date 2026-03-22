package com.cesarconstanzo.kanban_board_api.repository;

import com.cesarconstanzo.kanban_board_api.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
