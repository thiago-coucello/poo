public abstract class Empregado {
	private String nome;
 	private String nomeDepto;
 	public Empregado() {// constructor SEM par�metros 
		this.nome="";
		this.nomeDepto="";
 
	}
	public Empregado(String n, String nd) {
	 // construtor COM par�metros
 		this.nome = n;
 		this.nomeDepto=nd;
 	}
 
 // metodo abstrato a ser reescrito e implementado nas subClasses
 	public abstract double calculaSalario(); // nenhum implementacao aqui
 	
 	public void setNomeDepto( String nd) {
 		this.nomeDepto = nd;
 	}
 	
 	public void setNome( String nome) {
 		this.nome = nome;
 	}
 	
 	public String getNomeDepto() { 		
 		return (this.nomeDepto);
 	}
 	
 	public String getNome() {
 		return (this.nome);
 	}
 
 	public String toString() {
 		return String.format("\nNome=%s Depto=%s",
 				this.getNome(),this.getNomeDepto());
 	}
}// fecha classe empregado 