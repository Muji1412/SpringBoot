package com.simple.basic.memo.service;

import com.simple.basic.command.MemoVO;

import java.util.List;


public interface MemoService {
    int postMemo(MemoVO memoVO);
    List<MemoVO> getMemoList();

}
