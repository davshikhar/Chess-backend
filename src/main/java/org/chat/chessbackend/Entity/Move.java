package org.chat.chessbackend.Entity;

import jakarta.persistence.*;

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
    private Game game;

    @Column(nullable = false)
    private Integer moveNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Game.PlayerColor playerColor;

    @Column(nullable = false)
    private String fromSquare;

    @Column(nullable = false)
    private String toSquare;

    @Column(nullable = false)
    private String san;

    @Enumerated(EnumType.STRING)
    private PieceType promotedTo;

    @Column(nullable = false)
    private String fenAfterMove;

    private Integer timeRemainig;

    @Column(nullable = false)
    private Instant playedAt;

}
