
public abstract class Funcionario {
	String Nome;
	String Departamento;
	
	public Funcionario() {
		this.setNome("");
		this.setDepartamento("");
	}
	
	public Funcionario(String nome, String departamento) {
		this.setNome(nome);
		this.setDepartamento(departamento);
	}
	
	public void setNome(String nome) {
		this.Nome = nome;
	}
	
	public void setDepartamento(String departamento) {
		this.Departamento = departamento;
	}
	
	public String getNome() { 
		return this.Nome; 
	}
	
	public String getDepartamento() {
		return this.Departamento;
	}
	
	public abstract double getBonificacao();
	
	public String toString() {
		return String.format("Nome = %s, Departamento = %s ", this.getNome(), this.getDepartamento());
	}
}
