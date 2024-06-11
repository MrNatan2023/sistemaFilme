import db.DB;
import jdbc.FilmeDaoJDBC;

import java.sql.Connection;

public class Program {
    public static void main(String[] args) {

        FilmeDaoJDBC filmeDao = new FilmeDaoJDBC(DB.getConnection());
        filmeDao.deleteById(30014);
    }
}
