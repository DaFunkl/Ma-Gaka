package wassabi;

public class Gaus {

	Mat lM;
	Mat rM;
	Mat aM;
	Mat pM;
	Mat bV;
	
	private Gaus(){
		super();
	}

	public static Gaus calculateGaus(Mat a, Mat b) {
		Mat ai = new Mat(a);
		Mat bi = new Mat(b);
		for (int i = 0; i < ai.m; i++) {
			System.out.println("Schritt "+i+":\n"+ ai);
			// Pivotsuche:
			double pivot = Math.abs(ai.mat[i][i]);
			int maxindex = i;
			for (int index = i; index < ai.m; index++) {
				if (pivot < Math.abs(ai.mat[index][i])){
					pivot = Math.abs(ai.mat[index][i]);
					maxindex = index;
				}
			}
			ai.swapLine(i, maxindex);
			bi.swapLine(i, maxindex);
			// lM/rM.swap

			// Elimination
			for (int index = i + 1; index < ai.m; index++) {
				double l = ai.mat[index][i] / ai.mat[i][i];
				// l->lM
				ai.mat[index][i] = 0;
				for (int k = i + 1; k < ai.n; k++) {
					ai.mat[index][k] -= ai.mat[i][k] * l;
				}
				for (int k = 0; k < bi.n; k++) {
					bi.mat[index][k] -= bi.mat[i][k] * l;
				}
				// for switch l
			}
			
		}
		
		// save a to r;
		// save l;
		for (int i = ai.m - 1; i >= 0; i--) {
			double temp = ai.mat[i][i];
			ai.mat[i][i] = 1;
			for (int k = 0; k < bi.n; k++) {
				bi.mat[i][k] /= temp;
			}
			for (int j = 0; j < i; j++) {
				double l = ai.mat[j][i];
				ai.mat[j][i] = 0;
				for (int k = 0; k < bi.n; k++) {
					bi.mat[j][k] -= bi.mat[i][k] * l;
				}
			}

		}
		Gaus g = new Gaus();
		g.aM = ai;
		g.bV = bi;
		return g;
	}

	public String toString() {
		if (lM != null)
			System.out.println("L:\n"+lM);
		if (rM != null)
			System.out.println("R:\n"+rM);
		if (pM != null)
			System.out.println("P:\n"+pM);
		if (aM != null)
			System.out.println("A:\n"+aM);
		if (bV != null)
			System.out.println("B:\n"+bV);

		return null;

	}
}
