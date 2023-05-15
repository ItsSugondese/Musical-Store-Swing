import javax.swing.*;
import java.awt.*;

public class AllButtonsPanel extends JPanel {

    //for panel dimensions
    private int width, height;

    //for buttons sizing and spacing
    private int buttonWidth, buttonHeight, gap;

    //buttons that will be needed when renting instruments
    private JButton addInstrumentForRentButton, addInstrumentForSellButton, rentInstrumentButton;

    //buttons that will be needed when selling instruments
    private JButton sellInstrumentButton, returnInstrumentButton;

    //buttons that will be needed when displaying or clearing in text field or text area
    private JButton displayButton, clearButton, clearAllButton;

    //instance of mainframe class
    private MainFrame frame;

    //instance for event listener
    private ActionPerformer actionPerformer;

    public AllButtonsPanel(MainFrame frame, int width, int height){
        this.frame = frame;
        this.width = width;
        this.height = height;

        actionPerformer = new ActionPerformer(frame);


        //this method contains all the panel properties
        panelFeatures();

        //this method contains all the components like label and buttons declaration
        materials();

        //for panel transparency where object isn't present
        setOpaque(false);

    }

    void materials(){
        buttonWidth = 120;
        buttonHeight = 50;
        gap = 10;

        //checking whether renting instrument or selling instrument is selected in radio button
        if(frame.getRadioButtonsPanel().getButtonGroup().getSelection().getActionCommand() =="Selling Instrument"){

            //this method contains buttons like display and clear which will be needed in both renting and selling instrument
            both();

            //this method contains buttons which will be needed only when selling instrument
            selling();
        }else{

            //this method contains buttons like display and clear which will be needed in both renting and selling instrument
            both();

            //this method contains buttons which will be needed only when renting instrument
            renting();
        }



    }


    void both(){

        //for display button declaration, properties and panel adding
        display();

        //for clear button declaration, properties and panel adding
        clear();

        //for clear all button declaration, properties and panel adding
        clearAll();

    }
    void renting(){

        //for add instrument for rent button declaration, properties and panel adding
        addInstrumentForRent();

        //for rent instrument button declaration, properties and panel adding
        rentInstrument();

        //for return instrument declaration, properties and panel adding
        returnInstrument();
    }

    void selling(){

        //for add instrument for sell button declaration, properties and panel adding
        addInstrumentForSell();

        //for sell instrument button declaration, properties and panel adding
        sellInstrument();
    }

    void addInstrumentForRent(){
        addInstrumentForRentButton = new JButton("<html><center>Add Instrument <br>For Rent</center></html>");
        addInstrumentForRentButton.setName("Add Instrument For Rent");
        addInstrumentForRentButton.setBounds(width/2 - buttonWidth - buttonWidth/2 - 100,
                frame.getRentSellPanel().getRentDateLabel().getY() + 40*2, buttonWidth, buttonHeight);
        addInstrumentForRentButton.addActionListener(actionPerformer);

        add(addInstrumentForRentButton);

    }

    void addInstrumentForSell(){
        addInstrumentForSellButton = new JButton("<html><center>Add Instrument <br>For Sell</center></html>");
        addInstrumentForSellButton.setName("Add Instrument For Sell");
        addInstrumentForSellButton.setBounds(width/2 - buttonWidth - 50,
                frame.getRentSellPanel().getSellingDateLabel().getY() + 40*2, buttonWidth, buttonHeight);
        addInstrumentForSellButton.addActionListener(actionPerformer);

        add(addInstrumentForSellButton);
    }

    void rentInstrument(){
        rentInstrumentButton = new JButton("<html><center>Rent <br>Instrument</center></html>");
        rentInstrumentButton.setName("Rent Instrument");
        rentInstrumentButton.setBounds(width/2 - buttonWidth/2,
                addInstrumentForRentButton.getY(), buttonWidth, buttonHeight);
        rentInstrumentButton.addActionListener(actionPerformer);

        add(rentInstrumentButton);
    }

    void sellInstrument(){
        sellInstrumentButton = new JButton("<html><center>Sell <br>Instrument</center></html>");
        sellInstrumentButton.setName("Sell Instrument");
        sellInstrumentButton.setBounds(width/2 + 50,
                addInstrumentForSellButton.getY(), buttonWidth, buttonHeight);
        sellInstrumentButton.addActionListener(actionPerformer);

        add(sellInstrumentButton);
    }

    void returnInstrument(){
            returnInstrumentButton = new JButton("<html><center>Return <br>Instrument</center></html>");
            returnInstrumentButton.setName("Return Instrument");
            returnInstrumentButton.setBounds(width/2 + buttonWidth/2 + 100,
                    addInstrumentForRentButton.getY(), buttonWidth, buttonHeight);
            returnInstrumentButton.addActionListener(actionPerformer);

            add(returnInstrumentButton);
    }

    void display(){
        displayButton = new JButton("Display");
        displayButton.setName("Display");
//        displayButton.setBounds((width/2 - (int)(buttonWidth/1.5) - gap ),
        displayButton.setBounds((width/2 - (int)((buttonWidth/1.5)/2) - gap*2 - (int)(buttonWidth/1.5) ),
                (frame.getRentSellPanel().getCustomerPanNumberLabel().getY() + 40 * 4) + buttonHeight + 20,
                (int)(buttonWidth/1.5), buttonHeight/2);
        displayButton.addActionListener(actionPerformer);

        add(displayButton);
    }
    
    void clear(){
        clearButton = new JButton("Clear");
        clearButton.setName("Clear");
//        clearButton.setBounds(width/2 + gap,
        clearButton.setBounds((width/2 - (int)((buttonWidth/1.5)/2)),
                displayButton.getY(), (int)(buttonWidth/1.5), buttonHeight/2);
        clearButton.addActionListener(actionPerformer);

        add(clearButton);
    }

    void clearAll(){
        clearAllButton = new JButton("Clear All");
        clearAllButton.setName("Clear All");
        clearAllButton.setBounds((width/2 + (int)((buttonWidth/1.5)/2)) + gap *2,
                displayButton.getY(), (int) (buttonWidth/1.4), buttonHeight/2);
        clearAllButton.addActionListener(actionPerformer);

        add(clearAllButton);
    }



    void panelFeatures() {
        setSize(new Dimension(width, height));
        setLayout(null);
        setOpaque(false);

    }


    //getters and setters for all the components of this class
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

    public int getButtonWidth() {
        return buttonWidth;
    }

    public void setButtonWidth(int buttonWidth) {
        this.buttonWidth = buttonWidth;
    }

    public int getButtonHeight() {
        return buttonHeight;
    }

    public void setButtonHeight(int buttonHeight) {
        this.buttonHeight = buttonHeight;
    }

    public int getGap() {
        return gap;
    }

    public void setGap(int gap) {
        this.gap = gap;
    }

    public JButton getAddInstrumentForRentButton() {
        return addInstrumentForRentButton;
    }

    public void setAddInstrumentForRentButton(JButton addInstrumentForRentButton) {
        this.addInstrumentForRentButton = addInstrumentForRentButton;
    }

    public JButton getAddInstrumentForSellButton() {
        return addInstrumentForSellButton;
    }

    public void setAddInstrumentForSellButton(JButton addInstrumentForSellButton) {
        this.addInstrumentForSellButton = addInstrumentForSellButton;
    }

    public JButton getRentInstrumentButton() {
        return rentInstrumentButton;
    }

    public void setRentInstrumentButton(JButton rentInstrumentButton) {
        this.rentInstrumentButton = rentInstrumentButton;
    }

    public JButton getSellInstrumentButton() {
        return sellInstrumentButton;
    }

    public void setSellInstrumentButton(JButton sellInstrumentButton) {
        this.sellInstrumentButton = sellInstrumentButton;
    }

    public JButton getReturnInstrumentButton() {
        return returnInstrumentButton;
    }

    public void setReturnInstrumentButton(JButton returnInstrumentButton) {
        this.returnInstrumentButton = returnInstrumentButton;
    }

    public JButton getDisplayButton() {
        return displayButton;
    }

    public void setDisplayButton(JButton displayButton) {
        this.displayButton = displayButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public void setClearButton(JButton clearButton) {
        this.clearButton = clearButton;
    }

    public MainFrame getFrame() {
        return frame;
    }

    public void setFrame(MainFrame frame) {
        this.frame = frame;
    }
}
