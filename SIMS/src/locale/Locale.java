package locale;
import java.util.*;
/*
 *  用于简化本地化翻译文本的调用读取
 *  @author cz_kaga
 *  @date 2021.6.4
 *  @version 0.0.1
 */
public class Locale {
	private String _bundlename;
	private Locale _locale = null;
	public static ResourceBundle bundle = ResourceBundle.getBundle("locale/ui");
	public void setLang (String lang)
	{
		//TODO Change Language
	}
	/*
	 * @argument
	 */
	public static String getTrans(String label)
	{
		String Trans = bundle.getString(label);
		return Trans;
	}
	
}
