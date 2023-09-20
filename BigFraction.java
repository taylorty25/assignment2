import java.math.BigInteger;

/**
 * A simple implementation of Fractions.
 * 
 * @author Samuel A. Rebelsky
 * @author Tyrell Taylor
 * @version 1.2 of August 2023
 */
public class BigFraction {
  // +------------------+---------------------------------------------
  // | Design Decisions |
  // +------------------+
  /*
   * (1) Denominators are always positive. Therefore, negative fractions are represented with a
   * negative numerator. Similarly, if a fraction has a negative numerator, it is negative.
   * 
   * (2) Fractions are not necessarily stored in simplified form. To obtain a fraction in simplified
   * form, one must call the `simplify` method.
   */

  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  /** The numerator of the fraction. Can be positive, zero or negative. */
  BigInteger num;

  /** The denominator of the fraction. Must be non-negative. */
  BigInteger denom;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new fraction with numerator num and denominator denom.
   * 
   * Warning! Not yet stable.
   */
  public BigFraction(BigInteger num, BigInteger denom) {
    this.num = num;
    this.denom = denom;
  } // BigFraction(BigInteger, BigInteger)

  /**
   * Build a new fraction with numerator num and denominator denom.
   * 
   * Warning! Not yet stable.
   */
  public BigFraction(int num, int denom) {
    this.num = BigInteger.valueOf(num);
    this.denom = BigInteger.valueOf(denom);
  } // BigFraction(int, int)

  /**
   * Build a new fraction by parsing a string.
   *
   * Warning! Not yet implemented.
   */
  public BigFraction(String str) {
    this.num = new BigInteger(str.substring(0, str.indexOf('/')));
    this.denom = new BigInteger(str.substring(str.indexOf('/') + 1));
  } // BigFraction

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Express this fraction as a double.
   */
  public double doubleValue() {
    return this.num.doubleValue() / this.denom.doubleValue();
  } // doubleValue()

  public static BigFraction simplify(BigFraction simply) {
    if ((simply.denom.mod(simply.num).equals(BigInteger.valueOf(0)))) {
      simply.num = BigInteger.valueOf(1);
      simply.denom = simply.denom.divide(simply.num);
    }
    return simply;
  }

  public BigFraction multiply(BigFraction mult2) {
    BigInteger resultNum;
    BigInteger resultDen;
    resultNum = this.num.multiply(mult2.num);
    resultDen = this.denom.multiply(mult2.denom);
    return simplify(new BigFraction(resultNum, resultDen));
  }

  public BigFraction divide(BigFraction mult2) {
    BigInteger resultNum;
    BigInteger resultDen;
    resultNum = this.denom.multiply(mult2.num);
    resultDen = this.num.multiply(mult2.denom);
    return simplify(new BigFraction(resultNum, resultDen));
  }

  public BigFraction fractional() {
    BigInteger resultNum;
    resultNum = this.num.remainder(this.denom);
    return new BigFraction(resultNum, this.denom);
  }

  /**
   * Add the fraction `addMe` to this fraction.
   */
  public BigFraction add(BigFraction addMe) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the
    // product of this object's denominator
    // and addMe's denominator
    resultDenominator = this.denom.multiply(addMe.denom);
    // The numerator is more complicated
    resultNumerator = (this.num.multiply(addMe.denom)).add(addMe.num.multiply(this.denom));

    // Return the computed value
    return simplify(new BigFraction(resultNumerator, resultDenominator));
  }// add(BigFraction)

  public BigFraction subtract(BigFraction subMe) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;
    resultNumerator = (this.num.multiply(subMe.denom)).subtract(subMe.num.multiply(this.denom));
    resultDenominator = this.denom.multiply(subMe.denom);
    return simplify(new BigFraction(resultNumerator, resultDenominator));
  }

  /**
   * Get the denominator of this fraction.
   */
  public BigInteger denominator() {
    return this.denom;
  } // denominator()

  /**
   * Get the numerator of this fraction.
   */
  public BigInteger numerator() {
    return this.num;
  } // numerator()

  public String toString() {
    // Special case: It's zero
    if (this.num.equals(BigInteger.ZERO)) {
      return "0";
    } // if it's zero
    if (this.num.divide(this.denom).intValue() < 1) {
      simplify(this);
    } else if ((this.num.divide(this.denom).intValue() >= 1)
        && (this.num.mod(this.denom).equals(BigInteger.valueOf(0)))) {
      return this.num.divide(this.denom).toString();
    } else {
      return this.num.intValue() / this.denom.intValue() + " " + this.num + "/" + this.denom;
    }
    // Lump together the string represention of the numerator,
    // a slash, and the string representation of the denominator
    // return this.num.toString().concat("/").concat(this.denom.toString());
    return this.num + "/" + this.denom;
  } // toString()
} // class BigFraction
