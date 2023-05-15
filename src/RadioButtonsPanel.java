import javax.swing.*;
import java.awt.*;

public class RadioButtonsPanel extends JPanel {

    //instance of mainframe class
    private MainFrame frame;

    //insatance for event listener
    private ActionPerformer actionPerformer;

    //for panel dimension
    private int width, height;

    //for radion button sizing
    private int radioWidth, radioHeight;

    //for going back in homepage panel
    private JButton backButton;

    //radio buttons
    private JRadioButton rentInstrumentRadio, sellInstrumentRadio;

    //button gorup for above radio buttons
    private ButtonGroup buttonGroup;

    //for knowing which radio button to select
    private String choose;

    public RadioButtonsPanel(String choose, MainFrame frame, int width, int height){
      this.frame = frame;
      this.width = width;
      this.height = height;

      this.choose = choose;

      actionPerformer = new ActionPerformer(frame);
      buttonGroup = new ButtonGroup();

      rentInstrumentRadio = new JRadioButton("Renting Instrument");
      sellInstrumentRadio = new JRadioButton("Selling Instrument");


      //this method contains all the panel properties
      panelFeatures();

      //this method contains all the components like radio buttons and buttons declaration
      materials();

    }

    void materials(){
        radioWidth = 135;
        radioHeight = 20;

        //here, the value of choose is taken when user clicks a button of options in homepage
        if(choose.equals("Sell an Instrument")){
            sellInstrumentRadio.setSelected(true);
        }else {
            rentInstrumentRadio.setSelected(true);
        }

        //for rent Instrument radio button declaration, properties and panel adding
        rentInstrument();

        //for sell instrument radio button declaration, properties and panel adding
        sellInstrument();
        back();
    }

    void rentInstrument(){
        rentInstrumentRadio.setBounds(width/2 - radioWidth - 20, 20, radioWidth,radioHeight);
        rentInstrumentRadio.setActionCommand("Renting Instrument");
        rentInstrumentRadio.addActionListener(actionPerformer);
        buttonGroup.add(rentInstrumentRadio);
        add(rentInstrumentRadio);

    }

    void sellInstrument(){
        sellInstrumentRadio.setBounds(rentInstrumentRadio.getX() + radioWidth + 20,
                rentInstrumentRadio.getY(), radioWidth, radioHeight);
        sellInstrumentRadio.addActionListener(actionPerformer);
        sellInstrumentRadio.setActionCommand("Selling Instrument");
        buttonGroup.add(sellInstrumentRadio);
        add(sellInstrumentRadio);
    }

    void back(){
        backButton = new JButton("Back");
        backButton.setBounds(10,
                rentInstrumentRadio.getY()-5, 90, 30);
        backButton.setBackground(new Color(59, 89, 182));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setFont(new Font("Tahoma", Font.BOLD, 12));

        backButton.setName("Back");
        backButton.addActionListener(actionPerformer);
        add(backButton);
    }

    void panelFeatures() {
        setSize(new Dimension(width, height));
        setLayout(null);
        setOpaque(false);
    }


    //getters and setters for all the components of this class
    public MainFrame getFrame() {
        return frame;
    }

    public void setFrame(MainFrame frame) {
        this.frame = frame;
    }

    public ActionPerformer getActionPerformer() {
        return actionPerformer;
    }

    public void setActionPerformer(ActionPerformer actionPerformer) {
        this.actionPerformer = actionPerformer;
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

    public int getRadioWidth() {
        return radioWidth;
    }

    public void setRadioWidth(int radioWidth) {
        this.radioWidth = radioWidth;
    }

    public int getRadioHeight() {
        return radioHeight;
    }

    public void setRadioHeight(int radioHeight) {
        this.radioHeight = radioHeight;
    }

    public JRadioButton getRentInstrumentRadio() {
        return rentInstrumentRadio;
    }

    public void setRentInstrumentRadio(JRadioButton rentInstrumentRadio) {
        this.rentInstrumentRadio = rentInstrumentRadio;
    }

    public JRadioButton getSellInstrumentRadio() {
        return sellInstrumentRadio;
    }

    public void setSellInstrumentRadio(JRadioButton sellInstrumentRadio) {
        this.sellInstrumentRadio = sellInstrumentRadio;
    }

    public ButtonGroup getButtonGroup() {
        return buttonGroup;
    }

    public void setButtonGroup(ButtonGroup buttonGroup) {
        this.buttonGroup = buttonGroup;
    }
}
