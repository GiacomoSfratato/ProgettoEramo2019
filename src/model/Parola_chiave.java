package model;

public class Parola_chiave {
private static int id;
private String parola;
public static int getId() {
	return id;
}
public static void setId(int id) {
	Parola_chiave.id = id;
}
public String getParola() {
	return parola;
}
public void setParola(String parola) {
	this.parola = parola;
}
public Parola_chiave(String parola) {
	this.parola = parola;
}
@Override
public String toString() {
	return "Parola_chiave [parola=" + parola + "]";
}

}
