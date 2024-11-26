package miniProject.mapper;

import org.apache.ibatis.annotations.Mapper;

import miniProject.domain.MemberDTO;

@Mapper
public interface MemberMapper {
	public void memberInsert(MemberDTO dto);
}
