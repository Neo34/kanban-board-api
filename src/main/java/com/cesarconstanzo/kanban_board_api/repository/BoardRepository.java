package com.cesarconstanzo.kanban_board_api.repository;

import com.cesarconstanzo.kanban_board_api.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
