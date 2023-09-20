import java.util.Scanner;

public class InteractiveCalculator {
    public static void main(String[] args) throws Exception {
        Scanner inpStr = new Scanner(System.in);
        BFCalculator Calc = new BFCalculator();
        System.out.println("input a string in the form of 'STORE char', a proper mathamatical expression in order, or type 'QUIT' to quit the program");
        while (true) {
            String inp = inpStr.nextLine();
            if (inp.equals("QUIT")) {
                break;
            }
            if (inp.indexOf("STORE") == 0) {
                Calc.store(inp.charAt(6));
                System.out
                        .println("Stored " + Calc.prev.toString() + " in register " + inp.charAt(6));
            } else {
                System.out.println(Calc.evaluate(inp).toString());
            }

            
        }
        inpStr.close();
    }


}
