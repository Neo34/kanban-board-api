package com.cesarconstanzo.kanban_board_api.controller;

import com.cesarconstanzo.kanban_board_api.model.Board;
import com.cesarconstanzo.kanban_board_api.repository.BoardRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Boards.
 */
@RestController
@RequestMapping("/boards")
public class BoardController {

    private final BoardRepository repository;

    public BoardController(BoardRepository repository) {
        this.repository = repository;
    }

    /**
     * Create a board
     */
    @PostMapping
    public Board create(@RequestBody Board board) {
        return repository.save(board);
    }

    /**
     * List all boards
     */
    @GetMapping
    public List<Board> findAll() {
        return repository.findAll();
    }

    /**
     * Find board by ID
     */
    @GetMapping("/{id}")
    public Board findById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Board not found"));
    }

    /**
     * Delete board
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}