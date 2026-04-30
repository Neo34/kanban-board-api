package com.cesarconstanzo.kanban_board_api.controller;

import com.cesarconstanzo.kanban_board_api.dto.BoardColumnDTO;
import com.cesarconstanzo.kanban_board_api.model.Board;
import com.cesarconstanzo.kanban_board_api.model.BoardColumn;
import com.cesarconstanzo.kanban_board_api.repository.BoardColumnRepository;
import com.cesarconstanzo.kanban_board_api.repository.BoardRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * REST controller for managing Board Columns.
 */
@RestController
@RequestMapping("/columns")

public class BoardColumnController {

    private final BoardColumnRepository columnRepository;
    private final BoardRepository boardRepository;

    public BoardColumnController(BoardColumnRepository columnRepository,
                                 BoardRepository boardRepository) {
        this.columnRepository = columnRepository;
        this.boardRepository = boardRepository;
    }

    /**
     * Create a column inside a board
     */
    @PostMapping
    public BoardColumn create(@Valid @RequestBody BoardColumnDTO dto) {

        Board board = boardRepository.findById(dto.getBoardId())
                .orElseThrow(() -> new RuntimeException("Board not found"));
        BoardColumn column = BoardColumn.builder()
                .name(dto.getName())
                .order(dto.getOrder())
                .board(board)
                .build();

        return columnRepository.save(column);
    }

    /**
     * List all columns
     */
    @GetMapping
    public List<BoardColumn> findAll() {
        return columnRepository.findAll();
    }

    /**
     * List columns by board
     */
    @GetMapping("/board/{boardId}")
    public List<BoardColumn> findByBoard(@PathVariable Long boardId) {

        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new RuntimeException("Board not found"));

        return board.getColumns();
    }

    /**
     * Delete a column
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        columnRepository.deleteById(id);
    }
}