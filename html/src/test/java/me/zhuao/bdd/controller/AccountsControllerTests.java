package me.zhuao.bdd.controller;

import java.util.ArrayList;
import java.util.List;

import me.zhuao.bdd.domain.Account;
import me.zhuao.bdd.repository.AccountRepository;
import org.junit.Before;

public class AccountsControllerTests extends AbstractAccountControllerTests {

	protected static final Account theAccount = new Account(ACCOUNT_1,
			ACCOUNT_1_NAME);

	protected static class TestAccountRepository implements AccountRepository {

		public Account findByNumber(String accountNumber) {
			if (accountNumber.equals(ACCOUNT_1))
				return theAccount;
			else
				return null;
		}

		public List<Account> findByOwnerContainingIgnoreCase(String partialName) {
			List<Account> accounts = new ArrayList<Account>();

			if (ACCOUNT_1_NAME.toLowerCase().indexOf(partialName.toLowerCase()) != -1)
				accounts.add(theAccount);

			return accounts;
		}

		public int countAccounts() {
			return 1;
		}
	}

	protected TestAccountRepository testRepo = new TestAccountRepository();

	@Before
	public void setup() {
		accountController = new AccountsController(testRepo);
	}
}
