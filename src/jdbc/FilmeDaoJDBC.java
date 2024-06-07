package jdbc;

import db.DB;
import entities.Filme;
import entities.dao.FilmeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FilmeDaoJDBC implements FilmeDao {
    private Connection conn;

    public FilmeDaoJDBC(Connection conn){
        this.conn = conn;
    }
    public FilmeDaoJDBC(){

    }
    @Override
    public void insert(Filme filme) {

    }

    @Override
    public void update(Filme filme) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Filme findById(Integer id) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = DB.getConnection();
            st = conn.prepareStatement("SELECT f.* FROM filme f WHERE f.id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Filme filme = new Filme();
                filme.setId(rs.getInt("id"));
                filme.setTitulo(rs.getString("titulo"));
                filme.setDuracao(rs.getInt("duracao"));
                filme.setAnoLancamento(rs.getInt("ano_lancamento"));
                return filme;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeConnection();
        }
        return null;
    }

    @Override
    public List<Filme> findAll() {
        return null;
    }
}
