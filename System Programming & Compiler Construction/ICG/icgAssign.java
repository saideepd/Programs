import java.util.*;

public class icgAssign
{

	public static String replaceStuff(String equation, int i, String toReplace)
	{
		int midIndex = equation.indexOf(toReplace);
		String newEquation = "";
		String toFind = "";
		if(!(equation.charAt(midIndex-2)=='t')&&!(equation.charAt(midIndex+1)=='t'))
		{
			toFind = equation.substring(midIndex-1, midIndex+2);
			newEquation = equation.substring(0, midIndex-1) + "t" + Integer.toString(i) + equation.substring(midIndex+2, equation.length());
		}
		else if(equation.charAt(midIndex-2)=='t')
		{
			if(equation.charAt(midIndex+1)=='t')
			{
				toFind = equation.substring(midIndex-2, midIndex+3);
				newEquation = equation.substring(0, midIndex-2) + "t" + Integer.toString(i) + equation.substring(midIndex+3, equation.length());
			}
			else
			{
				toFind = equation.substring(midIndex-2, midIndex+2);
				newEquation = equation.substring(0, midIndex-2) + "t" + Integer.toString(i) + equation.substring(midIndex+2, equation.length());
			}
		}	
		else
		{
			toFind = equation.substring(midIndex-1, midIndex+3);
			newEquation = equation.substring(0, midIndex-1) + "t" + Integer.toString(i) + equation.substring(midIndex+3, equation.length());
		}
		System.out.println("t"+i + "=" + toFind);
		return newEquation;
	}

	public static void assignment(String equation)
	{
		int i = 1;
		while(equation.contains("^")||equation.contains("*")||equation.contains("/")||equation.contains("+")||equation.contains("-"))
		{
			if(equation.contains("^"))
			{
				String toReplace = "^";
				equation = replaceStuff(equation, i, toReplace);
			}
			else if(equation.contains("*")||equation.contains("/"))
			{
				if(equation.contains("*")&&equation.contains("/"))
				{
					if(equation.indexOf("*")<equation.indexOf("/"))
					{
						String toReplace = "*";
						equation = replaceStuff(equation, i, toReplace);
					}
					else
					{
						String toReplace = "/";
						equation = replaceStuff(equation, i, toReplace);
					}
				}
				else if(equation.contains("*"))
				{
					String toReplace = "*";
					equation = replaceStuff(equation, i, toReplace);
				}
				else
				{
					String toReplace = "/";
					equation = replaceStuff(equation, i, toReplace);
				}
			} 
			else
			{
				if(equation.contains("+")&&equation.contains("-"))
				{
					if(equation.indexOf("+")<equation.indexOf("-"))
					{
						String toReplace = "+";
						equation = replaceStuff(equation, i, toReplace);
					}
					else
					{
						String toReplace = "-";
						equation = replaceStuff(equation, i, toReplace);
					}
				}
				else if(equation.contains("+"))
				{
					String toReplace = "+";
					equation = replaceStuff(equation, i, toReplace);
				}
				else
				{
					String toReplace = "-";
					equation = replaceStuff(equation, i, toReplace);
				}
			}

			System.out.println(equation);
			i = i + 1;
			
		}	
	}

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the assignment equation");
		String equation = sc.next();
		assignment(equation);
	}
}

/*
OUTPUT:

Enter the assignment equation
k=a-b^c^d/f
t1=c^d
k=a-b^t1/f
t2=b^t1
k=a-t2/f
t3=t2/f
k=a-t3
t4=a-t3
k=t4
*/