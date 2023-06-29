package Service;

import Dao.StadiumDao;
import db.DBConnection;
import model.Stadium;

import java.sql.Connection;
import java.util.List;

public class StadiumService {

    private final StadiumDao stadiumDao;
    private Connection connection;

    public StadiumService(StadiumDao stadiumDao) {
        this.stadiumDao = stadiumDao;
        this.connection = DBConnection.getInstance();
    }


    public int registerStadium(String name) {
        return stadiumDao.registerStadium(name);
    }


    public void getStadium() {
        List<Stadium> stadiumList = stadiumDao.getStadiumList();
        System.out.println(stadiumList.toString());
    }

}
