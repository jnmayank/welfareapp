package com.app.rest.web;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mongo.provider.MongoProvider;
import com.app.mongo.transact.mgr.CountResponseC3;
import com.app.mongo.transact.mgr.MongoTransactMgr;
import com.app.rest.vo.AccountCreationResponseVO;
import com.app.rest.vo.BlogDataPostScrollVO;
import com.app.rest.vo.CountryListResponseVO;
import com.app.rest.vo.GenericMessageResponseVO;
import com.app.rest.vo.LoginDataVO;
import com.app.rest.vo.LoginResponseVO;
import com.app.rest.vo.PostDataVO;
import com.app.rest.vo.PostResponseVO;
import com.app.rest.vo.UserListResponseVO;
import com.app.rest.vo.UserWelfareAccountVO;
import com.app.rest.vo.WelfareVO;
import com.app.sql.mgr.HibernateTransMgr;
import com.google.gson.JsonObject;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

/**
 * Time : 12:53:28 am created: 14-Nov-2016 author : nitesh
 **/

@Service("baseService")
public class BaseServiceImpl implements BaseService {

	@Autowired
	private UserRepositoryService userRepositoryService;

	@Autowired
	private HibernateTransMgr hibernateTransMgr;

	@Autowired
	private MongoProvider mongoProvider;

	@Autowired
	private MongoTransactMgr mongoTransactMgr;

	@Override
	public WelfareVO<AccountCreationResponseVO> registerNewUser(UserWelfareAccountVO userWelfareAccountVO) {
		AccountCreationResponseVO accountCreationResponseVO = new AccountCreationResponseVO();
		accountCreationResponseVO.setResultmessage("success");
		String responseMessage = null; // userRepositoryService.createUser(userWelfareAccountVO);
		responseMessage = hibernateTransMgr.createNewUser(userWelfareAccountVO);
		accountCreationResponseVO.setResultmessage(responseMessage);
		WelfareVO<AccountCreationResponseVO> response = new WelfareVO<AccountCreationResponseVO>(
				accountCreationResponseVO, false);
		return response;
	}

	@Override
	public WelfareVO<PostResponseVO> feedNewPost(PostDataVO postDataVO) {
		// complete implementation
		PostResponseVO pvo = new PostResponseVO();
		pvo.setPostCreationDate(new Date());
		pvo.setPostData(postDataVO.getPostData());
		postDataVO.setPostDate(new Date());
		String indexId = userRepositoryService.createNewPost(postDataVO);
		pvo.setPostId(indexId);
		WelfareVO<PostResponseVO> response = new WelfareVO<PostResponseVO>(pvo, false);
		return response;
	}

	@Override
	public WelfareVO<BlogDataPostScrollVO> getPostScroll(String after) {
		BlogDataPostScrollVO bvo = new BlogDataPostScrollVO();
		List<PostResponseVO> postDataList = new ArrayList<>();
		bvo.setPostDataList(postDataList);

		Integer data = Integer.parseInt(after);
		for (int i = 0; i < 9; i++) {
			PostResponseVO pvo = new PostResponseVO();
			pvo.setPostData("postdata" + (data + i));
			pvo.setPostCreationDate(new Date());
			postDataList.add(pvo);
		}
		WelfareVO<BlogDataPostScrollVO> wvoResponse = new WelfareVO<BlogDataPostScrollVO>(bvo, false);
		return wvoResponse;
	}

	@Override
	public WelfareVO<UserListResponseVO> getAllAccountData() {
		List<UserWelfareAccountVO> userDataList = hibernateTransMgr.getAllUserData();// userRepositoryService.findAllUser();
		UserListResponseVO resp = new UserListResponseVO();
		resp.setUserWelfareAccountVOList(userDataList);
		WelfareVO<UserListResponseVO> wresp = new WelfareVO<UserListResponseVO>(resp, false);
		return wresp;
	}

	@Override
	public WelfareVO<LoginResponseVO> doLogin(LoginDataVO loginDataVO) {
		LoginResponseVO loginResponseVO = hibernateTransMgr.validateUser(loginDataVO);// userRepositoryService.validateLoginCredentials(loginDataVO);
		WelfareVO<LoginResponseVO> response = new WelfareVO<LoginResponseVO>(loginResponseVO, false);
		return response;
	}

	@Override
	public WelfareVO<GenericMessageResponseVO> createCountry(JsonObject jsonObject) {
		System.out.println(jsonObject.getAsString());
		return null;
	}

	@Override
	public Response createState(JsonObject jsonObject) {
		GenericMessageResponseVO resp = new GenericMessageResponseVO();
		resp.setMessage("OK");
		return javax.ws.rs.core.Response.created(URI.create(resp.getMessage())).build();
	}

	@Override
	public Response getCountryList() {
		CountryListResponseVO countryList = hibernateTransMgr.getCountryList();
		return Response.ok(countryList, MediaType.APPLICATION_JSON).build();
	}

	@Override
	public Response getStateList(long countryId) {
		return Response.ok(hibernateTransMgr.getStateListByCountry(countryId), MediaType.APPLICATION_JSON).build();
	}

	@Override
	public Response getCityList(long stateId) {
		return Response.ok(hibernateTransMgr.getCityListByState(stateId), MediaType.APPLICATION_JSON).build();
	}

	@Override
	public Response getStreetList(long cityId) {
		return Response.ok(hibernateTransMgr.getStreetListByState(cityId), MediaType.APPLICATION_JSON).build();
	}

	@Override
	public Response getUserImageForId(long userId) {
		File fl = new File("/home/nitesh/appdev/git/welfareapp/welfareui/src/main/webapp/resources/img/homeimg3.jpg");
		/*
		 * ByteArrayOutputStream baos = new ByteArrayOutputStream(); try {
		 * FileImageInputStream faos = new FileImageInputStream(fl); } catch
		 * (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		return Response.ok(fl, MediaType.APPLICATION_OCTET_STREAM).build();
	}

	@Override
	public String getMongo() {
		MongoDatabase db = mongoProvider.getDb();
		db.createCollection("aldex");
		MongoIterable<String> listCollectionNames = db.listCollectionNames();
		StringBuffer sbf = new StringBuffer();
		for (String string : listCollectionNames) {
			sbf.append(string + ",");
		}
		return sbf.toString();
	}

	@Override
	public Response createGrievance(JsonObject jsonObject) {
		try {
			boolean response = mongoTransactMgr.insertGrievanceDataInMongo(jsonObject);
			return Response.ok(response).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

	@Override
	public Response getListofStatesFromMongo() {
		List<String> stateList = mongoTransactMgr.getListOfStatesFromMongoServer();
		return Response.ok(stateList).build();
	}

	@Override
	public Response getListOfDepartMents() {
		List<String> departmentList = mongoTransactMgr.getListOfDepartmentMongoServer();
		return Response.ok(departmentList).build();
	}

	@Override
	public Response getSpecificCounts() {
		CountResponseC3 counts = mongoTransactMgr.getDistinctCountsByStateaDepartment();
		return Response.ok(counts).build();
	}

}
