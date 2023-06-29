package model;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class Player {

    private int playerId;
    private int teamId;
    private String playerName;
    private String playerPosition;
    private Timestamp playerCreatedAt;

    public Player(int playerId, int teamId, String playerName, String playerPosition, Timestamp playerCreatedAt) {
        this.playerId = playerId;
        this.teamId = teamId;
        this.playerName = playerName;
        this.playerPosition = playerPosition;
        this.playerCreatedAt = playerCreatedAt;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", teamId=" + teamId +
                ", playerName='" + playerName + '\'' +
                ", playerPosition='" + playerPosition + '\'' +
                ", playerCreatedAt=" + playerCreatedAt +
                '}';
    }
}