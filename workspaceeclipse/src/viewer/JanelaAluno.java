package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Aluno;
import model.Curso;
import model.ModelException;
import model.dao.DaoAluno;
import model.dao.DaoCurso;

public class JanelaAluno extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfCpf;
	private JTextField tfNome;
	private JTextField tfIdade;
	private JComboBox<String> cbSexo;
	private JTextField tfMatricula;
	private JComboBox cbCurso;

	/**
	 * Create the frame.
	 */
	public JanelaAluno() {
		setTitle("Aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 384, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(30, 27, 46, 14);
		contentPane.add(lblCpf);
		
		tfCpf = new JTextField();
		tfCpf.setBounds(74, 22, 169, 20);
		contentPane.add(tfCpf);
		tfCpf.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(30, 109, 46, 14);
		contentPane.add(lblNewLabel);
		
		tfNome = new JTextField();
		tfNome.setBounds(74, 106, 260, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Idade:");
		lblNewLabel_1.setBounds(30, 150, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		tfIdade = new JTextField();
		tfIdade.setBounds(74, 148, 86, 20);
		contentPane.add(tfIdade);
		tfIdade.setColumns(10);
		
		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Recuperando o que o usuário preencheu no textfield tfCpf
				String cpf = tfCpf.getText();
				// Recuperando o que o usuário preencheu no textfield tfNome
				String nome = tfNome.getText();
				// Recuperando o que o usuário preencheu no textfield tfMatricula
				String matricula = tfMatricula.getText();
				// Recuperando o que o usuário preencheu no textfield tfIdade
				String aux = tfIdade.getText();
				// Faço a conversão do que está em aux para int
				int idade;
				try {
					idade = Integer.parseInt(aux);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "O valor para idade não corresponde a um número");
					return;
				}
				// Recuperando a seleção feita pelo usuário com relação ao sexo
				String selecao = (String)cbSexo.getSelectedItem();
				char sexo = selecao.charAt(0);
				
				// Recuperando a seleção feita pelo usuário com relação ao curso
				Curso cursoSelecionado = (Curso)cbCurso.getSelectedItem();
				
				try {
					// Tento instanciar um objeto Aluno
					Aluno a = new Aluno(cpf, nome, idade, sexo, matricula, cursoSelecionado);
					// Se não ocorreu exceção, mostro os dados do objeto
					JOptionPane.showMessageDialog(null, "Sucesso: " + a);
					// Solicitando ao DAO para guardar o aluno instanciado
					DaoAluno dao = new DaoAluno();
					dao.adicionar(a);					
					// Fechar a Janela
					setVisible(false);
				} catch (ModelException e1) {
					// Mostro em um Dialog (Modal) a mensagem presente dentro do objeto
					// de exceção que foi capturado
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btOk.setBounds(74, 290, 89, 23);
		contentPane.add(btOk);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Fecha a janela
				setVisible(false);
			}
		});
		btCancelar.setBounds(220, 290, 89, 23);
		contentPane.add(btCancelar);
		
		cbSexo = new JComboBox<String>();
		cbSexo.setModel(new DefaultComboBoxModel(new String[] {"Feminino", "Masculino"}));
		cbSexo.setBounds(74, 190, 105, 22);
		contentPane.add(cbSexo);
		
		JLabel lblNewLabel_2 = new JLabel("Sexo:");
		lblNewLabel_2.setBounds(30, 191, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Matrícula:");
		lblNewLabel_3.setBounds(22, 68, 54, 14);
		contentPane.add(lblNewLabel_3);
		
		tfMatricula = new JTextField();
		tfMatricula.setBounds(74, 64, 217, 20);
		contentPane.add(tfMatricula);
		tfMatricula.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Curso:");
		lblNewLabel_4.setBounds(30, 235, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		DaoCurso dao = new DaoCurso();
		Curso[] conjCursos = dao.obterCursos();
		cbCurso = new JComboBox();
		cbCurso.setModel(new DefaultComboBoxModel( conjCursos  ));
		cbCurso.setBounds(74, 231, 260, 22);
		contentPane.add(cbCurso);
	
		// Torno a janela visível
		this.setVisible(true);
	}
}