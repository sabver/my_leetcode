package leetcode.test;


public class Test {
	
	public static void main(String[] args) {
		int [] x = new int[3];
		int [] y = new int[3];
		x[0] = 1;
		y[0] = 2;
		x[1] = 2;
		y[1] = 3;
		x[2] = 4;
		y[2] = 6;
		int a = 19/14;
		int b = 1/2;
		float result = 0.0f;
		for(int i=0;i<3;i++){
			result += (( y[i] - a*x[i] - b ) * ( y[i] - a*x[i] - b ));
		}
		result = result / 3;
		System.out.print(result);
	}
}
