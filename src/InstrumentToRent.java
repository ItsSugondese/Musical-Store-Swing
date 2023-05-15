public class InstrumentToRent extends Instrument{

    //creating attributes
    private int chargePerDay, noOfDays;
    private String dateOfRent, dateOfReturn;
    private boolean isRented;

    //creating constructor of this class
    public InstrumentToRent(String instrumentName, int chargePerDay) {
        //calling constructor of parent(Instrument) class
        super(instrumentName);

        this.chargePerDay = chargePerDay;
        dateOfRent = "";
        dateOfReturn = "";
        noOfDays = 0;
        isRented = false;
    }

    public void rentingInstrument(String customerName, String phone, int PANnumber,
                                    String dateOfRent, String dateOfReturn, int noOfDays ){
        //checking whether instrument is rented or not
        if (isRented){
            System.out.println("Rented by " + getCustomerName() + " (contact no. : " + getCustomerMobileNumber() + 
                                ") and will be returning it on " + getDateOfReturn() + ".");
        } else {
            //creating a local variable that calculate totalCharge that customer will be paying
            int totalCharge;
            //assigning parameter variable values to some attributes of parents class using setter method and super keyword
            super.setCustomerName(customerName);
            super.setCustomerMobileNumber(phone);
            super.setPAN_number(PANnumber);
            //assigning parameter variable values to instance variable of this class using setter methods
            setDateOfRent(dateOfRent);
            setDateOfReturn(dateOfReturn);
            setNoOfDays(noOfDays);
            setRented(true);
            //calculator total charage that customer will be paying
            totalCharge = getNoOfDays() * getChargePerDay();

            System.out.println("Successfully rented by " + getCustomerName() + " (contact no. : "+ 
                                getCustomerMobileNumber() + ", PAN Number: " + getPAN_number() + ").");
            System.out.println("It is rented on " + getDateOfRent() + " and will be returned by " + 
                                getDateOfReturn() + " i.e. it will be rented for " + getNoOfDays() + " days.");
            System.out.println("The customer will be paying Rs." + totalCharge + ".");
        }
    }

    public void instrumentReturn(){
        //checking whether the instrument is rented or not
        if(!isRented){
            System.out.println("Instrument " + getInstrumentName() + " hasn't been rented yet.");
        }else{
            //assigning attributes of parents class empty since the instrument 
            //has been returned by the one who took it.
            super.setCustomerName("");
            super.setCustomerMobileNumber("");
            super.setPAN_number(0);
            //assigning attributes of this class empty for same reason as above
            setDateOfReturn("");
            setDateOfRent("");
            setNoOfDays(0);
            setRented(false);
        }
    }

    public void display(){
        //calling display method of Instrument class
        super.display();
        //checking whether the instrument is rented or not
        if(isRented) {
            System.out.println("Rented on " + dateOfRent + " and will be returned by "
                    + dateOfReturn + ".");
        }
    }

    //setter methods for all attributes
    public void setChargePerDay(int chargePerDay) {
        this.chargePerDay = chargePerDay;
    }

    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }

    public void setDateOfRent(String dateOfRent) {
        this.dateOfRent = dateOfRent;
    }

    public void setDateOfReturn(String dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    //Getter methods for each attributes
    public int getChargePerDay() {
        return chargePerDay;
    }

    public int getNoOfDays() {
        return noOfDays;
    }

    public String getDateOfRent() {
        return dateOfRent;
    }

    public String getDateOfReturn() {
        return dateOfReturn;
    }

    public boolean isRented() {
        return isRented;
    }
}