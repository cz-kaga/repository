package org.xust.sims.kagatools;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 个人用于正则表达式提取字符串的工具类
 * 无法实例化
 * @author cz_kaga
 */
public class RegexToString {
    private RegexToString(){

    }
    /**
     * 用于提取输入数据中特定的键对应的值
     * 别问，问就是lambda不会用，不过也不应该用lambda，所以就直接粗暴对待了
     * 我相信我没有弄疼数据
     * @param key 需要提取数据的键
     * @return 如果成功，返回对应的值，如果失败，返回空
     */
    public static String getRequestvalue(String md, String key) {
        String pattern =  "(\"?" + key + "\"?:+ ?\"?)([\\w.]*)\"?,?";    //谁要动了这串东西，我杀他的马
        Pattern r = Pattern.compile(pattern);
        Matcher m =r.matcher(md);
        if (m.find()) {
            return m.group(2);
        } else {
            return null;
        }
    }

}
