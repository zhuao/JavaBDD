package me.zhuao.bdd;

import me.zhuao.bdd.repository.AccountRepository;
import me.zhuao.bdd.repository.AccountsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.util.logging.Logger;

@EnableAutoConfiguration
@Import(AccountsConfiguration.class)
public class AccountsServer {

	@Autowired
	protected AccountRepository accountRepository;

	protected Logger logger = Logger.getLogger(AccountsServer.class.getName());

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		// Tell server to look for accounts-server.properties or
		// accounts-server.yml
		System.setProperty("spring.config.name", "accounts-server");

		SpringApplication.run(AccountsServer.class, args);
	}
}
