package dto;

import lombok.ToString;

import java.sql.Connection;

@ToString
public class PositionRespDTOPivot {
     String position;
     String lotte;
     String doosan;
     String kium;


    public PositionRespDTOPivot(String position, String lotte, String doosan, String kium) {
        this.position = position;
        this.lotte = lotte;
        this.doosan = doosan;
        this.kium = kium;
    }

    public PositionRespDTOPivot(Connection connection) {
    }
}
