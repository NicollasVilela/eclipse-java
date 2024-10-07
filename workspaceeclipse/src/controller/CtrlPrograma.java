//
// Versão do dia 19/Setembro
//
package controller;

import model.Curso;
import model.Disciplina;
import model.ModelException;
import model.Pessoa;
import viewer.JanelaPrincipal;

public class CtrlPrograma {

	public static void main(String[] args) {
		// CtrlPrograma.oldMain(null);
		new JanelaPrincipal();
	}

	/**
	 * Versão antiga do método main
	 * @param args
	 */
	public static void oldMain(String[] args) {
		// Declarando as variáveis p1, p2 e p3, cujo tipo é "Ponteiro para Pessoa" 
		// e inicializadas com null
		Pessoa p1 = null;
		Pessoa p2 = null;
		Pessoa p3 = null;

		// Na INSTRUÇÃO abaixo temos dois OPERADORES: = e new. Pela precedência, o
		// primeiro a ser executado é o 'new'. A missão do 'new' é "CRIAR UM NOVO
		// OBJETO".
		// Para cumprir essa missão, o 'new' executa duas tarefas:
		// (1) Aloca memória para o novo objeto, promovendo a inicialização default
		// (2) Solicita ao objeto recém-criado que execute o método construtor.
		// Ao final, o operador new devolve o endereço de memória onde está o novo
		// objeto.
		// Depois do new, o operador de atribuição '=' irá pegar o valor do endereço de
		// memória devolvido pelo new e o atribuirá para a variável 'p1'.

		try {
			p1 = new Pessoa("123.456.789-09", "José da Silva", 23, 'M');
		} catch (ModelException e) {
			// Se ocorreu a exceção, a variável 'e' vai apontar para o objeto de exceção
			// gerado, nos permitindo obter a mensagem de erro com o problema detectado
			System.out.println("Não foi possível criar o objeto Pessoa: " + e.getMessage());
		}
		
		// Mesmas considerações feitas acima, porém com a variável 'p2'
		try {
			p2 = new Pessoa("098.765.432-10", "Maria de Souza", 31, 'F');
		} catch (Exception e) {
			// Se ocorreu a exceção, a variável 'e' vai apontar para o objeto de exceção
			// gerado, nos permitindo obter a mensagem de erro com o problema detectado
			System.out.println("Não foi possível criar o objeto Pessoa: " + e.getMessage());
		}

		// p3 passará a ter o mesmo valor de p1, logo passará a apontar para o mesmo
		// objeto apontado por p1
		p3 = p1;

		// Escreve "o endereço de memória presente em p1" (na realidade, há a chamada ao
		// toString)
		System.out.println("a variável p1 referencia: " + p1);

		// Envio para o objeto apontado por p1 a mensagem 'getNome()' que retorna o
		// ponteiro
		// para String que contém o nome. O System.out.println recebe esse ponteiro, vai
		// no
		// objeto String e escreve seu conteúdo.
		System.out.println(p1.getNome());
		System.out.println(p2.getNome());
		System.out.println(p3.getNome());

		// Como o conteúdo do bloco PODE LANÇAR UMA EXCEÇÃO, então devemos colocar um
		// bloco
		// de try...catch
		try {
			// Envio para o objeto apontado por p1 a mensagem "setNome" que irá modificar o
			// nome do objeto Pessoa referenciado
			p1.setNome("José Silva");
		} catch (Exception e) {
			// Se ocorreu a exceção, a variável 'e' vai apontar para o objeto de exceção
			// gerado, nos permitindo obter a mensagem de erro com o problema detectado
			System.out.println("Ocorreu um problema ao alterar o nome: " + e.getMessage());
		}

		System.out.println(p3.getNome());

		// Envia "para o objeto apontado por p1" a mensagem "apresenteSe". Com o
		// resultado, escreve
		// na console a String produzida por "apresenteSe"
		System.out.println(p1.toString());

		System.out.println(p2);
		System.out.println(p2.toString());

		Curso c1 = null;
		Curso c2 = null;

		try {
			c1 = new Curso(17, "Sistemas de Informação");
			c2 = new Curso(40, "Direito");
		} catch (ModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(c1);
		System.out.println(c1.toString());

		System.out.println(c2);
		System.out.println(c2.toString());

		Disciplina d1;
		Disciplina d2;

		d1 = new Disciplina("ProgIII", "Programação de Computadores III", 4);
		d2 = new Disciplina("Herm", "Hermenêutica", 4);

		System.out.println(d1);
		System.out.println(d1.toString());

		System.out.println(d2);
		System.out.println(d2.toString());
	}
}