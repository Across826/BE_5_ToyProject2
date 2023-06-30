package dto;

import lombok.Builder;
import lombok.ToString;

import java.sql.Connection;

@ToString
public class OutPlayerRespDTO {
    int playerId;
    String playerName;
    String playerPosition;
    String outReason;
    String outTime;

    @Builder
    public OutPlayerRespDTO(int playerId, String playerName, String playerPosition, String outReason, String outTime) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerPosition = playerPosition;
        this.outReason = outReason;
        this.outTime = outTime;
    }

    public OutPlayerRespDTO(Connection connection) {
    }
}
