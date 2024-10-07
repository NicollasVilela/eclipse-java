package model.dao;

import model.Disciplina;

public class DaoDisciplina {
	//
	// CONSTANTES
	//
	final public static int NUM_MAX_DISCIPLINAS = 5;
	
	//
	// ATRIBUTOS
	//
	private static Disciplina[] conjDisciplinas = new Disciplina[NUM_MAX_DISCIPLINAS];
	private static int     numObjetos = 0;
	
	//
	// MÉTODOS
	//
	public DaoDisciplina() {
		super();
	}
	
	/**
	 * Adiciona um objeto Aluno ao conjunto de objetos gerenciados pelo DAO
	 * @param novo
	 * @return
	 */
	public boolean adicionar(Disciplina novo) {
		if(DaoDisciplina.numObjetos == NUM_MAX_DISCIPLINAS) 
			return false;
		DaoDisciplina.conjDisciplinas[numObjetos] = novo;
		DaoDisciplina.numObjetos++;
		return true;
	}

	/**
	 * Retorna o Aluno presente na posição indicada por parâmetro
	 * @param posicao
	 * @return
	 */
	public Disciplina obter(int posicao) {
		// Se a posição não for válida, retornamos null
		if(posicao < 0 || posicao >= DaoDisciplina.numObjetos)
			return null;
		return DaoDisciplina.conjDisciplinas[posicao];
	}
	
	/**
	 * Retorna o número de objetos Aluno gerenciados pelo Dao
	 * @return
	 */
	public int getNumObjetos() {
		return DaoDisciplina.numObjetos;
	}
	
	/**
	 * Retorna uma cópia do array de ponteiros para Aluno gerenciado pelo DAO
	 * @return
	 */
	public Disciplina[] obterDisciplinas() {
		Disciplina[] copia = new Disciplina[DaoDisciplina.numObjetos];
		for(int i = 0; i < DaoDisciplina.numObjetos; i++)
			copia[i] = DaoDisciplina.conjDisciplinas[i];
		return copia;
	}
}