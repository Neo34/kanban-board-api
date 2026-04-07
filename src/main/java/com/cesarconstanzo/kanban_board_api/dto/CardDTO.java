package com.cesarconstanzo.kanban_board_api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardDTO {

    private String title;
    private String description;
    private Long columnId;
}