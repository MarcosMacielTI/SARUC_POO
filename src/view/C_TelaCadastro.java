package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class C_TelaCadastro extends JFrame {

    public C_TelaCadastro() {
        setTitle("Cadastro - SARUC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Tela cheia
        getContentPane().setBackground(new Color(0x0073C5)); // Fundo azul principal
        setLayout(null);

        // Painel branco arredondado
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.WHITE); // Cor do painel branco
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 50, 50); // Bordas arredondadas
                g2.dispose();
            }
        };
        mainPanel.setOpaque(false); // Remove a opacidade para exibir o fundo arredondado
        mainPanel.setLayout(null);

        // Dimensões do painel
        int panelWidth = 800;
        int panelHeight = 600;

        // Calcula a posição central do painel
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - panelWidth) / 2;
        int y = (screenSize.height - panelHeight) / 2;

        mainPanel.setBounds(x, y, panelWidth, panelHeight); // Centraliza o painel

        // Título "CADASTRO"
        JLabel titleLabel = new JLabel("CADASTRO", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 36));
        titleLabel.setForeground(new Color(0x0073C5));
        titleLabel.setBounds(0, 20, panelWidth, 40);
        mainPanel.add(titleLabel);

        // Subtítulo
        JLabel subtitleLabel = new JLabel("BEM-VINDO AO SARUC", JLabel.CENTER);
        subtitleLabel.setFont(new Font("Serif", Font.ITALIC, 16));
        subtitleLabel.setForeground(new Color(0x0073C5));
        subtitleLabel.setBounds(0, 60, panelWidth, 20);
        mainPanel.add(subtitleLabel);

        // Campos de texto
        JLabel nomeLabel = new JLabel("Nome");
        nomeLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        nomeLabel.setBounds(250, 100, 300, 20);
        mainPanel.add(nomeLabel);

        JTextField nomeField = createRoundedTextField();
        nomeField.setBounds(250, 130, 300, 40);
        mainPanel.add(nomeField);

        JLabel matriculaLabel = new JLabel("Matrícula");
        matriculaLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        matriculaLabel.setBounds(250, 180, 300, 20);
        mainPanel.add(matriculaLabel);

        JTextField matriculaField = createRoundedTextField();
        matriculaField.setBounds(250, 210, 300, 40);
        mainPanel.add(matriculaField);

        JLabel emailLabel = new JLabel("E-mail");
        emailLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        emailLabel.setBounds(250, 260, 300, 20);
        mainPanel.add(emailLabel);

        JTextField emailField = createRoundedTextField();
        emailField.setBounds(250, 290, 300, 40);
        mainPanel.add(emailField);

        JLabel senhaLabel = new JLabel("Senha");
        senhaLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        senhaLabel.setBounds(250, 340, 300, 20);
        mainPanel.add(senhaLabel);

        JPasswordField senhaField = createRoundedPasswordField();
        senhaField.setBounds(250, 370, 300, 40);
        mainPanel.add(senhaField);

        // Botões
        JButton cancelarButton = createRoundedButton("CANCELAR");
        cancelarButton.setBounds(200, 450, 150, 40);
        mainPanel.add(cancelarButton);

        JButton cadastrarButton = createRoundedButton("CADASTRAR");
        cadastrarButton.setBounds(450, 450, 150, 40);
        mainPanel.add(cadastrarButton);

        // Texto para redirecionar para o login
        JLabel loginLabel = new JLabel("Fazer login", JLabel.CENTER);
        loginLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        loginLabel.setForeground(new Color(0x0073C5)); // Cor azul
        loginLabel.setBounds(0, 510, panelWidth, 20); // Centralizado horizontalmente
        loginLabel.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Aponta o cursor como link
        loginLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // Ao clicar no "Fazer login", redireciona para a tela de login
                new D_TelaLogin(); // Cria uma nova instância de D_TelaLogin
                dispose(); // Fecha a tela de cadastro
            }
        });
        mainPanel.add(loginLabel);

        // Adiciona o painel ao JFrame
        add(mainPanel);
        setVisible(true);
    }

    // Método para criar campos de texto arredondados
    private JTextField createRoundedTextField() {
        JTextField textField = new JTextField();
        textField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        textField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        textField.setBackground(new Color(0xE0E0E0));
        textField.setOpaque(true);
        return textField;
    }

    // Método para criar campos de senha arredondados
    private JPasswordField createRoundedPasswordField() {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        passwordField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        passwordField.setBackground(new Color(0xE0E0E0));
        passwordField.setOpaque(true);
        return passwordField;
    }

    // Método para criar botões arredondados
    private JButton createRoundedButton(String text) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Fundo do botão
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

                // Texto do botão
                g2.setColor(getForeground());
                FontMetrics fm = g2.getFontMetrics();
                int textWidth = fm.stringWidth(getText());
                int textHeight = fm.getAscent();
                g2.drawString(getText(), (getWidth() - textWidth) / 2, (getHeight() + textHeight) / 2 - 2);
            }

            @Override
            protected void paintBorder(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getForeground());
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
            }
        };
        button.setFocusPainted(false);
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setBackground(new Color(0x0073C5));
        button.setForeground(Color.WHITE);
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(C_TelaCadastro::new);
    }
}
