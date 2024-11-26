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
	String memberAddr;
	String memberAddrDetail;
	String memberPost;
	Date memberRegist;
	String gender;
	String memberPhone1;
	String memberPhone2;
	String memberEmail;
	Date memberBirth;
}
