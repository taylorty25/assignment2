public class QuickCalculator{
public static void main(String[] args) {
    BFCalculator Calc = new BFCalculator();
    if(args.length == 0){
    System.out.println("You must enter STORE or a mathematical expression");
    return;
    }
    for (int i = 0; i < args.length; i++){
        String inpStr = args[i];
        if (inpStr.indexOf("STORE") == 0){
            Calc.store(inpStr.charAt(6));
            System.out.println("Stored");
        }
        else {
        System.out.println(Calc.evaluate(inpStr));
        }
    }
}



}