package com.websitedungcuthethao.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class FormatNumber {
	public static String formatVND(double tien) {
		DecimalFormat df =  new DecimalFormat("#,###.00 VND");
		return df.format(new BigDecimal(tien));
	}
}
