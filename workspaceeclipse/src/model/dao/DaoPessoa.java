package model.dao;

import model.Pessoa;

public class DaoPessoa {
	//
	// CONSTANTES
	//
	final public static int NUM_MAX_PESSOAS = 5;
	
	//
	// ATRIBUTOS
	//
	private static Pessoa[] conjPessoas = new Pessoa[NUM_MAX_PESSOAS];
	private static int      numObjetos = 0;
	
	//
	// MÉTODOS
	//
	public DaoPessoa() {
		super();
	}
	
	/**
	 * Adiciona um objeto Pessoa ao conjunto de objetos gerenciados pelo DAO
	 * @param novo
	 * @return
	 */
	public boolean adicionar(Pessoa novo) {
		if(DaoPessoa.numObjetos == NUM_MAX_PESSOAS) 
			return false;
		DaoPessoa.conjPessoas[DaoPessoa.numObjetos] = novo;
		DaoPessoa.numObjetos++;
		return true;
	}

	/**
	 * Retorna a Pessoa presente na posição indicada por parâmetro
	 * @param posicao
	 * @return
	 */
	public Pessoa obter(int posicao) {
		// Se a posição não for válida, retornamos null
		if(posicao < 0 || posicao >= DaoPessoa.numObjetos)
			return null;
		return DaoPessoa.conjPessoas[posicao];
	}
	
	/**
	 * Retorna o número de objetos Pessoa gerenciados pelo Dao
	 * @return
	 */
	public int getNumObjetos() {
		return DaoPessoa.numObjetos;
	}
	
	/**
	 * Retorna uma cópia do array de ponteiros para Pessoa gerenciado pelo DAO
	 * @return
	 */
	public Pessoa[] obterPessoas() {
		Pessoa[] copia = new Pessoa[DaoPessoa.numObjetos];
		for(int i = 0; i < DaoPessoa.numObjetos; i++)
			copia[i] = DaoPessoa.conjPessoas[i];
		return copia;
	}
}