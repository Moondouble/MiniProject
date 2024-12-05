package miniProject.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberCommand {
	String memberNum;
	String memberId;
	String memberPw;
	String memberPwCon;
	String memberName;
	String memberPhone1;
	String memberPhone2;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date memberBirth;
	String memberEmail;
	
	public boolean isMemberPwEqualMemberPwCon() {
		return memberPw.equals(memberPwCon);
	}
}
