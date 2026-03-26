package com.cesarconstanzo.kanban_board_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Represents a column in a Kanban board.
 * A column belongs to a Board and contains multiple Cards.
 */
@Entity // Marks this class as a database entity
@Table(name = "columns") // Table name in the database
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Columns {

    /**
     * Primary key of the column.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name of the column (e.g., To Do, In Progress, Done).
     */
    @Column(nullable = false)
    private String name;

    /**
     * Order of the column within the board.
     * Helps define the position (important for moving cards).
     */
    @Column(nullable = false)
    private int order;

    /**
     * Many columns belong to one board.
     */
    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    /**
     * One column has many cards.
     */
    @OneToMany(mappedBy = "column", cascade = CascadeType.ALL)
    private List<Card> cards;
}