package model;

public class Persona {
	private String dni;
	private String nom;
	private String cognom1;
	private String cognom2;
	private int edat;

	public Persona(String dni, String nom, String cognom1, String cognom2,
			int edat) {
		this.dni = dni;
		this.nom = nom;
		this.cognom1 = cognom1;
		this.cognom2 = cognom2;
		this.edat = edat;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognom1() {
		return this.cognom1;
	}

	public void setCognom1(String cognom1) {
		this.cognom1 = cognom1;
	}

	public String getCognom2() {
		return this.cognom2;
	}

	public void setCognom2(String cognom2) {
		this.cognom2 = cognom2;
	}

	public int getEdat() {
		return this.edat;
	}

	public void setEdat(int edat) {
		this.edat = edat;
	}

	public String toString() {
		return this.dni + ";" + this.nom + ";" + this.cognom1 + ";"
				+ this.cognom2 + ";" + this.edat;
	}
}
