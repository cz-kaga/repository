package locale;

import java.util.*;

/*
 *  ���ڼ򻯱��ػ������ı��ĵ��ö�ȡ
 *  @author cz_kaga
 *  @date 2021.6.4
 *  @version 0.0.1
 */
public class Locale {

	private static ResourceBundle uiTrans = ResourceBundle.getBundle("locale/ui");
	private static ResourceBundle clientTrans = ResourceBundle.getBundle("locale/settings");
	public void setLang(String lang) {
		// TODO Change Language
	}

	/*
	 * @argument
	 */
	public static String getuiTrans(String label) {
		String Trans = uiTrans.getString(label);
		return Trans;
	}

	public static String getclientTrans(String label) {
		String Trans = clientTrans.getString(label);
		return Trans;
	}

}
