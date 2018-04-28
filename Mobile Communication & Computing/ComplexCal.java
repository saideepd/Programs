import javax.microedition.lcdui.*;
import javax.microedition.midlet.*; 
import java.io.*;
import java.util.*;
import java.lang.*;

public class ComplexCal extends MIDlet implements CommandListener {
  private Form form;
  private Display display;
  private TextField realinput1, realinput2, imginput1, imginput2;
  private Command add, sub, mul,div;
  private StringItem item;

  public void ComplexCal() {}
  
  public void startApp() {

    display = Display.getDisplay(this);
    form = new Form("Calculator");
    form.append("Welcome to my calculator");
    item = new StringItem("Result", "");

    realinput1 = new TextField("Real part of first Number:", "", 30, TextField.NUMERIC);
    imginput1 = new TextField("Imaginary part of first Number:", "", 30, TextField.NUMERIC);
    realinput2 = new TextField("Real part of Second Number", "", 30, TextField.NUMERIC);
    imginput2 = new TextField("Imaginary part of Second Number", "", 30, TextField.NUMERIC);
    
    form.append(realinput1);
    form.append(imginput1);
    form.append(realinput2);
    form.append(imginput2);
    
    add = new Command("Addition", Command.OK, 1);
    sub = new Command("Subtraction", Command.OK, 1);
    mul = new Command("Multiplication", Command.OK, 1);
    div = new Command("Division", Command.OK, 1);
    
    form.addCommand(div);
    form.addCommand(add);
    form.addCommand(sub);
    form.addCommand(mul);

    form.append(item);
    form.setCommandListener(this);
    display.setCurrent(form);
  }

  public void pauseApp() {}

  public void destroyApp(boolean uncondn) {
    notifyDestroyed();
  }


  private void calculateAdd() {
    int realone=Integer.parseInt(realinput1.getString());
    int imgone=Integer.parseInt(imginput1.getString());
    int realtwo=Integer.parseInt(realinput2.getString());
    int imgtwo= Integer.parseInt(imginput2.getString());
    int realresult=realone + realtwo;
    int imgresult=imgone + imgtwo;    
    item.setText( realresult + " +  " + imgresult + "i");
  }
 
  private void calculateSub() {
    int realone=Integer.parseInt(realinput1.getString());
    int imgone=Integer.parseInt(imginput1.getString());
    int realtwo=Integer.parseInt(realinput2.getString());
    int imgtwo= Integer.parseInt(imginput2.getString());
    int realresult=realone - realtwo;
    int imgresult=imgone - imgtwo;    
    item.setText( realresult + " +  " + imgresult + "i");
  }

  private void calculateMul() {
    int realone=Integer.parseInt(realinput1.getString());
    int imgone=Integer.parseInt(imginput1.getString());
    int realtwo=Integer.parseInt(realinput2.getString());
    int imgtwo= Integer.parseInt(imginput2.getString());
    int realresult=realone * realtwo - imgone * imgtwo;
    int imgresult=realtwo * imgone + imgtwo * realone;    
    item.setText( realresult + " +  " + imgresult + "i");
  }

  private void calculateDiv() {

    int realone=Integer.parseInt(realinput1.getString());
    int imgone=Integer.parseInt(imginput1.getString());
    int realtwo=Integer.parseInt(realinput2.getString());
    int imgtwo= Integer.parseInt(imginput2.getString());
    
    int realnum = ( realone * realtwo ) + ( imgone * imgtwo );
    int realdom = ( realtwo * realtwo ) + ( imgtwo * imgtwo );

    double realresult = (double) realnum / realdom;
    int imgnum = ( realtwo * imgone ) - ( realone * imgtwo );
    double imgresult = (double) imgnum / realdom;
    item.setText( realresult + " +  " + imgresult + "i");
  }

  public void commandAction(Command c, Displayable d) {
    String label = c.getLabel();
    if (label.equals("Addition")) {
      calculateAdd();
    }
    else if (label.equals("Subtraction")) {
      calculateSub();
    }
    else if (label.equals("Multiplication")) {
      calculateMul();
    }
    else if (label.equals("Division")) {
      calculateDiv();
    }
  }
}
