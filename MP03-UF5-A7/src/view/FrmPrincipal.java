package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import model.Persona;
import java.awt.Toolkit;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField tfDNI;
	private JTextField tfCognom1;
	private JTextField tfNom;
	private JTextField tfCognom2;
	private JTextField tfEdat;
	private JToolBar tlbrMenu;

	private JButton btnNou;
	private JButton btnEsborra;
	private JButton btnEdita;
	private JButton btnPrimer;
	private JButton btnDarrer;
	private JButton btnAnterior;
	private JButton btnSeguent;
	private JButton btnDesa;
	private JButton btnCancella;
	private JLabel lbInformacio;

	/**
	 * Create the frame.
	 */
	public FrmPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("icona.png"));
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		tlbrMenu = new JToolBar();

		btnNou = new JButton("Nou");
		tlbrMenu.add(btnNou);

		btnEsborra = new JButton("Esborra");
		tlbrMenu.add(btnEsborra);

		btnEdita = new JButton("Edita");
		tlbrMenu.add(btnEdita);

		btnPrimer = new JButton("Primer");
		tlbrMenu.add(btnPrimer);

		btnDarrer = new JButton("Darrer");
		tlbrMenu.add(btnDarrer);

		btnAnterior = new JButton("Anterior");
		tlbrMenu.add(btnAnterior);

		btnSeguent = new JButton("Seg\u00FCent");
		tlbrMenu.add(btnSeguent);

		btnDesa = new JButton("Desa");
		btnDesa.setEnabled(false);
		tlbrMenu.add(btnDesa);

		btnCancella = new JButton("Cancel\u00B7la");
		btnCancella.setEnabled(false);
		tlbrMenu.add(btnCancella);

		JLabel lbEdat = new JLabel("DNI:");
		lbEdat.setFont(new Font("Tahoma", Font.BOLD, 11));

		tfDNI = new JTextField();
		tfDNI.setDisabledTextColor(Color.BLACK);
		tfDNI.setEnabled(false);
		tfDNI.setColumns(10);

		JLabel lbNom = new JLabel("Nom:");
		lbNom.setFont(new Font("Tahoma", Font.BOLD, 11));

		tfNom = new JTextField();
		tfNom.setDisabledTextColor(Color.BLACK);
		tfNom.setEnabled(false);
		tfNom.setColumns(10);

		JLabel lbCognom1 = new JLabel("Primer cognom:");
		lbCognom1.setFont(new Font("Tahoma", Font.BOLD, 11));

		tfCognom1 = new JTextField();
		tfCognom1.setDisabledTextColor(Color.BLACK);
		tfCognom1.setEnabled(false);
		tfCognom1.setColumns(10);

		JLabel lbCognom2 = new JLabel("Segon cognom:");
		lbCognom2.setFont(new Font("Tahoma", Font.BOLD, 11));

		tfCognom2 = new JTextField();
		tfCognom2.setDisabledTextColor(Color.BLACK);
		tfCognom2.setEnabled(false);
		tfCognom2.setColumns(10);

		JLabel lblEdat = new JLabel("Edat:");
		lblEdat.setFont(new Font("Tahoma", Font.BOLD, 11));

		tfEdat = new JTextField();
		tfEdat.setDisabledTextColor(Color.BLACK);
		tfEdat.setEnabled(false);
		tfEdat.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(getContentPane());
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addComponent(tlbrMenu, GroupLayout.DEFAULT_SIZE, 612,
								Short.MAX_VALUE)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGap(15)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(lbNom)
														.addComponent(lbEdat)
														.addComponent(lbCognom1)
														.addComponent(lbCognom2)
														.addComponent(lblEdat))
										.addGap(18)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																tfNom,
																GroupLayout.PREFERRED_SIZE,
																454,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																tfCognom1,
																GroupLayout.PREFERRED_SIZE,
																454,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																tfDNI,
																GroupLayout.PREFERRED_SIZE,
																454,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																tfCognom2,
																GroupLayout.PREFERRED_SIZE,
																454,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																tfEdat,
																GroupLayout.PREFERRED_SIZE,
																454,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(24, Short.MAX_VALUE)));
		gl_contentPane
				.setVerticalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addComponent(tlbrMenu,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(32)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(lbEdat)
														.addComponent(
																tfDNI,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(lbNom)
														.addComponent(
																tfNom,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(lbCognom1)
														.addComponent(
																tfCognom1,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(lbCognom2)
														.addComponent(
																tfCognom2,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(lblEdat)
														.addComponent(
																tfEdat,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(31)));

		lbInformacio = new JLabel("");
		tlbrMenu.add(lbInformacio);
		contentPane.setLayout(gl_contentPane);
	}

	public JButton getBtnNou() {
		return btnNou;
	}

	public JButton getBtnEsborra() {
		return btnEsborra;
	}

	public JButton getBtnEdita() {
		return btnEdita;
	}

	public JButton getBtnPrimer() {
		return btnPrimer;
	}

	public JButton getBtnDarrer() {
		return btnDarrer;
	}

	public JButton getBtnAnterior() {
		return btnAnterior;
	}

	public JButton getBtnSeguent() {
		return btnSeguent;
	}

	public JButton getBtnDesa() {
		return btnDesa;
	}

	public JButton getBtnCancella() {
		return btnCancella;
	}

	/**
	 * MËtode que actualitza les dades dels diferents textField
	 * 
	 * @param usu
	 */
	public void actualitzaDades(Persona usu) {
		// Si l'usuari no es null actualitzem les dades dels textFields, sinÛ
		// netejo les dades dels textFields i desactivo els butons innecessaris
		if (usu != null) {
			this.tfDNI.setText(usu.getDni());
			this.tfNom.setText(usu.getNom());
			this.tfCognom1.setText(usu.getCognom1());
			this.tfCognom2.setText(usu.getCognom2());
			this.tfEdat.setText(Integer.toString(usu.getEdat()));
		} else {
			// MËtode que neteja els textFields
			netejaTextFields();

			// MËtode que desactiva els butons
			desActBotons(false);
		}
	}

	/**
	 * MËtode que neteja les dades dels textFields
	 */
	public void netejaTextFields() {
		for (Component jtext : getContentPane().getComponents()) {
			if ((jtext instanceof JTextField)) {
				((JTextField) jtext).setText("");
			}
		}
	}

	/**
	 * MËtode que activa o desactiva els textFields segons el par‡metre passat
	 * 
	 * @param opcio
	 */
	public void actDesCaixes(boolean opcio) {
		for (Component jtext : getContentPane().getComponents()) {
			if ((jtext instanceof JTextField)) {
				((JTextField) jtext).setEnabled(opcio);
			}
		}
	}

	/**
	 * MËtode que actualitza el label que mostra per quin usuari passem de la
	 * llista i quans n'hi ha
	 * 
	 * @param posActual
	 * @param tamany
	 */
	public void actualitzarInfoLabel(int posActual, int tamany) {
		if (tamany > 0) {
			this.lbInformacio.setText("        Registre " + posActual + " de "
					+ Integer.toString(tamany));
		} else {
			this.lbInformacio.setText("     No hi ha registres");
		}
	}

	/**
	 * MËtode que actualitza el label quan fem clic al botÛ de nou usuari
	 */
	public void actualitzarInfoLabel() {
		this.lbInformacio.setText("        Nou registre");
	}

	/**
	 * MËtode que activa i desactiva els botons segons el par‡metre passat
	 * 
	 * @param opcio
	 */
	public void desActBotons(boolean opcio) {
		this.btnEdita.setEnabled(opcio);
		this.btnEsborra.setEnabled(opcio);
		this.btnPrimer.setEnabled(opcio);
		this.btnDarrer.setEnabled(opcio);
		this.btnAnterior.setEnabled(opcio);
		this.btnSeguent.setEnabled(opcio);
	}

	/**
	 * MËtode que activa desactiva els botons nou, desa, cancel∑lar segons el
	 * par‡metre passat
	 * 
	 * @param opcio
	 */
	public void botonsUsuaris(boolean opcio) {
		this.btnNou.setEnabled(!opcio);
		this.btnDesa.setEnabled(opcio);
		this.btnCancella.setEnabled(opcio);
	}

	/**
	 * MËtode que recull les dades entrades als textFields i les retorna en
	 * forma de nova persona
	 * 
	 * @return
	 */
	public Persona obtenirDades() {
		// Comprovo que el DNI entrat Ès correcte
		if (this.tfDNI.getText().matches("(\\d{8})([-]?)([A-Z]{1})")) {

			// Comprovo que el nom d'usuari entrat Ès correcte
			if (this.tfNom.getText().matches("^[a-zA-Z·‡ÈËÌÛÚ˙¡¿…»Õ”“⁄—Ò«Á]+$")) {

				// Comprovo que el primer cognom Ès correcte
				if (this.tfCognom1.getText().matches(
						"^[a-zA-Z·‡ÈËÌÛÚ˙¡¿…»Õ”“⁄—Ò«Á]+$")) {

					// Comprovo que el segon cognom Ès correcte
					if (this.tfCognom2.getText().matches(
							"^[a-zA-Z·‡ÈËÌÛÚ˙¡¿…»Õ”“⁄—Ò«Á]+$")) {

						// Comprovo que l'edat Ès correcta
						if (this.tfEdat.getText().matches(
								"^([1-9]|[1-9][0-9]|[1-9][0-9][0-9])$")) {

							// Retorno la persona
							return new Persona(this.tfDNI.getText(),
									this.tfNom.getText(),
									this.tfCognom1.getText(),
									this.tfCognom2.getText(),
									Integer.parseInt(this.tfEdat.getText()));

							// Crido el mËtode missatgeError que em pintar‡ els
							// errors si
							// les dades entrades sÛn incorrectes
						} else {
							missatgeError("Escriu una edat d'entre 1 a 999 anys");
						}
					} else {
						missatgeError("Escriu un segon cognom correcte");
					}
				} else {
					missatgeError("Escriu un primer cognom correcte");
				}
			} else {
				missatgeError("Escriu un nom correcte");
			}
		} else {
			missatgeError("Escriu un DNI correcte. Per exemple 12345678A o 12345678-A");
		}
		return null;
	}

	/**
	 * MËtode que pinta el missatge d'error passat per par‡metre per pantalla
	 * 
	 * @param missatge
	 */
	public void missatgeError(String missatge) {
		JOptionPane.showMessageDialog(this, missatge, "Error",
				JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * MËtode que em pinta un missatge, demanant si vull esborrar una persona i
	 * retorna la resposta de l'usuari (valor del botÛ que s'ha fet click)
	 * 
	 * @return retorno la resposta Si = 0; No = 1;
	 */
	public int respostaEsborrar() {
		return JOptionPane.showOptionDialog(this,
				"Est‡s segur que vols esborrar aquest usuari?",
				"Esborrar usuari", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null,
				new Object[] { "Si", "No" }, "Si");
	}
}