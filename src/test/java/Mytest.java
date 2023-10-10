import com.ybb.pojo.Books;
import com.ybb.pojo.Word;
import com.ybb.service.bookService;
import com.ybb.service.bookServiceImpl;
import com.ybb.service.noWordServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class Mytest {
    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        noWordServiceImpl noWordService = (noWordServiceImpl) context.getBean("noWordServiceImpl");
        List<Word> yb = noWordService.noWordSelect("yb");
        for (Word word:yb){
            System.out.println(word);
    }
    }

    @Test
    public void RegexExample1() {
        String str="yu1  YU ASs     sss，是  试 试，s  e  ";
        System.out.println(str.replaceAll(" ",""));
        System.out.println(str.toLowerCase());


    }
    @Test
    public void qqqqq(){

    }
}

