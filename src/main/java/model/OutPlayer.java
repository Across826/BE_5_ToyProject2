package model;

import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class OutPlayer {
    private int outPlayerId;
    private int playerId;
    private String outPlayerReason;
    private Timestamp outPlayerCreatedAt;

    public OutPlayer(int outPlayerId, int playerId, String outPlayerReason, Timestamp outPlayerCreatedAt) {
        this.outPlayerId = outPlayerId;
        this.playerId = playerId;
        this.outPlayerReason = outPlayerReason;
        this.outPlayerCreatedAt = outPlayerCreatedAt;
    }

    @Override
    public String toString() {
        return "OutPlayer{" +
                "outPlayerId=" + outPlayerId +
                ", playerId=" + playerId +
                ", outPlayerReason='" + outPlayerReason + '\'' +
                ", outPlayerCreatedAt=" + outPlayerCreatedAt +
                '}';
    }
}