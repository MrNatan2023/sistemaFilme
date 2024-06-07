import db.DB;
import entities.Filme;
import entities.dao.FilmeDao;
import jdbc.FilmeDaoJDBC;

import java.sql.*;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) {

        FilmeDao filmeDao = new FilmeDaoJDBC(DB.getConnection());
        System.out.println(filmeDao.findById(1));

    }
    public static void adicionar(){
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "insert into " +
                            "()" +
                            "values "
                            + "()",
                    Statement.RETURN_GENERATED_KEYS
            );

            int rows = st.executeUpdate();

            if (rows > 0){
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()){
                    int id = rs.getInt(1);
                    System.out.println("Id = " + id);
                }
            }else {
                System.out.println("No rows");
            }

            System.out.println("Rows: " + rows);

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }

    public static void atualizar(){
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "update  " +
                            "set " +
                            "where "
                            + "()",
                    Statement.RETURN_GENERATED_KEYS
            );

            int rows = st.executeUpdate();

            if (rows > 0){
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()){
                    int id = rs.getInt(1);
                    System.out.println("Id = " + id);
                }
            }else {
                System.out.println("No rows");
            }

            System.out.println("Rows: " + rows);

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }

    public static void deletar(){
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "delete from " +
                            "where " +
                             "id = ?",
                    Statement.RETURN_GENERATED_KEYS
            );

            int rows = st.executeUpdate();

            if (rows > 0){
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()){
                    int id = rs.getInt(1);
                    System.out.println("Id = " + id);
                }
            }else {
                System.out.println("No rows");
            }

            System.out.println("Rows: " + rows);

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }

    public static void consultar(String tabela) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "select * from " + tabela
            );

            rs = st.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                System.out.println("Id = " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }


}