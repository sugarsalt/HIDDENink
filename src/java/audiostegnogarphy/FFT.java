/*
 * Decompiled with CFR 0_102.
 */
package audiostegnogarphy;

import audiostegnogarphy.Complex;

public class FFT {
    public static Complex[] fft(Complex[] x) {
        int N = x.length;
        if (N == 1) {
            return new Complex[]{x[0]};
        }
        if (N % 2 != 0) {
            throw new RuntimeException("N is not a power of 2");
        }
        Complex[] even = new Complex[N / 2];
        for (int k = 0; k < N / 2; ++k) {
            even[k] = x[2 * k];
        }
        Complex[] q = FFT.fft(even);
        Complex[] odd = even;
        for (int k2 = 0; k2 < N / 2; ++k2) {
            odd[k2] = x[2 * k2 + 1];
        }
        Complex[] r = FFT.fft(odd);
        Complex[] y = new Complex[N];
        for (int k3 = 0; k3 < N / 2; ++k3) {
            double kth = (double)(-2 * k3) * 3.141592653589793 / (double)N;
            Complex wk = new Complex(Math.cos(kth), Math.sin(kth));
            y[k3] = q[k3].plus(wk.times(r[k3]));
            y[k3 + N / 2] = q[k3].minus(wk.times(r[k3]));
        }
        return y;
    }

    public static Complex[] ifft(Complex[] x) {
        int i;
        int N = x.length;
        Complex[] y = new Complex[N];
        for (i = 0; i < N; ++i) {
            y[i] = x[i].conjugate();
        }
        y = FFT.fft(y);
        for (i = 0; i < N; ++i) {
            y[i] = y[i].conjugate();
        }
        for (i = 0; i < N; ++i) {
            y[i] = y[i].conjugate();
            y[i] = y[i].times(1.0 / (double)N);
        }
        return y;
    }

    public static double[][] getMag(double[] data, int Fs) {
        data = FFT.correctDataLength(data);
        Complex[] x = new Complex[data.length];
        for (int i = 0; i < data.length; ++i) {
            x[i] = new Complex(data[i], 0.0);
        }
        Complex[] y = FFT.fft(x);
        int n = y.length;
        double[] k = new double[n];
        int j = 0;
        for (int i2 = (- n) / 2; i2 < n / 2 - 1; ++i2) {
            k[j] = i2;
            ++j;
        }
        double T = (double)n / (double)Fs;
        double[] amp = new double[n];
        for (int i3 = 0; i3 < n; ++i3) {
            amp[i3] = y[i3].divides(new Complex(n, 0.0)).abs();
        }
        FFT.fftShift(amp);
        double[][] freqMag = new double[n][2];
        for (int i4 = 0; i4 < n; ++i4) {
            freqMag[i4][0] = k[i4] / T;
            freqMag[i4][1] = amp[i4];
        }
        return freqMag;
    }

    public static void fftShift(double[] x) {
        int i;
        double[] temp = new double[x.length];
        for (i = 0; i < x.length; ++i) {
            temp[i] = x[i];
        }
        for (i = 0; i < x.length / 2; ++i) {
            x[i] = temp[x.length / 2 + i];
            x[x.length / 2 + i] = temp[i];
        }
    }

    public static double[] correctDataLength(double[] in) {
        int n = in.length;
        double x = (int)(Math.log(n) / Math.log(2.0));
        if (Math.abs(x - Math.log(n) / Math.log(2.0)) < 1.0E-6) {
            return in;
        }
        int newLength = (int)Math.pow(2.0, x);
        double[] correctArray = new double[newLength];
        for (int i = 0; i < newLength - 1; ++i) {
            correctArray[i] = i < in.length ? in[i] : 0.0;
        }
        return correctArray;
    }

    public static double[] getFreqs(int n, int fS) {
        double[] freqs = new double[n];
        double[] k = new double[n];
        int j = 0;
        for (int i = (- n) / 2; i < n / 2 - 1; ++i) {
            k[j] = i;
            ++j;
        }
        double T = (double)n / (double)fS;
        for (int i2 = 0; i2 < freqs.length; ++i2) {
            freqs[i2] = k[i2] / T;
        }
        FFT.fftShift(freqs);
        return freqs;
    }
}

