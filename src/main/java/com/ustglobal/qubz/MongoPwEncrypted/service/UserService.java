package com.ustglobal.qubz.MongoPwEncrypted.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.ustglobal.qubz.MongoPwEncrypted.model.User;
import com.ustglobal.qubz.MongoPwEncrypted.repo.UserRepo;

@Component
public class UserService {

//	@Autowired
//	private MongoOperations mongoOps;

	@Autowired
	UserRepo userRepo;

	@Autowired
	private MongoTemplate mongoTemplate;

	public Page<User> findAllByOrderByNameAsc(Pageable pageable) {
//		System.out.println(mongoOps.find(query(where("name").ne("sonu")), User.class));
		Criteria searchCriteria = Criteria.where("name").ne("sonu");
//		System.out.println(
//				mongoTemplate.find(new org.springframework.data.mongodb.core.query.Query(searchCriteria), User.class));

		Query query = new Query().with(pageable);
		query.addCriteria(searchCriteria);
		List<User> list = mongoTemplate.find(query, User.class);
		System.out.println(list);
//		return PageableExecutionUtils.getPage(list, pageable, () -> mongoTemplate.count(query, User.class));
		long count = mongoTemplate.count(query, User.class);
		System.out.println(count);
		Page<User> resultPage = new PageImpl<User>(list, pageable, count);
		System.out.println(resultPage);
		return resultPage;

//		return userRepo.findAllByOrderByNameAsc(pageable);
	}

}
