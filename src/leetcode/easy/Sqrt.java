package leetcode.easy;

public class Sqrt {
	/**
	 * 用牛顿迭代法进行近似 F = x-t^2 求F=0时t的值
	 * 
	 * @param x
	 * @return
	 */
	public int mySqrt(int x) {
		double xn = x/2;
		double xn1 = getXn1(xn, x);
//		System.out.println(xn1);
		while (xn1 * xn1 - x > 0.01) {
			xn = xn1;
			xn1 = getXn1(xn, x);
//			System.out.println(xn1);
		}
		return (int) (xn1);
	}

	/**
	 * xn+1 = xn-(x-xn^2)/(-2xn)=xn+x/2xn-xn/2
	 */
	public double getXn1(double xn, int x) {
		return xn + (double) x / (2 * xn) - xn / 2;
	}

	public static void main(String[] args) {
		Sqrt s = new Sqrt();
		System.out.println(s.mySqrt(2147395600));
		System.out.println(46339 * 46339);
	}
}
