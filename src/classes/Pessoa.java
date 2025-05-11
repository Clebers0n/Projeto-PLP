package classes;

public abstract class Pessoa {
	
	protected String nome;
	protected String cpf;
	protected int idade;
	
	public Pessoa(String nome, String cpf, int idade) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
	}
	
	public boolean maioridade(){
		return this.idade >= 18;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public int getIdade() {
		return this.idade;
	}
}
