package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Concessionaria extends Empresa {
	
	private ArrayList<Veiculo> veiculos = new ArrayList<>();
	
	public Concessionaria(String cnpj, String razaoSocial) {
		super(cnpj, razaoSocial);
		
		this.veiculos.add(new Carro("Mustang", 500000, 2000, "Amarelão", 1500, 20, 50, 5000, true, "dianteira", "manual",  4, 15));
		this.veiculos.add(new Carro("Onix", 90000, 2025, "Branco",  2000, 5, 50,  1000, true, "dianteita", "manual", 4, 25));
		this.veiculos.add(new Carro("Prisma", 250000, 2024, "Preto",  2220, 8, 40,  1000, false, "traseira", "automatica", 2, 25));
		
		this.veiculos.add(new Moto("Titan", 16000, 2021, "Branca", 117, 6, 16.1, 162, true, "original", 40));
		this.veiculos.add(new Moto("CB-500", 40000, 2025, "Preto", 400, 3, 17, 500, true, "aberto", 25));
		this.veiculos.add(new Moto("Pop", 10000, 2023, "Vermelha", 10, 2, 8, 100, true, "original", 50));

	}

	public ArrayList<Veiculo> listarVeiculos() {
		
		System.out.println("Lista de veiculos disponiveis para compra: \n");
		
		for(int i = 0; i < this.veiculos.size(); i++) {
			System.out.println((i+1) + ". " + this.veiculos.get(i).nome + ", ano: " + this.veiculos.get(i).ano + ", preço R$: " + this.veiculos.get(i).preco);
		}
		
		return this.veiculos;
	}
	
	public ArrayList<Veiculo> listarVeiculos(double precoMaximo) {
		
		System.out.println("Lista de veiculos disponiveis para compra até R$: " + precoMaximo + "\n");
		ArrayList<Veiculo> veiculosFiltrados = new ArrayList<>();
		
		int iterador = 1;
		for(Veiculo veiculo : this.veiculos) {
			if (veiculo.preco <= precoMaximo) {
				veiculosFiltrados.add(veiculo);
				System.out.println(iterador++ + ". " + veiculo.nome + ", ano: " + veiculo.ano + ", preço R$: " + veiculo.preco);
			}
		}
		
		return veiculosFiltrados;
	}
	
	@Override
	public void vender(Cliente cliente) {
		
		if (!this.estaAberta) {
			System.out.println("A concessionaria precisa estar aberta!");
			return;
		}
		
		if (!cliente.maioridade()) {
			System.out.println("Você precisa ser maior de idade para comprar um veiculo!");
			return;
		}
		
		Scanner scn = new Scanner(System.in);

		System.out.print("Preço máximo (0 para listar todos): ");
		double precoMax = scn.nextDouble();
		ArrayList<Veiculo> veiculosDisponiveis;
		
		if (precoMax > 0) {
			veiculosDisponiveis = this.listarVeiculos(precoMax);
		} else {
			veiculosDisponiveis = this.listarVeiculos();
		}
		
		System.out.print("Selecione o ID do veículo que deseja comprar: ");
		
		int veiculoId = scn.nextInt();
		
		Veiculo veiculoSelecionado = veiculosDisponiveis.get(veiculoId-1);
		
		cliente.comprar(veiculoSelecionado.preco, veiculoSelecionado);

	}
	
}
