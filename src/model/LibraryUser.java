package model;

// TODO: Auto-generated Javadoc
/**
 * The Class LibraryUser.
 */
public class LibraryUser {
	
	/** The id. */
	private static int id;
	
	/** The email. */
	private static String email;
	
	/** The password. */
	private static String password;
	
	/** The livello. */
	private static String livello;
	
	/** The nome. */
	private static String nome;
	
	/** The cognome. */
	private static String cognome;

	/**
	 * Instantiates a new library user.
	 *
	 * @param id the id
	 * @param email the email
	 * @param password the password
	 * @param livello the livello
	 * @param nome the nome
	 * @param cognome the cognome
	 */
	public LibraryUser(int id, String email, String password, String livello, String nome, String cognome) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.livello = livello;
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
		LibraryUser.id = id;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public static String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public static void setEmail(String email) {
		LibraryUser.email = email;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public static String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public static void setPassword(String password) {
		LibraryUser.password = password;
	}

	/**
	 * Gets the livello.
	 *
	 * @return the livello
	 */
	public static String getLivello() {
		return livello;
	}

	/**
	 * Sets the livello.
	 *
	 * @param livello the new livello
	 */
	public static void setLivello(String livello) {
		LibraryUser.livello = livello;
	}
	
	
/**
 * Gets the nome.
 *
 * @return the nome
 */
public static String getNome() {
		return nome;
	}

	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public static void setNome(String nome) {
		LibraryUser.nome = nome;
	}

	/**
	 * Gets the cognome.
	 *
	 * @return the cognome
	 */
	public static String getCognome() {
		return cognome;
	}

	/**
	 * Sets the cognome.
	 *
	 * @param cognome the new cognome
	 */
	public static void setCognome(String cognome) {
		LibraryUser.cognome = cognome;
	}

/**
 * To string.
 *
 * @return the string
 */
public String toString() {
	return "Email: " + email + "\nPassword: " + password + "\nLivello: "  + livello;
}
	
}
