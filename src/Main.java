import db.DB;
import entities.Diretor;
import jdbc.DiretorDaoJDBC;


import java.sql.*;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Connection conn = DB.getConnection();
        DiretorDaoJDBC diretorDao = new DiretorDaoJDBC(conn);


        try {
            conn.setAutoCommit(false);
            long inicio = System.currentTimeMillis();

            List<Diretor> lista = diretorDao.findAll();
            for (Diretor diretor : lista){
                System.out.println(diretor);
            }

            diretorDao.findAll();
            diretorDao.deleteById(2);
            System.out.println();

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