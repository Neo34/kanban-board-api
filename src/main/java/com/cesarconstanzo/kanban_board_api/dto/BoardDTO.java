package com.cesarconstanzo.kanban_board_api.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * DTO for board
 */
public class BoardDTO {
    @NotBlank(message = "Board name is required")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
