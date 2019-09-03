package model;

// TODO: Auto-generated Javadoc
/**
 * The Class Autore.
 */
public class Autore {

/** The id. */
private static int id;

/** The cognome. */
private String nome,cognome;

/**
 * Instantiates a new autore.
 *
 * @param nome the nome
 * @param cognome the cognome
 */
public Autore(String nome, String cognome) {
	super();
	this.nome = nome;
	this.cognome = cognome;
}

/**
 * Gets the id.
 *
 * @return the id
 */
public static int getId() {
	return id;
}

/**
 * Sets the id.
 *
 * @param id the new id
 */
public static void setId(int id) {
	Autore.id = id;
}

/**
 * Gets the nome.
 *
 * @return the nome
 */
public String getNome() {
	return nome;
}

/**
 * Sets the nome.
 *
 * @param nome the new nome
 */
public void setNome(String nome) {
	this.nome = nome;
}

/**
 * To string.
 *
 * @return the string
 */
@Override
public String toString() {
	return nome + " "+ cognome;
}

/**
 * Gets the cognome.
 *
 * @return the cognome
 */
public String getCognome() {
	return cognome;
}

/**
 * Sets the cognome.
 *
 * @param cognome the new cognome
 */
public void setCognome(String cognome) {
	this.cognome = cognome;
}

}
