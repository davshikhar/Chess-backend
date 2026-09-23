package org.chat.chessbackend.Repository;

import org.chat.chessbackend.Entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findByStatus(Game.GameStatus status);
    List<Game> findByWhitePlayer_IdOrBlackPlayer_Id(Long whitePlayerId, Long blackPlayerId);
    boolean existsByWhitePlayer_IdOrWhitePlayer_IdAndStatus(Long whitePlayerId, Long blackPlayerId, Game.GameStatus status);
}
