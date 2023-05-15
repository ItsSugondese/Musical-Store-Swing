import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;

public class DisplayPanel extends JPanel {

    //instance of mainframe class
    private MainFrame frame;

    //for dimension of panel
    private int width, height;

    //for text area
    JTextPane displayArea;

    //for text area if the data overflow happens in text area
    JScrollPane forDisplayArea;

    public DisplayPanel(MainFrame frame, int width, int height){
        this.frame = frame;
        this.width = width;
        this.height = height;

        //this method contains all the panel properties
        panelFeatures();

        //this method contains all the components like label and buttons declaration
        materials();

    }

    void materials(){
        //for display text area/text pane declaration, properties and panel adding
        display();
    }

    void display(){
        int areaWidth = (int)(width/1.5);
        displayArea = new JTextPane();
        displayArea.setContentType("text/html");
        displayArea.setBorder((new LineBorder(Color.BLACK)));

        forDisplayArea = new JScrollPane(displayArea);
        forDisplayArea.setBounds(width/2 - areaWidth/2,
                frame.getAllButtonsPanel().getDisplayButton().getY() + frame.getAllButtonsPanel().getDisplayButton().getHeight() + 20,
                areaWidth,(int)(height/3.5));


        add(forDisplayArea);

//        add(displayArea);

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

    public JTextPane getDisplayArea() {
        return displayArea;
    }

    public void setDisplayArea(JTextPane displayArea) {
        this.displayArea = displayArea;
    }
}
