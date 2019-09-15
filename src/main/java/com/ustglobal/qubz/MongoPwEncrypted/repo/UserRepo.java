package com.ustglobal.qubz.MongoPwEncrypted.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ustglobal.qubz.MongoPwEncrypted.model.User;

@Repository
public interface UserRepo extends MongoRepository<User, String> {

	Page<User> findAllByOrderByNameAsc(Pageable pageable);

}
