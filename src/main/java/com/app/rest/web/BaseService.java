package com.app.rest.web;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.app.rest.vo.AccountCreationResponseVO;
import com.app.rest.vo.PostCreatedSuccessfullVO;
import com.app.rest.vo.PostDataVO;
import com.app.rest.vo.UserWelfareAccountVO;
import com.app.rest.vo.WelfareVO;

/**
Time   : 12:53:00 am
created: 14-Nov-2016
author : nitesh
**/

@Path("/welfareservice")
public interface BaseService {
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/registerNewUser")
	public WelfareVO<AccountCreationResponseVO> registerNewUser(UserWelfareAccountVO userWelfareAccountVO);

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/feedNewPost")
	public WelfareVO<PostCreatedSuccessfullVO> feedNewPost(PostDataVO postDataVO);
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getCall")
	public String getCallTest();
	
	
	
}
