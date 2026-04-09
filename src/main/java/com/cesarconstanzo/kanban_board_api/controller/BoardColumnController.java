package com.cesarconstanzo.kanban_board_api.controller;

import com.cesarconstanzo.kanban_board_api.model.BoardColumn;
import com.cesarconstanzo.kanban_board_api.repository.BoardColumnRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Board Columns.
 */
@RestController
@RequestMapping("/columns")
public class BoardColumnController {

    private final BoardColumnRepository repository;

    public BoardColumnController(BoardColumnRepository repository) {
        this.repository = repository;
    }

    /**
     * Create column
     */
    @PostMapping
    public BoardColumn create(@RequestBody BoardColumn column) {
        return repository.save(column);
    }

    /**
     * List all columns
     */
    @GetMapping
    public List<BoardColumn> findAll() {
        return repository.findAll();
    }

    /**
     * Delete column
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}