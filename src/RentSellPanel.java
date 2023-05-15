import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class RentSellPanel extends JPanel {

	//Array for year month and day for JComboHBox
	String[] year, month, day;

	//instance of mainframe class
	private MainFrame frame;

	//for panel dimension
	private int width, height;

	//for text field sizing
	private int fieldWidth, fieldHeight;

	//for label sizing
	private int labelWidth, labelHeight;

	// date and time arrayList for renting date, returining date and selling date
	private List<JLabel> barsa, maina, din;


	// Instrument Name
	private JLabel instrumentNameLabel;
	private JTextField instrumentNameField;

	// Price
	private JLabel priceLabel;
	private JTextField priceField;

	// Charge Per Day
	private JLabel chargePerDay;
	private JTextField chargePerDayField;

	// No of Days
	private JLabel noOfDaysLabel;
	private JTextField noOfDaysField;

	// Customer Name
	private JLabel customerNameLabel;
	private JTextField customerNameField;

	// Customer Phone
	private JLabel customerPhoneLabel;
	private JTextField customerPhoneField;

	// Customer PAN No.
	private JLabel customerPanNumberLabel;
	private JTextField customerPanNumberField;

	// Discount Percent
	private JLabel discountPercentLabel;
	private JTextField discountPercentField;

	// Selling Date
	private JLabel sellingDateLabel;
	private JComboBox sellingDateYearComboBox, sellingDateMonthComboBox, sellingDateDayComboBox;

	// Rent Date
	private JLabel rentDateLabel;
	JComboBox rentDateYearComboBox, rentDateMonthComboBox, rentDateDayComboBox;

	// Return Date
	private JLabel returnDateLabel;
	private JComboBox returnDateYearComboBox, returnDateMonthComboBox, returnDateDayComboBox;

	public RentSellPanel(MainFrame frame, int width, int height) {

		this.frame = frame;
		barsa = new ArrayList<>();
		maina = new ArrayList<>();
		din = new ArrayList<>();

		year = new String[10];
		month = new String[12];
		day = new String[30];

		//this method contans declaration of year month and day value and insertion of them in respective arrays
		date();

		this.width = width;
		this.height = height;

		//label declaration
		instrumentNameLabel = new JLabel("Instrument Name");
		priceLabel = new JLabel("Price");
		chargePerDay = new JLabel("Charge Per Day");
		noOfDaysLabel = new JLabel("No. of Days");
		customerNameLabel = new JLabel("Customer Name");
		customerPhoneLabel = new JLabel("Customer Phone");
		customerPanNumberLabel = new JLabel("Customer PAN No.");
		discountPercentLabel = new JLabel("Discount Percent");

		//field declaration
		instrumentNameField = new JTextField();
		priceField = new JTextField();
		chargePerDayField = new JTextField();
		noOfDaysField = new JTextField();
		customerNameField = new JTextField();
		customerPhoneField = new JTextField();
		customerPanNumberField = new JTextField();
		discountPercentField = new JTextField();


		//this method contains all the panel properties
		panelFeatures();

		//this method contains all the components like label and buttons declaration
		materials();


	}

	void materials() {
		labelWidth = 100;
		labelHeight = 20;

		fieldWidth = 160;
		fieldHeight = 25;


		//checking whether renting instrument or selling instrument is selected in radio button
		if(frame.getRadioButtonsPanel().getButtonGroup().getSelection().getActionCommand() =="Selling Instrument"){

			//this method contains label and fields like customer name which will be needed in both renting and selling instrument
			both();

			//this method contains labels and fields  which will be needed only when selling instrument
			selling();
		}else{

			//this method contains label and fields like customer name which will be needed in both renting and selling instrument
			both();

			//this method contains labels and fields which will be needed only when renting instrument
			renting();
		}

		// Instrument Name



	}

	void both(){

		// for customer name declaration, properties and panel adding
		customerName();

		//for instrument name declaration, properties and panel adding
		instrumentName();

		//for customer phone number declaration, properties and panel adding
		customerPhone();
		customerPanNo();
	}

	void renting(){

		//for no of days declaration, properties and panel adding
		noOfDays();

		//for charge per day declaration, properties and panel adding
		chargePerDay();

		// for rent date declaration, properties and panel adding
		rentDate();

		//for return date declaration, properties and panel adding
		returnDate();
	}

	void selling(){

		//for selling price declaration, properties and panel adding
		price();

		//for discount percent declaration, properties and panel adding
		discountPercent();

		//for selling date declaration, properties and panel adding
		sellingDate();
	}



	void instrumentName() {
		// label
		instrumentNameLabel.setBounds(customerNameLabel.getX() + 365, customerNameLabel.getY(), labelWidth,
				labelHeight);

		instrumentNameLabel.setOpaque(true);
		add(instrumentNameLabel);

		// field
		instrumentNameField.setBounds(instrumentNameLabel.getX() + 120, (int) (instrumentNameLabel.getY() - 5),
				fieldWidth, fieldHeight);
		add(instrumentNameField);
	}

	void price() {
		// label
		priceLabel.setBounds(customerNameLabel.getX(), customerNameLabel.getY() + 40, labelWidth, labelHeight);
		add(priceLabel);

		// field
		priceField.setBounds(customerNameField.getX(), priceLabel.getY() - 5, fieldWidth, fieldHeight);
		priceField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				String value = priceField.getText();
				int l = value.length();
				if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') ||
						ke.getKeyCode() == KeyEvent.VK_BACK_SPACE ||
						ke.getKeyCode() == KeyEvent.VK_DELETE) {
					priceField.setEditable(true);
				} else {
					priceField.setEditable(false);
				}
			}
		});
		add(priceField);
	}

	void noOfDays() {
		// label
		noOfDaysLabel.setBounds(customerNameLabel.getX(),customerNameLabel.getY()+40, labelWidth, labelHeight);
		// noOfDaysLabel.setBounds((width/2)-(labelWidth), priceLabel.getY() + 40,
		// labelWidth, labelHeight);
		add(noOfDaysLabel);

		// field
		noOfDaysField.setBounds(customerNameField.getX(), noOfDaysLabel.getY() - 5, fieldWidth, fieldHeight);
		noOfDaysField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				String value = noOfDaysField.getText();
				int l = value.length();
				if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') ||
						ke.getKeyCode() == KeyEvent.VK_BACK_SPACE ||
						ke.getKeyCode() == KeyEvent.VK_DELETE) {
					noOfDaysField.setEditable(true);
				} else {
					noOfDaysField.setEditable(false);
				}
			}
		});
		add(noOfDaysField);
	}

	void chargePerDay() {
		// label
		chargePerDay.setBounds(instrumentNameLabel.getX(), noOfDaysLabel.getY(), labelWidth, labelHeight);
		add(chargePerDay);

		// field
		chargePerDayField.setBounds(instrumentNameField.getX(), noOfDaysField.getY(), fieldWidth, fieldHeight);
		chargePerDayField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				String value = chargePerDayField.getText();
				int l = value.length();
				if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') ||
						ke.getKeyCode() == KeyEvent.VK_BACK_SPACE ||
						ke.getKeyCode() == KeyEvent.VK_DELETE) {
					chargePerDayField.setEditable(true);
				} else {
					chargePerDayField.setEditable(false);
				}
			}
		});
		add(chargePerDayField);
	}

	void customerName() {
		// label
		customerNameLabel.setBounds(10, 60, labelWidth, labelHeight);
		add(customerNameLabel);

		// field
		customerNameField.setBounds(customerNameLabel.getX() + 120, customerNameLabel.getY() - 5, fieldWidth, fieldHeight);
		add(customerNameField);
	}

	void customerPhone() {
		customerPhoneLabel.setBounds(instrumentNameLabel.getX(), instrumentNameLabel.getY()  + 40 *2, labelWidth, labelHeight);
		add(customerPhoneLabel);

		// field
		customerPhoneField.setBounds(instrumentNameField.getX(), (int) (customerPhoneLabel.getY() - 5), fieldWidth,
				fieldHeight);
		customerPhoneField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				String value = customerPhoneField.getText();
				int l = value.length();
				if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') ||
						 ke.getKeyCode() == KeyEvent.VK_BACK_SPACE ||
				 ke.getKeyCode() == KeyEvent.VK_DELETE) {
					customerPhoneField.setEditable(true);
				} else {
					customerPhoneField.setEditable(false);
				}
			}
		});
		add(customerPhoneField);
	}

	void customerPanNo() {
		customerPanNumberLabel.setBounds(customerNameLabel.getX(), customerNameLabel.getY() + 40 *2, labelWidth + 20,
				labelHeight);
		add(customerPanNumberLabel);

		// field
		customerPanNumberField.setBounds(customerNameField.getX(), customerPanNumberLabel.getY() - 5, fieldWidth,
				fieldHeight);
		customerPanNumberField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				String value = customerPanNumberField.getText();
				int l = value.length();
				if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') ||
						ke.getKeyCode() == KeyEvent.VK_BACK_SPACE ||
						ke.getKeyCode() == KeyEvent.VK_DELETE) {
					customerPanNumberField.setEditable(true);
				} else {
					customerPanNumberField.setEditable(false);
				}
			}
		});
		add(customerPanNumberField);
	}

	void discountPercent() {
		// label
		discountPercentLabel.setBounds(customerPhoneLabel.getX(), priceLabel.getY(), labelWidth,
				labelHeight);
		add(discountPercentLabel);

		// field
		discountPercentField.setBounds(instrumentNameField.getX(), priceField.getY(), fieldWidth,
				fieldHeight);
		discountPercentField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				String value = discountPercentField.getText();
				int l = value.length();
				if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') ||
						ke.getKeyCode() == KeyEvent.VK_BACK_SPACE ||
						ke.getKeyCode() == KeyEvent.VK_DELETE) {
					discountPercentField.setEditable(true);
				} else {
					discountPercentField.setEditable(false);
				}
			}
		});
		add(discountPercentField);
	}

	void sellingDate() {
		// label
		sellingDateLabel = new JLabel("Selling Date");
		sellingDateLabel.setBounds(width/2 - 200, customerPanNumberLabel.getY() + 40 * 2, labelWidth,
				labelHeight);
		add(sellingDateLabel);

		// year
		barsa.add(new JLabel("Year"));
		barsa.get(barsa.size()-1).setBounds(sellingDateLabel.getX() + (sellingDateLabel.getWidth()), sellingDateLabel.getY() - 25,
				labelWidth - 25, labelHeight);
		add(barsa.get(barsa.size()-1));

		sellingDateYearComboBox = new JComboBox(year);
		sellingDateYearComboBox.setBounds(sellingDateLabel.getX() + (sellingDateLabel.getWidth() - 20),
				sellingDateLabel.getY(), labelWidth - 25, labelHeight);
		add(sellingDateYearComboBox);

		// month
		maina.add(new JLabel("Month"));
		maina.get(maina.size()-1).setBounds(sellingDateYearComboBox.getX() + (sellingDateYearComboBox.getWidth() + 10),
				sellingDateYearComboBox.getY() - 25, sellingDateYearComboBox.getWidth() - 25,
				sellingDateYearComboBox.getHeight());
		add(maina.get(maina.size()-1));

		sellingDateMonthComboBox = new JComboBox(month);
		sellingDateMonthComboBox.setBounds(sellingDateYearComboBox.getX() + (sellingDateYearComboBox.getWidth() + 10),
				sellingDateYearComboBox.getY(), sellingDateYearComboBox.getWidth() - 25,
				sellingDateYearComboBox.getHeight());
		add(sellingDateMonthComboBox);

		// day
		din.add(new JLabel("Day"));
		din.get(din.size()-1).setBounds(
				sellingDateMonthComboBox.getX() + (sellingDateMonthComboBox.getWidth() + 10)
						+ (sellingDateMonthComboBox.getWidth() / 4),
				sellingDateMonthComboBox.getY() - 25, sellingDateMonthComboBox.getWidth() - 25,
				sellingDateMonthComboBox.getHeight());
		add(din.get(din.size()-1));

		sellingDateDayComboBox = new JComboBox(day);
		sellingDateDayComboBox.setBounds(sellingDateMonthComboBox.getX() + (sellingDateMonthComboBox.getWidth() + 10),
				sellingDateMonthComboBox.getY(), sellingDateMonthComboBox.getWidth(),
				sellingDateMonthComboBox.getHeight());
		add(sellingDateDayComboBox);
	}

	void rentDate() {
		// label
		rentDateLabel = new JLabel("Rent Date");
		rentDateLabel.setBounds(customerNameLabel.getX(), customerPanNumberLabel.getY() + 40 * 2, labelWidth,
				labelHeight);
		add(rentDateLabel);

		// year

		barsa.add(new JLabel("Year"));
		barsa.get(barsa.size()-1).setBounds(rentDateLabel.getX() + (rentDateLabel.getWidth()), rentDateLabel.getY() - 25,
				labelWidth - 25, labelHeight);
		add(barsa.get(barsa.size()-1));

		rentDateYearComboBox = new JComboBox(year);
		rentDateYearComboBox.setBounds(rentDateLabel.getX() + (rentDateLabel.getWidth() - 20), rentDateLabel.getY(),
				labelWidth - 25, labelHeight);
		add(rentDateYearComboBox);

		// month
		maina.add(new JLabel("Month"));
		maina.get(maina.size()-1).setBounds(rentDateYearComboBox.getX() + (rentDateYearComboBox.getWidth() + 10),
				rentDateYearComboBox.getY() - 25, rentDateYearComboBox.getWidth() - 25,
				rentDateYearComboBox.getHeight());
		add(maina.get(maina.size()-1));

		rentDateMonthComboBox = new JComboBox(month);
		rentDateMonthComboBox.setBounds(rentDateYearComboBox.getX() + (rentDateYearComboBox.getWidth() + 10),
				rentDateYearComboBox.getY(), rentDateYearComboBox.getWidth() - 25, labelHeight);
		add(rentDateMonthComboBox);

		// day
		din.add(new JLabel("Day"));
		din.get(din.size()-1).setBounds(
				rentDateMonthComboBox.getX() + (rentDateMonthComboBox.getWidth() + 10)
						+ (rentDateMonthComboBox.getWidth() / 4),
				rentDateMonthComboBox.getY() - 25, rentDateMonthComboBox.getWidth() - 25,
				rentDateMonthComboBox.getHeight());
		add(din.get(din.size()-1));

		rentDateDayComboBox = new JComboBox(day);
		rentDateDayComboBox.setBounds(rentDateMonthComboBox.getX() + (rentDateMonthComboBox.getWidth() + 10),
				rentDateMonthComboBox.getY(), rentDateMonthComboBox.getWidth(), rentDateMonthComboBox.getHeight());
		add(rentDateDayComboBox);
	}

	void returnDate() {
		// label
		returnDateLabel = new JLabel("Return Date");
		returnDateLabel.setBounds(customerPhoneLabel.getX(), rentDateLabel.getY(),
				labelWidth, labelHeight);
		add(returnDateLabel);

		// year
		barsa.add(new JLabel("Year"));
		barsa.get(barsa.size()-1).setBounds(returnDateLabel.getX() + (returnDateLabel.getWidth()), returnDateLabel.getY() - 25,
				labelWidth - 25, labelHeight);
		add(barsa.get(barsa.size()-1));

		returnDateYearComboBox = new JComboBox(year);
		returnDateYearComboBox.setBounds(returnDateLabel.getX() + (returnDateLabel.getWidth() - 20),
				returnDateLabel.getY(), labelWidth - 25, labelHeight);
		add(returnDateYearComboBox);

		// month
		maina.add(new JLabel("Month"));
		maina.get(maina.size()-1).setBounds(returnDateYearComboBox.getX() + (returnDateYearComboBox.getWidth() + 10),
				returnDateYearComboBox.getY() - 25, returnDateYearComboBox.getWidth() - 25,
				returnDateYearComboBox.getHeight());
		add(maina.get(maina.size()-1));

		returnDateMonthComboBox = new JComboBox(month);
		returnDateMonthComboBox.setBounds(returnDateYearComboBox.getX() + (returnDateYearComboBox.getWidth() + 10),
				returnDateYearComboBox.getY(), returnDateYearComboBox.getWidth() - 25,
				returnDateYearComboBox.getHeight());
		add(returnDateMonthComboBox);

		// day
		din.add(new JLabel("Day"));
		din.get(din.size()-1).setBounds(
				returnDateMonthComboBox.getX() + (returnDateMonthComboBox.getWidth() + 10)
						+ (returnDateMonthComboBox.getWidth() / 4),
				returnDateMonthComboBox.getY() - 25, returnDateMonthComboBox.getWidth() - 25,
				returnDateMonthComboBox.getHeight());
		add(din.get(din.size()-1));

		returnDateDayComboBox = new JComboBox(day);
		returnDateDayComboBox.setBounds(returnDateMonthComboBox.getX() + (returnDateMonthComboBox.getWidth() + 10),
				returnDateMonthComboBox.getY(), returnDateMonthComboBox.getWidth(),
				returnDateMonthComboBox.getHeight());
		add(returnDateDayComboBox);
	}

	void date() {
		String yr = "201";
		for (int i = 0; i < year.length; i++) {
			if ((i + 3) >= 10) {
				yr = "202";
			}

			year[i] = yr + ((i + 3) % 10);
		}

		for (int i = 0; i < month.length; i++) {
			month[i] = "" + (i + 1);
		}

		for (int i = 0; i < day.length; i++) {
			day[i] = "" + (i + 1);
		}
	}

	void panelFeatures() {
		setSize(new Dimension(width, height));
		setLayout(null);
		setOpaque(false);
	}

	public String[] getYear() {
		return year;
	}

	public void setYear(String[] year) {
		this.year = year;
	}

	public String[] getMonth() {
		return month;
	}

	public void setMonth(String[] month) {
		this.month = month;
	}

	public String[] getDay() {
		return day;
	}

	public void setAdd(String[] day) {
		this.day = day;
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

	public int getFieldWidth() {
		return fieldWidth;
	}

	public void setFieldWidth(int fieldWidth) {
		this.fieldWidth = fieldWidth;
	}

	public int getFieldHeight() {
		return fieldHeight;
	}

	public void setFieldHeight(int fieldHeight) {
		this.fieldHeight = fieldHeight;
	}

	public int getLabelWidth() {
		return labelWidth;
	}

	public void setLabelWidth(int labelWidth) {
		this.labelWidth = labelWidth;
	}

	public int getLabelHeight() {
		return labelHeight;
	}

	public void setLabelHeight(int labelHeight) {
		this.labelHeight = labelHeight;
	}

	public List<JLabel> getBarsa() {
		return barsa;
	}

	public void setBarsa(List<JLabel> barsa) {
		this.barsa = barsa;
	}

	public List<JLabel> getMaina() {
		return maina;
	}

	public void setMaina(List<JLabel> maina) {
		this.maina = maina;
	}

	public List<JLabel> getDin() {
		return din;
	}

	public void setDin(List<JLabel> din) {
		this.din = din;
	}


	public JLabel getInstrumentNameLabel() {
		return instrumentNameLabel;
	}

	public void setInstrumentNameLabel(JLabel instrumentNameLabel) {
		this.instrumentNameLabel = instrumentNameLabel;
	}

	public JTextField getInstrumentNameField() {
		return instrumentNameField;
	}

	public void setInstrumentNameField(JTextField instrumentNameField) {
		this.instrumentNameField = instrumentNameField;
	}

	public JLabel getPriceLabel() {
		return priceLabel;
	}

	public void setPriceLabel(JLabel priceLabel) {
		this.priceLabel = priceLabel;
	}

	public JTextField getPriceField() {
		return priceField;
	}

	public void setPriceField(JTextField priceField) {
		this.priceField = priceField;
	}

	public JLabel getChargePerDay() {
		return chargePerDay;
	}

	public void setChargePerDay(JLabel chargePerDay) {
		this.chargePerDay = chargePerDay;
	}

	public JTextField getChargePerDayField() {
		return chargePerDayField;
	}

	public void setChargePerDayField(JTextField chargePerDayField) {
		this.chargePerDayField = chargePerDayField;
	}

	public JLabel getNoOfDaysLabel() {
		return noOfDaysLabel;
	}

	public void setNoOfDaysLabel(JLabel noOfDaysLabel) {
		this.noOfDaysLabel = noOfDaysLabel;
	}

	public JTextField getNoOfDaysField() {
		return noOfDaysField;
	}

	public void setNoOfDaysField(JTextField noOfDaysField) {
		this.noOfDaysField = noOfDaysField;
	}

	public JLabel getCustomerNameLabel() {
		return customerNameLabel;
	}

	public void setCustomerNameLabel(JLabel customerNameLabel) {
		this.customerNameLabel = customerNameLabel;
	}

	public JTextField getCustomerNameField() {
		return customerNameField;
	}

	public void setCustomerNameField(JTextField customerNameField) {
		this.customerNameField = customerNameField;
	}

	public JLabel getCustomerPhoneLabel() {
		return customerPhoneLabel;
	}

	public void setCustomerPhoneLabel(JLabel customerPhoneLabel) {
		this.customerPhoneLabel = customerPhoneLabel;
	}

	public JTextField getCustomerPhoneField() {
		return customerPhoneField;
	}

	public void setCustomerPhoneField(JTextField customerPhoneField) {
		this.customerPhoneField = customerPhoneField;
	}

	public JLabel getCustomerPanNumberLabel() {
		return customerPanNumberLabel;
	}

	public void setCustomerPanNumberLabel(JLabel customerPanNumberLabel) {
		this.customerPanNumberLabel = customerPanNumberLabel;
	}

	public JTextField getCustomerPanNumberField() {
		return customerPanNumberField;
	}

	public void setCustomerPanNumberField(JTextField customerPanNumberField) {
		this.customerPanNumberField = customerPanNumberField;
	}

	public JLabel getDiscountPercentLabel() {
		return discountPercentLabel;
	}

	public void setDiscountPercentLabel(JLabel discountPercentLabel) {
		this.discountPercentLabel = discountPercentLabel;
	}

	public JTextField getDiscountPercentField() {
		return discountPercentField;
	}

	public void setDiscountPercentField(JTextField discountPercentField) {
		this.discountPercentField = discountPercentField;
	}

	public JLabel getSellingDateLabel() {
		return sellingDateLabel;
	}

	public void setSellingDateLabel(JLabel sellingDateLabel) {
		this.sellingDateLabel = sellingDateLabel;
	}

	public JComboBox getSellingDateYearComboBox() {
		return sellingDateYearComboBox;
	}

	public void setSellingDateYearComboBox(JComboBox sellingDateYearComboBox) {
		this.sellingDateYearComboBox = sellingDateYearComboBox;
	}

	public JComboBox getSellingDateMonthComboBox() {
		return sellingDateMonthComboBox;
	}

	public void setSellingDateMonthComboBox(JComboBox sellingDateMonthComboBox) {
		this.sellingDateMonthComboBox = sellingDateMonthComboBox;
	}

	public JComboBox getSellingDateDayComboBox() {
		return sellingDateDayComboBox;
	}

	public void setSellingDateDayComboBox(JComboBox sellingDateDayComboBox) {
		this.sellingDateDayComboBox = sellingDateDayComboBox;
	}

	public JLabel getRentDateLabel() {
		return rentDateLabel;
	}

	public void setRentDateLabel(JLabel rentDateLabel) {
		this.rentDateLabel = rentDateLabel;
	}

	public JComboBox getRentDateYearComboBox() {
		return rentDateYearComboBox;
	}

	public void setRentDateYearComboBox(JComboBox rentDateYearComboBox) {
		this.rentDateYearComboBox = rentDateYearComboBox;
	}

	public JComboBox getRentDateMonthComboBox() {
		return rentDateMonthComboBox;
	}

	public void setRentDateMonthComboBox(JComboBox rentDateMonthComboBox) {
		this.rentDateMonthComboBox = rentDateMonthComboBox;
	}

	public JComboBox getRentDateDayComboBox() {
		return rentDateDayComboBox;
	}

	public void setRentDateDayComboBox(JComboBox rentDateDayComboBox) {
		this.rentDateDayComboBox = rentDateDayComboBox;
	}

	public JLabel getReturnDateLabel() {
		return returnDateLabel;
	}

	public void setReturnDateLabel(JLabel returnDateLabel) {
		this.returnDateLabel = returnDateLabel;
	}

	public JComboBox getReturnDateYearComboBox() {
		return returnDateYearComboBox;
	}

	public void setReturnDateYearComboBox(JComboBox returnDateYearComboBox) {
		this.returnDateYearComboBox = returnDateYearComboBox;
	}

	public JComboBox getReturnDateMonthComboBox() {
		return returnDateMonthComboBox;
	}

	public void setReturnDateMonthComboBox(JComboBox returnDateMonthComboBox) {
		this.returnDateMonthComboBox = returnDateMonthComboBox;
	}

	public JComboBox getReturnDateDayComboBox() {
		return returnDateDayComboBox;
	}

	public void setReturnDateDayComboBox(JComboBox returnDateDayComboBox) {
		this.returnDateDayComboBox = returnDateDayComboBox;
	}
}
