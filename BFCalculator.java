public class BFCalculator {
  BigFraction register[] = new BigFraction[26];
  BigFraction prev = new BigFraction(0, 0);

  public BigFraction evaluate(String exp) {
    String[] inpStr = exp.split("\\s+");
    String inp = inpStr[0];
    int cha = (int) inp.charAt(0);
    int base = (int) 'a';
    int end = (int) 'z';
    if (exp.equals("")) {
      return new BigFraction(0, 0);
    }
    if ((cha <= end) && (cha >= base)) {
      BigFraction update = (register[cha - base]);
      for (int i = 1; i < inpStr.length; i++) {
        inp = inpStr[i + 1];
        cha = inp.charAt(0);
        if ((cha <= end) && (cha >= base)) {
          BigFraction updater = (register[cha - base]);
          if (inpStr[i].equals("+")) {
            update = update.add(updater);
          }
          if (inpStr[i].equals("-")) {
            update = update.subtract(updater);
          }
          if (inpStr[i].equals("/")) {
            update = update.divide(updater);
          }
          if (inpStr[i].equals("*")) {
            update = update.multiply(updater);
          }
          i++;
        }

        else {
          BigFraction updater = new BigFraction(inpStr[i + 1]);
          if (inpStr[i].equals("-")) {
            update = update.subtract(updater);
          }
          if (inpStr[i].equals("+")) {
            update = update.add(updater);
          }
          if (inpStr[i].equals("/")) {
            update = update.divide(updater);
          }
          if (inpStr[i].equals("*")) {
            update = update.multiply(updater);
          }
          i++;
        }
      }
      prev = update;
      return update;
    } else {
      BigFraction update = new BigFraction(inpStr[0]);
      for (int i = 1; i < inpStr.length; i++) {
        inp = inpStr[i + 1];
        cha = inp.charAt(0);
        if ((cha >= 97) && (cha <= 122)) {
          BigFraction updater = (register[cha - 97]);
          if (inpStr[i].equals("+")) {
            update = update.add(updater);
          }
          if (inpStr[i].equals("-")) {
            update = update.subtract(updater);
          }
          if (inpStr[i].equals("/")) {
            update = update.divide(updater);
          }
          if (inpStr[i].equals("*")) {
            update = update.multiply(updater);
          }
          i++;
        } else {
          BigFraction updater = new BigFraction(inpStr[i + 1]);
          if (inpStr[i].equals("+")) {
            update = update.add(updater);
          }
          if (inpStr[i].equals("-")) {
            update = update.subtract(updater);
          }
          if (inpStr[i].equals("/")) {
            update = update.divide(updater);
          }
          if (inpStr[i].equals("*")) {
            update = update.multiply(updater);
          }
          i++;
        }
      }
      prev = update;
      return update;
    }
  }

  public BigFraction[] store(char register) {
    int base = (int) 'a';
    int arrCha = register;
    arrCha = arrCha - base;
    this.register[arrCha] = prev;

    return this.register;
  }
}
