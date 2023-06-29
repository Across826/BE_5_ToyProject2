package dto;

import lombok.Builder;
import lombok.ToString;

import java.sql.Connection;
import java.sql.Timestamp;

@ToString
public class TeamRespDTO {

    private Connection connection;
    
    int id;
    int stadiumId;
    String name;
    Timestamp createdAt;
    String stadiumName;
    Timestamp stadiumCreatedAt;

    @Builder
    public TeamRespDTO(int id, int stadiumId, String name, Timestamp createdAt, String stadiumName, Timestamp stadiumCreatedAt) {
        this.id = id;
        this.stadiumId = stadiumId;
        this.name = name;
        this.createdAt = createdAt;
        this.stadiumName = stadiumName;
        this.stadiumCreatedAt = stadiumCreatedAt;
    }

    public TeamRespDTO(Connection connection) {
    }
}
