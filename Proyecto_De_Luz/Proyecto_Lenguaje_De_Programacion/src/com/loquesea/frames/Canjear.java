package com.loquesea.frames;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Canjear extends JPanel implements ActionListener {
	private JLabel lblSalir;
	private JButton btnNewButton;

	public Canjear(Boolean Condicion, Boolean Condicion2) {
		setOpaque(false);
		setBackground(Color.LIGHT_GRAY);
		setVisible(false);
		setLayout(null);
		
		lblSalir = new JLabel("\u00BFDeseas Salir del programa?");
		lblSalir.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblSalir.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalir.setBounds(164, 168, 482, 91);
		add(lblSalir);
		
		btnNewButton = new JButton("Si");
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnNewButton.setBounds(325, 270, 119, 85);
		add(btnNewButton);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		
		System.exit(1);
	}
}
