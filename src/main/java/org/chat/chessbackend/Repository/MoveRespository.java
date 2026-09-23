package org.chat.chessbackend.Repository;

import org.chat.chessbackend.Entity.Move;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoveRespository extends JpaRepository<Move, Long> {
    List<Move> findByGame_IdOrderByMoveNumberAsc(Long gameId);
}
