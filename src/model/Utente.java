package model;
// TODO: Auto-generated Javadoc

/**
 * The Class Utente.
 */
public class Utente {

/**
 * The Class Builder.
 */
public static class Builder{ 
 /** The pic. */
 /* implementazione del pattern builder */
	private String email, password, nome, cognome, luogo_di_nascita, tipo, livello, sesso, data_di_nascita, pic;
	
	/** The libri. */
	private int id, libri; // considerazione futura di toglierlo dato che db lo auto implemanta
	
	/**
	 * Instantiates a new builder.
	 */
	public Builder () {
		this.libri=0;
		this.sesso="indefinito";
		this.data_di_nascita="0000-00-00";
		this.luogo_di_nascita="indefinito";
		this.tipo="passivo";
		this.livello="base";
		this.nome="indefinito";
		this.cognome="indefinito";
		this.pic="/view/immagini/avatars/boy.png";
	};
	
	/**
	 * Withpic.
	 *
	 * @param pic the pic
	 * @return the builder
	 */
	public Builder withpic(String pic) {
		this.pic = pic;
		return this;
	}
	
	/**
	 * Withsesso.
	 *
	 * @param sesso the sesso
	 * @return the builder
	 */
	public Builder withsesso(String sesso) {
		this.sesso=sesso;
		return this;
	}
	
	/**
	 * Withmail.
	 *
	 * @param email the email
	 * @return the builder
	 */
	public Builder withmail(String email) {
		this.email = email;
		return this;
	}
	
	/**
	 * Withpassword.
	 *
	 * @param password the password
	 * @return the builder
	 */
	public Builder withpassword(String password) {
		this.password = password;
		return this;
	}
	
	/**
	 * Withnome.
	 *
	 * @param nome the nome
	 * @return the builder
	 */
	public Builder withnome(String nome) {
		this.nome = nome;
		return this;
	}
	
	/**
	 * Withcognome.
	 *
	 * @param cognome the cognome
	 * @return the builder
	 */
	public Builder withcognome(String cognome) {
		this.cognome = cognome;
		return this;
	}
	
	/**
	 * Withluogo di nascita.
	 *
	 * @param luogo_di_nascita the luogo di nascita
	 * @return the builder
	 */
	public Builder withluogo_di_nascita(String luogo_di_nascita) {
		this.luogo_di_nascita = luogo_di_nascita;
		return this;
	}
	
	/**
	 * Withid.
	 *
	 * @param id the id
	 * @return the builder
	 */
	public Builder withid(int id) {
		this.id = id;
		return this;
	}
	
	/**
	 * Withtipo.
	 *
	 * @param tipo the tipo
	 * @return the builder
	 */
	public Builder withtipo(String tipo) {
		this.tipo = tipo;
		return this;
	}
	
	/**
	 * Withlivello.
	 *
	 * @param livello the livello
	 * @return the builder
	 */
	public Builder withlivello(String livello) {
		this.livello = livello;
		return this;
	}
	
	/**
	 * Withdata nascita.
	 *
	 * @param data_di_nascita the data di nascita
	 * @return the builder
	 */
	public Builder withdata_nascita(String data_di_nascita) {
		this.data_di_nascita = data_di_nascita;
		return this;
	}
	
	/**
	 * Withlibri.
	 *
	 * @param libri the libri
	 * @return the builder
	 */
	public Builder withlibri(int libri) {
		this.libri = libri;
		return this;
	}
	
	/**
	 * Builds the.
	 *
	 * @return the utente
	 */
	public Utente build() {
		Utente utente = new Utente();
		utente.libri=this.libri;
		utente.email=this.email;
		utente.password=this.password;
		utente.cognome=this.cognome;
		utente.nome=this.nome;
		utente.luogo_di_nascita=this.luogo_di_nascita;
		utente.tipo=this.tipo;
		utente.livello=this.livello;
		utente.id=this.id;
		utente.data_di_nascita=this.data_di_nascita;
		utente.sesso=this.sesso;
		utente.pic = this.pic;
		return utente;
	}
	
}

/** The pic. */
private String email, password, nome, cognome,luogo_di_nascita, sesso,data_di_nascita, pic;

/** The libri. */
private int id, libri;

/** The tipo. */
private String tipo; //ho pensato di farlo con enum come nel db ma e' sufficente un try-catch

/** The livello. */
private String livello;
	
	/**
	 * Gets the pic.
	 *
	 * @return the pic
	 */
	public String getPic() {
		return pic;
	}
	
	/**
	 * Sets the pic.
	 *
	 * @param pic the new pic
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Gets the sesso.
	 *
	 * @return the sesso
	 */
	public String getSesso() {
		return sesso;
	}
	
	/**
	 * Sets the sesso.
	 *
	 * @param sesso the new sesso
	 */
	public void setSesso(String sesso) {
		this.sesso = sesso;
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
	 * Gets the livello.
	 *
	 * @return the livello
	 */
	public String getLivello() {
		return livello;
	}
	
	/**
	 * Sets the livello.
	 *
	 * @param livello the new livello
	 */
	public void setLivello(String livello) {
		this.livello = livello;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
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
	
	/**
	 * Gets the luogo di nascita.
	 *
	 * @return the luogo di nascita
	 */
	public String getLuogo_di_nascita() {
		return luogo_di_nascita;
	}
	
	/**
	 * Sets the luogo di nascita.
	 *
	 * @param luogo_di_nascita the new luogo di nascita
	 */
	public void setLuogo_di_nascita(String luogo_di_nascita) {
		this.luogo_di_nascita = luogo_di_nascita;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Gets the data di nascita.
	 *
	 * @return the data di nascita
	 */
	public String getData_di_nascita() {
		return data_di_nascita;
	}
	
	/**
	 * Sets the data di nascita.
	 *
	 * @param data_nascita the new data di nascita
	 */
	public void setData_di_nascita(String data_nascita) {
		this.data_di_nascita = data_nascita;
	}
	
	/**
	 * Gets the libri.
	 *
	 * @return the libri
	 */
	public int getLibri() {
		return this.libri;
	}
	
	/**
	 * Sets the libri.
	 *
	 * @param libri the new libri
	 */
	public void setLibri(int libri) {
		this.libri = libri;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Utente [email=" + email + ", password=" + password + ", nome=" + nome + ", cognome=" + cognome
				+ ", luogo_di_nascita=" + luogo_di_nascita + ", sesso=" + sesso + ", data_di_nascita=" + data_di_nascita
				+ ", id=" + id + ", tipo=" + tipo + ", livello=" + livello + "]";
	}
	
	/**
	 * Instantiates a new utente.
	 */
	private Utente() {} ;
}