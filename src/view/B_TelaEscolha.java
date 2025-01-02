package view;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;

public class B_TelaEscolha extends JFrame {

    public B_TelaEscolha() {
        setTitle("SARUC - Escolha");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Abre em tela cheia
        setLayout(new GridLayout(1, 2)); // Divide a tela em duas partes

        // Painel esquerdo (logotipo e mensagem de boas-vindas)
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(0x0073C5)); // Fundo azul
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS)); // Alinhamento vertical

        // Logotipo
        ImageIcon logoIcon = new ImageIcon("src/imagem/logo.png"); // Caminho da imagem
        Image logoImage = logoIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(logoImage), JLabel.CENTER);
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza no painel

        // Texto de boas-vindas
        JLabel welcomeLabel = new JLabel("<html><center>SEJA BEM-VINDO<br>AO<br>SARUC</center></html>", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 36)); // Fonte maior para tela cheia
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza no painel

        // Adicionando componentes ao painel esquerdo com espaçamento
        leftPanel.add(Box.createVerticalGlue()); // Espaçamento flexível no topo
        leftPanel.add(logoLabel);
        leftPanel.add(Box.createVerticalStrut(20)); // Espaçamento fixo entre logotipo e texto
        leftPanel.add(welcomeLabel);
        leftPanel.add(Box.createVerticalGlue()); // Espaçamento flexível no final

        // Painel direito (botões)
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE); // Fundo branco
        rightPanel.setLayout(new GridBagLayout()); // Centraliza os botões

        // Botões
        JButton cadastroButton = new JButton("Cadastro");
        JButton loginButton = new JButton("Login");

        // Estilizando os botões
        customizeButton(cadastroButton);
        customizeButton(loginButton);

        // Adicionando botões ao painel direito
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1, 20, 20)); // Espaçamento entre botões
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(cadastroButton);
        buttonPanel.add(loginButton);

        rightPanel.add(buttonPanel);

        // Adicionando os painéis principais ao JFrame
        add(leftPanel);
        add(rightPanel);

        // Ações dos botões
        cadastroButton.addActionListener(e -> {
            dispose();
            new C_TelaCadastro(); // Abre a tela de cadastro
        });

        loginButton.addActionListener(e -> {
            dispose();
            new D_TelaLogin(); // Abre a tela de login
        });
    }

    // Método para estilizar botões arredondados
    private void customizeButton(JButton button) {
        button.setFont(new Font("Serif", Font.BOLD, 24)); // Fonte maior para tela cheia
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(0x0073C5)); // Azul
        button.setFocusPainted(false);
        button.setBorderPainted(false); // Remove a borda padrão
        button.setOpaque(true);
        button.setContentAreaFilled(false); // Para suportar a personalização completa
        button.setUI(new RoundedButtonUI());
        button.setPreferredSize(new Dimension(150, 50)); // Mantém o tamanho
    }

    // Classe para UI personalizada de botões arredondados
    static class RoundedButtonUI extends javax.swing.plaf.basic.BasicButtonUI {
        @Override
        public void paint(Graphics g, JComponent c) {
            Graphics2D g2 = (Graphics2D) g;
            AbstractButton button = (AbstractButton) c;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Desenha o fundo arredondado
            g2.setColor(button.getBackground());
            g2.fillRoundRect(0, 0, button.getWidth(), button.getHeight(), 20, 20);

            // Desenha o texto do botão
            g2.setColor(button.getForeground());
            FontMetrics fm = g2.getFontMetrics();
            int x = (button.getWidth() - fm.stringWidth(button.getText())) / 2;
            int y = (button.getHeight() + fm.getAscent()) / 2 - fm.getDescent();
            g2.drawString(button.getText(), x, y);
        }

        @Override
        public Dimension getPreferredSize(JComponent c) {
            AbstractButton button = (AbstractButton) c;
            Dimension size = super.getPreferredSize(c);
            size.width = Math.max(size.width, button.getWidth());
            size.height = Math.max(size.height, button.getHeight());
            return size;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new B_TelaEscolha().setVisible(true));
    }
}
