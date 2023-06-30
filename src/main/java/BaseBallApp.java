
import dto.PositionRespDTO;
import dto.PositionRespDTOPivot;
import dto.TeamRespDTO;
import Dao.PlayerDao;

import Dao.StadiumDao;
import Service.PlayerService;
import Service.StadiumService;
import Service.TeamService;
import Service.OutPlayerService;
import constant.Position;
import db.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class BaseBallApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Connection connection = DBConnection.getInstance();

        System.out.println("어떤 기능을 요청하시겠습니까?");
        String userInput = scanner.nextLine();

        //@Todo main 줄이기
        if (userInput.equals("야구장목록")){ // 3.2
            StadiumDao stadiumDao = new StadiumDao(connection);
            StadiumService stadiumService = new StadiumService(stadiumDao);
            stadiumService.getStadium();
        } else if (userInput.equals("팀목록")){ // 3.4
            TeamRespDTO teamRespDTO = new TeamRespDTO(connection);
            TeamService teamService = new TeamService(teamRespDTO);
            teamService.getTeam();
        } else if(userInput.equals("포지션별목록")) { // 3. 10
          PositionRespDTOPivot positionRespDTOPivot = new PositionRespDTOPivot(connection);
          PlayerService playerService = new PlayerService(positionRespDTOPivot);
          playerService.getPositionPlayerPivot();

//        PositionRespDTO positionRespDTO = new PositionRespDTO(connection);
//        PlayerService playerService = new PlayerService(positionRespDTO);
//        playerService.getPositionPlayer();
        } else if (userInput.startsWith("선수목록")) { // 3.6
            String[] params = userInput.split("\\?")[1].split("&");
            int teamId = 0;

            for (String param : params) {
                String[] keyValue = param.split("=");
                String key = keyValue[0];
                String value = keyValue[1];

                switch (key) {
                    case "teamId":
                        teamId = Integer.parseInt(value);
                        break;
                    default:
                        System.out.println("잘못된 입력입니다.");
                        return;
                }
            }
            PlayerDao playerDao = new PlayerDao(connection);
            PlayerService playerService = new PlayerService(playerDao);
            playerService.getPlayers(teamId);
        }
        else if (userInput.startsWith("선수등록")) { //3.5
            String[] params = userInput.split("\\?")[1].split("&");
            int teamId = 0;
            String name = "";
            Position position = null;

            for (String param : params) {
                String[] keyValue = param.split("=");
                String key = keyValue[0];
                System.out.println(keyValue[0]);
                System.out.println(keyValue[1]);
                String value = keyValue[1];

                switch (key) {
                    case "teamId":
                        teamId = Integer.parseInt(value);
                        break;
                    case "name":
                        name = value;
                        break;
                    case "position":
                        position = Position.findByName(value);
                        break;
                    default:
                        System.out.println("잘못된 입력입니다.");
                        return;
                }
            }

            PlayerDao playerDao = new PlayerDao(connection);
            PlayerService playerService = new PlayerService(playerDao);
            int result = playerService.registerPlayer(teamId, name, position);

            if (result == 1) {
                System.out.println("선수 등록이 성공적으로 완료되었습니다.");
            }
        } else if (userInput.startsWith("야구장등록")) { //3.1
            String[] params = userInput.split("\\?")[1].split("&");
            String name = "";

            for (String param : params) {
                String[] keyValue = param.split("=");
                String key = keyValue[0];
                String value = keyValue[1];

                switch (key) {
                    case "name":
                        name = value;
                        break;
                    default:
                        System.out.println("잘못된 입력입니다.");
                        return;
                }
            }

            StadiumDao stadiumDao = new StadiumDao(connection);
            StadiumService stadiumService = new StadiumService(stadiumDao);
            int result = stadiumService.registerStadium(name);

            if (result == 1) {
                System.out.println("야구장 등록이 성공적으로 완료되었습니다.");
            }
        } else if (userInput.startsWith("팀등록")) {// 3.3
            String[] params = userInput.split("\\?")[1].split("&");
            int stadiumId = 0;
            String name = "";

            for (String param : params) {
                String[] keyValue = param.split("=");
                String key = keyValue[0];
                String value = keyValue[1];

                switch (key) {
                    case "stadiumId":
                        stadiumId = Integer.parseInt(value);
                        break;
                    case "name":
                        name = value;
                        break;
                    default:
                        System.out.println("잘못된 입력입니다.");
                        return;
                }
            }
            TeamService teamService = new TeamService();
            int result = teamService.registerTeam(stadiumId, name);

            if (result == 1) {
                System.out.println("팀 등록이 성공적으로 완료되었습니다.");
            }

        } else if (userInput.startsWith("퇴출등록")) { // 3.7
            String[] params = userInput.split("\\?")[1].split("&");
            int playerId = 0;
            String reason = "";

            for (String param : params) {
                String[] keyValue = param.split("=");
                String key = keyValue[0];
                String value = keyValue[1];

                switch (key) {
                    case "playerId":
                        playerId = Integer.parseInt(value);
                        break;
                    case "reason":
                        reason = value;
                        break;
                    default:
                        System.out.println("잘못된 입력입니다.");
                        return;
                }
            }

            OutPlayerService outPlayerService = new OutPlayerService(connection);
            outPlayerService.registerOutPlayer(playerId, reason);
            System.out.println("퇴출 등록이 성공적으로 완료되었습니다.");
        } else {
            System.out.println("잘못된 입력입니다.");
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
