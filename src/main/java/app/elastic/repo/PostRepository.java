package app.elastic.repo;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.app.rest.vo.PostDataVO;

/**
Time   : 12:37:04 am
created: 22-Dec-2016
author : nitesh
**/

public interface PostRepository extends ElasticsearchRepository<PostDataVO, String>{
	List<PostDataVO> getPostByuserId(String userId);
}
