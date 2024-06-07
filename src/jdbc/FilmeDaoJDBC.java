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
    public FilmeDao findById(Integer id) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "select f.* from filme f"
                    + "where f.id = ?"
            );
            st.setInt(1, id);
            rs = st.executeQuery();

            while (rs.next()) {
                Filme filme = new Filme();
                filme.setId(rs.getInt("id"));
                filme.setTitulo(rs.getString("titulo"));
                filme.setDuracao(rs.getInt("duracao"));
                filme.setAnoLancamento(rs.getInt("ano_lancamento"));
                return (FilmeDao) filme;
            }
            return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }

    @Override
    public List<Filme> findAll() {
        return null;
    }
}
