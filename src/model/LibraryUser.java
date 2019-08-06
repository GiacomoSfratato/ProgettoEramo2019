package model;

public class LibraryUser {
	
	private static String email;
	private static String password;
	private static String livello;

	public LibraryUser(String email, String password, String livello) {
		this.email = email;
		this.password = password;
		this.livello = livello;
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
	
	
public String toString() {
	return "Email: " + email + "\nPassword: " + password + "\nLivello: "  + livello;
}
	
}
