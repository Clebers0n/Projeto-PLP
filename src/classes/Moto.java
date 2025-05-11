package classes;

public class Moto extends Veiculo {
	
	public String estiloEcapamento;
	
	public Moto(String nome, double preco, int ano, String cor, double peso, double tanque, 
			double capacidadeMaxima, int potencia, boolean embreagem, String estiloEscapamento, double kmPorLitro) {
		super(nome, preco, ano, cor, peso, tanque, capacidadeMaxima, potencia, embreagem, kmPorLitro);
		this.estiloEcapamento = estiloEscapamento;
		this.numPassageiros = 2;
		this.numRodas = 2;
	}
	
	@Override
	public void exibirInformacoes() {
		System.out.println("Ano: " + this.ano);
		System.out.println("Cor: " + this.cor);
		System.out.println("Capacidade máxima: " + this.capacidadeMaxima);
		System.out.println("Potência: " + this.potencia);
		System.out.println("Tipo do escapamento: " + this.estiloEcapamento);
		System.out.println("KM/L: " + this.kmPorLitro);
	}
	
}
