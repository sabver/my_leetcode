package leetcode.medium;

public class Pow {
	public double myPow(double x, int n) {
		if (n < 0) {
			return 1 / pow(x, -n);
		} else {
			return pow(x, n);
		}
	}

	public double pow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}
		double result = pow(x, n / 2);
		if (n % 2 == 0) {
			return result * result;
		} else {
			return result * result * x;
		}
	}

	public static void main(String[] args) {
		Pow p = new Pow();
		System.out.println(p.myPow(2, -1));
	}
}
