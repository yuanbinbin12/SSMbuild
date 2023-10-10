package com.ybb.utils;

import com.github.houbb.opencc4j.util.ZhConverterUtil;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class tranlistion {
    /**
     * 转换字符串中的繁体中文为简体中文
     */
    public static String changeToSimpleChinese(String searchName) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = 0;
        for(int i = 0; i < searchName.length(); i++) {
            n = (int)searchName.charAt(i);
            char c = searchName.charAt(i);
            String s = String.valueOf(c);
            if(!(19968 <= n && n <40869)) {
                stringBuilder.append(c);
            }else {
                List<String> strings = ZhConverterUtil.toSimple(c);
                if (strings != null) {
                    int z = 1;
                    //下面用于解决：如果出现简体字转简体居然不是同一个字的时候
                    for (String string : strings) {
                        if (string.equals(s)) {
                            stringBuilder.append(string);
                        } else if (strings.size() == z) {
                            stringBuilder.append(strings.get(0));
                        }
                        z++;
                    }
                } else {
                    stringBuilder.append(c);
                }
            }
        }
        return stringBuilder.toString();
    }


    /**
     * 转换字符串中的简体中文为繁体中文
     */
    public static String changeToTraditionalChinese(String searchName) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = 0;
        for(int i = 0; i < searchName.length(); i++) {
            n = (int)searchName.charAt(i);
            char c = searchName.charAt(i);
            String s = String.valueOf(c);
            if(!(19968 <= n && n <40869)) {
                stringBuilder.append(c);
            }else {
                List<String> strings = ZhConverterUtil.toTraditional(c);
                if (strings != null) {
                    int z = 1;
                    //下面用于解决：如果出现繁体字转繁体字居然不是同一个字的时候
                    for (String string : strings) {
                        if (string.equals(s)) {
                            stringBuilder.append(string);
                        } else if (strings.size() == z) {
                            stringBuilder.append(strings.get(0));
                        }
                        z++;
                    }
                } else {
                    stringBuilder.append(c);
                }
            }
        }
        return stringBuilder.toString();
    }
}
