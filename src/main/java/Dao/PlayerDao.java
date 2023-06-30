package Dao;

import constant.Position;
import dto.PositionRespDTO;
import dto.PositionRespDTOPivot;
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
        String query = "select * from player where team_id=?";
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

    // 3.10
    //        String query = "SELECT player_position, MAX(CASE WHEN team_name = '롯데' THEN player_name END) AS '롯데', MAX(CASE WHEN team_name = '두산' THEN player_name END) AS '두산', MAX(CASE WHEN team_name = '키움' THEN player_name END) AS '키움' FROM player JOIN team ON player.team_id = team.team_id GROUP BY player_position ";
    public List<PositionRespDTO> positionPlayer() {
        List<PositionRespDTO> positionList = new ArrayList<>();
        String query = "SELECT t.team_name, p.player_position, p.player_name FROM team t LEFT JOIN player p ON t.team_id = p.team_id";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                PositionRespDTO positionRespDTO = new PositionRespDTO(
                        rs.getString("team_name"),
                        rs.getString("player_position"),
                        rs.getString("player_name")
                );
                positionList.add(positionRespDTO);
            }
            return positionList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return positionList;
    }

    public List<PositionRespDTOPivot> positionPlayerSecond() {
        List<PositionRespDTOPivot> positionList = new ArrayList<>();
        String query = "select player_position, " +
                "MAX(CASE WHEN team_name = '롯데' THEN player_name END) as '롯데', " +
                "MAX(CASE WHEN team_name = '두산' THEN player_name END) as '두산', " +
                "MAX(CASE WHEN team_name = '키움' THEN player_name END) as'키움' " +
                "from player " +
                "join team on player.team_id = team.team_id " +
                "GROUP BY player_position";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                PositionRespDTOPivot positionRespDTOpivot = new PositionRespDTOPivot(
                        rs.getString("player_position"),
                        rs.getString("롯데"),
                        rs.getString("두산"),
                        rs.getString("키움")
                );
                positionList.add(positionRespDTOpivot);
            }
            return positionList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return positionList;
    }


}