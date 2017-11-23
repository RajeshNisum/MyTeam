/**
 * 
 */
package com.nisum.mytime.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nisum.mytime.model.UserAccount;

/**
 * @author nisum
 *
 */
public interface AccountRepository extends MongoRepository<UserAccount, String> {
	
	public UserAccount findByUsernameAndPassword(String username, String password);
}
