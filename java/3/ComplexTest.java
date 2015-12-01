package ntou.cs.java2015.yuhang;
import java.util.*;
public class ComplexTest{
  public static void main(String[] args) {
      Complex a = new Complex(5.0, 6.0);
      Complex b = new Complex(-3.0, 4.0);
      System.out.println("a = " + a);
      System.out.println("conjugates of a = " + a.conjugate());
      System.out.printf("Absolute value of a = %.2f\n",a.abs());
      System.out.println("b = " + b);
      System.out.println("conjugates of b = " + b.conjugate());
      System.out.printf("Absolute value of b = %.2f" , b.abs());
      System.out.println("a + b = " + a.plus(b));
      System.out.println("a - b = " + a.minus(b));
      System.out.println("a X b = " + a.times(b));
      System.out.println("a ÷ b = " + a.divides(b));
  }
}
