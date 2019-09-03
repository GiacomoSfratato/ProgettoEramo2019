package model;

// TODO: Auto-generated Javadoc
/**
 * The Class Parola_chiave.
 */
public class Parola_chiave {

/** The id. */
private static int id;

/** The parola. */
private String parola;

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
	Parola_chiave.id = id;
}

/**
 * Gets the parola.
 *
 * @return the parola
 */
public String getParola() {
	return parola;
}

/**
 * Sets the parola.
 *
 * @param parola the new parola
 */
public void setParola(String parola) {
	this.parola = parola;
}

/**
 * Instantiates a new parola chiave.
 *
 * @param parola the parola
 */
public Parola_chiave(String parola) {
	this.parola = parola;
}

/**
 * To string.
 *
 * @return the string
 */
@Override
public String toString() {
	return "Parola_chiave [parola=" + parola + "]";
}

}
