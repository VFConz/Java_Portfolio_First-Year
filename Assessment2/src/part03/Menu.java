package part03;

import java.util.Scanner;


public class Menu {
	private final String title;
	private final String[] items;
	private final Scanner input;

	public Menu(String title, String[] options) {
		this.title = title;
		items = options;
		input = new Scanner(System.in);
	}

	public void display() {
		System.out.println(title);
		for (int i = 0; i < title.length(); i++) {
			System.out.print("+");
		}
		System.out.println();
		for (int opt = 1; opt <= items.length; opt++) {
			System.out.println(opt + ". " + items[opt - 1]);
		}
		System.out.println();
	}

	public int getUserChoice() {
		int value = 0;
		do {
			try {
				System.out.print("Enter Selection: ");
				value = input.nextInt();
				break;
			}
			catch(Exception ex) {
				System.out.println("Invalid menu option - try again!");
				input.nextLine();
			}
		} while (true);
		return value;
	}

}
