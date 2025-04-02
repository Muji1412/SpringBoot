package com.simple.basic.memo.mapper;

import com.simple.basic.command.MemoVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemoMapper {

    String getTime();
    int postMemo(MemoVO memoVO);
    List<MemoVO> getMemoList();
}
