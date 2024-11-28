package miniProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import miniProject.mapper.LoginMapper;

@Service
public class IdcheckService {
	@Autowired
	LoginMapper loginMapper;
	public Integer execute(String userId) {
		return loginMapper.idCheckSelectOne(userId);
	}
}
