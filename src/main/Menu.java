package main;

import java.util.Scanner;

import classes.Cliente;
import classes.Concessionaria;

public class Menu {
	
	public void iniMenu(Scanner scn) {
		Concessionaria conces = new Concessionaria("12839123", "Lcar");
		
		System.out.print("Informe seu nome: ");
		String nome = scn.next();
		
		System.out.print("Informe seu CPF: ");
		String cpf = scn.next();
		
		System.out.print("Informe sua idade: ");
		int idade = scn.nextInt();
		
		System.out.print("Informe a quantidade de dinheiro que vc tem: ");
		double dinheiro = scn.nextDouble();
		
		Cliente cliente = new Cliente(nome, cpf, idade, dinheiro);
		conces.abrir();
		this.menu(scn, conces, cliente);
	}
	
	public void menu(Scanner scn,  Concessionaria conces, Cliente cliente) {
		int opcao;
		do {
			System.out.println("1 - Consessiconaria | 2 - User menu | 3 - Sair");
			System.out.print("Informe sua opção: ");
			opcao = scn.nextInt();
			switch(opcao) {
			case 1:
				this.menuConcessionaria(scn, cliente, conces);
				break;
			case 2:
				this.menuUsuario(scn, cliente, conces);
				break;
			case 3:
				System.out.println("\nA concessionária " + conces.getRazaoSocial() + " agradece pela sua preferência!");
				break;
				
			default:
				System.out.println("Opção inválida.");
				break;
			}
		} while(opcao != 3);
	}
	
	
	
	public void menuUsuario(Scanner scn, Cliente cliente, Concessionaria conces) {

		int op;
		do {
			System.out.println("1. Listar veículos | 2. Selecionar veículo | 3. Sair");
			op = scn.nextInt();
			
			switch (op) {
			case 1:
				cliente.listarVeiculos();
				break;
				
			case 2:
				cliente.selecionarVeiculo(scn);
				break;

			case 3:
				System.out.println("Saindo...");
				break;

			default:
				System.out.println("Opção inválida, tente novamente.");
				break;
			}
			
		} while (op != 3);
		
	}
	
	public void menuConcessionaria(Scanner scn, Cliente cliente, Concessionaria conces) {
		System.out.println("\nOlá, " + cliente.getNome() + ", bem-vindo a concessionária " + conces.getRazaoSocial() + "\n");

		int op;
		do {
			System.out.println("1. Visualizar veículos | 2. Comprar | 3. Sair");
			op = scn.nextInt();
			
			switch (op) {
			case 1:
				conces.listarVeiculos();
				break;
				
			case 2:
				conces.vender(cliente);
				break;

			case 3:
				System.out.println("Saindo...");
				break;

			default:
				System.out.println("Opção inválida, tente novamente.");
				break;
			}
			
		} while (op != 3);
		
		
	}

}
