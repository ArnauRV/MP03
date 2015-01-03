package model;

import java.util.ArrayList;

public class LlistaPersones extends ArrayList<Persona> {
	private int persones;

	public LlistaPersones() {
		this.persones = 0;
	}

	/**
	 * Mètode que assigno la variable persones a 0 per desplaçar-me al primer
	 * usuari de la llista
	 */
	public void primerLlista() {
		this.persones = 0;
	}

	/**
	 * Mètode que assigno la variable persones a l'última posició de de la
	 * llista per desplaçar-me a l'última persona
	 */
	public void ultimLlista() {
		this.persones = (size() - 1);
	}

	/**
	 * Mètode que retorno la posició on es troba l'usuari de la llista
	 * 
	 * @return la posició on es troba l'usuari de la llista
	 */
	public int getPosicioActual() {
		return this.persones + 1;
	}

	/**
	 * Mètode que afegeixo una posició a la variable persones quan faig clic al
	 * botó següent.
	 * 
	 * @throws UnsupportedOperationException
	 */
	public void usuariSeguent() throws UnsupportedOperationException {
		if (this.persones < size() - 1) {
			this.persones += 1;
		}
	}

	/**
	 * Mètode que resto una posició a la variable persones quan faig clic al
	 * botó següent.
	 * 
	 * @throws UnsupportedOperationException
	 */
	public void usuariAnterior() throws UnsupportedOperationException {
		if (this.persones > 0) {
			this.persones -= 1;
		}
	}

	/**
	 * Mètode que retorno l'objecte persona de llista que es troba a la posicio
	 * persones
	 * 
	 * @return retorno l'objecte persona
	 */
	public Persona usuActual() {
		if (size() >= 1) {
			return (Persona) get(this.persones);
		}
		return null;
	}

	/**
	 * Mètode que esborra una persona de la llista
	 */
	public boolean remove(Object o) {
		boolean correcta = super.remove(o);
		if (correcta) {
			this.persones = 0;
		}
		return correcta;
	}

	/**
	 * Mètode que afegeix una persona a la llista
	 */
	public boolean add(Persona e) {
		this.persones = size();
		return super.add(e);
	}
}
