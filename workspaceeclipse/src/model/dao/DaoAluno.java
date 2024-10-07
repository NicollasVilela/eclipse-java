package model.dao;

import model.Aluno;

public class DaoAluno {
	//
	// CONSTANTES
	//
	final public static int NUM_MAX_ALUNOS = 5;
	
	//
	// ATRIBUTOS
	//
	private static Aluno[] conjAlunos = new Aluno[NUM_MAX_ALUNOS];
	private static int     numObjetos = 0;
	
	//
	// MÉTODOS
	//
	public DaoAluno() {
		super();
	}
	
	/**
	 * Adiciona um objeto Aluno ao conjunto de objetos gerenciados pelo DAO
	 * @param novo
	 * @return
	 */
	public boolean adicionar(Aluno novo) {
		if(DaoAluno.numObjetos == NUM_MAX_ALUNOS) 
			return false;
		DaoAluno.conjAlunos[numObjetos] = novo;
		DaoAluno.numObjetos++;
		return true;
	}

	/**
	 * Retorna o Aluno presente na posição indicada por parâmetro
	 * @param posicao
	 * @return
	 */
	public Aluno obter(int posicao) {
		// Se a posição não for válida, retornamos null
		if(posicao < 0 || posicao >= DaoAluno.numObjetos)
			return null;
		return DaoAluno.conjAlunos[posicao];
	}
	
	/**
	 * Retorna o número de objetos Aluno gerenciados pelo Dao
	 * @return
	 */
	public int getNumObjetos() {
		return DaoAluno.numObjetos;
	}
	
	/**
	 * Retorna uma cópia do array de ponteiros para Aluno gerenciado pelo DAO
	 * @return
	 */
	public Aluno[] obterAlunos() {
		Aluno[] copia = new Aluno[DaoAluno.NUM_MAX_ALUNOS];
		for(int i = 0; i < DaoAluno.numObjetos; i++)
			copia[i] = DaoAluno.conjAlunos[i];
		return copia;
	}
}