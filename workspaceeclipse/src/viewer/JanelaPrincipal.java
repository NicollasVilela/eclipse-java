package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Aluno;
import model.Pessoa;
import model.dao.DaoAluno;
import model.dao.DaoPessoa;

public class JanelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JanelaPrincipal() {
		setTitle("Janela Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 120);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btPessoas = new JButton("Pessoas");
		btPessoas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JanelaConsultarPessoas();
			}
		});
		btPessoas.setBounds(10, 11, 89, 63);
		contentPane.add(btPessoas);
		
		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Mostrando todos os objetos Pessoa que foram instanciados
				System.out.println("Objetos Pessoa Instanciados");
				System.out.println("===========================");
				DaoPessoa daoPessoa = new DaoPessoa();
				Pessoa[] pessoas = daoPessoa.obterPessoas();
				for(int i = 0; i < daoPessoa.getNumObjetos(); i++)
					System.out.println(i + ") " + pessoas[i]);				

				// Mostrando todos os objetos Aluno que foram instanciados
				System.out.println("Objetos Aluno Instanciados");
				System.out.println("===========================");
				DaoAluno daoAluno = new DaoAluno();
				Aluno[] alunos = daoAluno.obterAlunos();
				for(int i = 0; i < daoAluno.getNumObjetos(); i++)
					System.out.println(i + ") " + alunos[i]);				
				// Encerro o programa
				System.exit(0);
			}
		});
		btSair.setBounds(360, 11, 89, 63);
		contentPane.add(btSair);
		
		JButton btAlunos = new JButton("Alunos");
		btAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JanelaConsultarAlunos();
			}
		});
		btAlunos.setBounds(129, 11, 89, 63);
		contentPane.add(btAlunos);
		
		JButton btCursos = new JButton("Cursos");
		btCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JanelaConsultarCursos();
			}
		});
		btCursos.setBounds(246, 11, 89, 63);
		contentPane.add(btCursos);
		
		// Torno a Janela Principal Visível
		this.setVisible(true);
	}
}