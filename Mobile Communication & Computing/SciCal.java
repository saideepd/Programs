import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import java.util.*;
import java.lang.Math;
import java.io.*;

public class SciCal extends MIDlet implements CommandListener {

	private Form form;
	private Display display;
	private TextField input1, input2;
	private StringItem item;
	private Command sin,cos,tan,mod,cot,cosec,sec,pow;
	private Command logi,exp;

	public void SciCal() {}

	public void startApp() {

		display = Display.getDisplay(this);
		form = new Form("Calculator");
		form.append("Welcome");

		item = new StringItem("Result","");
		input1 = new TextField("First Number: ","",30,TextField.NUMERIC);
		input2 = new TextField("Second Number: ","",30,TextField.NUMERIC);
		sin = new Command("Sine",Command.OK,1);
		cos = new Command("Cosine",Command.OK,1);
		tan = new Command("Tangent",Command.OK,1);
		sec = new Command("Secant",Command.OK,1);
		cosec = new Command("Cosecant",Command.OK,1);
		cot = new Command("Cotangent",Command.OK,1);
		pow = new Command("Power",Command.OK,1);
		mod = new Command("Modulus",Command.OK,1);
		//logi = new Command("Log",Command.OK,1);
		//exp = new Command("Exponent",Command.OK,1);

		form.append(input1);
		form.append(input2);
		form.addCommand(sin);
		form.addCommand(cos);
		form.addCommand(tan);
		form.addCommand(cot);
		form.addCommand(sec);
		form.addCommand(cot);
		form.addCommand(cosec);
		//form.addCommand(exp);
		//form.addCommand(logi);
		form.addCommand(mod);
		form.append(item);
		form.setCommandListener(this);
		display.setCurrent(form);
	}

	public void pauseApp() {}

	public void destroyApp(boolean unconditional) {
		notifyDestroyed();
	}

	private void calculateSin() {
		int angle = Integer.parseInt(input1.getString());
		double rad  = Math.toRadians(angle);
		double result = Math.sin(rad);
		item.setText(result + "");
	}

	private void calculateCos() {
		int angle = Integer.parseInt(input1.getString());
		double rad  = Math.toRadians(angle);
		double result = Math.cos(rad);
		item.setText(result + "");
	}

	private void calculateTan() {
		int angle = Integer.parseInt(input1.getString());
		double rad  = Math.toRadians(angle);
		double result = Math.tan(rad);
		item.setText(result + "");
	}

	private void calculateCot() {
		int angle = Integer.parseInt(input1.getString());
		double rad  = Math.toRadians(angle);
		double result = 1.0/Math.tan(rad);
		item.setText(result + "");
	}
	
	private void calculateSec() {
		int angle = Integer.parseInt(input1.getString());
		double rad  = Math.toRadians(angle);
		double result = 1.0/Math.cos(rad);
		item.setText(result + "");
	}

	private void calculateCosec() {
		int angle = Integer.parseInt(input1.getString());
		double rad  = Math.toRadians(angle);
		double result = 1.0/Math.sin(rad);
		item.setText(result + "");
	}

	private void calculateMod() {
		int one = Integer.parseInt(input1.getString());
		int two = Integer.parseInt(input2.getString());
		int result = one%two;
		item.setText(result + "");
	}

	/*private void calculateExp() {
		int one = Integer.parseInt(input1.getString());
		double result = java.lang.Math.exp((double)one);
		item.setText(result + "");
	}

	private void calculateLog() {
		int one = Integer.parseInt(input1.getString());
		double result = Math.log(600.48);
		item.setText(result + "");
	}*/

	public void commandAction (Command c, Displayable d) {
		String label = c.getLabel();
		if(label.equals("Sine"))
		{
			calculateSin();
		}
		else if (label.equals("Cosine"))
		{
			calculateCos();
		}
		else if (label.equals("Tangent"))
		{
			calculateTan();
		}
		else if (label.equals("Cosecant"))
		{
			calculateCosec();
		}
		else if (label.equals("Secant"))
		{
			calculateSec();
		}
		else if (label.equals("Cotangent"))
		{
			calculateCot();
		}
		/*else if (label.equals("Exponent"))
		{
			calculateExp();
		}*/
		else if (label.equals("Modulus"))
		{
			calculateMod();
		}
		/*else if (label.equals("Log"))
		{
			calculateLog();
		}*/
		
	}

}

/*

Somehow my log and exp functions aren't working and they give this weird error:
C:\Users\Niti123\j2mewtk\2.5.2\apps\SciCal\src\SciCal.java:111: error: cannot find symbol
		double result = java.lang.Math.exp((double)one);
		                              ^
  symbol:   method exp(double)
  location: class Math
C:\Users\Niti123\j2mewtk\2.5.2\apps\SciCal\src\SciCal.java:117: error: cannot find symbol
		double result = Math.log((double)one);
		                    ^
  symbol:   method log(double)
  location: class Math
2 errors

If anyone can resolve it, please do!

*/
