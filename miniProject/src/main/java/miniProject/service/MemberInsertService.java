package miniProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import miniProject.command.MemberCommand;
import miniProject.domain.MemberDTO;
import miniProject.mapper.MemberMapper;

@Service
public class MemberInsertService {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	MemberMapper memberMapper;
	
	public void execute(MemberCommand memberCommand) {
		MemberDTO dto = new MemberDTO();
		dto.setMemberBirth(memberCommand.getMemberBirth());
		dto.setMemberEmail(memberCommand.getMemberEmail());
		dto.setMemberId(memberCommand.getMemberId());
		dto.setMemberName(memberCommand.getMemberName());
		dto.setMemberPhone(memberCommand.getMemberPhone());
		dto.setMemberPw(passwordEncoder.encode(memberCommand.getMemberPw()));
		memberMapper.memberInsert(dto);
	}
}
