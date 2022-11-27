package com.app.byeolbyeolsseudam.entity;

import com.app.byeolbyeolsseudam.domain.CommentDTO;
import com.app.byeolbyeolsseudam.repository.BoardRepository;
import com.app.byeolbyeolsseudam.repository.CommentRepository;
import com.app.byeolbyeolsseudam.repository.MemberRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class CommentTest {
    @Autowired
    private JPAQueryFactory jpaQueryFactory;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void saveTest(){
        CommentDTO commentDTO = new CommentDTO();

        commentDTO.setCommentContent("안녕");
        commentDTO.setCommentFile("hi.png");
        commentDTO.setBoard(boardRepository.findAll().get(0));
        commentDTO.setMember(memberRepository.findAll().get(0));

        commentRepository.save(commentDTO.toEntity());
    }

    @Test
    public void findTest(){
        Optional<Comment> findComment = commentRepository.findById(8L);

        if(findComment.isPresent()){
            Assertions.assertThat(findComment.get().getMember().getMemberName().equals("은지"));

            log.info("CommentContent : " + findComment.get().getCommentContent());
            log.info("BoardTitle : " + findComment.get().getBoard().getBoardTitle());
        }
    }

    @Test
    public void updateTest(){
        Optional<Comment> updateComment = commentRepository.findById(8L);

        if(updateComment.isPresent()){
            updateComment.get().update("수정댓글", "update.png");
        }
    }
    
    @Test
    public void deleteTest(){
        Optional<Comment> deleteComment = commentRepository.findById(8L);

        if(deleteComment.isPresent()){
            Assertions.assertThat(deleteComment.get().getMember().getMemberName().equals("은지"));

            log.info("CommentContent : " + deleteComment.get().getCommentContent());
            log.info("BoardTitle : " + deleteComment.get().getBoard().getBoardTitle());
        }
    }
}
