package model;

public class Sorgente {
private static int id;
private int id_pubblicazione;
private String URI,tipo,formato,descrizione;
public static int getId() {
	return id;
}
public static void setId(int id) {
	Sorgente.id = id;
}
public int getId_pubblicazione() {
	return id_pubblicazione;
}
public void setId_pubblicazione(int id_pubblicazione) {
	this.id_pubblicazione = id_pubblicazione;
}
public String getURI() {
	return URI;
}
public void setURI(String uRI) {
	URI = uRI;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
public String getFormato() {
	return formato;
}
public void setFormato(String formato) {
	this.formato = formato;
}
public String getDescrizione() {
	return descrizione;
}
public void setDescrizione(String descrizione) {
	this.descrizione = descrizione;
}
public Sorgente(int id_pubblicazione, String uRI, String tipo, String formato, String descrizione) {
	super();
	this.id_pubblicazione = id_pubblicazione;
	URI = uRI;
	this.tipo = tipo;
	this.formato = formato;
	this.descrizione = descrizione;
}
public Sorgente(String uRI) {
URI = uRI;	
}
@Override
public String toString() {
	return "Sorgente [id_pubblicazione=" + id_pubblicazione + ", URI=" + URI + ", tipo=" + tipo + ", formato=" + formato
			+ ", descrizione=" + descrizione + "]";
}

}
