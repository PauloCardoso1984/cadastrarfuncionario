package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Funcionario;

public class Program {

	public static void main(String[] args) {
				
		Locale.setDefault(Locale.US);	// PADRONIZAR A FORMA DE PONTO , . NOS NÚMEROS
		Scanner sc = new Scanner(System.in);	// RECEBE INFORMAÇÕES TIPO VIA TECLADO 
		
		List<Funcionario> list = new ArrayList<>();	// LISTA DE FUNCIONÁRIOS → TIPO LIST
		
		System.out.print("Quantos funcionário serão registado? ");	// PERGUNTA QUANTOS FUNCIONÁRIO SERÃO REGISTRADOS
		
		int N = sc.nextInt();	// INICIALIZANDO O → N
		System.out.println();

		for (int i=0; i<N; i++ ) {
			
			// IRÁ ADICIONAR DURANTE O  FOR A QUANTIDADE DE FUNCIONÁRIOS	
			System.out.print("Funcionário #" + (i + 1) + ": ");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			while (hasId(list, id)) {  // NÃO DEIXAR REPETIR ID
				System.out.println("Esse Id já existe!! Tente novamente!!!");
				System.out.print("Funcionário #" + (i + 1) + ": ");
				id = sc.nextInt();
			}
			
			System.out.print("Nome: ");
			sc.nextLine();  // LIMPAR O BUFFER
			String nome = sc.nextLine();
			
			System.out.print("Salário: ");
			double salario = sc.nextDouble();
			
			Funcionario func = new Funcionario(id, nome, salario); // INSTANCIAR UM FUNCIONÁRIO	
			list.add(func); // INSERIR NA LISTA O FUNCIONÁRIO	
			
			System.out.println();
		}
		
		// ATENÇÃO → DUAS MANEIRAS DE PROCURAR O FUNCIONARIO POR ID 
		// VEJA  ====== REF 001 e ===== REF 002
				
		// PERGUNTAR QUAL ID RECEBERÁ AUMENTO
		System.out.print("Qual funcionário receberá aumento no salário, digite o Id: ");
		int idsalario = sc.nextInt();
		
		// ===== REF 001
		// VERIFICAR (PROCURAR) SE O ID EXISTE NA LISTA 
		Integer func = posicaoDoId(list, idsalario);  // ======= REF 001
		
		// ====== REF 002 
		// VERIFICAR (PROCURAR) SE O ID EXISTE NA LISTA 
		// UTILIZANDO EXPRESSÃO LAMBDA - NÍVEL ALTO DE APRENDIZAGEM
//		Funcionario func = list.stream().filter(x -> x.getId() == idsalario).findFirst().orElse(null); // ======= REF 002
		
		if (func == null) {
			System.out.println("Funcionário ou Id inexistente!!!");
		}
		else {
			System.out.print("Enter com o valor de percentagem que esse funcionário terá: ");
			double porcento = sc.nextDouble();

		// ACESSAR O FUNCIONARIO ENCONTRADO E CHAMAR A FUNÇÃO PARA AUMENTAR O SALARIO
			list.get(func).aumentoSalario(porcento); // ===== REF 001
//			func.aumentoSalario(porcento);			 // ===== REF 002
		}
		System.out.println();		
		System.out.println("Lista de Funcionário: ");
		for (Funcionario f : list ) {
			System.out.println(f);
		}
	
		// ENCERRAR O SCANNER
		sc.close();
	} 
	// ======= REF 001 - FUNÇÃO AUXILIAR PARA VERIFICAR O ID
	public static Integer posicaoDoId(List<Funcionario> lista, int id) {
		for (int i=0; i<lista.size(); i++ ) { // VARREDURA NA LISTA PARA PROCURAR O ID
			if(lista.get(i).getId() == id) {  // PEGAR O ID SE ENCONTRAR NA LISTA
				return i;
			} 
		}
		return null;  // INDICA QUE O ELEMENTO ID NÃO FOI ENCONTRADO
	}
	
	// FUNÇÃO AUXILIAR PARA VERIFICAR SE O ID EXISTE NA LISTA
	public static boolean hasId(List<Funcionario> list, int id) {
		Funcionario func = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return func != null;
	}
}
