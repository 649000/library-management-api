package com.example.dynamodb.service;

import com.example.dynamodb.exception.EntityNotFoundException;
import com.example.dynamodb.model.Member;
import com.example.dynamodb.model.MemberStatus;
import com.example.dynamodb.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
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
    public Member updateMember (Member member) {
        Optional<Member> optionalMember = memberRepository.findById(member.getId());
        if (optionalMember.isEmpty()) {
            throw new EntityNotFoundException("Member not present in the database");
        }
        Member retrivedMember = optionalMember.get();
        retrivedMember.setLastName(member.getLastName());
        retrivedMember.setFirstName(member.getFirstName());
        return memberRepository.save(retrivedMember);
    }

    public void deleteMember(final String memberId) {
        memberRepository.deleteById(memberId);
    }


}
