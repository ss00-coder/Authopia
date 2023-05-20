package com.app.authopia.service.post.writingPost;

import com.app.authopia.dao.MemberDAO;
import com.app.authopia.domain.vo.MemberVO;
import com.app.authopia.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements MemberService {
    private final MemberDAO memberDAO;

    @Override
    public Optional<MemberVO> checkEmail(String memberEmail) {
        return memberDAO.findByMemberEmail(memberEmail);
    }

    @Override
    public void join(MemberVO memberVO) {
        memberDAO.save(memberVO);
    }

    @Override
    public Optional<Long> login(String memberEmail, String memberPassword) {
        return memberDAO.findByMemberEmailAndMemberPassword(memberEmail, memberPassword);
    }

    @Override
    public void modifyPassword(String memberEmail, String memberPassword) {
        memberDAO.setPassword(memberEmail, memberPassword);
    }
}
