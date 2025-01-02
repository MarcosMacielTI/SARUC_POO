package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class E_TelaEsqueciSenha extends JFrame {

    public E_TelaEsqueciSenha() {
        setTitle("Esqueci Senha - SARUC");
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

        // Botão "Voltar"
        JButton backButton = new JButton("←");
        backButton.setFont(new Font("Serif", Font.BOLD, 24)); // Ajuste a fonte para garantir que a seta apareça
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);
        backButton.setForeground(new Color(0x0073C5)); // Cor do ícone "Voltar"
        backButton.setBounds(20, 20, 80, 40);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Voltar para a tela D_TelaLogin
                new D_TelaLogin();
                dispose(); // Fecha a tela atual
            }
        });
        mainPanel.add(backButton);

        // Título "Esqueci Senha"
        JLabel titleLabel = new JLabel("Esqueci Senha", JLabel.CENTER);
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
        JLabel nomeLabel = new JLabel("Matrícula");
        nomeLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        nomeLabel.setBounds(250, 100, 300, 20);
        mainPanel.add(nomeLabel);

        JTextField nomeField = createRoundedTextField();
        nomeField.setBounds(250, 130, 300, 40);
        mainPanel.add(nomeField);

        JLabel matriculaLabel = new JLabel("E-mail");
        matriculaLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        matriculaLabel.setBounds(250, 180, 300, 20);
        mainPanel.add(matriculaLabel);

        JTextField matriculaField = createRoundedTextField();
        matriculaField.setBounds(250, 210, 300, 40);
        mainPanel.add(matriculaField);

        JLabel senhaLabel = new JLabel("Senha Atual");
        senhaLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        senhaLabel.setBounds(250, 260, 300, 20);
        mainPanel.add(senhaLabel);

        JPasswordField senhaField = createRoundedPasswordField();
        senhaField.setBounds(250, 290, 300, 40);
        mainPanel.add(senhaField);

        
        JLabel senhanova = new JLabel("Senha Nova");
        senhanova.setFont(new Font("SansSerif", Font.BOLD, 16));
        senhanova.setBounds(250, 340, 300, 20);
        mainPanel.add(senhanova);

        JPasswordField senhaField_nova = createRoundedPasswordField();
        senhaField_nova.setBounds(250, 370, 300, 40);
        mainPanel.add(senhaField_nova);
        
        
        // Botões
        JButton cancelarButton = createRoundedButton("CANCELAR");
        cancelarButton.setBounds(200, 460, 150, 40);
        mainPanel.add(cancelarButton);

        JButton loginButton = createRoundedButton("ENVIAR");
        loginButton.setBounds(450, 460, 150, 40);
        mainPanel.add(loginButton);

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
        SwingUtilities.invokeLater(E_TelaEsqueciSenha::new);
    }
}
