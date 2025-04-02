package com.simple.basic.memo.service;

import com.simple.basic.command.MemoVO;
import com.simple.basic.memo.mapper.MemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("memoService")
public class MemoServiceImpl implements MemoService {

    @Autowired
    private MemoMapper memoMapper;

    @Override
    public int postMemo(MemoVO memoVO) {

        return memoMapper.postMemo(memoVO);
    }

    @Override
    public List<MemoVO> getMemoList() {
        return memoMapper.getMemoList();
    }


}
