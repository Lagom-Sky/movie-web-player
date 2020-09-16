package ee.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ee.ssm.en.Tuser;
import ee.ssm.mapper.TuserMapper;
import ee.ssm.service.TuserService;

@Service
public class TuserServiceimpl implements TuserService{
	
	//注入数据动作
	@Autowired
	private TuserMapper tuserMapper;

	@Override
	public List<Tuser> selectTuser() {
		// TODO Auto-generated method stub
		return tuserMapper.selectTuser();
	}

	@Override
	public Tuser selectTuserByPassword(Tuser tuser) {
		// TODO Auto-generated method stub
		return tuserMapper.selectTuserByPassword(tuser);
	}

	@Override
	public int deleteUserByTid(int tid) {
		// TODO Auto-generated method stub
		return tuserMapper.deleteUserByTid(tid);
	}

	@Override
	public List<Tuser> selectUserByUsername(String username) {
		// TODO Auto-generated method stub
		return tuserMapper.selectUserByUsername(username);
	}

	@Override
	public int insertTuser(Tuser tuser) {
		// TODO Auto-generated method stub
		return tuserMapper.insertTuser(tuser);
	}

	@Override
	public int updateTuser(Tuser tuser) {
		// TODO Auto-generated method stub
		return tuserMapper.updateTuser(tuser);
	}

	
	
}
