package com.cesarconstanzo.kanban_board_api.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * DTO for BoardColumn
 */
public class BoardColumnDTO {
    @NotBlank(message = "Column name is required")
    private String name;

    @NotNull(message = "Order is required")
    private Integer order;

    @NotNull(message = "Board ID is required")
    private Long boardId;

    //getters e setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }
}
