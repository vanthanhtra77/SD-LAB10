import exercise8_6.Exercise86Demo;
import exercise8_7.Exercise87Demo;

/**
 * Master Main entry point for Lab 10: runs demos for both Exercise 8.6 and Exercise 8.7.
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("############################################################");
		System.out.println("                 LAB 10: OBSERVER PATTERN                   ");
		System.out.println("############################################################\n");

		// Run Exercise 8.6 Demo
		Exercise86Demo.main(args);

		System.out.println("\n\n");

		// Run Exercise 8.7 Demo
		Exercise87Demo.main(args);

		System.out.println("############################################################");
		System.out.println("               END OF LAB 10 DEMONSTRATION                  ");
		System.out.println("############################################################");
	}
}
