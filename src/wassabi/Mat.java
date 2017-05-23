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
	int n;
	int m;
	double[][] mat;

	/**
	 * constructor empty m x n matrix
	 * 
	 * @param i
	 */
	public Mat(int m, int n) {
		this.n = n;
		this.m = m;
		mat = new double[m][n];
	}

	/**
	 * constructor m x n and inits it with mat use with care, since it's not
	 * looking for faulty input
	 * 
	 * @param n
	 * @param m
	 * @param mat
	 */
	public Mat(double[][] mat) {
		this.mat = mat;
		this.m = mat.length;
		this.n = mat[0].length;
	}

	/**
	 * constructor for permutation matrix p contains the pasitions of 1 for
	 * matrix 1 are set from top to buttom
	 * 
	 * @param p
	 */
	public Mat(int[] p) {
		n = p.length;
		mat = new double[n][n];
		m = n;
		int i = 0;
		for (int x : p) {
			mat[i++][x] = 1;
		}
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
	public Mat inv(boolean debug) {
		double[][] x = mat;
		Mat p = identity(n);
		double u; // represents current multiplikator
		double d; // represents multiplikator of row
		for (int i = 0; i < m; i++) { // traversing top -> down
			u = x[i][i];
			for (int k = 0; k < m; k++) { // creating zeros
				d = x[k][i];
				if (u * d > 0)
					d *= -1;
				if (d == 0 || k == i) {
					continue;
				}
				for (int j = 0; j < n; j++) { // applying to complete row
					if (j >= i) {
						x[k][j] = (x[i][j] * d) + (x[k][j] * u);
					}
					p.mat[k][j] = (p.mat[i][j] * d) + (p.mat[k][j] * u);
				}
			}
		}
		return p;
	}

	@Override
	public String toString() {
		return matString(mat, m, n);
	}

	public static String matString(double[][] mat, int m, int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (j != 0)
					sb.append("\t");
				else
					sb.append("|");
				sb.append(mat[i][j]);
				sb.append(",");
			}
			sb.append("|\n");
		}
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
}
