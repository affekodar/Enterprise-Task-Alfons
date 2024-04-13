package com.example.eewigell.controllers;

import com.example.eewigell.model.Member;
import com.example.eewigell.services.MemberServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
@RestController
*/
@Controller
public class MemberController {

    @Autowired
    private MemberServices memberService;


    @GetMapping("/allmembers")
    public ResponseEntity<List<Member>> getAllMembers() {
        return ResponseEntity.ok(memberService.fetchAllMembers());
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAllmembers2(Model model) {
        model.addAttribute("members", memberService.fetchAllMembers());
        return "member-list";
    }

    @PostMapping("/addmember")
    public ResponseEntity<Member> addNewMember(@RequestBody Member member) {
        return new ResponseEntity<>(memberService.addNewMember(member), HttpStatus.CREATED);
    }

    @DeleteMapping("/deletemember/{memberId}")
    public ResponseEntity<String> deleteMemberById(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
        return ResponseEntity.ok("Member with id " + memberId + " was deleted.");
    }

    @PutMapping("/updatemember/{memberId}")
    public ResponseEntity<Member> updateMember(@PathVariable long memberId, @RequestBody Member member) {
        return ResponseEntity.ok(memberService.updateMember(memberId, member));
    }

    @RequestMapping(value = "/admin/deletemember/{memberId}", method = RequestMethod.GET)
    public String deleteMember(@PathVariable("memberId") Long memberId, Model model) {
        memberService.deleteMember(memberId);
        model.addAttribute("members", memberService.fetchAllMembers());
        return "member-list";
    }
}
