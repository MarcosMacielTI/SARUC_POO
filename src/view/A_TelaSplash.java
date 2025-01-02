package view;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class A_TelaSplash extends JFrame {
	public A_TelaSplash() {
		setTitle("SARUC - Splash");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		// Painel de fundo
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0x0073C5));
		panel.setLayout(new BorderLayout());
		// Mensagem
		JLabel label = new JLabel("Carregando SARUC...", JLabel.CENTER);
		label.setFont(new Font("Serif", Font.BOLD, 24));
		label.setForeground(Color.WHITE);
		panel.add(label, BorderLayout.CENTER);
		add(panel);
		// Timer para transição
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				dispose(); // Fecha a tela splash
				new B_TelaEscolha().setVisible(true); // Abre a tela de escolha em tela cheia
			}
		}, 2000); // 2 segundos
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new A_TelaSplash().setVisible(true));
	}
}
