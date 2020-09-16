package ee.ssm.mapper;

import java.util.List;

import ee.ssm.en.Tuser;

public interface TuserMapper {
	List<Tuser> selectTuser();
	Tuser selectTuserByPassword(Tuser tuser);
	int deleteUserByTid(int tid);
	List<Tuser> selectUserByUsername(String username);
	int insertTuser(Tuser tuser);
	int updateTuser(Tuser tuser);
}
