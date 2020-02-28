package deloitte.sanli.util;


/**
 * @author hasan.sanli
 *
 * Feb 27, 2020
 */
public class DisplayUtil {
	public static String clearAndResize(String text, int maxLength) {
		String str = text.replace('"', ' ').replaceAll("&quot;", "");
		while (str.length() <= maxLength) {
			str += " " + str;
		}
		return str.substring(0, maxLength - 3) + "...";
	}
}
