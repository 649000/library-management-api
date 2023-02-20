package com.library.service;

import com.library.exception.EntityNotFoundException;
import com.library.model.Mapper;
import com.library.model.Member;
import com.library.model.MemberStatus;
import com.library.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    private final Mapper mapper;

    @Autowired
    public MemberService(MemberRepository memberRepository, Mapper mapper) {
        this.memberRepository = memberRepository;
        this.mapper = mapper;
    }


    public Member createMember(Member member) {
        member.setStatus(MemberStatus.ACTIVE);
        return memberRepository.save(member);
    }

    public Iterable<Member> getMembers() {
        return memberRepository.findAll();
    }

    public Member getMember(final String memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        if(optionalMember.isPresent()) {
            return optionalMember.get();
        }
        throw new EntityNotFoundException("Member Not Found");
    }
    public Member updateMember (Member request) {
        Optional<Member> optionalMember = memberRepository.findById(request.getId());
        if (optionalMember.isEmpty()) {
            throw new EntityNotFoundException("Member not present in the database");
        }

        Member member = mapper.updateMember(request, optionalMember.get());
        return memberRepository.save(member);
    }

    public void deleteMember(final String memberId) {
        memberRepository.deleteById(memberId);
    }


}
