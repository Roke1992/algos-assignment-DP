package csci323;
public class GlassFalling {

	// Do not change the parameters!
	public int glassFallingRecur(int floors, int sheets) {

		if (floors == 1 || floors == 0 || sheets == 1)
			return floors;

		int min = Integer.MAX_VALUE;
		int min_drop;

		for (int i = 1; i <= floors; i++) {
			min_drop = Math.max(glassFallingRecur(i - 1, sheets - 1), glassFallingRecur(floors - i, sheets));
			min = Math.min(min, min_drop);
		}

		return min + 1;
	}

	// Optional:
	// Pick whatever parameters you want to, just make sure to return an int.
	public int glassFallingdp_tableized() {
		// Fill in here and change the return

		return 0;
	}

	// Do not change the parameters!
	public int glassFallingBottomUp(int floors, int sheets) {

		int dp_table[][] = new int[floors + 1][sheets + 1];

		for (int j = 0; j <= floors; j++) {

			for (int i = 0; i <= sheets; i++) {

				if (j == 0 || i == 0)
					dp_table[j][i] = 0;
				else if (j == 1)
					dp_table[j][i] = 1;
				else if (i == 1)
					dp_table[j][i] = j;
				else
					dp_table[j][i] = Integer.MAX_VALUE;
			}
		}

		for (int j = 2; j <= floors; j++) {
			for (int i = 2; i <= sheets; i++) {
				for (int k = 1; k <= j; k++) {
					int drops = Math.max(dp_table[k - 1][i - 1], dp_table[j - k][i]) + 1;
					dp_table[j][i] = Math.min(drops, dp_table[j][i]);

				}
			}

		}

		return dp_table[floors][sheets];
	}

	public static void main(String args[]) {
		GlassFalling gf = new GlassFalling();

		// Do not touch the below lines of code, and make sure
		// in your final turned-in copy, these are the only things printed
		int minTrials1Recur = gf.glassFallingRecur(27, 2);
		int minTrials1Bottom = gf.glassFallingBottomUp(27, 2);
		int minTrials2Recur = gf.glassFallingRecur(100, 3);
		int minTrials2Bottom = gf.glassFallingBottomUp(100, 3);
		System.out.println(minTrials1Recur + " " + minTrials1Bottom);
		System.out.println(minTrials2Recur + " " + minTrials2Bottom);
	}
}
