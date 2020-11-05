package c.s.sample;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

/**
 * @author chineshine
 * @since 2020年8月25日
 */
@SuppressWarnings("deprecation")
public class AdhocTest {

	@Test
	public void timeMillsTest() {
		Date d = new Date(120, 0, 6, 17, 40, 22);
		Long currentTime = System.currentTimeMillis();
		System.out.println(d);
		System.out.println(currentTime);
		System.out.println(d.getTime());
		System.out.println(new Date(currentTime));
		Long x = currentTime - d.getTime();
		System.out.println(x);
		// 相差分钟数
		System.out.println(x / 1000 / 60);
		// 相差天数
		System.out.println(x / 1000 / 60 / 60 / 24);
	}

	@Test
	public void bigDecimalCompareTest() {
		BigDecimal big = new BigDecimal(10000);
		BigDecimal small = new BigDecimal(4950.00);
		System.out.println(big.compareTo(small) >= 0);
	}
}
