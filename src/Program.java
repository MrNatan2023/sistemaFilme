import db.DB;
import jdbc.FilmeDaoJDBC;

import java.sql.Connection;

public class Program {
    public static void main(String[] args) {

        FilmeDaoJDBC filmeDao = new FilmeDaoJDBC(DB.getConnection());

        for (int i = 20006; ; i++){
            if (filmeDao.findById(i) != null){
                filmeDao.deleteById(i);
            }
        }
    }
}
