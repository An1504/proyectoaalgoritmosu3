package Buzon;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class PantallaBuzon {

	private JFrame frmBuzonDeSugerencias;
	private JTextField txtmatricula;
	private JTextField txtgrupo;
	private JTextField txtingenierias;
	private JTextField txtcomentario;
	private JButton btnSalir;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaBuzon window = new PantallaBuzon();
					window.frmBuzonDeSugerencias.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PantallaBuzon() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBuzonDeSugerencias = new JFrame();
		frmBuzonDeSugerencias.getContentPane().setForeground(new Color(255, 228, 196));
		frmBuzonDeSugerencias.getContentPane().setBackground(new Color(176, 224, 230));
		frmBuzonDeSugerencias.setTitle("BUZON DE SUGERENCIAS");
		frmBuzonDeSugerencias.setBounds(100, 100, 450, 387);
		frmBuzonDeSugerencias.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBuzonDeSugerencias.getContentPane().setLayout(null);
		
		JLabel matricula = new JLabel("MATRICULA");
		matricula.setForeground(new Color(138, 43, 226));
		matricula.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		matricula.setBounds(10, 59, 81, 17);
		frmBuzonDeSugerencias.getContentPane().add(matricula);
		
		txtmatricula = new JTextField();
		txtmatricula.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) 
			{
				if(txtmatricula.getText().length()>=10)
				{
					e.consume();
					JOptionPane.showMessageDialog(null, "Limite de caracteres");
				}
			}
			});
		txtmatricula.setBounds(108, 58, 121, 20);
		frmBuzonDeSugerencias.getContentPane().add(txtmatricula);
		txtmatricula.setColumns(10);
		
		JLabel grupo = new JLabel("GRUPO");
		grupo.setForeground(new Color(138, 43, 226));
		grupo.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		grupo.setBounds(239, 60, 46, 14);
		frmBuzonDeSugerencias.getContentPane().add(grupo);
		
		txtgrupo = new JTextField();
		txtgrupo.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) 
			{
				if(txtgrupo.getText().length()>=9)
				{
					e.consume();
					JOptionPane.showMessageDialog(null, "Limite de caracteres");
				}
			}
		});
		txtgrupo.setBounds(295, 58, 121, 20);
		frmBuzonDeSugerencias.getContentPane().add(txtgrupo);
		txtgrupo.setColumns(10);
		
		JLabel comentario = new JLabel("COMENTARIO");
		comentario.setForeground(new Color(138, 43, 226));
		comentario.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 14));
		comentario.setBounds(237, 87, 86, 29);
		frmBuzonDeSugerencias.getContentPane().add(comentario);
		
		JLabel ing = new JLabel("INGENIERIA / LICENCIATURA");
		ing.setForeground(new Color(106, 90, 205));
		ing.setBackground(new Color(175, 238, 238));
		ing.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 14));
		ing.setBounds(10, 89, 187, 25);
		frmBuzonDeSugerencias.getContentPane().add(ing);
		
		JButton enviar = new JButton("ENVIAR");
		enviar.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 14));
		enviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Variables v=new Variables();
				v.setMatricula(txtmatricula.getText());
				v.setGrupo(txtgrupo.getText());
				v.setIngenierias(txtingenierias.getText());
				v.setComentario(txtcomentario.getText());
				if(v.insertarqueja()){
				     JOptionPane.showMessageDialog(null, "cliente agregado");
				}else{
					 JOptionPane.showMessageDialog(null, "cliente no agregado");
				}
			}
		});
		enviar.setBounds(10, 190, 151, 29);
		frmBuzonDeSugerencias.getContentPane().add(enviar);
		
		txtingenierias = new JTextField();
		txtingenierias.setBounds(10, 125, 170, 42);
		frmBuzonDeSugerencias.getContentPane().add(txtingenierias);
		txtingenierias.setColumns(10);
		
		txtcomentario = new JTextField();
		txtcomentario.setBounds(237, 127, 187, 147);
		frmBuzonDeSugerencias.getContentPane().add(txtcomentario);
		txtcomentario.setColumns(10);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 14));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				JOptionPane.showMessageDialog(null, " SALISTE DE UPT COMMUNYTY");
				System.exit(0);
			}
		});
		btnSalir.setBounds(10, 247, 151, 29);
		frmBuzonDeSugerencias.getContentPane().add(btnSalir);
		
		lblNewLabel = new JLabel("BUZON DE SUGERENCIAS - UPT");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		lblNewLabel.setBounds(111, 11, 240, 20);
		frmBuzonDeSugerencias.getContentPane().add(lblNewLabel);
	}
}
