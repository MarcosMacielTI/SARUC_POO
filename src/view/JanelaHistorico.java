package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class JanelaHistorico extends JFrame {
    private JTable tabelaHistorico;
    private DefaultTableModel modeloTabela;

    public JanelaHistorico() {
        setTitle("Histórico de Chaves");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Definindo o layout da janela
        setLayout(new BorderLayout());

        // Definindo as colunas da tabela
        String[] colunas = {"ID", "Qual Laboratório", "Nome da pessoa", "Matrícula", "Horário que pegou", "Horário que trouxe", "Data da devolução", "Descrição"};

        // Criando o modelo da tabela
        modeloTabela = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;  // Tornar todas as células não editáveis
            }
        };

        // Criando a tabela e vinculando ao modelo
        tabelaHistorico = new JTable(modeloTabela);

        // Adicionando a tabela a um JScrollPane para habilitar a rolagem
        JScrollPane scrollPane = new JScrollPane(tabelaHistorico);

        // Adicionando o JScrollPane ao centro da janela
        add(scrollPane, BorderLayout.CENTER);
    }

    // Método para adicionar uma nova linha à tabela
    public void adicionarEntradaHistorico(int id, String laboratorio, String nomePessoa, String matricula, String horarioPegou, String horarioTrouxe) {
        modeloTabela.insertRow(0, new Object[]{
            id, laboratorio, nomePessoa, matricula, horarioPegou, horarioTrouxe, "", ""
        });
    }
}
