package dto;

import lombok.ToString;

import java.sql.Connection;

@ToString
public class PositionRespDTO {
    String teamName;
    String position;
    String playerName;


    public PositionRespDTO(String teamName, String position, String playerName) {
        this.teamName = teamName;
        this.position = position;
        this.playerName = playerName;
    }

    public PositionRespDTO(Connection connection) {
    }

}

