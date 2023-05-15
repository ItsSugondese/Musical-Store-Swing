import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ActionPerformer implements ActionListener {

    //instrance of mainframe class
    private MainFrame frame;

    //for text decoration using HTML
    String startHtml, endHtml;


    public ActionPerformer(MainFrame frame){
        this.frame = frame;
        startHtml = "<html> <head> <style> " +
                "h3{" +
                "text-align:center;" +
                "margin-top:0px;" +
                "font-family: \"Comic Sans MS\", \"Comic Sans\", cursive;} " +
                "</style> " +
                "</head> <body><h3>";
        endHtml = "</h3> </body></html>";
    }


    //this is where all the action is performed when any button is pressed in the UI
    @Override
    public void actionPerformed(ActionEvent e) {
        //for storing pressed buttons value
        String value;

        //checking if user selected renting instrument or selling instrument radio button
        if(e.getActionCommand().equals("Renting Instrument") || e.getActionCommand().equals("Selling Instrument")){

            //removing current panel from the frame
            frame.remove(getRentSellPanel());
            frame.remove(getAllButtonsPanel());
            frame.remove(getDisplayPanel());

            //making new object of removed class and declaring it in mainframe class using setting method
            frame.setRentSellPanel(new RentSellPanel(frame, frame.getWidth(), frame.getHeight()));
            frame.setAllButtonsPanel(new AllButtonsPanel(frame, frame.getWidth(), frame.getHeight()));
            frame.setDisplayPanel(new DisplayPanel(frame, frame.getWidth(), frame.getHeight()));

            //adding the newly created object inside JFrame
            frame.add(frame.getRentSellPanel());
            frame.add(frame.getAllButtonsPanel());
            frame.add(frame.getDisplayPanel());

            //refreshing the frame
            SwingUtilities.updateComponentTreeUI(frame);
        }else {
            value = ((JButton) e.getSource()).getName();

            //checking if user clicked renting instrument or selling instrument button in homepage
            if(value.equals("Rent an Instrument") || value.equals("Sell an Instrument")){

                //removing current panel from the frame
                frame.remove(getHomePage());

                //making new object of needed class and declaring it in mainframe class using setting method
                frame.setRadioButtonsPanel(new RadioButtonsPanel(value, frame, frame.getWidth(), frame.getHeight()));
                frame.setRentSellPanel(new RentSellPanel(frame, frame.getWidth(), frame.getHeight()));
                frame.setAllButtonsPanel(new AllButtonsPanel(frame, frame.getWidth(), frame.getHeight()));
                frame.setDisplayPanel(new DisplayPanel(frame, frame.getWidth(), frame.getHeight()));

                //adding the newly created object inside JFrame
                frame.add(getRadioButtonsPanel());
                frame.add(getRentSellPanel());
                frame.add(getAllButtonsPanel());
                frame.add(getDisplayPanel());

                SwingUtilities.updateComponentTreeUI(frame);

            }
            else {


                //Looping through all the components (like label, text field) of presents in  Rent Sell Panel
                for (Component comp : getRentSellPanel().getComponents())
                {
                    //cheking whether the current index comp is JTextField or not
                    if (comp instanceof JTextField)
                    {
                        //removing the red color from border
                        ((JTextField) comp).setBorder(new LineBorder(null));
                        SwingUtilities.updateComponentTreeUI(frame);
                    }
                }
                //the above code is so that the red color won't stay on border if user try to perform other action



                if(value.equals("Add Instrument For Rent")) {

                    //contains action when InstrumentForRent button is clicked
                    addInstrumentForRentAction();
                }

                else if(value.equals("Rent Instrument")){

                    //contain action when rentInstrument Button is clicked
                    rentInstrumentAction();
                }

                else if(value.equals("Return Instrument")){

                    //contain action when return instrument button is clicked
                    returnInstrumentAction();
                }

                else if(value.equals("Add Instrument For Sell")){

                    //contain action when addInstrumentForSell button is clicked
                    addInstrumentForSellAction();
                }

                else if(value.equals("Sell Instrument")){

                    //contain action when sellInstrumentAction button is clicked
                    sellInstrumentAction();
                }

                else if(value.equals("Display")){

                    //contain action when display button is clicked
                    //in parenthesis, extracting value using which radio button is being selected
                    displayAction(getButtonGroup().getSelection().getActionCommand());


                }

                else if(value.equals("Clear")){

                    //clearing everything written in text area when clear button is clicked
                    getDisplayArea().setText("");
                }

                else if(value.equals("Clear All")){

                    //contain action when clearAll button is clicked
                    clearAllAction();
                }
                else if(value.equals("Back")){

                    //action when clicked back button

                    //removing current panel from the frame
                    frame.remove(getRadioButtonsPanel());
                    frame.remove(getRentSellPanel());
                    frame.remove(getAllButtonsPanel());
                    frame.remove(getDisplayPanel());

                    //making new object of needed class and declaring it in mainframe class using setting method
                    frame.setHomePage(new HomePage(frame, frame.getWidth(), frame.getHeight()));

                    //adding the newly created object inside JFrame
                    frame.add(getHomePage());
                    SwingUtilities.updateComponentTreeUI(frame);
                }

            }
        }




    }




    void addInstrumentForRentAction(){

        //checking whether instrument field and charge per day field is empty or not
        if(!getInstrumentNameField().getText().isEmpty() &&
                !getChargePerDayField().getText().isEmpty()) {
            boolean exist = false;

            //checking if the current inserted instrument name value in instrument name field already exist in list or not
            for(Instrument instrument : frame.getInstrumentList()){
                if(instrument instanceof InstrumentToRent) {
                    if (instrument.getInstrumentName().equals(getInstrumentNameField().getText())) {
                        exist = true;
                    }
                }
            }

            //creating object of InstrumentToRent class and adding in Array List of Instrument class
            if(!exist) {
                getInstrumentList().add(new InstrumentToRent(
                        getInstrumentNameField().getText(),
                        Integer.parseInt(getChargePerDayField().getText())));


                //calling display method of Instrument To Rent class
                ((InstrumentToRent) getInstrumentList().get(frame.getInstrumentList().size() - 1)).display();

            }

            //refreshing the frame
            SwingUtilities.updateComponentTreeUI(frame);
        }else{

            //making border color red if charge per day and instrument name field is empty
            getChargePerDayField().setBorder(new LineBorder(Color.RED, 2));
            getInstrumentNameField().setBorder(new LineBorder(Color.RED, 2));

            //refreshing JFrame
            SwingUtilities.updateComponentTreeUI(frame);

            //alerting user when charge per day and instrument name field is left empty
            dialogPopper("The Highlighted Field shouldn't be empty inorder to add instrument for rent");

        }

    }



    void rentInstrumentAction(){

        //checking whether instrument name, customer name, customer phone, customer pan and no. of days field is empty or not
        if(!getInstrumentNameField().getText().isEmpty() &&
                !getCustomerNameField().getText().isEmpty() &&
                !getCustomerPhoneField().getText().isEmpty() &&
                !getCustomerPanNumberField().getText().isEmpty() &&
                !getNoOfDaysField().getText().isEmpty()){

            //for checking if instrument name inserted in instrument name field exist in array list or not
            boolean foundInstrument = false;

            //checking if the current inserted instrument name value in instrument name field already exist in list or not
            for(Instrument instrument : getInstrumentList()) {
                if(instrument instanceof InstrumentToRent){
                if (instrument.getInstrumentName().equals(getInstrumentNameField().getText())) {
                    foundInstrument = true;


                    //calling renting Instrument method of InstrumentToRent class
                    ((InstrumentToRent) instrument).rentingInstrument(
                            getCustomerNameField().getText(),
                            getCustomerPhoneField().getText(),
                            Integer.parseInt(getCustomerPanNumberField().getText()),
                            dateValue("Rent"),
                            dateValue("Return"),
                            Integer.parseInt(getNoOfDaysField().getText())
                    );

                    //calling display method of Instrument To Rent class
                    ((InstrumentToRent) getInstrumentList().get(getInstrumentList().size() - 1)).display();

                    getDisplayArea().setText(
                            startHtml + "The instrument is " + instrument.getInstrumentName() +
                                    " and the charge per day is " + ((InstrumentToRent) instrument).getChargePerDay() + endHtml
                    );

                }
                }
            }
            if(!foundInstrument){
                getDisplayArea().setText(startHtml +
                        "Sorry but there doesn't exist Instrument of that name" + endHtml);
            }

        }else{
            //making border color red of the required field if left empty
            getInstrumentNameField().setBorder(new LineBorder(Color.RED, 2));
            getCustomerNameField().setBorder(new LineBorder(Color.RED, 2));
            getCustomerPhoneField().setBorder(new LineBorder(Color.RED, 2));
            getCustomerPanNumberField().setBorder(new LineBorder(Color.RED, 2));
            getNoOfDaysField().setBorder(new LineBorder(Color.RED, 2));

            //refreshing the frame
            SwingUtilities.updateComponentTreeUI(frame);

            //alerting user not to leave the needed field empty
            dialogPopper("The highlighted field shouldn't be empty inorder to rent Instrument");

        }
    }

    void returnInstrumentAction(){

        //checking whether instrument name field is empty or not
        if(!getInstrumentNameField().getText().isEmpty()){

            //for checking if the inserted instrument name in instrument name field exist in list or not
            boolean foundInstrument = false;

            //checking if the current inserted instrument name value in instrument name field already exist in list or not
            for(Instrument instrument : getInstrumentList()) {

                if(instrument instanceof InstrumentToRent){
                if (instrument.getInstrumentName().equals(getInstrumentNameField().getText())) {

                    if (!((InstrumentToRent) instrument).isRented()) {
                        getDisplayArea().setText(startHtml +
                                "Sorry but the instrument of that index hasn't been rented yet" + endHtml);
                    } else {
                        foundInstrument = true;
                        ((InstrumentToRent) instrument).instrumentReturn();
                        getDisplayArea().setText(
                                startHtml + "Name of the instrument is " + instrument.getInstrumentName() +
                                        " and its price is Rs. " + ((InstrumentToRent) instrument).getChargePerDay() + endHtml
                        );


                    }
                }
            }
            }
            if(!foundInstrument){
               getDisplayArea().setText(startHtml +
                        "Sorry but the instrument of that index hasn't been rented yet" + endHtml);
            }

        }else{
            //making border of instrument name red if left empty
            getInstrumentNameField().setBorder(new LineBorder(Color.RED, 2));

            //refreshing the frame
            SwingUtilities.updateComponentTreeUI(frame);

            //alerting user not to left instrument name empty
            dialogPopper("The highlighted field shoulnd't be empty inorder to return Instrument");

        }
    }


    void addInstrumentForSellAction() {

        //checking whether instrument name and price field is left empty or not
        if (!getInstrumentNameField().getText().isEmpty() &&
                !getPriceField().getText().isEmpty()) {

            //to check if the instrumet name vlaue inserted in instrument name field exist in array list or not
            boolean exist = false;

            //checking if the current inserted instrument name value in instrument name field already exist in list or not
            for(Instrument instrument : getInstrumentList()){
                if(instrument instanceof InstrumentToSell) {
                    if (instrument.getInstrumentName().equals(getInstrumentNameField().getText())) {
                        exist = true;
                    }
                }
            }

            //creating object of InstrumentToSell class and adding in Array List of Instrument class
            if(!exist) {
                getInstrumentList().add(new InstrumentToSell(
                        getInstrumentNameField().getText(),
                        Integer.parseInt(getPriceField().getText())));


                //calling display method of InstrumentToSell class
                ((InstrumentToSell) getInstrumentList().get(getInstrumentList().size() - 1)).display();

            }

            //refreshing the frame
            SwingUtilities.updateComponentTreeUI(frame);
        }else{

            //making price and instrument name field border red if left empty
            getPriceField().setBorder(new LineBorder(Color.RED, 2));
            getInstrumentNameField().setBorder(new LineBorder(Color.RED, 2));

            //refreshing the frame
            SwingUtilities.updateComponentTreeUI(frame);

            //alerting the user not to leave instrument name and price field empty
            dialogPopper("The Highlighted Field shouldn't be empty inorder to add instrument for Sell");

        }
    }


    void sellInstrumentAction(){

        //checking whether instrument name, customer name, customer phone, customer pan and discount percent field is left empty or not
        if(!getInstrumentNameField().getText().isEmpty() &&
                !getCustomerNameField().getText().isEmpty() &&
                !getCustomerPhoneField().getText().isEmpty() &&
                !getCustomerPanNumberField().getText().isEmpty() &&
                !getDiscountPercentField().getText().isEmpty()){

            //to check if in instrument name inserted in instrument name field exist in list or not
            boolean foundInstrument = false;

            //checkinn if the instrument name inserted in instrument name field exist in list or not
            for(Instrument instrument : getInstrumentList()) {
                if(instrument instanceof InstrumentToSell){
                    if (instrument.getInstrumentName().equals(getInstrumentNameField())) {
                        foundInstrument = true;

                        //calling sell instrument method of InstrumentToSell class
                        ((InstrumentToSell) instrument).sellInstruments(
                                getCustomerNameField().getText(),
                                getCustomerPhoneField().getText(),
                                Integer.parseInt(getCustomerPanNumberField().getText()),
                                date("Year", "Sell") + "-"  + date("Month", "Sell") +  "-"
                                + date("Day", "Sell"),
                                Integer.parseInt(getDiscountPercentField().getText())
                        );

                        //calling display method of Instrument To Rent class
                        ((InstrumentToSell) getInstrumentList().get(getInstrumentList().size() - 1)).display();

                        getDisplayArea().setText(
                                startHtml + "The instrument is " + instrument.getInstrumentName() +
                                        " and the price is " + ((InstrumentToSell) instrument).getPrice() + endHtml
                        );

                    }
                }
            }

            //alerting user when instrument of that name is not found in list
            if(!foundInstrument){
                getDisplayArea().setText(startHtml +
                        "Sorry but there doesn't exist Instrument in that index" + endHtml);
            }

        }else{

            //making border red of the needed field if left empty
            getInstrumentNameField().setBorder(new LineBorder(Color.RED, 2));
            getCustomerNameField().setBorder(new LineBorder(Color.RED, 2));
            getCustomerPhoneField().setBorder(new LineBorder(Color.RED, 2));
            getCustomerPanNumberField().setBorder(new LineBorder(Color.RED, 2));
            getDiscountPercentField().setBorder(new LineBorder(Color.RED, 2));

            //refreshing the frame
                SwingUtilities.updateComponentTreeUI(frame);

                //alerting user not to leave required field empty
            dialogPopper("The highlighted field should't be empty inorder to sell Instrument");

        }
    }

    void displayAction(String option){
        String displayRentValue = "";
        int i =1;
        if(option.equals("Renting Instrument")) {


            for (Instrument instrument : getInstrumentList()) {

                //checking if current index is instance of instrument to rent class or not
                if (instrument instanceof InstrumentToRent) {
                    //concating value of rentDisplay method in displayRentValue
                   displayRentValue += rentDisplay(instrument, i);
                   i++;
                }
            }
            getDisplayArea().setText(startHtml + displayRentValue + endHtml);
        }else if(option.equals("Selling Instrument")){
            for (Instrument instrument : getInstrumentList()) {

                //checking if current index is instance of instrument to sell class or not
                if (instrument instanceof InstrumentToSell) {

                    //concating value of sellDisplay method in displayRentValue
                    displayRentValue += sellDisplay(instrument, i);
                    i++;
                }
            }
            getDisplayArea().setText(startHtml + displayRentValue + endHtml);
        }


    }

    String rentDisplay(Instrument instrument, int i) {
        String str = "";
        if (i > 1)
            str += "<br>";

        str += i + ".";

        str += " " + instrument.getInstrumentName() + ".";
        if (!instrument.getCustomerName().isEmpty())
            str = str + " Name: " + instrument.getCustomerName() + ".";
        if (!instrument.getCustomerMobileNumber().isEmpty())
            str += " Contact no.: " + instrument.getCustomerMobileNumber() + ".";
        if (instrument.getPAN_number() > 0)
            str += " PAN No.: " + instrument.getPAN_number();
        if (((InstrumentToRent) instrument).isRented())
            str += " Rented date: " + ((InstrumentToRent) instrument).getDateOfRent() + " & Return date: " +
                    ((InstrumentToRent) instrument).getDateOfReturn() + ".";
            return str;
    }

    String sellDisplay(Instrument instrument, int i){
        String str = "";
        if(((InstrumentToSell) instrument).isSold()) {
            if (i > 1)
            str += "\n";

             str += i + ".";
            if (!instrument.getCustomerName().isEmpty())
                str = str + " Name: " + instrument.getCustomerName() + ".";
            if (!instrument.getCustomerMobileNumber().isEmpty())
                str += " Contact no.: " + instrument.getCustomerMobileNumber() + ".";
            if (instrument.getPAN_number() > 0)
                str += " PAN No.: " + instrument.getPAN_number();
            str +="Sold on "+ ((InstrumentToSell) instrument).getSellDate();
            str +="Price of instrument: " + ((InstrumentToSell) instrument).getPrice();
        }else
            str += "Price of the " + instrument.getInstrumentName() +  " is Rs."+ ((InstrumentToSell) instrument).getPrice() + ".";
        return str;
    }


    void dialogPopper(String message){
        JOptionPane.showMessageDialog(frame.getContentPane(),
                message,
                "Validation",
                JOptionPane.WARNING_MESSAGE);
    }

    String dateValue(String condition) {
        if (condition.equals("Rent") || condition.equals("rent")) {
            return (String) frame.getRentSellPanel().getRentDateYearComboBox().getItemAt(
                    frame.getRentSellPanel().getRentDateYearComboBox().getSelectedIndex()) + "-" +
                    (String) frame.getRentSellPanel().getRentDateMonthComboBox().getItemAt(
                            frame.getRentSellPanel().getRentDateMonthComboBox().getSelectedIndex()) + "-" +
                    (String) frame.getRentSellPanel().getRentDateDayComboBox().getItemAt(
                            frame.getRentSellPanel().getRentDateDayComboBox().getSelectedIndex());
        } else if (condition.equals("Return") || condition.equals("return")) {
            return (String) frame.getRentSellPanel().getRentDateYearComboBox().getItemAt(
                    frame.getRentSellPanel().getReturnDateYearComboBox().getSelectedIndex()) + "-" +
                    (String) frame.getRentSellPanel().getReturnDateMonthComboBox().getItemAt(
                            frame.getRentSellPanel().getReturnDateMonthComboBox().getSelectedIndex()) + "-" +
                    (String) frame.getRentSellPanel().getReturnDateDayComboBox().getItemAt(
                            frame.getRentSellPanel().getReturnDateDayComboBox().getSelectedIndex());
        }else if (condition.equals("Sell") || condition.equals("sell")) {
            return (String) frame.getRentSellPanel().getSellingDateYearComboBox().getItemAt(
                    frame.getRentSellPanel().getSellingDateYearComboBox().getSelectedIndex()) + "-" +
                    (String) frame.getRentSellPanel().getSellingDateMonthComboBox().getItemAt(
                            frame.getRentSellPanel().getSellingDateMonthComboBox().getSelectedIndex()) + "-" +
                    (String) frame.getRentSellPanel().getSellingDateDayComboBox().getItemAt(
                            frame.getRentSellPanel().getSellingDateDayComboBox().getSelectedIndex());
        }  else {
            return "";
        }
    }

    void clearAllAction(){
        getInstrumentNameField().setText("");
        getCustomerNameField().setText("");
        getCustomerPanNumberField().setText("");
        getCustomerPhoneField().setText("");
        getDisplayArea().setText("");

        if(getRentInstrumentRadio().isSelected()){
            getChargePerDayField().setText("");
            getNoOfDaysField().setText("");
        }
        else if(getSellInstrumentRadio().isSelected()){
            getPriceField().setText("");
            getDiscountPercentField().setText("");
        }
    }

    int noOfdays(){
        return (Integer.parseInt(date("Day", "Return")) - Integer.parseInt(date("Day", "Rent")))
                +
                (Integer.parseInt(date("Month", "Return")) - Integer.parseInt(date("Month", "Rent")))*30
                +
                (Integer.parseInt(date("Year", "Return")) -
                        Integer.parseInt(date("Year", "Rent"))) * 30 * 12;
    }



    String date(String time, String label){
        if(label.equals("Rent")){
            if(time.equals("Day"))
                return (String) frame.getRentSellPanel().getRentDateDayComboBox().getItemAt(
                        frame.getRentSellPanel().getRentDateDayComboBox().getSelectedIndex());
            if(time.equals("Month"))
                return (String) frame.getRentSellPanel().getRentDateMonthComboBox().getItemAt(
                        frame.getRentSellPanel().getRentDateMonthComboBox().getSelectedIndex());
            if(time.equals("Year"))
                return (String) frame.getRentSellPanel().getRentDateYearComboBox().getItemAt(
                        frame.getRentSellPanel().getRentDateYearComboBox().getSelectedIndex());
        }
        else if(label.equals("Return")){
            if(time.equals("Day"))
                return (String) frame.getRentSellPanel().getReturnDateDayComboBox().getItemAt(
                        frame.getRentSellPanel().getReturnDateDayComboBox().getSelectedIndex());
            if(time.equals("Month"))
                return (String) frame.getRentSellPanel().getReturnDateMonthComboBox().getItemAt(
                        frame.getRentSellPanel().getReturnDateMonthComboBox().getSelectedIndex());
            if(time.equals("Year"))
                return (String) frame.getRentSellPanel().getReturnDateYearComboBox().getItemAt(
                        frame.getRentSellPanel().getReturnDateYearComboBox().getSelectedIndex());
        }else if(label.equals("Sell")){
            if(time.equals("Day"))
                return (String) frame.getRentSellPanel().getSellingDateDayComboBox().getItemAt(
                        frame.getRentSellPanel().getSellingDateDayComboBox().getSelectedIndex());
            if(time.equals("Month"))
                return (String) frame.getRentSellPanel().getSellingDateMonthComboBox().getItemAt(
                        frame.getRentSellPanel().getSellingDateMonthComboBox().getSelectedIndex());
            if(time.equals("Year"))
                return (String) frame.getRentSellPanel().getSellingDateYearComboBox().getItemAt(
                        frame.getRentSellPanel().getSellingDateYearComboBox().getSelectedIndex());
        }
        return "";
    }

    
    
    //Panel getter
    JPanel getRentSellPanel(){
        return frame.getRentSellPanel();
    }

    JPanel getAllButtonsPanel(){
        return frame.getAllButtonsPanel();
    }

    JPanel getDisplayPanel(){
        return frame.getDisplayPanel();
    }

    JPanel getRadioButtonsPanel(){
        return frame.getRadioButtonsPanel();
    }

    JPanel getHomePage(){
        return frame.getHomePage();
    }

    //Arraylist getter
    List<Instrument> getInstrumentList(){
        return frame.getInstrumentList();
    }
    
    //button group and radio getter
    ButtonGroup getButtonGroup(){
        return frame.getRadioButtonsPanel().getButtonGroup();
    }

    JRadioButton getRentInstrumentRadio(){
        return frame.getRadioButtonsPanel().getRentInstrumentRadio();
    }

    JRadioButton getSellInstrumentRadio(){
        return frame.getRadioButtonsPanel().getSellInstrumentRadio();
    }

    //textArea getter
    JTextPane getDisplayArea(){
        return frame.getDisplayPanel().getDisplayArea();
    }


    //text field getter
    JTextField getInstrumentNameField(){
        return frame.getRentSellPanel().getInstrumentNameField();
    }

    JTextField getChargePerDayField(){
        return frame.getRentSellPanel().getChargePerDayField();
    }

    JTextField getCustomerNameField(){
        return frame.getRentSellPanel().getCustomerNameField();
    }

    JTextField getCustomerPhoneField(){
        return frame.getRentSellPanel().getCustomerPhoneField();
    }

    JTextField getCustomerPanNumberField(){
        return frame.getRentSellPanel().getCustomerPanNumberField();
    }

    JTextField getNoOfDaysField(){
        return frame.getRentSellPanel().getNoOfDaysField();
    }

    JTextField getPriceField(){
        return frame.getRentSellPanel().getPriceField();
    }

    JTextField getDiscountPercentField(){
        return frame.getRentSellPanel().getDiscountPercentField();

    }


    }

