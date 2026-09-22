package org.chat.chessbackend.Entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "games")
public class Game {

    public enum GameStatus{
        WAITING_FOR_PLAYER, GAME_STARTED, GAME_ENDED
    }
    public enum PlayerColor{WHITE,BLACK}
    public enum GameResult{WHITE_WON,BLACK_WON,DRAW}
    public enum TimeControlType {
        BULLET_1(1, 0),
        BLITZ_3(3, 0),
        BLITZ_5(5, 0),
        RAPID_10(10, 0),
        RAPID_30(30, 0),
        DAILY_1(1440, 0);   // 1 day in minutes

        private final int minutes;
        private final int incrementSeconds;

        TimeControlType(int minutes, int incrementSeconds) {
            this.minutes = minutes;
            this.incrementSeconds = incrementSeconds;
        }

        public int getMinutes() {
            return minutes;
        }

        public int getIncrementSeconds() {
            return incrementSeconds;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "white_player_id", nullable = false)
    private User whitePlayer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "blac_player_id", nullable = true)
    private User blackPlayer;

    @Enumerated(EnumType.STRING)
    private PlayerColor currentTurn;

    @Enumerated(EnumType.STRING)
    private GameStatus status;

    @Enumerated(EnumType.STRING)
    private GameResult result;

    private String currentFEN;

    @Enumerated(EnumType.STRING)
    private TimeControlType time;

    private Integer whiteTimeRemaining;
    private Integer blackTimeRemaining;

    private String forfeitReason;

    private Instant createdAt;
    private Instant lastMovedAt;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("moveNumber ASC")
    private List<Move> moves = new ArrayList<>();

}
