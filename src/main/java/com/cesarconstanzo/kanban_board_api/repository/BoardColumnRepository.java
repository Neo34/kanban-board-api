package com.cesarconstanzo.kanban_board_api.repository;

import com.cesarconstanzo.kanban_board_api.model.BoardColumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository responsible for databases operations related to BoardColumn.
 */
@Repository
public interface BoardColumnRepository extends JpaRepository<BoardColumn, Long> {
}
