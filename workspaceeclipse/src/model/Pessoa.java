//
// Versão do dia 19/Setembro
//
package model;

public class Pessoa {
	//
	// ATRIBUTOS
	// 
	private String cpf;
	private String nome;
	private int    idade;
	private char   sexo;
	
	//
	// MÉTODOS
	//
	/**
	 * Método construtor da classe Pessoa. Toda vez que um objeto Pessoa
	 * for instanciado (criado), esse objeto, no momento de sua criação,
	 * irá executar este método. O método construtor é o método responsável
	 * pela INICIALIZAÇÃO do objeto recém-criado.
	 * 
	 * Observe a presença do 'this' no código. Por definição, 'this' é a 
	 * referência para o objeto que estiver executando o método.
	 * 
	 * @param c referência para a String com o CPF da Pessoa
	 * @param n referência para a String com o nome da Pessoa
	 * @param i valor para a idade da Pessoa
	 * @param s indicação do sexo da Pessoa [F] ou [M]
	 */
	public Pessoa(String c, String n, int i, char s) throws ModelException {
		super();
		this.setCpf(c);
		this.setNome(n);
		this.setIdade(i);
		this.setSexo(s);
	}
	
	/**
	 * Retorna o valor presente dentro do atributo 'cpf' (ponteiro para String) 
	 * @return
	 */
	public String getCpf() {
		return this.cpf;
	}
	
	/**
	 * Altera o cpf do objeto Pessoa
	 * @param c referência para a String com o novo cpf
	 */
	public void setCpf(String c) throws ModelException {
		Pessoa.validarCpf(c);
		this.cpf = c;
	}
	
	/**
	 * Retorna o valor presente dentro do atributo 'nome' (ponteiro para String) 
	 * @return
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Altera o nome do objeto Pessoa
	 * @param n referência para String com o novo nome do objeto
	 */
	public void setNome(String n) throws ModelException {
		Pessoa.validarNome(n);
		this.nome = n;
	}
	
	/**
	 * Retorna o valor presente dentro do atributo idade
	 * @return
	 */
	public int getIdade() {
		return this.idade;
	}
	
	/**
	 * Altera a idade do objeto Pessoa
	 * @param i nova idade do objeto Pessoa
	 */
	public void setIdade(int i) throws ModelException {
		Pessoa.validarIdade(i);
		this.idade = i;
	}
	
	/**
	 * Retorna a indicação do sexo da pessoa: [F] ou [M]
	 * @return
	 */
	public char getSexo() {
		return this.sexo;
	}

	/**
	 * Altera o sexo da pessoa
	 * @param sexo
	 * @throws ModelException
	 */
	public void setSexo(char sexo) throws ModelException {
		Pessoa.validarSexo(sexo);
		this.sexo = sexo;
	}
	
	/**
	 * Método para verificar se o parâmetro pode ser utilizado na atribuição ao 
	 * atributo 'cpf'
	 * @param cpf
	 * @throws ModelException
	 */
	public static void validarCpf(String cpf) throws ModelException {
		// Verificando se o parâmetro corresponde a um cpf nulo ou vazio
		if(cpf == null || cpf.length() == 0)
			throw new ModelException("O cpf de uma pessoa não pode ser nulo!");
		// Verificando se o tamanho (em caracteres) da String do cpf é igual a 14
		if(cpf.length() != 14)
			throw new ModelException("O cpf deve 14 caracteres no formato 999.999.999-99!");
		// Verificando cada um dos caracteres presentes na String
		for(int i = 0; i < cpf.length(); i++) {
			// Recupero o caracter presente na posição 'i'
			char c = cpf.charAt(i);
			switch(i) {
			case 3:
			case 7:
				if(c != '.')
					throw new ModelException("O caracter na posição " + i + " deve ser '.'");
				break;
			case 11:
				if(c != '-')
					throw new ModelException("O caracter na posição 11 deve ser '-'");
				break;
			default:
				if(! Character.isDigit(c))
					throw new ModelException("O caracter na posição " + i + " deve corresponder a um dígito: " + c);
				break;
			}
		}
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
			throw new ModelException("O nome de uma pessoa não pode ser nulo!");
		// Verificando o tamanho (em caracteres) da String
		if(nome.length() < 5 || nome.length() > 40)
			throw new ModelException("O nome deve ter entre 5 e 40 caracteres!");
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
	 * Método para verificar se o parâmetro pode ser utilizado na atribuição ao 
	 * atributo 'idade'	 
	 * @param idade
	 * @throws ModelException
	 */
	public static void validarIdade(int idade) throws ModelException {
		if(idade < 0 || idade > 150)
			throw new ModelException("Idade Inválida: " + idade);
	}

	/**
	 * Método para verificar a indicação do sexo da pessoa
	 * @param sexo
	 * @throws ModelException
	 */
	public static void validarSexo(char sexo) throws ModelException {
		if(sexo != 'F' && sexo != 'M')
			throw new ModelException("A indicação do sexo deve ser [F] ou [M]");
	}
	/**
	 * Método que retorna uma referência para a String que descreve o objeto Pessoa
	 */
	@Override
	public String toString() {
		return "CPF: " + this.cpf + " - " + this.nome;
	}

}