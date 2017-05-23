package wassabi;

public class Mat {
	int n;
	int m;
	int[][] mat;

	public Mat(int i) {
		n = i;
		mat = new int[i][i];
	}

	public Mat(int n, int[][] m) {
		this.mat = m;
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
		for(int i ){
			
		}
	}

	public Mat inv() {
		
	}
}
