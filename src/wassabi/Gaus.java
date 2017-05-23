package wassabi;

public class Gaus {

	Mat lM;
	Mat rM;
	Mat aM;
	Mat pM;
	Mat bM;
	
	private Gaus(){
		super();
	}
	
	public static Gaus l_r_Gaus(Mat a, Mat b){
		Mat aM = new Mat(a);
		Mat bM = new Mat(b);
		Mat pM = Mat.identity(a.m);
		Mat lM = new Mat(a.m,a.m);
		
		for (int i = 0; i < aM.m; i++) {
			// Pivotsuche:
			double pivot = Math.abs(aM.mat[i][i]);
			int maxindex = i;
			for (int index = i; index < aM.m; index++) {
				if (pivot < Math.abs(aM.mat[index][i])){
					pivot = Math.abs(aM.mat[index][i]);
					maxindex = index;
				}
			}
			aM.swapLine(i, maxindex);
			bM.swapLine(i, maxindex);
			pM.swapLine(i, maxindex);
			lM.swapLine(i, maxindex);

			// Elimination
			for (int index = i + 1; index < aM.m; index++) {
				double l = aM.mat[index][i] / aM.mat[i][i];
				lM.mat[index][i] = l;
				// l->lM
				aM.mat[index][i] = 0;
				for (int k = i + 1; k < aM.n; k++) {
					aM.mat[index][k] -= aM.mat[i][k] * l;
				}
				for (int k = 0; k < bM.n; k++) {
					bM.mat[index][k] -= bM.mat[i][k] * l;
				}
				// for switch l
			}
			
		}
		
		for(int i = 0; i < lM.m;i++){
			lM.mat[i][i] = 1;
		}
		Mat rM = new Mat (aM);// save a to r;
		Gaus g = new Gaus();
		g.aM = aM;
		g.bM = bM;
		g.lM = lM;
		g.rM = rM;
		g.pM = pM;
		return g;
	}

	public static Gaus calculateGaus(Mat a, Mat b) {
		Gaus g = Gaus.l_r_Gaus(a, b);
		Mat ai = g.aM;
		Mat bi = g.bM;
		
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
		g.aM = new Mat(a);
		g.bM = bi;
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
		if (bM != null)
			System.out.println("B:\n"+bM);

		return null;

	}
}
