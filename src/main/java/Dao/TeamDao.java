package Dao;

import dto.TeamRespDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeamDao {
    private final Connection connection;

    public TeamDao(Connection connection) {
        this.connection = connection;
    }
    public int  registerTeam(int stadiumId, String name) {
        String query = "insert into team (stadium_id, team_name, team_created_at) values (?, ?,now())";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, stadiumId);
            statement.setString(2, name);

            int result = statement.executeUpdate();
            System.out.println("registerTeam res : " + result);

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public List<TeamRespDTO> getTeamList() {

        List<TeamRespDTO> teamList = new ArrayList<>();
        String query = "SELECT t.team_id, s.stadium_id, t.team_name,t.team_created_at, s.stadium_name, s.stadium_created_at " +
                "FROM team t " +
                "JOIN stadium s ON t.stadium_id = s.stadium_id";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                TeamRespDTO teamRespDTO = new TeamRespDTO(
                        rs.getInt("team_id"),
                        rs.getInt("stadium_id"),
                        rs.getString("team_name"),
                        rs.getTimestamp("team_created_at"),
                        rs.getString("stadium_name"),
                        rs.getTimestamp("stadium_created_at")
                );
                teamList.add(teamRespDTO);
            }
            return teamList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teamList;
    }
}
