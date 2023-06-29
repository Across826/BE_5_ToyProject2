package Service;

import dto.TeamRespDTO;
import Dao.StadiumDao;
import Dao.TeamDao;
import db.DBConnection;

import java.sql.Connection;
import java.util.List;

public class TeamService {

    private TeamRespDTO teamRespDTO;
    private StadiumDao stadiumDao;
    private TeamDao teamDao;
    private Connection connection;

    public TeamService() {
        this.connection = DBConnection.getInstance();
        this.teamDao = new TeamDao(connection);
        this.teamRespDTO = new TeamRespDTO(connection);
    }

    public TeamService(TeamRespDTO teamRespDTO) {
        this.connection = DBConnection.getInstance();
        this.teamDao = new TeamDao(connection);
        this.teamRespDTO = teamRespDTO;
    }

    public int registerTeam(int stadiumId, String name) {
        return teamDao.registerTeam(stadiumId, name);
    }

    public void getTeam() {

        List<TeamRespDTO> teamList = teamDao.getTeamList();

        System.out.println(teamList.toString());
    }
}

