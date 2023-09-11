package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Funcionario;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Funcionario> list = new ArrayList<>();
		
		System.out.println("Quantos empregados serão registrados? ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println("Funcionário #" + i +" :");
			System.out.print("Id: ");
			int id = sc.nextInt();
			
			while(hasId(list, id)) {
				System.out.print("Id já existe... tente novamente: ");
				id = sc.nextInt();
			}
			System.out.print("Name: ");
			sc.nextLine();
			String nome = sc.nextLine();
			
			System.out.print("Salário: ");
			double salario = sc.nextDouble();
			
			list.add(new Funcionario(id, nome, salario));	
		}
		
		System.out.print("Entre com o número do Id do funcionário que irá receber aumento: ");
		int idFunc = sc.nextInt(); 
		Funcionario func = list.stream().filter(x -> x.getId() == idFunc).findFirst().orElse(null);
			if (func == null) {
				System.out.println("Esse id não existe");
			} else {
				System.out.print("Entre com o número percentual do aumento: ");
				double increase = sc.nextInt();
				
				func.incremento(increase);
			}
		for (Funcionario obj : list) {
			System.out.println(obj);
		}
		
		sc.close();
	}

	private static boolean hasId(List<Funcionario> list, int id) {
		Funcionario func = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return func != null;
	}

}
