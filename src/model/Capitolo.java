package model;

public class Capitolo {
private int numero;
private String titolo;

public Capitolo (int numero, String titolo) {
	this.numero = numero;
	this.titolo = titolo;
}

public int getNumero() {
	return numero;
}
public void setNumero(int numero) {
	this.numero = numero;
}
public String getTitolo() {
	return titolo;
}
public void setTitolo(String titolo) {
	this.titolo = titolo;
}


}
