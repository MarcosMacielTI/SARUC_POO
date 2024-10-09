package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInformacoesDevolucao extends JFrame {
    private JLabel labelId;
    private JLabel labelLab;
    private JLabel labelNome;
    private JLabel labelMatricula;
    private JLabel labelHorarioPegou;
    private JTextField textHorarioDevolucao;
    private JButton buttonDevolver;
    
    private MainWindow mainWindow;
    private int laboratorioId;

    // Construtor para receber as informações corretas
    public TelaInformacoesDevolucao(MainWindow mainWindow, int laboratorioId) {
        this.mainWindow = mainWindow;
        this.laboratorioId = laboratorioId;
        
        setTitle("Informações de Devolução");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Definindo layout
        setLayout(new GridLayout(7, 2));

        // Recuperando as informações da tabela
        String labNome = (String) mainWindow.getTableModel().getValueAt(laboratorioId - 1, 1);
        String nomePessoa = (String) mainWindow.getTableModel().getValueAt(laboratorioId - 1, 2);
        String matricula = (String) mainWindow.getTableModel().getValueAt(laboratorioId - 1, 3);
        String horarioPegou = (String) mainWindow.getTableModel().getValueAt(laboratorioId - 1, 4);

        // Exibindo as informações
        labelId = new JLabel("ID: " + laboratorioId);
        labelLab = new JLabel("Laboratório: " + labNome);
        labelNome = new JLabel("Nome: " + nomePessoa);
        labelMatricula = new JLabel("Matrícula: " + matricula);
        labelHorarioPegou = new JLabel("Horário que Pegou: " + horarioPegou);

        // Campo para preencher horário de devolução
        JLabel labelHorarioDevolucao = new JLabel("Horário que Trouxe:");
        textHorarioDevolucao = new JTextField();

        // Botão para devolver a chave
        buttonDevolver = new JButton("Devolver Chave");
        buttonDevolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String horarioDevolucao = textHorarioDevolucao.getText();
                if (!horarioDevolucao.isEmpty()) {
                    // Atualiza o horário de devolução e remove da tabela
                    mainWindow.devolverChave(laboratorioId, horarioDevolucao);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha o horário de devolução.");
                }
            }
        });

        // Adicionando componentes na tela
        add(labelId);
        add(new JLabel(""));
        add(labelLab);
        add(new JLabel(""));
        add(labelNome);
        add(new JLabel(""));
        add(labelMatricula);
        add(new JLabel(""));
        add(labelHorarioPegou);
        add(new JLabel(""));
        add(labelHorarioDevolucao);
        add(textHorarioDevolucao);
        add(new JLabel(""));
        add(buttonDevolver);
    }
}
