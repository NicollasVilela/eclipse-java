//
// Versão do dia 22/agosto
//
package model;

public class Disciplina {
	//
	// ATRIBUTOS
	//
	private String codigo;
	private String nome;
	private int    numCreditos;
	
	//
	// MÉTODOS
	//
	/**
	 * Método construtor de Disciplina
	 * @param c referência para String que contém o código da Disciplina
	 * @param n referência para String que contém o nome da Disciplina
	 * @param nc valor com o número de créditos da Disciplina
	 */
	public Disciplina(String c, String n, int nc) {
		super();
		this.codigo = c;
		this.nome = n;
		this.numCreditos = nc;
	}
	
	/**
	 * Método que retorna uma referência para a String que descreve o objeto Disciplina
	 */
	public String apresenteSe() {
		return "Sou uma disciplina com código " + this.codigo + 
			   ", meu nome é " + this.nome + " e tenho " + this.numCreditos +
			   " créditos";
	}
}

