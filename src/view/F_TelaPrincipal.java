package view;

import javax.swing.*;
import java.awt.*;

public class F_TelaPrincipal extends JFrame {

    public F_TelaPrincipal() {
        setTitle("Tela Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Tela cheia
        setLayout(new BorderLayout());

        // Painel esquerdo com ícones de navegação
        JPanel painelEsquerdo = new JPanel();
        painelEsquerdo.setLayout(new GridLayout(5, 1, 20, 20)); // Maior espaçamento entre os botões
        painelEsquerdo.setBackground(Color.WHITE);

        JButton btnHome = criarBotaoIcone("🏠", "Home");
        JButton btnBanheiros = criarBotaoIcone("🚽", "Banheiros");
        JButton btnLaboratorios = criarBotaoIcone("💻", "Laboratórios");
        JButton btnSalas = criarBotaoIcone("📒", "Salas");
        JButton btnCriarAmbiente = criarBotaoIcone("➕", "Criar Ambiente");

        painelEsquerdo.add(btnHome);
        painelEsquerdo.add(btnBanheiros);
        painelEsquerdo.add(btnLaboratorios);
        painelEsquerdo.add(btnSalas);
        painelEsquerdo.add(btnCriarAmbiente);

        // Painel central com botões organizados
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new GridLayout(2, 2, 200, 60)); // Aumentei o espaçamento entre os botões
        painelPrincipal.setOpaque(false); // Para permitir fundo arredondado

        // Adicionar botões ao painel central com bordas arredondadas
        painelPrincipal.add(criarBotaoCard("🚽", "Banheiros"));
        painelPrincipal.add(criarBotaoCard("🖥️", "Laboratórios"));
        painelPrincipal.add(criarBotaoCard("📒", "Salas"));
        painelPrincipal.add(criarBotaoCard("➕", "Criar Ambiente"));

        // Painel para centralizar o painel principal
        JPanel painelCentralizado = new JPanel();
        painelCentralizado.setLayout(new GridBagLayout());
        painelCentralizado.setBackground(new Color(0, 132, 180)); // Azul de fundo
        painelCentralizado.add(painelPrincipal); // Adiciona o painel ao centro

        // Painel superior com barra de busca e logo
        JPanel painelSuperior = new JPanel();
        painelSuperior.setLayout(new BorderLayout());
        painelSuperior.setBackground(Color.LIGHT_GRAY);

        // Painel branco com borda
        JPanel painelBranco = new JPanel(new BorderLayout());
        painelBranco.setBackground(Color.WHITE);
        painelBranco.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); // Borda de 1px

        // Carregar e redimensionar a imagem logo
        ImageIcon logoIcon = new ImageIcon("src/imagem/logo.png");
        Image logoImage = logoIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(logoImage));

        // Ajustar posicionamento da logo no painel branco
        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        logoPanel.setBackground(Color.WHITE);
        logoPanel.add(logoLabel);

        painelBranco.add(logoPanel, BorderLayout.WEST);

        // Adicionar o painel branco ao painel superior
        painelSuperior.add(painelBranco, BorderLayout.NORTH);

        // Adicionar os painéis à janela
        add(painelSuperior, BorderLayout.NORTH);
        add(painelEsquerdo, BorderLayout.WEST);
        add(painelCentralizado, BorderLayout.CENTER);

        setVisible(true);
    }

    // Método para criar botões com bordas arredondadas e texto customizado
    private JButton criarBotaoCard(String emoji, String texto) {
        JButton botao = new JButton(emoji + " " + texto) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Definir cor de fundo do botão
                g2.setColor(Color.WHITE);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 50, 50); // Bordas arredondadas

                super.paintComponent(g); // Chama o método pai para renderizar o conteúdo (texto, ícones)
            }

            @Override
            protected void paintBorder(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(0, 132, 180)); // Cor da borda
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 50, 50); // Bordas arredondadas
            }
        };

        botao.setFont(new Font("Serif", Font.BOLD, 30)); // Aumentei o tamanho da fonte
        botao.setForeground(new Color(0, 132, 180)); // Cor do texto
        botao.setFocusPainted(false);
        botao.setContentAreaFilled(false);
        botao.setBorderPainted(false);
        botao.setPreferredSize(new Dimension(300, 250)); // Aumentei o tamanho dos botões
        botao.setHorizontalAlignment(SwingConstants.CENTER);
        botao.setVerticalAlignment(SwingConstants.CENTER);

        // Adiciona evento ao botão (exemplo de ação)
        botao.addActionListener(e -> JOptionPane.showMessageDialog(null, "Você clicou em " + texto));

        return botao;
    }

    private JButton criarBotaoIcone(String emoji, String tooltip) {
        JButton botao = new JButton(emoji);
        botao.setToolTipText(tooltip);
        botao.setFocusPainted(false);
        botao.setContentAreaFilled(false);
        botao.setBorderPainted(false);
        botao.setOpaque(false);
        return botao;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(F_TelaPrincipal::new);
    }
}
