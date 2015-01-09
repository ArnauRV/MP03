import java.awt.EventQueue;

import model.LlistaPersones;
import view.FrmPrincipal;
import controller.Controlador;

public class Main {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					Controlador controlador = new Controlador(
							new LlistaPersones(), frame);
					controlador.control();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
