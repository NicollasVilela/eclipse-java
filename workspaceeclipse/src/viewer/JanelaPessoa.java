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

import model.ModelException;
import model.Pessoa;
import model.dao.DaoPessoa;

public class JanelaPessoa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfCpf;
	private JTextField tfNome;
	private JTextField tfIdade;
	private JComboBox<String> cbSexo;
	final private static String[] SEXOS = new String[] {"Feminino", "Masculino"};

	/**
	 * Create the frame.
	 */
	public JanelaPessoa() {
		setTitle("Pessoa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 384, 293);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(30, 29, 46, 14);
		contentPane.add(lblCpf);
		
		tfCpf = new JTextField();
		tfCpf.setBounds(74, 26, 169, 20);
		contentPane.add(tfCpf);
		tfCpf.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(30, 69, 46, 14);
		contentPane.add(lblNewLabel);
		
		tfNome = new JTextField();
		tfNome.setBounds(74, 66, 260, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Idade:");
		lblNewLabel_1.setBounds(30, 112, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		tfIdade = new JTextField();
		tfIdade.setBounds(74, 112, 86, 20);
		contentPane.add(tfIdade);
		tfIdade.setColumns(10);
		
		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Recuperando o que o usuário preencheu no textfield tfCpf
				String cpf = tfCpf.getText();
				// Recuperando o que o usuário preencheu no textfield tfCpf
				String nome = tfNome.getText();
				// Recuperando o que o usuário preencheu no textfield tfCpf
				String aux = tfIdade.getText();
				// Faço a conversão do que está em aux para int
				int idade;
				try {
					idade = Integer.parseInt(aux);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "O valor para idade não corresponde a um número");
					return;
				}
				// Recuperando a seleção feito pelo usuário com relação ao sexo
				String selecao = (String)cbSexo.getSelectedItem();
				char sexo = selecao.charAt(0);
				
				try {
					// Tento instanciar um objeto Pessoa
					Pessoa p = new Pessoa(cpf, nome, idade, sexo);
					// Se não ocorreu exceção, mostro os dados do objeto
					JOptionPane.showMessageDialog(null, "Sucesso: " + p);
					// Solicitando ao DAO para guardar a pessoa instanciada
					DaoPessoa dao = new DaoPessoa();
					dao.adicionar(p);					
					// Fechar a Janela
					setVisible(false);
				} catch (ModelException e1) {
					// Mostro em um Dialog (Modal) a mensagem presente dentro do objeto
					// de exceção que foi capturado
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btOk.setBounds(74, 205, 89, 23);
		contentPane.add(btOk);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Fecha a janela
				setVisible(false);
			}
		});
		btCancelar.setBounds(220, 205, 89, 23);
		contentPane.add(btCancelar);
		
		cbSexo = new JComboBox<String>();
		cbSexo.setModel(new DefaultComboBoxModel( SEXOS ));
		cbSexo.setBounds(74, 155, 105, 22);
		contentPane.add(cbSexo);
		
		JLabel lblNewLabel_2 = new JLabel("Sexo:");
		lblNewLabel_2.setBounds(30, 159, 46, 14);
		contentPane.add(lblNewLabel_2);
	
		// Torno a janela visível
		this.setVisible(true);
	}
}