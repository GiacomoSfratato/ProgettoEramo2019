package model;
public class Utente {
public static class Builder{ /* implementazione del pattern builder */
	private String email, password, nome, cognome, luogo_di_nascita, tipo, livello, sesso, data_di_nascita;
	private static int id; // considerazione futura di toglierlo dato che db lo auto implemanta
	public Builder () {
		this.sesso="indefinito";
		this.data_di_nascita="0000-00-00";
		this.luogo_di_nascita="indefinito";
		this.tipo="passivo";
		this.livello="base";
		this.nome="indefintio";
		this.cognome="indefinito";
	};
	public Builder withsesso(String sesso) {
		this.sesso=sesso;
		return this;
	}
	public Builder withmail(String email) {
		this.email = email;
		return this;
	}
	public Builder withpassword(String password) {
		this.password = password;
		return this;
	}
	public Builder withnome(String nome) {
		this.nome = nome;
		return this;
	}
	public Builder withcognome(String cognome) {
		this.cognome = cognome;
		return this;
	}
	public Builder withluogo_di_nascita(String luogo_di_nascita) {
		this.luogo_di_nascita = luogo_di_nascita;
		return this;
	}
	public Builder withid(int id) {
		this.id = id;
		return this;
	}
	public Builder withtipo(String tipo) {
		this.tipo = tipo;
		return this;
	}
	public Builder withlivello(String livello) {
		this.livello = livello;
		return this;
	}
	public Builder withdata_nascita(String data_di_nascita) {
		this.data_di_nascita = data_di_nascita;
		return this;
	}
	public Utente build() {
		Utente utente = new Utente();
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
		return utente;
	}
}
private String email, password, nome, cognome,luogo_di_nascita, sesso,data_di_nascita;
private int id;
private String tipo; //ho pensato di farlo con enum come nel db ma e' sufficente un try-catch
private String livello;
	public String getEmail() {
		return email;
	}
	public String getSesso() {
		return sesso;
	}
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getLivello() {
		return livello;
	}
	public void setLivello(String livello) {
		this.livello = livello;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getLuogo_di_nascita() {
		return luogo_di_nascita;
	}
	public void setLuogo_di_nascita(String luogo_di_nascita) {
		this.luogo_di_nascita = luogo_di_nascita;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getData_di_nascita() {
		return data_di_nascita;
	}
	public void setData_di_nascita(String data_nascita) {
		this.data_di_nascita = data_nascita;
	}
	
	@Override
	public String toString() {
		return "Utente [email=" + email + ", password=" + password + ", nome=" + nome + ", cognome=" + cognome
				+ ", luogo_di_nascita=" + luogo_di_nascita + ", sesso=" + sesso + ", data_di_nascita=" + data_di_nascita
				+ ", id=" + id + ", tipo=" + tipo + ", livello=" + livello + "]";
	}
	private Utente() {} ;
}