package wassabi;

/**
 * 
 * @author PakaBelly
 *
 * mat is represented as m x n Matrix
 * --> int[m][n]
 */
public class Mat {
	int n;
	int m;
	int[][] mat;

	/**
	 * constructor empty m x n matrix
	 * @param i
	 */
	public Mat(int i) {
		n = i;
		m = i;
		mat = new int[i][i];
	}

	/**
	 * constructor m x n  and inits it with mat
	 * use with care, since it's not looking for faulty input
	 * @param n
	 * @param m
	 * @param mat
	 */
	public Mat(int n, int m, int[][] mat) {
		this.mat = mat;
		this.m = m;
		this.n = n;
	}

	/**
	 * constructor for permutation matrix
	 * p contains the pasitions of 1 for matrix
	 * 1 are set from top to buttom
	 * @param p
	 */
	public Mat(int[] p) {
		n = p.length;
		mat = new int[n][n];
		int i = 0;
		for (int x : p) {
			mat[i++][x] = 1;
		}
	}

	/**
	 * multiplies this matrix with b
	 * @param b
	 * @return
	 */
	public Mat mult(Mat b) {
		// asdasdasdad nonsesensensnesnense
		Mat ret = new Mat(b.mat[0]);

		return ret;
	}

	/**
	 * creates identity matrix with this matrix dimensions
	 * @param n
	 * @return
	 */
	public static Mat identity(int n){
		int[] p = new int[n];
		for(int  i = 0; i < n; i++){
			p[i] = i;
		}
		return new Mat(p);
	}

	/**
	 * return invers of this matrix
	 * @param n
	 * @return
	 */
	public Mat inv() {
		int[][] x = mat;
		Mat p = identity(n);

		for(int i = 0; i < n; i++){
			
		}
		
		return p;
	}
}
