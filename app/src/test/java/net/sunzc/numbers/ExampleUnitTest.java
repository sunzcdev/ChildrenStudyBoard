package net.sunzc.numbers;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
	@Test
	public void addition_isCorrect() {
		assertEquals(4, 2 + 2);
		int corlor = Integer.parseInt("0x" + getRandColor(),16);
		System.out.println(corlor);

	}

	public static String getRandColor() {
		String R, G, B;
		Random random = new Random();
		R = Integer.toHexString(random.nextInt(256)).toUpperCase();
		G = Integer.toHexString(random.nextInt(256)).toUpperCase();
		B = Integer.toHexString(random.nextInt(256)).toUpperCase();

		R = R.length() == 1 ? "0" + R : R;
		G = G.length() == 1 ? "0" + G : G;
		B = B.length() == 1 ? "0" + B : B;

		return R + G + B;
	}
}