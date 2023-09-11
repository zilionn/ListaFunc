package entities;

public class Funcionario {
	
	private int id;
	private String name;
	private double salary;
	
	public Funcionario(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public double incremento(double porcent) {
		salary += salary * porcent / 100.0;
		return salary;
	}

	public String toString() {
		return id + ", " + name + ", " + String.format("%.2f", salary);
	}
}
