package Dao;

import constant.Position;
import model.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDao {
    private final Connection connection;

    public PlayerDao(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    //선수 조회
    public Player getPlayerById(int playerId) {
        String query = "SELECT * FROM player WHERE player_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, playerId);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                Player player = new Player(
                        rs.getInt("player_id"),
                        rs.getInt("team_id"),
                        rs.getString("player_name"),
                        rs.getString("player_position"),
                        rs.getTimestamp("player_created_at")
                );
                return player;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    //선수 등록

    public int registerPlayer(int teamId, String name, Position position) {
        String query = "INSERT INTO player (team_id, player_name, player_position, player_created_at) VALUES (?, ?, ?, NOW())";

        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, teamId);
            statement.setString(2, name);
            statement.setString(3, position.getName());

            int rowCount = statement.executeUpdate();

            return rowCount;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    // 팀별 선수 목록
    public List<Player> getPlayers(int teamId) {
        List<Player> players = new ArrayList<>();
        String query = "select * from player_tb where team_id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, teamId);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Player player = new Player(
                        rs.getInt("player_id"),
                        rs.getInt("team_id"),
                        rs.getString("player_name"),
                        rs.getString("player_position"),
                        rs.getTimestamp("player_created_at")
                );
                players.add(player);
            }
            return players;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 선수의 team_id를 null로 변경
    public void updateTeamIdToNull(int playerId) throws SQLException {
        String query = "UPDATE player SET team_id = NULL WHERE player_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, playerId);
            statement.executeUpdate();
        }
    }


}