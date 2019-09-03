package model;

// TODO: Auto-generated Javadoc
/**
 * The Class Capitolo.
 */
public class Capitolo {

/** The numero. */
private int numero;

/** The titolo. */
private String titolo;

/**
 * Instantiates a new capitolo.
 *
 * @param numero the numero
 * @param titolo the titolo
 */
public Capitolo (int numero, String titolo) {
	this.numero = numero;
	this.titolo = titolo;
}

/**
 * Gets the numero.
 *
 * @return the numero
 */
public int getNumero() {
	return numero;
}

/**
 * Sets the numero.
 *
 * @param numero the new numero
 */
public void setNumero(int numero) {
	this.numero = numero;
}

/**
 * Gets the titolo.
 *
 * @return the titolo
 */
public String getTitolo() {
	return titolo;
}

/**
 * Sets the titolo.
 *
 * @param titolo the new titolo
 */
public void setTitolo(String titolo) {
	this.titolo = titolo;
}


}
