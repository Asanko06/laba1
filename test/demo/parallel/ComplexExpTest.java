package demo.parallel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComplexExpTest {

    @Test
    public void testExpReal() {
        Complex a = new Complex(2, 0);
        Complex result = a.exp();

        assertEquals(Math.exp(2), result.getRe(), 1e-10, "exp(2) real part");
        assertEquals(0, result.getIm(), 1e-10, "exp(2) imaginary part");
    }

    @Test
    public void testExpImaginary() {
        Complex a = new Complex(0, Math.PI); // i*π
        Complex result = a.exp();

        assertEquals(-1, result.getRe(), 1e-10, "exp(iπ) real part (формула Эйлера)");
        assertEquals(0, result.getIm(), 1e-10, "exp(iπ) imaginary part");
    }

    @Test
    public void testExpComplex() {
        Complex a = new Complex(1, Math.PI/2); // 1 + i*π/2
        Complex result = a.exp();

        double expectedRe = Math.exp(1) * Math.cos(Math.PI/2);
        double expectedIm = Math.exp(1) * Math.sin(Math.PI/2);

        assertEquals(expectedRe, result.getRe(), 1e-10, "exp(1 + iπ/2) real part");
        assertEquals(expectedIm, result.getIm(), 1e-10, "exp(1 + iπ/2) imaginary part");
    }

    @Test
    public void testExpZero() {
        Complex a = new Complex(0, 0);
        Complex result = a.exp();

        assertEquals(1, result.getRe(), 1e-10, "exp(0) real part");
        assertEquals(0, result.getIm(), 1e-10, "exp(0) imaginary part");
    }

    @Test
    public void testExpNegativeReal() {
        Complex a = new Complex(-1, 0);
        Complex result = a.exp();

        assertEquals(1/Math.exp(1), result.getRe(), 1e-10, "exp(-1) real part");
        assertEquals(0, result.getIm(), 1e-10, "exp(-1) imaginary part");
    }

    @Test
    public void testExpHalfPiImaginary() {
        Complex a = new Complex(0, Math.PI/2); // i*π/2
        Complex result = a.exp();

        assertEquals(0, result.getRe(), 1e-10, "exp(iπ/2) real part");
        assertEquals(1, result.getIm(), 1e-10, "exp(iπ/2) imaginary part");
    }

    @Test
    public void testExpTwoPiImaginary() {
        Complex a = new Complex(0, 2*Math.PI); // i*2π
        Complex result = a.exp();

        assertEquals(1, result.getRe(), 1e-10, "exp(i2π) real part");
        assertEquals(0, result.getIm(), 1e-10, "exp(i2π) imaginary part");
    }

    @Test
    public void testExpConjugateIdentity() {
        Complex a = new Complex(2, 3);

        Complex expConjugate = a.conjugate().exp();
        Complex conjugateExp = a.exp().conjugate();

        assertEquals(expConjugate.getRe(), conjugateExp.getRe(), 1e-10, "exp(conjugate(z)) real part");
        assertEquals(expConjugate.getIm(), conjugateExp.getIm(), 1e-10, "exp(conjugate(z)) imaginary part");
    }

    @Test
    public void testExpMagnitude() {
        Complex a = new Complex(2, 3);
        Complex result = a.exp();

        double expectedMagnitude = Math.exp(2); // |exp(a+bi)| = exp(a)
        double actualMagnitude = Math.sqrt(result.getRe() * result.getRe() + result.getIm() * result.getIm());

        assertEquals(expectedMagnitude, actualMagnitude, 1e-10, "|exp(z)| should equal exp(Re(z))");
    }
}