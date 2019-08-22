package model;

public class LibraryUser {
	
	private static int id;
	private static String email;
	private static String password;
	private static String livello;
	private static String nome;
	private static String cognome;

	public LibraryUser(int id, String email, String password, String livello, String nome, String cognome) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.livello = livello;
		this.nome = nome;
		this.cognome = cognome;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		LibraryUser.id = id;
	}

	public static String getEmail() {
		return email;
	}

	public static void setEmail(String email) {
		LibraryUser.email = email;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		LibraryUser.password = password;
	}

	public static String getLivello() {
		return livello;
	}

	public static void setLivello(String livello) {
		LibraryUser.livello = livello;
	}
	
	
public static String getNome() {
		return nome;
	}

	public static void setNome(String nome) {
		LibraryUser.nome = nome;
	}

	public static String getCognome() {
		return cognome;
	}

	public static void setCognome(String cognome) {
		LibraryUser.cognome = cognome;
	}

public String toString() {
	return "Email: " + email + "\nPassword: " + password + "\nLivello: "  + livello;
}
	
}
