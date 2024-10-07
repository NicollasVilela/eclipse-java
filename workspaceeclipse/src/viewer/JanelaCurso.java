package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Curso;
import model.ModelException;
import model.dao.DaoCurso;

public class JanelaCurso extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfCodigo;
	private JTextField tfNome;

	/**
	 * Create the frame.
	 */
	public JanelaCurso() {
		setTitle("Curso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 384, 207);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCpf = new JLabel("Código:");
		lblCpf.setBounds(30, 29, 46, 14);
		contentPane.add(lblCpf);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(74, 26, 169, 20);
		contentPane.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(30, 69, 46, 14);
		contentPane.add(lblNewLabel);
		
		tfNome = new JTextField();
		tfNome.setBounds(74, 66, 260, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Recuperando o que o usuário preencheu no textfield tfCodigo
				String aux = tfCodigo.getText();
				int codigo;
				try {
					codigo = Integer.parseInt(aux);
				} catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "O código digitado é inválido: " + aux);
					return;
				}
				// Recuperando o que o usuário preencheu no textfield tfNome
				String nome = tfNome.getText();
				
				try {
					// Tento instanciar um objeto Curso
					Curso c = new Curso(codigo, nome);
					// Se não ocorreu exceção, mostro os dados do objeto
					JOptionPane.showMessageDialog(null, "Sucesso: " + c);
					// Solicitando ao DAO para guardar o curso instanciado
					DaoCurso dao = new DaoCurso();
					dao.adicionar(c);					
					// Fechar a Janela
					setVisible(false);
				} catch (ModelException e1) {
					// Mostro em um Dialog (Modal) a mensagem presente dentro do objeto
					// de exceção que foi capturado
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btOk.setBounds(74, 115, 89, 23);
		contentPane.add(btOk);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Fecha a janela
				setVisible(false);
			}
		});
		btCancelar.setBounds(220, 115, 89, 23);
		contentPane.add(btCancelar);
	
		// Torno a janela visível
		this.setVisible(true);
	}
}