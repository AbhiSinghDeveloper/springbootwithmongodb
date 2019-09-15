package com.ustglobal.qubz.MongoPwEncrypted.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ustglobal.qubz.MongoPwEncrypted.model.User;
import com.ustglobal.qubz.MongoPwEncrypted.repo.UserRepo;
import com.ustglobal.qubz.MongoPwEncrypted.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/users")
@Api(value = "User Api", description = "Operations pertaining to users in MongoDB.")
public class UserController {

	@Autowired
	UserRepo userRepo;
	@Autowired
	UserService userService;

	@RequestMapping(path = "", method = RequestMethod.GET)
	@ApiOperation(value = "list of users")
	public Page<User> findAll(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "1") int size) {
		Pageable pageable = new PageRequest(page, size);
//		return userRepo.findAll(pageable);
		return userService.findAllByOrderByNameAsc(pageable);
	}

	@RequestMapping(path = "", method = RequestMethod.POST)
	@ApiOperation(value = "save user")
	public User save(@RequestBody User user) {
		return userRepo.save(user);
	}
}
