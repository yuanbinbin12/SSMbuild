package com.ybb.service;

import com.ybb.mapper.noWordMapper;
import com.ybb.pojo.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class noWordServiceImpl implements noWordService {
    @Autowired
    @Qualifier("noWordMapper")
    private noWordMapper nwm;
    public void setNwm(noWordMapper nwm) {
        this.nwm = nwm;
    }
    @Override
    public List<Word> noWordSelect(String word) {
        word="%"+word+"%";
        return nwm.noWordSelect(word);
    }

    @Override
    public List<Word> noWordSelect1(String word) {
        return nwm.noWordSelect1(word);
    }
}
