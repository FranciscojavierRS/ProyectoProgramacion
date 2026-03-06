package Examen_Feria_Colecciones;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Component;
import javax.swing.ButtonGroup;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class VentanaPpal extends JFrame
{

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblConcepto;
	private JTextField campoArticulo;
	private JLabel lblTamao;
	private JRadioButton radioGrande;
	private JRadioButton radioMediano;
	private JRadioButton radioPequenio;
	private JLabel lblPrecio;
	private JTextField campoPrecio;
	private JButton botonGuardarArticulo;
	private JButton botonBorrarArticulo;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel panel_2;
	private JPanel panel_3;
	private JScrollPane scrollPane;
	private JTextArea areaTexto;
	private JLabel lblSocio;
	private JComboBox<Socio> comboSocios;
	private JLabel lblArtculo;
	private JComboBox<Articulo> comboArticulos;
	private JLabel lblCantidad;
	private JButton botonPagarCuenta;
	private JButton botonAniadirConsumicion;
	private Principal controlador;
	private JSpinner spinnerCantidad = new JSpinner();


	public VentanaPpal(Principal controlador)
	{
		this.controlador = controlador;
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setMinimumSize(new Dimension(540, 365));
		setTitle("Pascual M\u00E1rquez 34 - Feria de Sevilla 2017");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		panel = new JPanel();
		tabbedPane.addTab("Gesti\u00F3n de Lista de Precios", null, panel, null);

		lblConcepto = new JLabel("Art\u00EDculo:");

		campoArticulo = new JTextField();
		campoArticulo.setColumns(10);

		lblTamao = new JLabel("Tama\u00F1o:");

		radioGrande = new JRadioButton("Grande");
		radioGrande.setSelected(true);
		buttonGroup.add(radioGrande);

		radioMediano = new JRadioButton("Mediano");
		buttonGroup.add(radioMediano);

		radioPequenio = new JRadioButton("Peque\u00F1o");
		buttonGroup.add(radioPequenio);

		lblPrecio = new JLabel("Precio");

		campoPrecio = new JTextField();
		campoPrecio.setColumns(10);

		botonGuardarArticulo = new JButton("Guardar o modificar precio");
		botonGuardarArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				botonGuardarArticuloPulsado();
			}
		});

		botonBorrarArticulo = new JButton("Borrar art\u00EDculo");
		botonBorrarArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				botonBorrarArticuloPulsado();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(botonGuardarArticulo, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(botonBorrarArticulo, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(lblConcepto, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblTamao)
												.addComponent(lblPrecio, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel.createSequentialGroup()
														.addComponent(radioGrande)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(radioMediano, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(radioPequenio, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
												.addComponent(campoPrecio, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
												.addComponent(campoArticulo, GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE))))
						.addContainerGap())
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblConcepto)
								.addComponent(campoArticulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(campoPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPrecio))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTamao)
								.addComponent(radioGrande)
								.addComponent(radioMediano)
								.addComponent(radioPequenio))
						.addPreferredGap(ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(botonGuardarArticulo)
								.addComponent(botonBorrarArticulo))
						.addContainerGap())
				);
		gl_panel.linkSize(SwingConstants.HORIZONTAL, new Component[] {radioGrande, radioMediano, radioPequenio});
		panel.setLayout(gl_panel);

		panel_1 = new JPanel();
		tabbedPane.addTab("Barra", null, panel_1, null);

		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Consumici\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Cuenta activa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
						.addContainerGap())
				);
		gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
								.addComponent(panel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))
						.addContainerGap())
				);
		panel_3.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel_3.add(scrollPane, BorderLayout.CENTER);

		areaTexto = new JTextArea();
		areaTexto.setEditable(false);
		scrollPane.setViewportView(areaTexto);

		lblSocio = new JLabel("Socio :");

		comboSocios = new JComboBox<Socio>();
		comboSocios.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) 
			{
				comboSocioCambiado();
			}
		});

		lblArtculo = new JLabel("Art\u00EDculo:");

		comboArticulos = new JComboBox<Articulo>();

		lblCantidad = new JLabel("Cantidad:");

		botonPagarCuenta = new JButton("Calcular cuenta del socio");
		botonPagarCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				botonPagarCuentaPulsado();
			}
		});

		botonAniadirConsumicion = new JButton("A\u00F1adir consumici\u00F3n al socio");
		botonAniadirConsumicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				botonAniadirConsumicionPulsado();
			}
		});
		spinnerCantidad.setFont(new Font("Tahoma", Font.PLAIN, 11));

		spinnerCantidad.setModel(new SpinnerNumberModel(1, 0, 10, 1));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSocio, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblArtculo, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCantidad, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
								.addComponent(comboArticulos, 0, 141, Short.MAX_VALUE)
								.addComponent(comboSocios, 0, 189, Short.MAX_VALUE)
								.addComponent(spinnerCantidad)))
						.addComponent(botonPagarCuenta, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
						.addComponent(botonAniadirConsumicion, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSocio)
						.addComponent(comboSocios, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblArtculo)
						.addComponent(comboArticulos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCantidad)
						.addComponent(spinnerCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
					.addComponent(botonAniadirConsumicion)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(botonPagarCuenta))
		);
		panel_2.setLayout(gl_panel_2);
		panel_1.setLayout(gl_panel_1);
	}





	protected void botonPagarCuentaPulsado() 
	{
		if(this.comboSocios.getSelectedIndex()==0)
			this.error("Debe seleccionar un socio.");	
		else
		{
			this.muestraTotalSocio();
		}
	}





	private void muestraTotalSocio() 
	{
	 this.areaTexto.setText(this.controlador.calculaTotal((Socio)this.comboSocios.getSelectedItem()));
	}



	protected void comboSocioCambiado() 
	{
		actualizaAreaTexto();
	}


	protected void botonAniadirConsumicionPulsado() 
	{
		if(this.comboSocios.getSelectedIndex()==0)
			this.error("Debe seleccionar un socio.");	
		else
			if(this.comboArticulos.getSelectedIndex()==0)
				this.error("Debe seleccionar un articulo");
			else
			{
				this.controlador.aniadeConsumicion((Socio)this.comboSocios.getSelectedItem(),
						(Articulo)this.comboArticulos.getSelectedItem(),
						(int)this.spinnerCantidad.getValue());
				this.actualizaAreaTexto();
				this.comboArticulos.setSelectedIndex(0);
				this.spinnerCantidad.setValue(1);
			}
	}



	private void actualizaAreaTexto() 
	{
		this.areaTexto.setText("");
		if((Socio)this.comboSocios.getSelectedItem()!= null)
		{
			LinkedList<Consumicion> listaConsumiciones;
			listaConsumiciones = this.controlador.getListaConsumiciones((Socio)this.comboSocios.getSelectedItem());
			if(listaConsumiciones!=null)
			{
				this.areaTexto.append((Socio)this.comboSocios.getSelectedItem()+"\n");
						for(Consumicion c:listaConsumiciones)
							this.areaTexto.append(c.toString()+"\n");
			}
		}
	}





	protected void botonBorrarArticuloPulsado() 
	{
		if(this.campoArticulo.getText().isEmpty())
			this.error("No puede dejar vacio el nombre del articulo.");
		else
		{
			String tamanio="Pequenio";
			if(this.radioGrande.isSelected())
				tamanio = "Grande";
			else
				if(this.radioMediano.isSelected())
					tamanio = "Mediano";

			if(this.controlador.hayCuentaPendienteConEseArticulo(this.campoArticulo.getText(),tamanio))
				this.error("No puede borrar el articulo porque hay cuentas sin pagar que lo contienen.");
			else

				if(this.controlador.borraArticulo(this.campoArticulo.getText(),tamanio)==false)
					this.error("Ese articulo no existe.");
				else
				{
					this.msg("Articulo borrado.");
					this.limpiaCamposLista();	
					this.actualizaComboArticulos();
				}
		}





	}


	public void actualizaComboArticulos() 
	{
		this.comboArticulos.removeAllItems();
		this.comboArticulos.addItem(new Articulo("seleccione articulo ...",""));
		for(Articulo a:this.controlador.getListaPrecios().keySet())
			this.comboArticulos.addItem(a);

	}

	public void actualizaComboSocios() 
	{
		this.comboSocios.removeAllItems();
		this.comboSocios.addItem(new Socio("seleccione socio ...",0));
		for(Socio s:this.controlador.getListaSocios())
			this.comboSocios.addItem(s);

	}



	protected void botonGuardarArticuloPulsado() 
	{
		if(this.campoArticulo.getText().isEmpty())
			this.error("No puede dejar vacio el nombre del articulo.");
		else
			if(this.campoPrecio.getText().isEmpty())
				this.error("No puede dejar vacio el precio del articulo.");			
			else
			{
				try
				{
					float precio = Float.parseFloat(this.campoPrecio.getText());
					String tamanio="Pequenio";
					if(this.radioGrande.isSelected())
						tamanio = "Grande";
					else
						if(this.radioMediano.isSelected())
							tamanio = "Mediano";

					if(this.controlador.aniadeArticulo(this.campoArticulo.getText(),
							tamanio,
							precio)==false)
						this.msg("Precio del articulo modificado.");
					else
						this.msg("Articulo guardado.");
					this.limpiaCamposLista();	
					this.actualizaComboArticulos();

				}
				catch(NumberFormatException e)
				{
					this.error("Escriba silo numeros en el precio del articulo.");
				}
			}


	}

	private void limpiaCamposLista() 
	{
		this.campoArticulo.setText("");
		this.campoPrecio.setText("");
		this.radioGrande.setSelected(true);
	}


	private void error(String msg)
	{
		JOptionPane.showMessageDialog(this, msg,"Error",JOptionPane.ERROR_MESSAGE);
	}

	private void msg(String msg)
	{
		JOptionPane.showMessageDialog(this, msg,"Correcto",JOptionPane.INFORMATION_MESSAGE);
	}
}
