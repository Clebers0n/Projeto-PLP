package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Pessoa{

	private double dinheiro;
	private ArrayList<Veiculo> veiculos = new ArrayList<>();
	
	public Cliente(String nome, String cpf, int idade, double dinheiro) {
		super(nome, cpf, idade);
		this.dinheiro = dinheiro;
	}
	
	public boolean comprar(double valor, Veiculo veiculo) {
		if (this.dinheiro >= valor) {
			System.out.println("\nCompra realizada com sucesso!\n");
			this.dinheiro -= valor;
			this.veiculos.add(veiculo);
		} else {
			System.out.println("\nVocê não tem saldo suficiente.\n");
		}
		
		return this.dinheiro >= valor;
	}
	
	public void listarVeiculos() {
		if (this.veiculos.size() == 0) {
			System.out.println("Você ainda não possui nenhum veículo");
			return;
		}
		
		for (int i = 0; i < this.veiculos.size(); i++) {
			System.out.println((i+1) + ". " + this.veiculos.get(i).nome);
		}
	}
	
	public void selecionarVeiculo(Scanner scn) {
		
		if (this.veiculos.size() == 0) {
			System.out.println("Você ainda não possui nenhum veículo");
			return;
		}
		
		this.listarVeiculos();
		System.out.print("Digite o ID do veiculo que deseja selecionar: ");
		int index = scn.nextInt();
		scn.nextLine();
		
		if (index > this.veiculos.size() || index <= 0) {
			System.out.println("Veiculo não encontrado.");
			return;
		}
		
		index -= 1;
		Veiculo veiculoAtual = this.veiculos.get(index);
		System.out.println("Novo veiculo selecionado: " + veiculoAtual.nome);
		
		int op;
		do {
			System.out.println("1. Verificar combustível | 2. Simular viagem | 3. Abastecer | 4. Sair");
			op = scn.nextInt();
			
			switch (op) {
			case 1:
				veiculoAtual.verificarCombustivel();
				break;
				
			case 2:
				System.out.print("Distância a percorrer (KM):  ");
				double distancia = scn.nextDouble();
				
				veiculoAtual.simularViagem(distancia);
				break;
				
			case 3:
				System.out.println("Informe a quantidade de litros: ");
				double qntLitros = scn.nextDouble();
				veiculoAtual.abastecer(qntLitros);
				break;
				
			case 4:
				System.out.println("Saindo...");
				break;

			default:
				System.out.println("Opção inválida, tente novamente.");
				break;
			}
			
		} while (op != 3);
	}
	
}
