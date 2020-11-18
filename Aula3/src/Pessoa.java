import java.util.Calendar;

public class Pessoa {
	private String nome;
	private int dia_nascimento, mes_nascimento, ano_nascimento;
	private String signo;
	
	public Pessoa() {
		this.nome = "";
		this.dia_nascimento = 0;
		this.mes_nascimento = 0;
		this.ano_nascimento = 0;
		this.signo = "";
	}
	
	public Pessoa(String nome, int dia, int mes, int ano) {
		this.nome = nome;
		this.dia_nascimento = dia;
		this.mes_nascimento = mes;
		this.ano_nascimento = ano;
	}
	
	public String getNome() {
		return (this.nome);
	}
	
	public int getDia() {
		return (this.dia_nascimento);
	}
	
	public int getMes() {
		return (this.mes_nascimento);
	}
	
	public int getAno() {
		return (this.ano_nascimento);
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setDia(int dia) {
		this.dia_nascimento = dia;
	}
	
	public void setMes(int mes) {
		this.mes_nascimento = mes;
	}
	
	public void setAno(int ano) {
		this.ano_nascimento = ano;
	}
	
	public void setSigno(String signo) {
		this.signo = signo;
	}
	
	public String toString() {
		String saida = "";
		
		saida = String.format("Nome: %s\n%d/%d/%d\nSigno: %s\n-------------------------\n", this.nome,this.dia_nascimento,this.mes_nascimento,this.ano_nascimento,this.signo);
		
		return saida;
	} 
	
	public int calculaIdade() {
		int idade = 0;
		int dia_atual,mes_atual,ano_atual;
		
		Calendar data_atual = Calendar.getInstance();
		
		dia_atual = data_atual.get(Calendar.DAY_OF_MONTH);
		mes_atual = data_atual.get(Calendar.MONTH);
		ano_atual = data_atual.get(Calendar.YEAR);
		
		if((this.mes_nascimento > mes_atual) ||(mes_atual == this.mes_nascimento && this.dia_nascimento < dia_atual))
			idade = ano_atual - this.ano_nascimento - 1;
		
		else
			idade = ano_atual - this.ano_nascimento;
		
		return idade;
	}
	
	public void verificaSigno() {
		switch(this.mes_nascimento) {
		case 1:
			if(this.dia_nascimento < 20)
				this.signo = "Capricórnio";
			
			else
				this.signo = "Aquario";
			
			break;
			
		case 2:
			if(this.dia_nascimento < 20)
				this.signo = "Aquario";
			
			else
				this.signo = "Peixes";
			
			break;
			
		case 3:
			if(this.dia_nascimento < 20)
				this.signo = "Peixes";
			
			else
				this.signo = "Áries";
			
			break;
			
		case 4:
			if(this.dia_nascimento < 20)
				this.signo = "Áries";
			
			else
				this.signo = "Touro";
			
			break;
			
		case 5:
			if(this.dia_nascimento < 20)
				this.signo = "Touro";
			
			else
				this.signo = "Gêmeos";
			
			break;
			
		case 6:
			if(this.dia_nascimento < 20)
				this.signo = "Gêmeos";
			
			else
				this.signo = "Câncer";
			
			break;
			
		case 7:
			if(this.dia_nascimento < 20)
				this.signo = "Câncer";
			
			else
				this.signo = "Leão";
			
			break;
			
		case 8:
			if(this.dia_nascimento < 20)
				this.signo = "Leão";
			
			else
				this.signo = "Virgem";
			
			break;
			
		case 9:
			if(this.dia_nascimento < 20)
				this.signo = "Virgem";
			
			else
				this.signo = "Libra";
			
			break;
			
		case 10:
			if(this.dia_nascimento < 20)
				this.signo = "Libra";
			
			else
				this.signo = "Escorpião";
			
			break;
			
		case 11:
			if(this.dia_nascimento < 20)
				this.signo = "Escorpião";
			
			else
				this.signo = "Sagitário";
			
			break;
			
		case 12:
			if(this.dia_nascimento < 20)
				this.signo = "Sagitário";
			
			else
				this.signo = "Capricórnio";
			
			break;
		}
	
	}
	
}