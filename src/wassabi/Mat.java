package wassabi;

import java.util.Arrays;
import javax.activation.UnsupportedDataTypeException;

/**
 * 
 * @author PakaBelly
 *
 *         mat is represented as m x n Matrix --> int[m][n]
 */
public class Mat {
	final int n;
	final int m;
	final int[][] mat;

	/**
	 * constructor empty m x n matrix
	 * 
	 * @param i
	 */
	public Mat(int m, int n) {
		this.n = n;
		this.m = m;
		mat = new int[m][n];
	}

	/**
	 * constructor m x n and inits it with mat use with care, since it's not
	 * looking for faulty input
	 * 
	 * @param n
	 * @param m
	 * @param mat
	 */
	public Mat(int[][] mat) {
		this.mat = mat;
		this.m = mat.length;
		this.n = mat[1].length;
	}

	/**
	 * constructor for permutation matrix p contains the pasitions of 1 for
	 * matrix 1 are set from top to buttom
	 * 
	 * @param p
	 */
	public Mat(int[] p) {
		n = p.length;
		mat = new int[n][n];
		m = n;
		int i = 0;
		for (int x : p) {
			mat[i++][x] = 1;
		}
	}

	public Mat(Mat a) {
		int[][] mat = new int[a.mat.length][];
		for(int i = 0; i < a.mat.length;i++){
			mat[i] = a.mat[i].clone();
		}
		this.mat = mat;
		m = a.m;
		n = a.n;
	}

	/**
	 * multiplies this matrix with b
	 * 
	 * @param b
	 * @return
	 * @throws UnsupportedDataTypeException
	 */

	public Mat mult(Mat b) throws UnsupportedDataTypeException {
		if (this.n != b.m)
			throw new UnsupportedDataTypeException("Wrong dimensions " + this.n + " != " + b.m);
		Mat c = new Mat(this.m, b.n);

		// slow, very slow
		for (int k = 0; k < this.n; k++) {
			for (int i = 0; i < this.m; i++) {
				for (int j = 0; j < b.n; j++) {
					c.mat[i][j] += this.mat[i][k] * b.mat[k][j];
				}
			}
		}
		return c;
	}

	/**
	 * creates identity matrix with this matrix dimensions
	 * 
	 * @param n
	 * @return
	 */
	public static Mat identity(int n) {
		int[] p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = i;
		}
		return new Mat(p);
	}

	/**
	 * return invers of this matrix
	 * 
	 * @param n
	 * @return
	 */
	public Mat inv() {
		int[][] x = mat;
		Mat p = identity(n);

		for (int i = 0; i < n; i++) {

		}

		return p;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{\n");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				sb.append("\t");
				sb.append(mat[i][j]);
				sb.append(",");
			}
			sb.append("\n");
		}
		sb.append("}");
		return sb.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj.getClass() == this.getClass()) {
			Mat o = (Mat) obj;
			return Arrays.deepEquals(mat, o.mat);
		}
		return false;
	}

	public void swapLine(int i, int i2) {
		int[] line = mat[i];
		mat[i] = mat[i2];
		mat[i2] = line;
	}
}
