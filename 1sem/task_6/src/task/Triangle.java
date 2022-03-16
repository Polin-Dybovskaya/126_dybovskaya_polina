package task;

public class Triangle {
    private double A;
    private double B;
    private double C;

    public Triangle(double A, double B, double C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public double getA() {
        return A;
    }

    public double getB() {
        return B;
    }

    public double getC() {
        return C;
    }

    public boolean isValid() {
        if ((A + B > C) && (A + C > B) && (C + B > A)) return true;
        else {
            return false;
        }
    }

    public double perimeter() {
        if (isValid()) return (A + B + C);
        return (-1);
    }

    public double square() {
        if (!isValid())
            return -1;
        double p;
        p = (A + B + C) / 2;
        return Math.sqrt(p * (p - A) * (p - B) * (p - C));
    }
}
