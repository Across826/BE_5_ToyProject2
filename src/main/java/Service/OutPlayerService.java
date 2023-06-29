package Service;

import Dao.OutPlayerDao;
import Dao.PlayerDao;
import db.DBConnection;
import model.OutPlayer;
import model.Player;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

public class OutPlayerService {
    private Connection connection;
    private PlayerDao playerDao;
    private OutPlayerDao outPlayerDao;
    public OutPlayerService(Connection connection) {
        this.connection = connection;
        this.outPlayerDao = new OutPlayerDao(connection);
        this.playerDao = new PlayerDao(connection);
    }

    public void registerOutPlayer(int playerId, String reason) {
        // 플레이어 조회
        Player player = playerDao.getPlayerById(playerId);

        if (player == null) {
            System.out.println("해당 선수를 찾을 수 없습니다.");
            return;
        }

        // OutPlayer 생성
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        OutPlayer outPlayer = new OutPlayer(0, playerId, reason, timestamp);

        try {
            // 트랜잭션 시작
            playerDao.getConnection().setAutoCommit(false);

            // out_player 테이블에 퇴출 선수 등록
            outPlayerDao.registerOutPlayer(
                    outPlayer.getPlayerId(),
                    outPlayer.getOutPlayerReason()
            );

            // player 테이블에서 해당 선수의 team_id를 null로 업데이트
            playerDao.updateTeamIdToNull(playerId);

            // 트랜잭션 커밋
            playerDao.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();

            // 트랜잭션 롤백
            try {
                playerDao.getConnection().rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            // 트랜잭션 종료
            try {
                playerDao.getConnection().setAutoCommit(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        System.out.println("퇴출 선수 등록이 완료되었습니다.");
    }
}