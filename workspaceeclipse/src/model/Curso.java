//
// Versão do dia 03/outubro
//
package model;

public class Curso {
	//
	// CONSTANTE
	//
	final public static int TAM_MIN_NOME = 5;
	final public static int TAM_MAX_NOME = 30;
	
	//
	// ATRIBUTOS
	//
	private int 	codigo;
	private String  nome;
	
	//
	// MÉTODOS
	//
	/**
	 * Método construtor de Curso
	 * @param c valor do código do curso
	 * @param n referência para a String com o nome do curso
	 */
	public Curso(int c, String n) throws ModelException {
		super();
		this.setCodigo(c);
		this.setNome(n);
	}
	
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) throws ModelException {
		Curso.validarCodigo(codigo);
		this.codigo = codigo;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) throws ModelException {
		Curso.validarNome(nome);
		this.nome = nome;
	}

	/**
	 * Método para verificar se o parâmetro pode ser utilizado na atribuição ao 
	 * atributo 'codigo'	 
	 * @param codigo
	 * @throws ModelException
	 */
	public static void validarCodigo(int codigo) throws ModelException {
		if(codigo < 0 || codigo > 99)
			throw new ModelException("Código Inválido: " + codigo);
	}

	/**
	 * Método para verificar se o parâmetro pode ser utilizado na atribuição ao 
	 * atributo 'nome'
	 * @param nome
	 * @throws ModelException
	 */
	public static void validarNome(String nome) throws ModelException {
		// Verificando se o parâmetro corresponde a um nome nulo ou vazio
		if(nome == null || nome.length() == 0)
			throw new ModelException("O nome do curso não pode ser nulo!");
		// Verificando o tamanho (em caracteres) da String
		if(nome.length() < TAM_MIN_NOME || nome.length() > TAM_MAX_NOME)
			throw new ModelException("O nome deve ter entre " + TAM_MIN_NOME + " e " + TAM_MAX_NOME + " caracteres!");
		// Verificando cada um dos caracteres presentes na String
		for(int i = 0; i < nome.length(); i++) {
			// Recupero o caracter presente na posição 'i'
			char c = nome.charAt(i);
			// Se o caracter NÃO é alfabético E NÃO é um espaço em branco, lançamos exceção
			if( ! Character.isAlphabetic(c) && ! Character.isSpaceChar(c) )
				throw new ModelException("O caracter na posição " + i + " é inválido: " + c);
		}
	}

	/**
	 * Método que retorna uma referência para a String que descreve o objeto Curso
	 */
	public String toString() {
		return this.codigo +  " - " + this.nome;
	}
}