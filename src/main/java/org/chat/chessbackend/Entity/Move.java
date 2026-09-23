package org.chat.chessbackend.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Table(name = "moves")
public class Move {

    public enum PieceType{QUEEN,ROOK,BISHOP,KNIGHT}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id",nullable = false)
    @NotNull
    private Game game;

    @Column(nullable = false)
    @NotNull
    @Positive
    private Integer moveNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull
    private Game.PlayerColor playerColor;

    @Column(nullable = false)
    @NotBlank
    private String fromSquare;

    @Column(nullable = false)
    @NotBlank
    private String toSquare;

    @Column(nullable = false)
    @NotBlank
    private String san;

    @Enumerated(EnumType.STRING)
    private PieceType promotedTo;

    @Column(nullable = false)
    @NotBlank
    private String fenAfterMove;

    @Column(nullable = false)
    @NotNull
    @PositiveOrZero
    private Integer timeRemainig;

    @CreationTimestamp
    @Column(nullable = false)
    private Instant playedAt;

}
