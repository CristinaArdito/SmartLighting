
public class Assistenza {
	private String nome;
	private String indirizzo;
	private String email;
	private String telefono;
	
	public Assistenza(String nome, String indirizzo, String email, String telefono) {
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.email = email;
		this.telefono = telefono;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	

}
