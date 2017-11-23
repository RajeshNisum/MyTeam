package com.nisum.mytime;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.nisum.mytime.model.UserAccount;
import com.nisum.mytime.repository.AccountRepository;

@SpringBootApplication
@EnableAutoConfiguration
@EnableMongoRepositories
public class DemoApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Bean
//	CommandLineRunner init(AccountRepository repository) {
//		return new CommandLineRunner() {
//
//			@Override
//			public void run(String... args) throws Exception {
//				Collection<GrantedAuthority> list1 = new ArrayList<>();
//				list1.add(new SimpleGrantedAuthority("ADMIN_ROLE"));
//				Collection<GrantedAuthority> list2 = new ArrayList<>();
//				list2.add(new SimpleGrantedAuthority("ADMIN_ROLE"));
//				Collection<GrantedAuthority> list3 = new ArrayList<>();
//				list3.add(new SimpleGrantedAuthority("USER_ROLE"));
////				repository.save(new UserAccount("srikanth", "password", list1));
////				repository.save(new UserAccount("mahesh", "password", list2));
////				repository.save(new UserAccount("srihari", "password", list3));
//			}
//
//		};
//	}
}
