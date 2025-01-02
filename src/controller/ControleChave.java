package controller;

import model.Chave;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utils.DatabaseConnection;


public class ControleChave {
    private Connection connection;

    public ControleChave() {
        connection = DatabaseConnection.getConnection();
    }

    public void emitirChave(Usuario usuario, Chave chave) throws SQLException {
        String sql = "INSERT INTO chaves (descricao, usuario_id, status) VALUES (?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, chave.getDescricao());
        stmt.setInt(2, usuario.getId());
        stmt.setBoolean(3, chave.isStatus());
        stmt.executeUpdate();
        stmt.close();
    }

    public void devolverChave(Usuario usuario, Chave chave) throws SQLException {
        String sql = "UPDATE chaves SET status = ? WHERE id = ? AND usuario_id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setBoolean(1, false);
        stmt.setInt(2, chave.getId());
        stmt.setInt(3, usuario.getId());
        stmt.executeUpdate();
        stmt.close();
    }
}
