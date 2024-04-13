package com.example.eewigell.services;

import com.example.eewigell.exceptions.ResourceNotFoundException;
import com.example.eewigell.model.Member;
import com.example.eewigell.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServices implements MemberServiceInterface {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public List<Member> fetchAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member addNewMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member updateMember(Long id, Member member) {
        Member memberToUpdate;
        Optional<Member> memberCheck = memberRepository.findById(id);

        if (memberCheck.isPresent()) {
            memberToUpdate = memberCheck.get();
            memberToUpdate.setFirstName(member.getFirstName());
            memberToUpdate.setLastName(member.getLastName());
            memberToUpdate.setEmail(member.getEmail());
            memberToUpdate.setPhone(member.getPhone());
            memberToUpdate.setDateOfBirth(member.getDateOfBirth());
            memberToUpdate.setAddress(member.getAddress());

            return memberRepository.save(memberToUpdate);
        }

        return null;

    }

    @Override
    public void deleteMember(Long id) {
        memberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Member", "Id", id));
        memberRepository.deleteById(id);
    }
}
