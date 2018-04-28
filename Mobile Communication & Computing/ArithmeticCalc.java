import javax.microedition.lcdui.*;
import javax.microedition.midlet.*; 
import java.io.*;
import java.util.*;
import java.lang.*;

public class MyCalc extends MIDlet implements CommandListener {
  private Form form;
  private Display display;
  private TextField input1, input2;
  private Command add, sub, mul,div,mul1,div1,add1,sub1;
  private StringItem item;

  public void MyCalc() {}
  
  public void startApp() {

    display = Display.getDisplay(this);
    Form form = new Form("Calculator");
    form.append("Welcome to my calculator");
    item = new StringItem("Result", "");

    input1 = new TextField("First Number:", "", 30, TextField.NUMERIC);
    input2 = new TextField("Second Number", "", 30, TextField.NUMERIC);
    
    form.append(input1);
    form.append(input2);
    
    add1 = new Command("Addition", Command.OK, 1);
    sub1 = new Command("Subtraction", Command.OK, 1);
    mul1 = new Command("Multiplication", Command.OK, 1);
    div1 = new Command("Division", Command.OK, 1);
    add = new Command("Exponent", Command.OK, 1);
    sub = new Command("Modulus", Command.OK, 1);
    mul = new Command("Sum Of Factorials", Command.OK, 1);
   
    form.addCommand(add1);
    form.addCommand(sub1);
    form.addCommand(mul1);
    form.addCommand(div1);
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


  private void calculate3() {
    int one=Integer.parseInt(input1.getString());
    int two= Integer.parseInt(input2.getString());
    int result=one+two;
    item.setText( result + "" );
  }
 
  private void calculate4() {
    int one = Integer.parseInt(input1.getString());
    int two = Integer.parseInt(input2.getString());
    int result = one - two;
    item.setText(result + "");
  }

  private void calculate5() {
    int one = Integer.parseInt(input1.getString());
    int two = Integer.parseInt(input2.getString());
    int result = one * two;
    item.setText(result + "");
  }

  private void calculate6() {
    int one = Integer.parseInt(input1.getString());
    int two = Integer.parseInt(input2.getString());
    int result = one / two;
    item.setText(result + "");
  }

  private void calculate() {
    int one=Integer.parseInt(input1.getString());
    int two= Integer.parseInt(input2.getString());
    int result = 1;
    for (int i = 1; i <= two; i++) {
      result *= one;
    }
    item.setText( result + "" );
  }

   private void calculate1() {
    int one = Integer.parseInt(input1.getString());
    int two = Integer.parseInt(input2.getString());
    int result = one % two;
    item.setText(result + "");
   }

  private void calculate2() {
    int one = Integer.parseInt(input1.getString());
    int two = Integer.parseInt(input2.getString());
    int fact=1,i;
    for(i=1;i<=one;i++){    
      fact=fact*i;    
    }    
    int fact1=1,j;
    for(j=1;j<=two;j++){    
      fact1=fact1*j;    
    } 
    int result = fact1+ fact;
    item.setText(result + "");
  }

  public void commandAction(Command c, Displayable d) {
    String label = c.getLabel();
    if (label.equals("Exponent")) {
      calculate();
    }
    else if (label.equals("Modulus")) {
      calculate1();
    }
    else if (label.equals("Sum Of Factorials")) {
      calculate2();
    }
    else if (label.equals("Addition")) {
      calculate3();
    }
    else if (label.equals("Multiplication")) {
      calculate5();
    }
    else if (label.equals("Subtraction")) {
      calculate4();
    }
    else if (label.equals("Division")) {
    calculate6();
    }
  }
}
