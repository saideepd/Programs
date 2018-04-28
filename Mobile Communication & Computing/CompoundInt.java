/*
Compound Interest = Principle * ((1 + Rate / 100) ^ time)
*/


import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import java.util.*;
import java.io.*;

public class CompoundInt extends MIDlet implements CommandListener {
	
	private Form form;
	private Display display;
	private StringItem item;
	private TextField input1,input2,input3;
	private Command ci;

	public void CompoundInt() {}

	public void startApp() {

		display = Display.getDisplay(this);
		form = new Form("Compound Interest Calculator");
		form.append("Welcome");

		item = new StringItem("Resulting Compound Interest is ","");
		input1 = new TextField("Principle amount : ","",30,TextField.NUMERIC);
		input2 = new TextField("Rate : ","",30,TextField.NUMERIC);
		input3 = new TextField("Time : ","",30,TextField.NUMERIC);
		ci = new Command("Compound Interest",Command.OK,1);

		form.append(input1);
		form.append(input2);
		form.append(input3);
		form.addCommand(ci);
		form.append(item);
		form.setCommandListener(this);
		display.setCurrent(form);
	}

	public void pauseApp() {}

	public void destroyApp(boolean unconditional) {
		notifyDestroyed();
	}

	private void calculateCI() {
		int prin = Integer.parseInt(input1.getString());
		int rate = Integer.parseInt(input2.getString());
		int time = Integer.parseInt(input3.getString());
		double interest = (double)prin * (power((1 + (double)(rate/100.0)),time));
		item.setText(interest + "");
	}

	public void commandAction (Command c, Displayable d) {
		String label = c.getLabel();
		if (label.equals("Compound Interest")) {
			calculateCI();
		}
	}

	private double power(double x, int y) {
		double ans = 1.0;
		for(int i=1;i<=y;i++) {
			ans = ans * x;
		}
		return ans;
	}

}

/*
Program works. However, I haven't figured out how to enter the '.' for decimal numbers through the GUI.
Please let me know if anyone figures that out!
*/