import db.DB;
import entities.Filme;
import entities.dao.FilmeDao;
import jdbc.FilmeDaoJDBC;

import java.sql.*;
import java.text.ParseException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FilmeDaoJDBC filmeDao = new FilmeDaoJDBC(DB.getConnection());

         List<Filme> filmes = filmeDao.findAll();
         for (Filme filme: filmes){
             System.out.println(filme);
         }

    }

}