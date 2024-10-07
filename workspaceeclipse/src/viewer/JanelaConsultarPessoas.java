package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import model.Pessoa;
import model.dao.DaoPessoa;

public class JanelaConsultarPessoas extends JFrame{
	//
	// ATRIBUTOS
	//
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable tabela;
	private Pessoa[] listaPessoas;

	/**
	 * Create the frame.
	 */
	public JanelaConsultarPessoas() {
		super();
		setTitle("Pessoas");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		this.atualizarDados();

		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btSair.setBounds(335, 227, 89, 23);
		contentPane.add(btSair);

		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(10, 11, 414, 200);
		contentPane.add(scrollPane);
		
		JButton btIncluir = new JButton("Incluir");
		btIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JanelaPessoa();
			}
		});
		btIncluir.setBounds(10, 227, 89, 23);
		contentPane.add(btIncluir);
		
		JButton btExcluir = new JButton("Excluir");
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btExcluir.setBounds(121, 227, 89, 23);
		contentPane.add(btExcluir);
		
		JButton btAlterar = new JButton("Alterar");
		btAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btAlterar.setBounds(231, 227, 89, 23);
		contentPane.add(btAlterar);
		
		this.setVisible(true);
	}

	/**
	 * Atualiza os dados apresentados no JTable da janela
	 */
	public void atualizarDados() {
		DaoPessoa dao = new DaoPessoa();		
		this.listaPessoas = dao.obterPessoas();
		HelperTableModel h = new HelperTableModel(this.listaPessoas);
		if(this.tabela == null)
			this.tabela = new JTable(h.getTableModel());
		else 
			this.tabela.setModel(h.getTableModel());
	}

	/**
	 * Retorna qual objeto 
	 * @return
	 */
	public Pessoa obterLinhaSelecionada() {
		int numLinhaSelecionada = this.tabela.getSelectedRow();
		if(numLinhaSelecionada != -1)
			return this.listaPessoas[numLinhaSelecionada];
		return null;
	}	
}