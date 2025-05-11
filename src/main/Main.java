package main;

import java.util.Scanner;

import classes.Cliente;
import classes.Concessionaria;

public class Main {
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		Menu menu = new Menu();
		
		menu.iniMenu(scn);
		
		scn.close();
	}
}
