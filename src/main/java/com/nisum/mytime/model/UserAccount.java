/**
 * 
 */
package com.nisum.mytime.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author nisum
 *
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "UserAccount")
public class UserAccount implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String empId;
	private String username;
	private String password;
	private Collection<GrantedAuthority> roles = new ArrayList<>();
}
