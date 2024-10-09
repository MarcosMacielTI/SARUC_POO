package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class MainWindow extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;
    private ArrayList<String> statusLaboratorios;

    public MainWindow() {
        setTitle("Sistema de Autorização e Registro de Chaves");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializando status dos laboratórios
        statusLaboratorios = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            statusLaboratorios.add("Disponível"); // Todos começam como disponíveis
        }

        // Painel principal
        JPanel panel = new JPanel(new BorderLayout());

        // Label do título
        JLabel label = new JLabel("Bem-vindo ao SARUC", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setForeground(Color.BLACK);
        label.setOpaque(true);
        label.setBackground(new Color(12, 192, 223));
        label.setPreferredSize(new Dimension(1000, 80));
        panel.add(label, BorderLayout.NORTH);

        // Painel dos botões (cards)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        // Card de Emitir Chave
        JButton emitirChaveCard = new JButton("Emitir Chave");
        emitirChaveCard.setPreferredSize(new Dimension(200, 50));
        emitirChaveCard.setBackground(new Color(12, 192, 223));
        emitirChaveCard.setForeground(Color.WHITE);
        emitirChaveCard.setFont(new Font("Arial", Font.BOLD, 16));
        emitirChaveCard.addActionListener(e -> abrirTelaEmissao());

        // Card de Devolver Chave
        JButton devolverChaveCard = new JButton("Devolver Chave");
        devolverChaveCard.setPreferredSize(new Dimension(200, 50));
        devolverChaveCard.setBackground(new Color(12, 192, 223));
        devolverChaveCard.setForeground(Color.WHITE);
        devolverChaveCard.setFont(new Font("Arial", Font.BOLD, 16));
        devolverChaveCard.addActionListener(e -> abrirTelaDevolucao());

        buttonPanel.add(emitirChaveCard);
        buttonPanel.add(devolverChaveCard);
        panel.add(buttonPanel, BorderLayout.CENTER);

        // Painel para legenda e tabela
        JPanel tablePanel = new JPanel(new BorderLayout());

        // Legenda de status com ícones redondos
        JPanel legendaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Ícone vermelho (usando)
        JLabel redCircle = new JLabel();
        redCircle.setOpaque(true);
        redCircle.setBackground(Color.RED);
        redCircle.setPreferredSize(new Dimension(15, 15));
        redCircle.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        redCircle.setText(" ");
        
        JLabel usandoLabel = new JLabel("Estão usando ");
        usandoLabel.setForeground(Color.RED);

        // Ícone verde (disponível)
        JLabel greenCircle = new JLabel();
        greenCircle.setOpaque(true);
        greenCircle.setBackground(Color.GREEN);
        greenCircle.setPreferredSize(new Dimension(15, 15));
        greenCircle.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        greenCircle.setText(" ");

        JLabel disponivelLabel = new JLabel(" | Está disponível ");
        disponivelLabel.setForeground(Color.GREEN);

        legendaPanel.add(redCircle);
        legendaPanel.add(usandoLabel);
        legendaPanel.add(greenCircle);
        legendaPanel.add(disponivelLabel);

        // Adicionando a legenda logo acima da tabela
        tablePanel.add(legendaPanel, BorderLayout.NORTH);

        // Tabela
        String[] columnNames = {"id", "Qual laboratório", "nome da pessoa", "matrícula", "horário que pegou"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel) {
            public Component prepareRenderer(javax.swing.table.TableCellRenderer renderer, int row, int col) {
                Component comp = super.prepareRenderer(renderer, row, col);
                if (col == 1) {
                    String status = statusLaboratorios.get(row);
                    if ("Usando".equals(status)) {
                        comp.setBackground(Color.RED);
                    } else {
                        comp.setBackground(Color.GREEN);
                    }
                } else {
                    comp.setBackground(Color.WHITE);
                }
                return comp;
            }
        };
        table.setRowHeight(30);
        table.setFont(new Font("Arial", Font.PLAIN, 14));

        // Evita que o usuário redimensione as colunas
        table.getTableHeader().setReorderingAllowed(false); 
        table.getTableHeader().setResizingAllowed(false);

        // Define a largura fixa para cada coluna
        table.getColumnModel().getColumn(0).setPreferredWidth(50);  // Coluna ID
        table.getColumnModel().getColumn(1).setPreferredWidth(200); // Coluna "Qual laboratório"
        table.getColumnModel().getColumn(2).setPreferredWidth(200); // Coluna "Nome da pessoa"
        table.getColumnModel().getColumn(3).setPreferredWidth(150); // Coluna "Matrícula"
        table.getColumnModel().getColumn(4).setPreferredWidth(150); // Coluna "Horário que pegou"

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(950, 250));
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        // Adiciona o painel da tabela ao painel principal
        panel.add(tablePanel, BorderLayout.SOUTH);

        // Adicionando apenas os ids e os laboratórios
        adicionarLinhaTabela(new Object[]{"1", "Laboratório I", "", "", ""});
        adicionarLinhaTabela(new Object[]{"2", "Laboratório II", "", "", ""});
        adicionarLinhaTabela(new Object[]{"3", "Laboratório III", "", "", ""});
        adicionarLinhaTabela(new Object[]{"4", "Laboratório IV", "", "", ""});
        adicionarLinhaTabela(new Object[]{"5", "Laboratório V", "", "", ""});
        adicionarLinhaTabela(new Object[]{"6", "Laboratório VI", "", "", ""});
        adicionarLinhaTabela(new Object[]{"7", "Laboratório VII", "", "", ""});

        add(panel);
    }

    // Método para abrir a tela de emissão
    private void abrirTelaEmissao() {
        TelaEmissao telaEmissao = new TelaEmissao(this);
        telaEmissao.setVisible(true);
    }

    // Método para abrir a tela de devolução
    private void abrirTelaDevolucao() {
        // Verifica os laboratórios que estão sendo usados
        ArrayList<Integer> laboratoriosEmUso = new ArrayList<>();
        for (int i = 0; i < statusLaboratorios.size(); i++) {
            if ("Usando".equals(statusLaboratorios.get(i))) {
                laboratoriosEmUso.add(i + 1); // Adiciona o ID (1 a 7)
            }
        }

        if (laboratoriosEmUso.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Não há laboratórios em uso.");
            return;
        }

        // Cria uma tela para escolher qual laboratório devolver
        String[] opcoes = new String[laboratoriosEmUso.size()];
        for (int i = 0; i < laboratoriosEmUso.size(); i++) {
            int id = laboratoriosEmUso.get(i);
            String labNome = (String) tableModel.getValueAt(id - 1, 1);
            opcoes[i] = "ID: " + id + " - " + labNome;
        }

        String escolha = (String) JOptionPane.showInputDialog(this, "Escolha o laboratório para devolver:", 
                "Devolver Chave", JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

        if (escolha != null) {
            int labId = Integer.parseInt(escolha.split(" ")[1]); // Extrai o ID do laboratório
            TelaInformacoesDevolucao telaDevolucao = new TelaInformacoesDevolucao(this, labId);
            telaDevolucao.setVisible(true);
        }
    }

    // Método para adicionar ou atualizar uma linha na tabela
    public void atualizarLinhaTabela(int id, String nome, String matricula, String horarioPegou) {
        tableModel.setValueAt(nome, id - 1, 2);
        tableModel.setValueAt(matricula, id - 1, 3);
        tableModel.setValueAt(horarioPegou, id - 1, 4);

        statusLaboratorios.set(id - 1, "Usando");
        table.repaint();
    }

    // Método para devolver a chave e liberar o laboratório
    public void devolverChave(int id, String horarioDevolucao) {
        tableModel.setValueAt("", id - 1, 2);
        tableModel.setValueAt("", id - 1, 3);
        tableModel.setValueAt("", id - 1, 4);

        statusLaboratorios.set(id - 1, "Disponível");
        table.repaint();
    }

    // Método para adicionar linhas à tabela
    private void adicionarLinhaTabela(Object[] linha) {
        tableModel.addRow(linha);
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow mainWindow = new MainWindow();
            mainWindow.setVisible(true);
        });
    }
}
