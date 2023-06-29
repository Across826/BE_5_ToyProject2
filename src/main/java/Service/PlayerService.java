package Service;

import Dao.PlayerDao;
import constant.Position;
import model.Player;
import java.util.List;

public class PlayerService {
    private final PlayerDao playerDao;

    public PlayerService(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }

    public int registerPlayer(int teamId, String name, Position position) {
        return playerDao.registerPlayer(teamId, name, position);
    }

    public List<Player> getPlayers(int teamId) {
        return playerDao.getPlayers(teamId);
    }
}