package view;

import controller.ControleHistorico;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JanelaHistorico extends JFrame {
    private ControleHistorico controleHistorico;
    private JTable historicoTable;
    private DefaultTableModel tableModel;

    public JanelaHistorico() {
        controleHistorico = new ControleHistorico();
        setTitle("Histórico de Chaves");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Criação da tabela
        String[] columnNames = {"ID", "Usuário ID", "Chave ID", "Horário que Pegou", "Horário que Trouxe"};
        tableModel = new DefaultTableModel(columnNames, 0);
        historicoTable = new JTable(tableModel);

        // Carrega os dados do histórico
        loadHistorico();

        // Adiciona a tabela a um scroll pane
        JScrollPane scrollPane = new JScrollPane(historicoTable);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void loadHistorico() {
        try {
            ResultSet rs = controleHistorico.obterHistorico();
            while (rs.next()) {
                int id = rs.getInt("id");
                int usuarioId = rs.getInt("usuarioId");
                int chaveId = rs.getInt("chaveId");
                String horarioPegou = rs.getString("horarioPegou");
                String horarioTrouxe = rs.getString("horarioTrouxe");
                
                // Adiciona os dados ao modelo da tabela
                tableModel.addRow(new Object[]{id, usuarioId, chaveId, horarioPegou, horarioTrouxe});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar histórico: " + e.getMessage());
        }
    }
}
