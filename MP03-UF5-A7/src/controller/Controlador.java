package controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import model.LlistaPersones;
import model.Persona;
import view.FrmPrincipal;

public class Controlador {

	private static boolean botoNouActivat = false;
	private LlistaPersones model;
	private FrmPrincipal vista;

	private WindowListener WindowListenerIniciarTancar;

	public Controlador(LlistaPersones model, FrmPrincipal vista) {
		this.model = model;
		this.vista = vista;
	}

	/**
	 * M�tode que implementa els escoltadors dels diferents botons
	 */
	public void control() {

		// Escoltador bot� nou
		vista.getBtnNou().addActionListener(e -> btnNou_Click());

		// Escoltador bot� esborrar
		vista.getBtnEsborra().addActionListener(e -> btnEsborrar_Click());

		// Escoltador bot� edita
		vista.getBtnEdita().addActionListener(e -> btnEdita_Click());

		// Escoltador bot� primer
		vista.getBtnPrimer().addActionListener(e -> btnPrimer_Click());

		// Escoltador bot� darrer
		vista.getBtnDarrer().addActionListener(e -> btnDarrer_Click());

		// Escoltador bot� cancel�la
		vista.getBtnCancella().addActionListener(e -> btnCancela_Click());

		// Escoltador bot� desa
		vista.getBtnDesa().addActionListener(e -> btnDesa_Click());

		// Escoltador bot� seguent
		vista.getBtnSeguent().addActionListener(e -> btnSeguent_Click());

		// Escoltador bot� anterior
		vista.getBtnAnterior().addActionListener(e -> btnAnterior_Click());

		// Escoltador d'iniciar i tancar el programa
		WindowListenerIniciarTancar = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				tancarPrograma();
			}

			public void windowOpened(WindowEvent e) {
				try {
					llegirFitxer();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		};
		vista.addWindowListener(WindowListenerIniciarTancar);
	}

	/**
	 * M�tode que s'executa quan faig clic al bot� nou
	 */
	private void btnNou_Click() {
		// Actualitzo la informaci� del label
		vista.actualitzarInfoLabel();

		// Netejo les dades dels textFields
		vista.netejaTextFields();

		// Crida al m�tode que desactiva i activa els botons necessaris
		nouEditaUsuaris();

		// Activo els textFields per poder escriure les dades de les persones
		vista.actDesCaixes(true);

		botoNouActivat = true;
	}

	/**
	 * M�tode que s'executa quan faig clic al bot� edita
	 */
	private void btnEdita_Click() {
		// Crida al m�tode que desactiva i activa els botons necessaris
		nouEditaUsuaris();

		// Activo els textFields per poder escriure les dades de les persones
		vista.actDesCaixes(true);
	}

	/**
	 * M�tode que s'executa quan faig clic al bot� editar
	 */
	private void nouEditaUsuaris() {
		// Activo els botons desa, cancel�la i desactivo el bot� nou
		vista.botonsUsuaris(true);

		// Desactivo la resta de botons
		vista.desActBotons(false);
	}

	/**
	 * M�tode que s'executa quan faig clic al bot� esborrar
	 */
	private void btnEsborrar_Click() {
		// Variable que emmagatzema la resposta retornada de si l'usuari
		// vol esborrar o no la persona de la llista
		int opcio = vista.respostaEsborrar();

		// Si la resposta �s igual a 0, s'esborrar� la persona
		if (opcio == 0) {
			// Esborro la persona de la llista
			model.remove(model.usuActual());

			// Actualitzo les dades dels textFields i actualitzo
			// la informaci� del label
			actualitzarDades();
		}
	}

	/**
	 * M�tode que s'executa quan faig clic al bot� primer
	 */
	private void btnPrimer_Click() {
		// Assigno la primera posici� a la variable persones
		model.primerLlista();

		// Actualitzo la informaci� dels textFields, mostrant les dades
		// de la primera persona de la llista i actualitzo la informaci� del
		// label
		actualitzarDades();
	}

	/**
	 * M�tode que s'executa quan faig clic al bot� darrer
	 */
	private void btnDarrer_Click() {
		// Assigno l'�ltima posici� a la variable persones
		model.ultimLlista();

		// Actualitzo la informaci� dels textFields, mostrant les dades
		// de l'�ltima persona de la llistai actualitzo la informaci� del label
		actualitzarDades();
	}

	/**
	 * M�tode que s'executa quan faig clic al bot� cancel�lar
	 */
	private void btnCancela_Click() {
		// Crida al m�tdode que desactiva i activa els botons necessaris
		cancelaDesa();

		// Desactivo els textFields
		vista.actDesCaixes(false);

		// Em situo a la primera posici� de la llista
		model.primerLlista();

		// Actualitzo la informaci� dels textFields, mostrant les dades
		// de la primera persona de la llista i actualitzo la informaci�
		// del label
		actualitzarDades();

		botoNouActivat = false;
	}

	/**
	 * M�tode que s'executa quan faig clic al bot� desa
	 */
	private void btnDesa_Click() {

		// Obtinc la persona de la vista
		Persona persona = vista.obtenirDades();

		if (persona != null) {

			// Si la variable booleana est� a true agrego l'usuari,
			// sin�, modifico les dades d'aquest
			if (botoNouActivat) {

				// Afegeixo l'usuari a la llista
				model.add(persona);

				// Actualitzo la informaci� dels textFields i
				// actualitzo la informaci� del label
				actualitzarDades();

				botoNouActivat = false;
			} else {
				// Modifico les dades de l'usuari
				model.usuActual().setDni(persona.getDni());
				model.usuActual().setNom(persona.getNom());
				model.usuActual().setCognom1(persona.getCognom1());
				model.usuActual().setCognom2(persona.getCognom2());
				model.usuActual().setEdat(persona.getEdat());
			}
			// Crida al m�tode que desactiva i activa els botons
			// necessaris
			cancelaDesa();

			// Desactivo els textFields
			vista.actDesCaixes(false);
		}
	}

	/**
	 * M�tode que crida els m�todes de la vista que desactiven i activen els
	 * botons
	 */
	private void cancelaDesa() {
		vista.botonsUsuaris(false);
		vista.desActBotons(true);
	}

	/**
	 * M�tode que s'executa quan faig clic al bot� seg�ent
	 */
	private void btnSeguent_Click() {
		// Avan�o el valor de la variable persones
		model.usuariSeguent();

		// Actualitzo les dades dels textFields i actualitzo
		// el label
		actualitzarDades();
	}

	/**
	 * M�tode que s'executa quan faig clic al bot� anterior
	 */
	private void btnAnterior_Click() {
		// Resto una posici� a la variable persones
		model.usuariAnterior();

		// Actualitzo les dades dels textFields i actualitzo
		// el label
		actualitzarDades();
	}

	/**
	 * M�tode que crida el m�tode actualitzaDades de la vista que actualitzar�
	 * els textFields amb les dades de l'usuari. Tamb� crida el m�tode
	 * actualitzarInfoLabel de la vista que actualitzar� la informaci� el label
	 */
	private void actualitzarDades() {
		vista.actualitzaDades(model.usuActual());
		vista.actualitzarInfoLabel(model.getPosicioActual(),
				model.getUltimaPosicio());
	}

	/**
	 * M�tode que s'executa quan es tanca el programa i escriu les persones de
	 * llista a l'arxiu usuaris.csv
	 * 
	 * @throws IOException
	 */
	private void tancarPrograma() {
		OutputStream fout = null;
		OutputStreamWriter out = null;
		try {
			fout = new FileOutputStream("usuaris.csv");
			out = new OutputStreamWriter(fout, "UTF8");
			

			for (int i = 0; i < model.size(); i++) {
				Persona linia = model.get(i);
				out.write(linia.toString());
				out.write("\n");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				out.close();
				fout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * M�tode que s'executa quan s'obre el programa i carrega les persones de
	 * l'arxiu usuaris.csv a la mem�ria
	 * 
	 * @throws IOException
	 */
	private void llegirFitxer() throws IOException {
		File fitxer = new File("usuaris.csv");

		if (fitxer.exists()) {
			FileInputStream fis = new FileInputStream(fitxer);
			InputStreamReader isr = new InputStreamReader(fis, "UTF8");
			BufferedReader br = new BufferedReader(isr);
			String linia = br.readLine();

			// Si hi ha m�s d'un usuari es recorrer� l'arxiu
			if (linia != null) {
				while (linia != null) {

					// Guardo les dades de les persones a un array separant-les
					// per la coma que hi ha entre les dades de cada persona
					String[] dades = linia.split(";");

					// Afegeixo la persona amb les seves dades
					model.add(new Persona(dades[0], dades[1], dades[2],
							dades[3], Integer.parseInt(dades[4])));
					linia = br.readLine();
				}

				// Em situo a la primera posici� de la llista
				model.primerLlista();

				// Actualitzo els inputs amb les dades del primer
				// usuari de la llista i el label
				actualitzarDades();
			} else {
				// Si no hi ha usuaris a l'arxiu, actualitzo el label, dient
				// que no hi ha registres
				vista.actualitzarInfoLabel(model.getPosicioActual(),
						model.getUltimaPosicio());

				// Desactivo els botons innecessaris
				vista.desActBotons(false);
			}
			
			br.close();
			isr.close();
			fis.close();
		}
		else{
			// Si no existeix el fitxer actualitzo el label amb el text
			// no hi ha registres
			vista.actualitzarInfoLabel(0,0);
		}
	}
}
