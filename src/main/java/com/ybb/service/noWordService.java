package com.ybb.service;

import com.ybb.pojo.Word;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface noWordService {
    List<Word> noWordSelect(String word);
    List<Word> noWordSelect1(@Param("word") String word);
}
