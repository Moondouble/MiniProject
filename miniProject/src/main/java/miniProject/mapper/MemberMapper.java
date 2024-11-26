package miniProject.mapper;

import org.apache.ibatis.annotations.Mapper;

import miniProject.domain.MemberDTO;

@Mapper
public interface MemberMapper {
	public Integer memberInsert(MemberDTO dto);
}
