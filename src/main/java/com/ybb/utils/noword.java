package com.ybb.utils;

import com.ybb.pojo.Books;
import com.ybb.pojo.Word;
import com.ybb.service.noWordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
@Component
public class noword {
    public boolean boo1;
    @Autowired
    @Qualifier("noWordServiceImpl")
    private noWordServiceImpl noWordService1;
    @Autowired
    @Qualifier("tranlistion")
    private tranlistion tl;
    public Books nowordMethod(Books book){
        String Detail=book.getDetail();
        String name=book.getBookName();
        boo1=true;
        book.setBookName(compareWord(name,"违规书籍名称，请修改"));
        boo1=true;
       book.setDetail(compareWord(Detail,"违规书籍详情，请修改"));
        return book;
    }
    public String compareWord(String str,String alert){
        int bc=0;
        boolean boo=true;
        String regex = "^[A-Z a-z 0-9]*$";
        str=str.replaceAll(" ","");
        StringBuffer str1=new StringBuffer(str);
        if (Pattern.matches(regex,str)){
            bc=3;
        } else {
            bc=1;
        }
        str1=str1.reverse();
        for (int s=0;s<str.length();s++) {
            for(int n=s;n<str.length()-s;n++){
                List<Word> words3 = noWordService1.noWordSelect1(str.substring(s, s + n+1));
                List<Word> words4 = noWordService1.noWordSelect1(str1.substring(s,s+n+1));
                if (words3.size()!=0||words4.size()!=0){
                    boo=false;
                    break;
                }
            }
            if(!boo){
                break;
            }

        }
        if (bc==1&&boo1) {
            boo1=false;
            System.out.println(tl.changeToSimpleChinese(str));
            System.out.println(tl.changeToTraditionalChinese(str));
            str = compareWord(tl.changeToSimpleChinese(str), alert);
        }
        for (int i=0;i<str.length()-bc+1;i++) {
            if(!boo){
                break;
            }
            List<Word> words1 = noWordService1.noWordSelect(str.toLowerCase().substring(i, i + bc));
            if (words1.size()!=0&&boo) {
                boo=false;
                break;
            }
            }
        if (boo){
            return str;
        } else{
            return alert;
        }
        }
}
