package Service;

import Dao.PlayerDao;
import Dao.TeamDao;
import constant.Position;
import db.DBConnection;
import dto.PositionRespDTO;
import dto.PositionRespDTOPivot;
import model.Player;

import java.sql.Connection;
import java.util.List;

public class PlayerService {
    private PlayerDao playerDao;
    private TeamDao teamDao;
    private Connection connection;
    private PositionRespDTO positionRespDTO;
    private PositionRespDTOPivot positionRespDTOPivot;

    public PlayerService(PositionRespDTO positionRespDTO) {
        this.connection = DBConnection.getInstance();
        this.teamDao = new TeamDao(connection);
        this.playerDao = new PlayerDao(connection);
        this.positionRespDTO = positionRespDTO;
    }
    public PlayerService(PositionRespDTOPivot positionRespDTOPivot) {
        this.connection = DBConnection.getInstance();
        this.teamDao = new TeamDao(connection);
        this.playerDao = new PlayerDao(connection);
        this.positionRespDTOPivot = positionRespDTOPivot;
    }

    public PlayerService(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }



    public void getPlayers(int teamId) {
        List<Player> playerList = playerDao.getPlayers(teamId);
        System.out.println(playerList.toString());
    }

    public int registerPlayer(int teamId, String name, Position position) {
        return playerDao.registerPlayer(teamId, name, position);
    }
    public void getPositionPlayerPivot() {
        List<PositionRespDTOPivot> positionRespDTOPivot = playerDao.positionPlayerSecond();

        System.out.println(positionRespDTOPivot.toString());
    }

    public void getPositionPlayer() {
        List<PositionRespDTO> positionRespDTO = playerDao.positionPlayer();

        System.out.println(positionRespDTO.toString());
    }



}