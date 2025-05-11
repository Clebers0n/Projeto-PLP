package classes;

import java.util.Scanner;

public abstract class Veiculo implements Automovel {
	
	protected String nome;
	protected double preco;
	protected int ano;
	protected int numRodas;
	protected int numPassageiros;
	protected String cor;
	protected double peso;
	protected boolean parado = false;
	protected double tanque;
	protected double capacidadeMaxima;
	protected int potencia;
	protected boolean embreagem;
	protected double kmPorLitro;
	
	private String nomeClasse = this.getClass().getSimpleName();
	
	public Veiculo(String nome, double preco, int ano, String cor, double peso, double tanque, 
			double capacidadeMaxima, int potencia, boolean embreagem, double kmPorLitro) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.ano = ano;
		this.cor = cor;
		this.peso = peso;
		this.tanque = tanque;
		this.capacidadeMaxima = capacidadeMaxima;
		this.potencia = potencia;
		this.embreagem = embreagem;
		this.kmPorLitro = kmPorLitro;
	}
	
	public void acelerar() {
		if(this.parado) {
			System.out.println(this.nomeClasse + " já está se movimentando");
		} else {
			System.out.println(this.nomeClasse + " acelerou!!");
			this.parado = true;
		}
	}
	public void frear() {
		if(this.parado) {
			System.out.println(this.nomeClasse + " freiou!");
		} else {
			System.out.println(this.nomeClasse + " já está parada");
			this.parado = true;
		}
	}
	
	public double verificarCombustivel() {
		System.out.println("Tanque: " + this.tanque);
		return this.tanque;
	}
	
	public boolean abastecer(double litros) {
		if(this.tanque + litros > this.capacidadeMaxima) {
            System.out.println("Excede a capacidade máxima!");
            return false;
        } else {
            this.tanque += litros;
            System.out.println("Abastecimento completo!");
            this.verificarCombustivel();
            return true;
        }
	}
	
	public boolean simularViagem(double quilometros) {
		if((quilometros / this.kmPorLitro) <= this.tanque) {
			System.out.println("A gasolina suficiente para a viajem!");
			return true;
		} else {
			System.out.println("Gasolina insuficiente para a viajem");
			return false;
		}
	}
	
	public void testeDrive(Scanner scn) {
		int op;
		do {
			System.out.println("1. Acelerar | 2. Frear | 3. Verificar combustivel | 4. Abastecer | 5. Simular viagem");
			op = scn.nextInt();
			scn.nextLine();
			
			switch (op) {
			case 1:
				this.acelerar();
				break;
				
			case 2:
				this.frear();
				break;

			case 3:
				this.verificarCombustivel();
				break;

			case 4:
				System.out.println("Informe a quantidade de litros: ");
				double qntLitros = scn.nextDouble();
				this.abastecer(qntLitros);
				break;

			case 5:
				System.out.println("Informe a distância (KM): ");
				double distancia = scn.nextDouble();
				this.simularViagem(distancia);
				break;
				
			case 6:
				System.out.println("Saindo...");
				break;
				
			default:
				System.out.println("Opção inválida, tente novamente.");
				break;
			}
			
		} while (op != 6);
	}
	
}
