package randNum;

public class RandNum {
	public static int genRandNum(int lo, int hi) {
		return (int) ((Math.random() * (hi - lo)) + lo);
	}

}
