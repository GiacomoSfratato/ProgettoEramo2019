package model;
import java.util.Date;

public class Utente {
public static class Builder{ /* implementazione del pattern builder */
	private String email, password, nome, cognome, luogo_di_nascita, tipo, livello ;
	private int id;
	private Date data_nascita;
	public Builder () {};
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
	public Builder withdata_nascita(Date data_nascita) {
		this.data_nascita = data_nascita;
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
		utente.data_nascita=this.data_nascita;
		return utente;
	}
}
private String email, password, nome, cognome,luogo_di_nascita;
private int id;
private Date data_nascita;
private String tipo; //ho pensato di farlo con enum come nel db ma e' sufficente un try-catch
private String livello;
	public String getEmail() {
		return email;
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
	public Date getData_nascita() {
		return data_nascita;
	}
	public void setData_nascita(Date data_nascita) {
		this.data_nascita = data_nascita;
	}
	@Override
	public String toString() {
		return "Utente [email=" + email + ", password=" + password + ", nome=" + nome + ", cognome=" + cognome
				+ ", luogo_di_nascita=" + luogo_di_nascita + ", id=" + id + ", data_nascita=" + data_nascita + ", tipo="
				+ tipo + ", livello=" + livello + "]";
	}
	
	private Utente() {} ;
}