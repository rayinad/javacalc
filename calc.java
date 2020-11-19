// (C) Daniyar Atadjanov
// 2020.11.17

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class calc{
	public static void main (String[] args){
		// Declarations
		String task;
		String first;
		String operator;
		String second;
		Pattern p;
		Matcher m;
		
		// Greetings
		System.out.println("calc v0.1 by Daniyar Atadjanov");
		System.out.println("Format is 1+1 or I+I (x for exit)");
		
		// New scanner object
		Scanner input = new Scanner(System.in);
		
		while (true){
			// Ask for a task
			System.out.println("");
			System.out.print("Please enter your condition:");
			task = input.nextLine();
			task = task.replaceAll("\\s", "");
			
			p = Pattern.compile("(\\w{1,4})([\\+\\-\\*\\/])(\\w{1,4})");
			m = p.matcher(task);
			if(m.find()){
				first = m.group(1);
				operator = m.group(2);
				second = m.group(3);
				if(first.matches("\\d{1,2}") && second.matches("\\d{1,2}")){
					if(Integer.parseInt(first)>10 || Integer.parseInt(second)>10){
						error(1);
					}
					else if(operator.equals("/") && Integer.parseInt(second)==0){
						error(3);
					}
					else{
						calculate(Double.parseDouble(first),operator,Double.parseDouble(second),1);
					}
				}
				else if(first.matches("[XVI]{1,4}") && second.matches("[XVI]{1,4}")){
					first=first.equals("X") ? "10": first.equals("IX") ? "9": first.equals("VIII") ? "8": first.equals("VII") ? "7": first.equals("VI") ? "6": first.equals("V") ? "5": first.equals("IV") ? "4": first.equals("III") ? "3": first.equals("II") ? "2": first.equals("I") ? "1": "0";
					second=second.equals("X") ? "10": second.equals("IX") ? "9": second.equals("VIII") ? "8": second.equals("VII") ? "7": second.equals("VI") ? "6": second.equals("V") ? "5": second.equals("IV") ? "4": second.equals("III") ? "3": second.equals("II") ? "2": second.equals("I") ? "1": "0";
					if(Integer.parseInt(first)>10 || Integer.parseInt(second)>10 || first.equals("0") || second.equals("0")){
						error(1);
					}
					else{
						calculate(Double.parseDouble(first),operator,Double.parseDouble(second),2);
					}
				}
				else{
					error(0);
				}
			}
			else{
				if(task.equals("x")){
					System.out.println("Good bye!");
					System.out.println("");
					break;
				}
				error(0);
			}
		}
	}
	
	public static void error(int n){
		if(n==1){
			System.out.println("Error. It is allowed to use numbers no more than 10.");
		}
		else if(n==2){
			System.out.println("The result is a number that cannot be written in Roman numerals.");
		}
		else if(n==3){
			System.out.println("Error. Division by zero is not possible.");
		}
		else{
			System.out.println("Error. Format is '1+1' for Arabic or 'I+I' for Roman numerals.");
		}
	}
	
	public static void calculate(double f, String o, double s, int type){
		Double result = 0.0;
		String res;
		String rom_f;
		String rom_s;
		String rom_r;
		if(o.equals("+")){
			result = f + s;
		}else if(o.equals("-")){
			result = f - s;
		}else if(o.equals("*")){
			result = f * s;
		}else if(o.equals("/")){
			result = f / s;
		}
		if(type==1){
			if(result==result.intValue()){
				res=Integer.toString(result.intValue());
			}else{
				res=Double.toString(result);
			}
			System.out.println(String.format("%d",(long)f) + o + String.format("%d",(long)s) + "="+res);
		}
		else{
			rom_f=String.format("%d",(long)f);
			rom_s=String.format("%d",(long)s);
			rom_r=Integer.toString(result.intValue());
			rom_f=arabic2roman(rom_f);
			rom_s=arabic2roman(rom_s);
			if(result<11){
				rom_r=arabic2roman(rom_r);
			}
			else if(result<20){
				result=result-10;
				rom_r=Integer.toString(result.intValue());
				rom_r=arabic2roman(rom_r);
				rom_r="X"+rom_r;
			}
			else if(result<30){
				result=result-20;
				rom_r=Integer.toString(result.intValue());
				rom_r=arabic2roman(rom_r);
				if(result==0){
					rom_r="XX";
				}else{
					rom_r="XX"+rom_r;
				}
			}
			else if(result<40){
				result=result-30;
				rom_r=Integer.toString(result.intValue());
				rom_r=arabic2roman(rom_r);
				if(result==0){
					rom_r="XXX";
				}else{
					rom_r="XXX"+rom_r;
				}
			}
			else if(result<50){
				result=result-40;
				rom_r=Integer.toString(result.intValue());
				rom_r=arabic2roman(rom_r);
				if(result==0){
					rom_r="XXXX";
				}else{
					rom_r="XXXX"+rom_r;
				}
			}
			else if(result<60){
				result=result-50;
				rom_r=Integer.toString(result.intValue());
				rom_r=arabic2roman(rom_r);
				if(result==0){
					rom_r="XXXXX";
				}else{
					rom_r="XXXXX"+rom_r;
				}
			}
			else if(result<70){
				result=result-60;
				rom_r=Integer.toString(result.intValue());
				rom_r=arabic2roman(rom_r);
				if(result==0){
					rom_r="XXXXXX";
				}else{
					rom_r="XXXXXX"+rom_r;
				}
			}
			else if(result<80){
				result=result-70;
				rom_r=Integer.toString(result.intValue());
				rom_r=arabic2roman(rom_r);
				if(result==0){
					rom_r="XXXXXXX";
				}else{
					rom_r="XXXXXXX"+rom_r;
				}
			}
			else if(result<90){
				result=result-80;
				rom_r=Integer.toString(result.intValue());
				rom_r=arabic2roman(rom_r);
				if(result==0){
					rom_r="XXXXXXXX";
				}else{
					rom_r="XXXXXXXX"+rom_r;
				}
			}
			else if(result<100){
				result=result-90;
				rom_r=Integer.toString(result.intValue());
				rom_r=arabic2roman(rom_r);
				if(result==0){
					rom_r="XXXXXXXXX";
				}else{
					rom_r="XXXXXXXXX"+rom_r;
				}
			}
			else{
				rom_r="XXXXXXXXXX";
			}
			if(rom_r.equals("0")){
				error(2);
				return;
			}
			System.out.println(rom_f+o+rom_s+"="+rom_r);
		}
	}
	
	public static String arabic2roman(String s) {
		String result = new String();
		result=s.equals("10") ? "X": s.equals("9") ? "IX": s.equals("8") ? "VIII": s.equals("7") ? "VII": s.equals("6") ? "VI": s.equals("5") ? "V": s.equals("4") ? "IV": s.equals("3") ? "III": s.equals("2") ? "II": s.equals("1") ? "I": "0";
		return result;
	}
}
