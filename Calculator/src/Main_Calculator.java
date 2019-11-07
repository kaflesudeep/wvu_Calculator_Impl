import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import external_lib.ArithmeticFunctions;

public class Main_Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean loop = true;

		Scanner sc = new Scanner(System.in);

		try {

		} catch (Exception ex) {

		}

		while (loop) {
			System.out.println("***********************************************************************");
			System.out.println("Simple Calculation operation");
			String operation = null, data_type = null, first_num = null, second_num = null;
			try {
				System.out.println("Enter 1 for additon, 2 for Subtraction, 3 for Multiplication, 4 for Division ");
				System.out.println("NOte: If you select invalid number addition will be performed");
				operation = sc.next();
				System.out.println("Enter 1 for integer, 2 for float, 3 for binary, 4 fro Octal, 5 for hexadeciaml");
				System.out.println("NOte: If you select invalid number integer will be considered");
				data_type = sc.next();
				System.out.println("Enter First number ");
				first_num = sc.next();

				System.out.println("Enter Second number ");
				second_num = sc.next();

			} catch (Exception ex) {
				System.out.println(" !!!!Please read the instruction Carefully and and Try Again!!!!");
			}

			String result = calculate(operation, data_type, first_num, second_num);
			System.out.println("$$$  The reuslt is $$$");
			System.out.println(result);
			System.out.println("***********************************************************************");
			System.out.println("Enter 1 to continue. enter anny other number to end");

			int loopcond = 0;
			try {
				loopcond = sc.nextInt();

			} catch (Exception ex) {
				System.out.println(" !!!!Please read the instruction Carefully and Try Again!!!!");
			}

			if (loopcond != 1) {
				loop = false;
			}
			System.out.println("***********************************************************************");
		}

	}

	private static String calculate(String operation, String data_type, String first_num, String second_num) {
		String opp = "add";
		switch (operation) {
		case "1":
			opp = "add";
			break;
		case "2":
			opp = "subtract";
			break;
		case "3":
			opp = "multiply";
			break;
		case "4":
			opp = "divide";
			break;
		default:
			opp = "add";
			break;

		}

		String methodType = "";
		switch (data_type) {
		case "1":
			methodType = opp;
			break;
		case "2":
			methodType = opp;
			break;
		case "3":
			methodType = opp + "Bin";
			break;
		case "4":
			methodType = opp + "Oct";
			break;
		case "5":
			methodType = opp + "Hex";
			break;
		default:
			methodType = opp;
			break;
		}
		String result = "";
		ArithmeticFunctions obj = new ArithmeticFunctions();
		try {
			Method sumInstanceMethod = external_lib.ArithmeticFunctions.class.getMethod(methodType, String.class,
					String.class);
			try {
				result = (String) sumInstanceMethod.invoke(obj, first_num, second_num);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(" !!!!Please read the instruction Carefully and enter valid  Entry!!!!");

			}
		} catch (Exception e) {
			System.out.println("!!!!Please read the instruction Carefully and enter valid  value!!!!");

		}
		return result;
	}

}
