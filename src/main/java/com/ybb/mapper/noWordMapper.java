package com.ybb.mapper;

import com.ybb.pojo.Word;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface noWordMapper {
    @Select("select 1 from nocallword1 A where A.word like #{word}")
    List<Word> noWordSelect(@Param("word") String word);
    @Select("select 1 from nocallword B where B.word =#{word}")
    List<Word> noWordSelect1(@Param("word") String word);
}
