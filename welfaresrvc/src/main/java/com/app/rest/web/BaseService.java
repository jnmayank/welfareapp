package com.app.rest.web;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.app.rest.vo.AccountCreationResponseVO;
import com.app.rest.vo.BlogDataPostScrollVO;
import com.app.rest.vo.GenericMessageResponseVO;
import com.app.rest.vo.LoginDataVO;
import com.app.rest.vo.LoginResponseVO;
import com.app.rest.vo.PostDataVO;
import com.app.rest.vo.PostResponseVO;
import com.app.rest.vo.UserListResponseVO;
import com.app.rest.vo.UserWelfareAccountVO;
import com.app.rest.vo.WelfareVO;
import com.google.gson.JsonObject;

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
	public WelfareVO<PostResponseVO> feedNewPost(PostDataVO postDataVO);
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/login")
	public WelfareVO<LoginResponseVO> doLogin(LoginDataVO loginDataVO);
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getMoreData")
	public WelfareVO<BlogDataPostScrollVO> getPostScroll(@QueryParam("after")String after);
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllUsers")
	public WelfareVO<UserListResponseVO> getAllAccountData();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/createCountry")
	public WelfareVO<GenericMessageResponseVO> createCountry(JsonObject jsonObject);

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/createState")
	Response createState(JsonObject jsonObject);
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getCountryList")
	Response getCountryList();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getStateList")
	Response getStateList(@QueryParam("countryId") long countryId);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getCityList")
	Response getCityList(@QueryParam("stateId") long stateId);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getCityList")
	Response getStreetList(@QueryParam("cityId") long cityId);
	
	@GET
    @Path("/getUserImageForId")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getUserImageForId(@QueryParam("userId") long userId);

	@GET
    @Path("/getMongo")
    @Produces(MediaType.APPLICATION_JSON)
	String getMongo();    
}
