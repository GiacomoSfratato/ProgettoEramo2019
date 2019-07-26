package model;

public class Autore {
private static int id;
private String nome,cognome;
public Autore(String nome, String cognome) {
	super();
	this.nome = nome;
	this.cognome = cognome;
}
public static int getId() {
	return id;
}
public static void setId(int id) {
	Autore.id = id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
@Override
public String toString() {
	return "Autore [nome=" + nome + ", cognome=" + cognome + "]";
}
public String getCognome() {
	return cognome;
}
public void setCognome(String cognome) {
	this.cognome = cognome;
}
}
