/*
 * Decompiled with CFR 0_102.
 */
package audiostegnogarphy;

import java.io.PrintStream;

public class Complex {
    private final double re;
    private final double im;

    public Complex(double real, double imag) {
        this.re = real;
        this.im = imag;
    }

    public String toString() {
        if (this.im == 0.0) {
            return "" + this.re + "";
        }
        if (this.re == 0.0) {
            return "" + this.im + "i";
        }
        if (this.im < 0.0) {
            return "" + this.re + " - " + (- this.im) + "i";
        }
        return "" + this.re + " + " + this.im + "i";
    }

    public double abs() {
        return Math.hypot(this.re, this.im);
    }

    public double phase() {
        return Math.atan2(this.im, this.re);
    }

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

    public Complex times(double alpha) {
        return new Complex(alpha * this.re, alpha * this.im);
    }

    public Complex conjugate() {
        return new Complex(this.re, - this.im);
    }

    public Complex reciprocal() {
        double scale = this.re * this.re + this.im * this.im;
        return new Complex(this.re / scale, (- this.im) / scale);
    }

    public double re() {
        return this.re;
    }

    public double im() {
        return this.im;
    }

    public Complex divides(Complex b) {
        Complex a = this;
        return a.times(b.reciprocal());
    }

    public Complex exp() {
        return new Complex(Math.exp(this.re) * Math.cos(this.im), Math.exp(this.re) * Math.sin(this.im));
    }

    public Complex sin() {
        return new Complex(Math.sin(this.re) * Math.cosh(this.im), Math.cos(this.re) * Math.sinh(this.im));
    }

    public Complex cos() {
        return new Complex(Math.cos(this.re) * Math.cosh(this.im), (- Math.sin(this.re)) * Math.sinh(this.im));
    }

    public Complex tan() {
        return this.sin().divides(this.cos());
    }

    public static Complex plus(Complex a, Complex b) {
        double real = a.re + b.re;
        double imag = a.im + b.im;
        Complex sum = new Complex(real, imag);
        return sum;
    }

    public static void main(String[] args) {
        Complex a = new Complex(5.0, 6.0);
        Complex b = new Complex(-3.0, 4.0);
        System.out.println("a            = " + a);
        System.out.println("b            = " + b);
        System.out.println("Re(a)        = " + a.re());
        System.out.println("Im(a)        = " + a.im());
        System.out.println("b + a        = " + b.plus(a));
        System.out.println("a - b        = " + a.minus(b));
        System.out.println("a * b        = " + a.times(b));
        System.out.println("b * a        = " + b.times(a));
        System.out.println("a / b        = " + a.divides(b));
        System.out.println("(a / b) * b  = " + a.divides(b).times(b));
        System.out.println("conj(a)      = " + a.conjugate());
        System.out.println("|a|          = " + a.abs());
        System.out.println("tan(a)       = " + a.tan());
    }
}

