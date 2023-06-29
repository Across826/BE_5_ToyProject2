package Dao;

import constant.Position;
import model.OutPlayer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OutPlayerDao {
    private final Connection connection;

    public OutPlayerDao(Connection connection) {
        this.connection = connection;
    }

    //선수 퇴출 등록

    public int registerOutPlayer(int PlayerId, String outPlayerReason) {
        String query = "INSERT INTO out_player (player_id, out_player_reason, out_player_created_at) VALUES (?, ?, NOW())";


        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, PlayerId);
            statement.setString(2, outPlayerReason);

            int rowCount = statement.executeUpdate();

            return rowCount;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //선수 퇴출 목록
    public List<OutPlayer> getOutPlayers(int playerId) {
        List<OutPlayer> players = new ArrayList<>();
        String query = "select * from out_player where player_id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, playerId);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                OutPlayer player = new OutPlayer(
                        rs.getInt("out_player_id"),
                        rs.getInt("player_id"),
                        rs.getString("out_player_reason"),
                        rs.getTimestamp("out_player_created_at")
                );
                players.add(player);
            }
            return players;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}