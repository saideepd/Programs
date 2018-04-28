/*
Using the following system of rules to calculate Tax. Any rules would work, apply the logic correctly
First     Rupees        2, 00,000/- of income      :    0% tax
Next     Rupees         5, 00,000/- of income      :    10% tax
Next     Rupees         10, 00,000/- of income    :    20% tax
An Amount Rupee     	above 10, 00,000/-        :    30% tax
*/


import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import java.util.*;
import java.io.*;

public class IncomeCal extends MIDlet implements CommandListener {
	
	private Form form;
	private Display display;
	private StringItem item;
	private TextField input;
	private Command income;

	public void IncomeCal() {}

	public void startApp() {

		display = Display.getDisplay(this);
		form = new Form("Income Calculator");
		form.append("Welcome");

		item = new StringItem("Resulting Tax","");
		input = new TextField("Income is: ","",30,TextField.NUMERIC);
		income = new Command("Income",Command.OK,1);

		form.append(input);
		form.addCommand(income);
		form.append(item);
		form.setCommandListener(this);
		display.setCurrent(form);
	}

	public void pauseApp() {}

	public void destroyApp(boolean unconditional) {
		notifyDestroyed();
	}

	private void calculateTax() {
		double tax;
		double inc = Double.parseDouble(input.getString());
		if (inc <= 200000)
			tax = 0;
		else if (inc > 200000 && inc <= 500000)
			tax = (inc - 200000) * 0.10;
		else if (inc > 500000 && inc <= 1000000)
			tax = (inc - 500000) * 0.20 + (300000 * 0.10);
		else 
			tax = (inc - 1000000) * 0.30 + (500000 * 0.20) + (300000 * 0.10);
		item.setText(tax + "");
	}

	public void commandAction (Command c, Displayable d) {
		String label = c.getLabel();
		if (label.equals("Income")) {
			calculateTax();
		}
	}

}