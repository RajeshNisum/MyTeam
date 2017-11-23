/**
 * 
 */
package com.nisum.mytime.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.nisum.mytime.model.UserAccount;
import com.nisum.mytime.repository.AccountRepository;

/**
 * @author nisum
 *
 */
@Service
public class CustomAuthenticationProviderImpl implements CustomAuthenticationProvider {

	@Autowired
	AccountRepository repository;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		UserAccount account = repository.findByUsernameAndPassword(username, password);
		if (account != null) {
			return new UsernamePasswordAuthenticationToken(username, password, account.getRoles());
		} else {
			throw new AuthenticationCredentialsNotFoundException("Invalid credentails");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
