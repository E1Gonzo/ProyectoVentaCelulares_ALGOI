package trabajorepetitivo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentaCelulares extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblCantidadCargas;
	private JTextField txtCantidadCargas;
	private JButton btnProcesar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentaCelulares frame = new VentaCelulares();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentaCelulares() {
		setTitle("Contador de productos en almac\u00E9n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 108);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCantidadCargas = new JLabel("Cantidad de Cargas:");
		lblCantidadCargas.setBounds(10, 28, 128, 14);
		contentPane.add(lblCantidadCargas);
		
		txtCantidadCargas = new JTextField();
		txtCantidadCargas.setBounds(137, 25, 86, 20);
		contentPane.add(txtCantidadCargas);
		txtCantidadCargas.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 24, 89, 23);
		contentPane.add(btnProcesar);
	}
	public void actionPerformed(ActionEvent e) {
		
		//Declaración de variables
		int cantidadCargas,contadorCargas;
		double cantidadProductos,totalProductos;
		
		//Captura de datos
		cantidadCargas = Integer.parseInt(txtCantidadCargas.getText());//7
		
		//Inicializamos la variable contadorGanancias(Contador)
		//contadorGanancias = 1;
		
		//Inicializamos la varible totalGanancias(Acumulador)
		totalProductos = 0;
		
		//Profe, no incluí las primeras 2 formas que hicimos en clase como usted nos dijo
		if (cantidadCargas<=0) {
			//Tercera forma del JOptionPane.showMessageDialog:
			ImageIcon icon = new ImageIcon("src\\Resource\\Icon\\crc_error.png");
			JOptionPane.showMessageDialog(null, "Ingrese una cantiad de carga válida",
	                "ERROR", JOptionPane.ERROR_MESSAGE, icon);
		} else {
			//Segunda forma del JOptionPane.showInputDialog:
			String nombreEmpresa = JOptionPane.showInputDialog(null, "Nombre de empresa distribuidora:");
			
			//Tercera forma del JOptionPane.showInputDialog:
			String nombreEmpleado = JOptionPane.showInputDialog( "Nombre de encargado:", "Nombres y apellidos");
			
			//Cuarta forma del JOptionPane.showInputDialog:
			String dia = JOptionPane.showInputDialog(null, "Día:", "DD-MMM-YY");
			
			for (contadorCargas=1;contadorCargas<=cantidadCargas; contadorCargas++) {
				//Quinta forma del JOptionPane.showInputDialog:
				cantidadProductos = Double.parseDouble(JOptionPane.showInputDialog
						(null, "Cantidad de produtos", "Contador", JOptionPane.QUESTION_MESSAGE));
				
				totalProductos = totalProductos + cantidadProductos;
			}
			//Segunda form del JOptionPane.showMessageDialog:
			JOptionPane.showMessageDialog(null, "El total de productos ingresados al almacén, el día " + dia + " por la empresa "
			+ nombreEmpresa + " es de: " + totalProductos, "Resultados", JOptionPane.INFORMATION_MESSAGE);
			
			//Sexta forma del JOptionPane.showInputDialog:
			String[] opciones = {"Muy Bueno", "Bueno", "Rgular", "Malo", "Muy malo"};
	        ImageIcon icon = new ImageIcon("src\\Resource\\Icon\\encuestaImagen.png");
	        JOptionPane.showInputDialog(null, "¿Qué le pareció nuestro servicio?", 
	                "Encuesta", JOptionPane.QUESTION_MESSAGE, icon, opciones, opciones[1]);
	        
	        //Yapa:
	        JOptionPane.showMessageDialog(null, "Muchas gracias por tu feedback: "
					+ nombreEmpleado, "Encuesta"+dia, JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
