package com.app.byeolbyeolsseudam.service.community;

import com.app.byeolbyeolsseudam.domain.board.BoardDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommunityService {
    public List<BoardDTO> selectTopView();
    public List<BoardDTO> selectBoards();
    public BoardDTO readBoard(Long boardId);
}
