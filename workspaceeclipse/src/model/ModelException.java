package model;

/**
 * Estamos criando a classe ModelException que é subclasse (especialização)
 * de Exception. Nossa intenção é qualificar as exceções derivadas de erros
 * na atribuição de valores a objetos de dados do nosso sistema. 
 */
public class ModelException extends Exception {
	/**
	 * Construtor de ModelException. Recebe um ponteiro para String que descreve qual foi
	 * o erro que ocorreu na tentativa de atribuir um valor a um atributo de um objeto de
	 * dados (camada model) 
	 * @param msgDeErro mensagem do erro que ocorreu
	 */
	public ModelException(String msgDeErro) {
		super(msgDeErro);
	}
}