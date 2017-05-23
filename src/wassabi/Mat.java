package wassabi;

public class Mat {
	int n;
	int m;
	int[][] mat;

	public Mat(int i) {
		n = i;
		mat = new int[i][i];
	}

	public Mat(int n, int m, int[][] mat) {
		this.mat = mat;
		this.m = m;
		this.n = n;
	}

	public Mat(int[] p) {
		n = p.length;
		mat = new int[n][n];
		int i = 0;
		for (int x : p) {
			mat[i++][x] = 1;
		}
	}

	public Mat mult(Mat b) {
		// asdasdasdad nonsesensensnesnense
		Mat ret = new Mat(b.mat[0]);
		
		
		return ret;
	}

	public Mat inv() {
		int [][] x = mat;
		int[] px = new int[n];
		for(int i = 0; i < n; i++){
			px[i] = i;
		}
		// das ist die Einheitsmatrix, welche umgeformt werden soll, sodass das inverse entsteht
		Mat p = new Mat(px);
		
		return p;
	}
}
