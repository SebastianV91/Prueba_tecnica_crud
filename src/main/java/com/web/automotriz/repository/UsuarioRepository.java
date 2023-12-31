package com.web.automotriz.repository;


import com.web.automotriz.exceptions.EtAuthException;
import com.web.automotriz.model.Usuario;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class UsuarioRepository {

    private static final String SQL_CREATE = "INSERT INTO INVENTARIOAUTOMOTRIZ.USUARIO(NOMBRE, EDAD, EMAIL, PASSWORD) VALUES(?, ?, ?, ?)";
    private static final String SQL_COUNT_BY_EMAIL = "SELECT COUNT(*) FROM INVENTARIOAUTOMOTRIZ.USUARIO WHERE EMAIL = ?";
    private static final String SQL_FIND_BY_ID = "SELECT IDUSUARIO, NOMBRE, EDAD, EMAIL, PASSWORD " +
            "FROM INVENTARIOAUTOMOTRIZ.USUARIO WHERE IDUSUARIO = ?";
    private static final String SQL_FIND_BY_EMAIL = "SELECT IDUSUARIO, NOMBRE, EDAD, EMAIL, PASSWORD " +
            "FROM INVENTARIOAUTOMOTRIZ.USUARIO WHERE EMAIL = ?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Integer create(String nombre, String edad, String email, String password) throws EtAuthException {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(10));
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, nombre);
                ps.setString(2, edad);
                ps.setString(3, email);
                ps.setString(4, hashedPassword);
                return ps;
            }, keyHolder);
            return (Integer) keyHolder.getKeys().get("IDUSUARIO");
        } catch (Exception e) {
            throw new EtAuthException("Detalles Invalidos. Fallido a crear cuenta");
        }

    }

    public Usuario findByEmailAndPassword(String email, String password) throws EtAuthException {
        try {
            Usuario usuario = jdbcTemplate.queryForObject(SQL_FIND_BY_EMAIL, new Object[]{email}, usuarioRowMapper);
            if(!BCrypt.checkpw(password, usuario.getPassword()))
                throw new EtAuthException("Password o email invalidos");
            return usuario;
        }catch(EmptyResultDataAccessException e){
            throw new EtAuthException("Password o email invalidos");
        }
    }

    public Integer getCountByEmail(String email) {
        return jdbcTemplate.queryForObject(SQL_COUNT_BY_EMAIL, new Object[]{email}, Integer.class);
    }

    public Usuario findById(Integer idusuario) {
        return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[]{idusuario}, usuarioRowMapper);
    }

    private RowMapper<Usuario> usuarioRowMapper = ((rs, rowNum) -> {
        return new Usuario(rs.getInt("IDUSUARIO"),
                rs.getString("NOMBRE"),
                rs.getString("EDAD"),
                rs.getString("EMAIL"),
                rs.getString("PASSWORD"));
    });

}
