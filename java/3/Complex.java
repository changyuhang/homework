package ntou.cs.java2015.yuhang;
import java.text.DecimalFormat;
public class Complex {
    private final double re;
    private final double im;
    DecimalFormat df = new DecimalFormat("0.00");

    public Complex(double real, double imag) {
        re = real;
        im = imag;
    }

    public String toString() {
        if (im == 0) return df.format(re) + "";
        if (re == 0) return df.format(im) + "i";
        if (im <  0) return df.format(re) + " - " + df.format(-im) + "i";
        return df.format(re) + " + " + df.format(im) + "i";
    }

    public double abs()   { return Math.hypot(re, im); }

    public Complex plus(Complex b) {
        Complex a = this;
        double real = a.re + b.re;
        double imag = a.im + b.im;
        return new Complex(real, imag);
    }

    public Complex minus(Complex b) {
        Complex a = this;
        double real = a.re - b.re;
        double imag = a.im - b.im;
        return new Complex(real, imag);
    }

    public Complex times(Complex b) {
        Complex a = this;
        double real = a.re * b.re - a.im * b.im;
        double imag = a.re * b.im + a.im * b.re;
        return new Complex(real, imag);
    }

    public Complex conjugate() {  return new Complex(re, -im); }

    public Complex reciprocal() {
        double scale = re*re + im*im;
        return new Complex(re / scale, -im / scale);
    }

    public Complex divides(Complex b) {
        Complex a = this;
        return a.times(b.reciprocal());
    }
}
