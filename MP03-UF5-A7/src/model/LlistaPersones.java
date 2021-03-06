package model;

import java.util.LinkedList;

public class LlistaPersones extends LinkedList<Persona> {
	private int persones;

	public LlistaPersones() {
		this.persones = 0;
	}

	/**
	 * M�tode que assigno la variable persones a 0 per despla�ar-me al primer
	 * usuari de la llista
	 */
	public void primerLlista() {
		this.persones = 0;
	}

	/**
	 * M�tode que assigno la variable persones a l'�ltima posici� de la llista
	 * per despla�ar-me a l'�ltima persona
	 */
	public void ultimLlista() {
		this.persones = (size() - 1);
	}

	/**
	 * M�tode que retorna la posici� on es troba l'usuari que mostro de la
	 * llista per pintar la posici� al label de la vista
	 * 
	 * @return la posici� on es troba l'usuari de la llista
	 */
	public int getPosicioActual() {
		return this.persones + 1;
	}

	/**
	 * M�tode que retorna la posici� on es troba l'�ltim usuari de la llista per
	 * pintar l'�ltim usuari disponible de la llista al label
	 * 
	 * @return retorno la mida de la llista
	 */
	public int getUltimaPosicio() {
		return this.size();
	}

	/**
	 * M�tode que afegeixo una posici� a la variable persones quan faig clic al
	 * bot� seg�ent.
	 * 
	 * @throws UnsupportedOperationException
	 */
	public void usuariSeguent() throws UnsupportedOperationException {
		if (this.persones < size() - 1) {
			this.persones += 1;
		}
	}

	/**
	 * M�tode que resto una posici� a la variable persones quan faig clic al
	 * bot� anterior.
	 * 
	 * @throws UnsupportedOperationException
	 */
	public void usuariAnterior() throws UnsupportedOperationException {
		if (this.persones > 0) {
			this.persones -= 1;
		}
	}

	/**
	 * M�tode que retorno l'objecte persona de llista que es troba a la posicio
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
	 * M�tode que esborra una persona de la llista
	 */
	public boolean remove(Object o) {
		boolean correcta = super.remove(o);
		if (correcta) {
			this.persones = 0;
		}
		return correcta;
	}

	/**
	 * M�tode que afegeix una persona a la llista
	 */
	public boolean add(Persona e) {
		this.persones = size();
		return super.add(e);
	}
}
