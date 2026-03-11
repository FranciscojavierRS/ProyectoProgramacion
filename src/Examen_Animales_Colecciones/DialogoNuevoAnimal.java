package Examen_Animales_Colecciones;



import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.Set;
import java.awt.event.ActionEvent;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.AbstractListModel;

public class DialogoNuevoAnimal extends JDialog
{

	private final JPanel contentPanel = new JPanel();
	private Vista vista;
	private JLabel lblAnimal;
	private JTextField campoNombreAnimal;
	private JScrollPane scrollPane;
	private JList<Animal> listaPresas;
	private JLabel lblPresas;
	private JLabel lblrea;
	private JComboBox<Area> comboAreas;
	private DefaultListModel<Animal> modeloLista;
	private JButton btnAcualizarAnimal;

	public DialogoNuevoAnimal(Vista vista)
	{
		setResizable(false);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana.class.getResource("iconos/leon.jpg")));
		setTitle("A\u00F1adir Nuevo Animal");
		this.vista = vista;
		setBounds(100, 100, 385, 240);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		lblAnimal = new JLabel("Animal:");

		campoNombreAnimal = new JTextField();
		campoNombreAnimal.setColumns(10);

		scrollPane = new JScrollPane();

		lblPresas = new JLabel("Presas:");

		lblrea = new JLabel("Area:");

		comboAreas = new JComboBox<Area>();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
										.addComponent(lblAnimal, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
										.addGap(7)
										.addComponent(campoNombreAnimal, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
								.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
										.addComponent(lblrea, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
										.addGap(7)
										.addComponent(comboAreas, 0, 256, Short.MAX_VALUE))
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(lblPresas, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
										.addGap(7)
										.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)))
						.addContainerGap())
				);
		gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAnimal)
								.addComponent(campoNombreAnimal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboAreas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblrea))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPresas))
						.addContainerGap(74, Short.MAX_VALUE))
				);

		this.modeloLista = new DefaultListModel<Animal>();
		listaPresas = new JList<Animal>();
		listaPresas.setModel(this.modeloLista);

		scrollPane.setViewportView(listaPresas);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton botonAnyadir = new JButton("A\u00F1adir animal");
				botonAnyadir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						botonAnyadirPulsado();
					}
				});
				botonAnyadir.setActionCommand("OK");
				buttonPane.add(botonAnyadir);
				getRootPane().setDefaultButton(botonAnyadir);
			}
			{
				JButton botonCancelar = new JButton("Cancelar");
				botonCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						botonCancelarPulsado();
					}
				});

				btnAcualizarAnimal = new JButton("Acualizar animal");
				btnAcualizarAnimal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						botonActualizarPulsado();
					}
				});
				buttonPane.add(btnAcualizarAnimal);

				buttonPane.add(botonCancelar);
			}
		}
	}

	protected void botonActualizarPulsado()
	{
		if(this.campoNombreAnimal.getText().isEmpty())
			this.vista.error(this, "Debe escribir un nombre de animal");
		else
		{
			Animal animalSeleccionado = this.vista.getAnimal(this.campoNombreAnimal.getText());



			if(animalSeleccionado == null)
				this.vista.error(this, "Ese animal no esta en la Reserva");
			else
			{
				if(this.listaPresas.getSelectedValuesList().contains(animalSeleccionado))
					this.vista.error(this, "En esta reserva un animal no puede ser depredador de sny mismo");
				else
				{
					this.vista.actualizaAnimal(animalSeleccionado,this.listaPresas.getSelectedValuesList());
					this.vista.actualizaListadoAreasVentana();
					this.vista.msg(this, "Animal actualizado");
					this.setVisible(false);
				}
			}
		}
	}

	protected void botonAnyadirPulsado()
	{
		if(this.campoNombreAnimal.getText().isEmpty())
			this.vista.error(this, "Debe escribir un nombre de animal");
		else
		{
			if(this.comboAreas.getSelectedIndex()<0)
				this.vista.error(this, "Debe seleccionar un nyrea");
			else

				if(this.vista.anyadeAnimal(this.campoNombreAnimal.getText(),
						(Area)this.comboAreas.getSelectedItem(),
						this.listaPresas.getSelectedValuesList()) == false)
					this.vista.error(this, "Ese animal ya estaba en la Reserva");
				else
				{
					this.vista.msg(this, "Animal almacenado");
					this.vista.actualizaListadoAreasVentana();
					this.setVisible(false);
				}
		}

	}

	protected void botonCancelarPulsado()
	{
		this.setVisible(false);

	}

	public void mostrar()
	{
		this.listaPresas.clearSelection();
		this.setVisible(true);
		this.campoNombreAnimal.setText("");


	}

	public void actualizaListaAnimales()
	{
		this.modeloLista.removeAllElements();

		for(Animal a:this.vista.getListaAnimales())
			this.modeloLista.addElement(a);
	}

	public void actualizaComboAreas()
	{
		Set<Area> lista = this.vista.getListaAreas(); 
		this.comboAreas.removeAllItems();
		for(Area a:lista)
			this.comboAreas.addItem(a);
	}
}
