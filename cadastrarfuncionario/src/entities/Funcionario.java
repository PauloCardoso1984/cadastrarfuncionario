package entities;

public class Funcionario {
	
	private Integer id;
	private String nome;
	private Double salario;
	
	//	CONSTRUTOR VAZIO
	public Funcionario() {
}
	
	// CONSTRUTOR COM ARGUMENTOS
	public Funcionario(Integer id, String nome, Double salario) {
		super();
		this.id = id;
		this.nome = nome;
		this.salario = salario;
	}
	
	// GETs e SETs

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	// METODO PARA ALTERAR O SALARIO
	public void aumentoSalario (double porcentagem) {
	//	salario = salario + (salario * porcentagem / 100);  // OPERADOR TRADICIONAL
		salario += salario + (salario * porcentagem / 100); // OPERADOR ACUMULATIVO
	}
	
	// ToString
	@Override
	public String toString() {
		return "Funcionario: " + "Id= " + id + "   Nome= " + nome + "		Salário R$: " + String.format("%.2f", salario);
	}
	

	
	
	
}
