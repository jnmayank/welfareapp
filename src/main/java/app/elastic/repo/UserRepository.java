package app.elastic.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Time : 1:02:04 am created: 25-Nov-2016 author : nitesh
 **/

public interface UserRepository extends ElasticsearchRepository<UserWelfareAccountVO, String> {
	List<UserWelfareAccountVO> findUserByUsername(String username);
	List<UserWelfareAccountVO> findUserByDateOfBirth(Date dateOfBirth);
}
