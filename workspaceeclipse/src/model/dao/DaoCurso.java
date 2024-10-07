package model.dao;

import model.Curso;

public class DaoCurso {
	//
	// CONSTANTES
	//
	final public static int NUM_MAX_CURSOS = 5;
	
	//
	// ATRIBUTOS
	//
	private static Curso[] conjCursos = new Curso[NUM_MAX_CURSOS];
	private static int     numObjetos = 0;
	
	//
	// MÉTODOS
	//
	public DaoCurso() {
		super();
	}
	
	/**
	 * Adiciona um objeto Curso ao conjunto de objetos gerenciados pelo DAO
	 * @param novo
	 * @return
	 */
	public boolean adicionar(Curso novo) {
		if(DaoCurso.numObjetos == NUM_MAX_CURSOS) 
			return false;
		DaoCurso.conjCursos[DaoCurso.numObjetos] = novo;
		DaoCurso.numObjetos++;
		return true;
	}

	/**
	 * Retorna a Curso presente na posição indicada por parâmetro
	 * @param posicao
	 * @return
	 */
	public Curso obter(int posicao) {
		// Se a posição não for válida, retornamos null
		if(posicao < 0 || posicao >= DaoCurso.numObjetos)
			return null;
		return DaoCurso.conjCursos[posicao];
	}
	
	/**
	 * Retorna o número de objetos Curso gerenciados pelo Dao
	 * @return
	 */
	public int getNumObjetos() {
		return DaoCurso.numObjetos;
	}
	
	/**
	 * Retorna uma cópia do array de ponteiros para Curso gerenciado pelo DAO
	 * @return
	 */
	public Curso[] obterCursos() {
		Curso[] copia = new Curso[DaoCurso.numObjetos];
		for(int i = 0; i < DaoCurso.numObjetos; i++)
			copia[i] = DaoCurso.conjCursos[i];
		return copia;
	}
}