package model;

// TODO: Auto-generated Javadoc
/**
 * The Class Sorgente.
 */
public class Sorgente {

/** The id. */
private static int id;

/** The id pubblicazione. */
private int id_pubblicazione;

/** The descrizione. */
private String URI,tipo,formato,descrizione;

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
	Sorgente.id = id;
}

/**
 * Gets the id pubblicazione.
 *
 * @return the id pubblicazione
 */
public int getId_pubblicazione() {
	return id_pubblicazione;
}

/**
 * Sets the id pubblicazione.
 *
 * @param id_pubblicazione the new id pubblicazione
 */
public void setId_pubblicazione(int id_pubblicazione) {
	this.id_pubblicazione = id_pubblicazione;
}

/**
 * Gets the uri.
 *
 * @return the uri
 */
public String getURI() {
	return URI;
}

/**
 * Sets the uri.
 *
 * @param uRI the new uri
 */
public void setURI(String uRI) {
	URI = uRI;
}

/**
 * Gets the tipo.
 *
 * @return the tipo
 */
public String getTipo() {
	return tipo;
}

/**
 * Sets the tipo.
 *
 * @param tipo the new tipo
 */
public void setTipo(String tipo) {
	this.tipo = tipo;
}

/**
 * Gets the formato.
 *
 * @return the formato
 */
public String getFormato() {
	return formato;
}

/**
 * Sets the formato.
 *
 * @param formato the new formato
 */
public void setFormato(String formato) {
	this.formato = formato;
}

/**
 * Gets the descrizione.
 *
 * @return the descrizione
 */
public String getDescrizione() {
	return descrizione;
}

/**
 * Sets the descrizione.
 *
 * @param descrizione the new descrizione
 */
public void setDescrizione(String descrizione) {
	this.descrizione = descrizione;
}

/**
 * Instantiates a new sorgente.
 *
 * @param id_pubblicazione the id pubblicazione
 * @param uRI the u RI
 * @param tipo the tipo
 * @param formato the formato
 * @param descrizione the descrizione
 */
public Sorgente(int id_pubblicazione, String uRI, String tipo, String formato, String descrizione) {
	super();
	this.id_pubblicazione = id_pubblicazione;
	URI = uRI;
	this.tipo = tipo;
	this.formato = formato;
	this.descrizione = descrizione;
}

/**
 * Instantiates a new sorgente.
 *
 * @param uRI the u RI
 */
public Sorgente(String uRI) {
URI = uRI;	
}

/**
 * Instantiates a new sorgente.
 *
 * @param URI the uri
 * @param tipo the tipo
 * @param formato the formato
 * @param descrizione the descrizione
 */
public Sorgente(String URI, String tipo, String formato, String descrizione) {
	this.URI = URI;
	this.tipo = tipo;
	this.formato = formato;
	this.descrizione = descrizione;
}

/**
 * To string.
 *
 * @return the string
 */
@Override
public String toString() {
	return "Sorgente [id_pubblicazione=" + id_pubblicazione + ", URI=" + URI + ", tipo=" + tipo + ", formato=" + formato
			+ ", descrizione=" + descrizione + "]";
}

}
