package app.elastic.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.app.rest.vo.UserWelfareAccountVO;

/**
 * Time : 1:02:04 am created: 25-Nov-2016 author : nitesh
 **/

public interface UserRepository extends ElasticsearchRepository<UserWelfareAccountVO, String> {
	List<UserWelfareAccountVO> findUserByUsername(String username);
	UserWelfareAccountVO findUserByUsernameAndPassword(String username,String password);
	List<UserWelfareAccountVO> findUserByDateOfBirth(Date dateOfBirth);
}
