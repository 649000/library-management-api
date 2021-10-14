package com.example.dynamodb.controller;

import com.example.dynamodb.model.Member;
import com.example.dynamodb.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/member")
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Member createMember(@RequestBody Member request) {
        log.info(request.toString());
        return memberService.createMember(request);
    }

    @GetMapping("/{memberId}")
    public Member getMember(@PathVariable String memberId) {
        return memberService.getMember(memberId);
    }

    @GetMapping
    public Iterable<Member> getAllMembers(){
        return memberService.getMembers();
    }

    @PatchMapping("/{memberId}")
    public Member updateMember (@PathVariable String memberId, @RequestBody Member request) {
        return memberService.updateMember(request);
    }

    @DeleteMapping("/{memberId}")
    public void deleteMember (@PathVariable String memberId) {
        memberService.deleteMember(memberId);
    }
}