package controller;

import model.Historico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControleHistorico {
    private Connection connection;

    public ControleHistorico() {
        connection = DatabaseConnection.getConnection();
    }

    public void registrarHistorico(Historico historico) throws SQLException {
        String sql = "INSERT INTO historico (usuario_id, chave_id, horario_pegou, horario_trouxe) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, historico.getUsuarioId());
        stmt.setInt(2, historico.getChaveId());
        stmt.setString(3, historico.getHorarioPegou());
        stmt.setString(4, historico.getHorarioTrouxe());
        stmt.executeUpdate();
        stmt.close();
    }

    public ResultSet obterHistorico() throws SQLException {
        String sql = "SELECT * FROM historico ORDER BY id DESC";
        PreparedStatement stmt = connection.prepareStatement(sql);
        return stmt.executeQuery();
    }
}
