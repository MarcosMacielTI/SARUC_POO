package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaDevolucao extends JFrame {

    private MainWindow mainWindow;
    private JComboBox<String> comboLaboratorios;

    public TelaDevolucao(MainWindow mainWindow) {
        this.mainWindow = mainWindow;

        setTitle("Devolver Chave");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));

        JLabel label = new JLabel("Selecione o laboratório para devolver a chave:", JLabel.CENTER);
        panel.add(label);

        // ComboBox com os laboratórios em uso
        comboLaboratorios = new JComboBox<>();
        for (int i = 0; i < mainWindow.getStatusLaboratorios().size(); i++) {
            if ("Usando".equals(mainWindow.getStatusLaboratorios().get(i))) {
                comboLaboratorios.addItem("Laboratório " + (i + 1));
            }
        }
        panel.add(comboLaboratorios);

        JButton btnDevolver = new JButton("Devolver Chave");
        btnDevolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String laboratorioSelecionado = (String) comboLaboratorios.getSelectedItem();
                if (laboratorioSelecionado != null) {
                    int laboratorioId = comboLaboratorios.getSelectedIndex() + 1;
                    abrirTelaInformacoesDevolucao(laboratorioId);
                }
            }
        });
        panel.add(btnDevolver);

        add(panel);
    }

    // Abrir a tela de informações para devolução
    private void abrirTelaInformacoesDevolucao(int laboratorioId) {
        TelaInformacoesDevolucao telaInformacoesDevolucao = new TelaInformacoesDevolucao(mainWindow, laboratorioId);
        telaInformacoesDevolucao.setVisible(true);
        this.dispose(); // Fecha a tela atual após abrir a próxima
    }
}
