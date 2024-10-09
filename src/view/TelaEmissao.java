package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaEmissao extends JFrame {

    private JTextField nomeField;
    private JTextField matriculaField;
    private JComboBox<String> laboratorioComboBox;
    private JTextField horarioPegouField;
    private MainWindow mainWindow;

    public TelaEmissao(MainWindow mainWindow) {
        this.mainWindow = mainWindow;

        setTitle("Emitir Chave");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));

        // Campos do formulário
        add(new JLabel("Qual laboratório:"));
        laboratorioComboBox = new JComboBox<>(new String[]{
                "Laboratório I", "Laboratório II", "Laboratório III", 
                "Laboratório IV", "Laboratório V", "Laboratório VI", "Laboratório VII"
        });
        add(laboratorioComboBox);

        add(new JLabel("Nome da pessoa:"));
        nomeField = new JTextField();
        add(nomeField);

        add(new JLabel("Matrícula:"));
        matriculaField = new JTextField();
        add(matriculaField);

        add(new JLabel("Horário que pegou:"));
        horarioPegouField = new JTextField();
        add(horarioPegouField);

        // Botão de confirmar
        JButton confirmarButton = new JButton("Confirmar");
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmarEmissao();
            }
        });
        add(confirmarButton);

        // Botão de cancelar
        JButton cancelarButton = new JButton("Cancelar");
        cancelarButton.addActionListener(e -> dispose());
        add(cancelarButton);
    }

    // Método para confirmar a emissão e enviar os dados para a tabela
    private void confirmarEmissao() {
        String nome = nomeField.getText();
        String matricula = matriculaField.getText();
        String horarioPegou = horarioPegouField.getText();
        int laboratorioId = laboratorioComboBox.getSelectedIndex() + 1;

        // Atualizando a linha da tabela no MainWindow
        mainWindow.atualizarLinhaTabela(laboratorioId, nome, matricula, horarioPegou);

        // Fechar a tela de emissão após confirmar
        dispose();
    }
}
