import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;


import javax.swing.JFrame;

public class SarangiSansar {
	public static void main(String[] args) {

		//making object of mainframe class and setting width and height
		MainFrame mainFrame = new MainFrame(730, 700);
	}
}

class MainFrame extends JFrame {

	//Creating ArrayList using list interface
	private List<Instrument> instrumentList;

	//panels to add in frame
	private RentSellPanel rentSellPanel;
	private AllButtonsPanel allButtonsPanel;
	private DisplayPanel displayPanel;
	private RadioButtonsPanel radioButtonsPanel;
	private HomePage homePage;

	//for dimension of frame
	private int width, height;

	public MainFrame(int width, int height) {

		//creating homepage class object and initializing mainframe object, width and height value
		homePage = new HomePage(this, width, height);
		//creating arrayList
		instrumentList = new ArrayList<>();

		//setting value in variable to use in dimension
		this.width = width;
		this.height = height;

		//this method contains all the features of JFrame
		frameFeatures();

		//adding homepage panel object in frame
		add(homePage);


		//setting frame visibility to true
		setVisible(true);
	}

	void frameFeatures() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(width, height));
		setResizable(false);
		setLayout(null);
		setTitle("Sarangi Sansar");
	}


	//getters and setters for all the components of this class
	public RentSellPanel getRentSellPanel() {
		return rentSellPanel;
	}

	public void setRentSellPanel(RentSellPanel rentSellPanel) {
		this.rentSellPanel = rentSellPanel;
	}

	@Override
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public AllButtonsPanel getAllButtonsPanel() {
		return allButtonsPanel;
	}

	public void setAllButtonsPanel(AllButtonsPanel allButtonsPanel) {
		this.allButtonsPanel = allButtonsPanel;
	}

	public DisplayPanel getDisplayPanel() {
		return displayPanel;
	}

	public void setDisplayPanel(DisplayPanel displayPanel) {
		this.displayPanel = displayPanel;
	}

	public List<Instrument> getInstrumentList() {
		return instrumentList;
	}

	public void setInstrumentList(List<Instrument> instrumentList) {
		this.instrumentList = instrumentList;
	}

	public RadioButtonsPanel getRadioButtonsPanel() {
		return radioButtonsPanel;
	}

	public void setRadioButtonsPanel(RadioButtonsPanel radioButtonsPanel) {
		this.radioButtonsPanel = radioButtonsPanel;
	}

	public HomePage getHomePage() {
		return homePage;
	}

	public void setHomePage(HomePage homePage) {
		this.homePage = homePage;
	}
}
