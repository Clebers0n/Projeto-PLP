package classes;

public class Carro extends Veiculo implements Automovel{
	
	public String tracao;
	public String tipoCambio;
	public int numPortas;
	
	public Carro(String nome, double preco, int ano, String cor, double peso, double tanque, double capacidadeMaxima, int potencia,
			boolean embreagem, String tracao, String tipoCambio, int numPortas, double kmPorLitro) {
		super(nome, preco, ano, cor, peso, tanque, capacidadeMaxima, potencia, embreagem, kmPorLitro);
		this.tracao = tracao;
		this.tipoCambio = tipoCambio;
		this.numPortas = numPortas;
	}
	
	@Override
	public void exibirInformacoes() {
		System.out.println("Ano: " + this.ano);
		System.out.println("Cor: " + this.cor);
		System.out.println("Capacidade máxima: " + this.capacidadeMaxima);
		System.out.println("Potência: " + this.potencia);
		System.out.println("Tração: " + this.tracao);
		System.out.println("Tipo de câmbio: " + this.tipoCambio);
		System.out.println("Número de portas: " + this.numPortas);
		System.out.println("KM/L: " + this.kmPorLitro);
	}

}
