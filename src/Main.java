import db.DB;
import entities.Filme;
import entities.dao.FilmeDao;
import jdbc.FilmeDaoJDBC;

import java.sql.*;
import java.text.ParseException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Connection conn = DB.getConnection();
        FilmeDaoJDBC filmeDao = new FilmeDaoJDBC(conn);


        try {
            conn.setAutoCommit(false);
            long inicio = System.currentTimeMillis();

            for (int i = 0; i < 10000; i++) {
                Filme filme = new Filme("Filme " + i, 120, 1996);
                filmeDao.insert(filme);
            }

            conn.commit();
            long fim = System.currentTimeMillis();
            long total = fim - inicio;
            System.out.println("Tempo com transação: " + total / 1000.0 + " segundos");
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException rollbackException) {
                rollbackException.printStackTrace();
            }
        } finally {
            DB.closeConnection();
        }



    }

}