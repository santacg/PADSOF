package GUI.vistas;

import javax.swing.*;

import java.awt.*;

import GUI.controlador.*;

public class Ventana extends JFrame {

	private JPanel cartas;
	private String cartaPrevia, cartaActual;

	private final static String LOGINGESTOR = "logInGestor";
	private final static String LOGINEMPLEADO = "logInEmpleado";
	private final static String EXPOSICIONES = "exposiciones";
	private final static String REGISTRO = "registro";
	private final static String PANELPRINCIPAL = "panelPrincipal";

	private final static String EMPLEADOPRINCIPAL = "empleadoPrincipal";
	private final static String CLIENTEPRINCIPAL = "clientePrincipal";

	private ControladorPantallaPrincipal controladorPantallaPrincipal;
	private PantallaPrincipal vistaPantallaPrincipal;

	private LoginEmpleado vistaLoginEmpleado;

	private LoginGestor vistaLoginGestor;

	private RegistroUsuario vistaRegistro;
	private ControladorRegistro controladorRegistro;

	private BusquedaExposiciones vistaExposiciones;

	private EmpleadoPrincipal vistaEmpleadoPrincipal;

	private ClientePrincipal vistaClientePrincipal;

	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		cartas = new JPanel();
		cartas.setLayout(new CardLayout());

		this.vistaPantallaPrincipal = new PantallaPrincipal();
		cartas.add(vistaPantallaPrincipal, PANELPRINCIPAL);

		this.vistaLoginEmpleado = new LoginEmpleado();
		cartas.add(vistaLoginEmpleado, LOGINEMPLEADO);

		this.vistaLoginGestor = new LoginGestor();
		cartas.add(vistaLoginGestor, LOGINGESTOR);

		this.vistaRegistro = new RegistroUsuario();
		cartas.add(vistaRegistro, REGISTRO);

		this.vistaExposiciones = new BusquedaExposiciones();
		cartas.add(vistaExposiciones, EXPOSICIONES);

		this.vistaEmpleadoPrincipal = new EmpleadoPrincipal();
		cartas.add(vistaExposiciones, EMPLEADOPRINCIPAL);

		this.vistaClientePrincipal = new ClientePrincipal();
		cartas.add(vistaClientePrincipal, CLIENTEPRINCIPAL);

		setContentPane(cartas);
	}

	public String getPanelPrincipal() {
		return PANELPRINCIPAL;
	}

	public PantallaPrincipal getVistaPantallaPrincipal() {
		return vistaPantallaPrincipal;
	}

	public RegistroUsuario getVistaRegistro() {
		return vistaRegistro;
	}

	public String getLogInGestor() {
		return LOGINGESTOR;
	}

	public String getLogInEmpleado() {
		return LOGINEMPLEADO;
	}

	public String getExposiciones() {
		return EXPOSICIONES;
	}

	public String getRegistro() {
		return REGISTRO;
	}

	public String getEmpleadoPrincipal() {
		return EMPLEADOPRINCIPAL;
	}

	public String getClientePrincipal() {
		return CLIENTEPRINCIPAL;
	}

	public JPanel getCardByName(String name) {
		for (Component comp : cartas.getComponents()) {
			if (comp.getName() != null && comp.getName().equals(name)) {
				return (JPanel) comp;
			}
		}
		return null;
	}

	public void setControlador(Controlador controlador) {
		this.controladorPantallaPrincipal = controlador.getControladorPantallaPrincipal();
		this.vistaPantallaPrincipal.setControlador(
				controladorPantallaPrincipal.getBuscaListener(),
				controladorPantallaPrincipal.getAcceptListener(),
				controladorPantallaPrincipal.getGestorListener(),
				controladorPantallaPrincipal.getEmpleadoListener(),
				controladorPantallaPrincipal.getRegistrarListener());

		this.controladorRegistro = controlador.getControladorRegistro();
		this.vistaRegistro.setControlador(controladorRegistro.getRegistrarListener(),
				controladorRegistro.getCancelarListener());
	}

	public void mostrarPanel(String carta) {
		cartaPrevia = cartaActual;
		cartaActual = carta;

		CardLayout l = (CardLayout) cartas.getLayout();
		l.show(cartas, carta);
	}

	public void mostrarPanelPrevio() {
		if (cartaPrevia != null) {
			mostrarPanel(cartaActual);
		}
	}

	public void panelPrevio() {
		String carta_aux;
		CardLayout l = (CardLayout) cartas.getLayout();
		l.show(cartas, cartaPrevia);
		carta_aux = cartaPrevia;
		cartaPrevia = cartaActual;
		cartaActual = carta_aux;
	}

}
