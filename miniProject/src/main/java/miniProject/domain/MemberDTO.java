package miniProject.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("MemberDTO")
public class MemberDTO {
	String memberNum;
	String memberName;
	String memberId;
	String memberPw;
	Date memberRegist;
	String memberPhone1;
	String memberEmail;
	Date memberBirth;
}
