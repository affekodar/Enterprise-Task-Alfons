package com.example.eewigell.services;

import com.example.eewigell.model.Member;

import java.util.List;

public interface MemberServiceInterface {
    List<Member> fetchAllMembers();

    Member addNewMember(Member member);

    Member updateMember(Long id, Member member);

    void deleteMember(Long id);

}
