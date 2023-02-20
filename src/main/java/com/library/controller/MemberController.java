package com.library.controller;

import com.library.model.Member;
import com.library.service.MemberService;
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
        log.debug("Member Object: {}", request.toString());
        return memberService.createMember(request);
    }

    @GetMapping("/{memberId}")
    public Member getMember(@PathVariable String memberId) {
        log.debug("Member ID: {}", memberId);
        return memberService.getMember(memberId);
    }

    @GetMapping
    public Iterable<Member> getAllMembers(){
        return memberService.getMembers();
    }

    @PatchMapping("/{memberId}")
    public Member updateMember (@PathVariable String memberId, @RequestBody Member request) {
        log.debug("Member ID: {}", memberId);
        log.debug("Member Object: {}", request.toString());
        return memberService.updateMember(request);
    }

    @DeleteMapping("/{memberId}")
    public void deleteMember (@PathVariable String memberId) {
        log.debug("Member ID: {}", memberId);
        memberService.deleteMember(memberId);
    }
}