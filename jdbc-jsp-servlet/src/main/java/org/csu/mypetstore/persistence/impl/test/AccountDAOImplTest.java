package org.csu.mypetstore.persistence.impl.test;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.service.AccountService;

/**
 * Created by pikachu on 2017/3/11.
 */
public class AccountDAOImplTest {
    public static void main(String[] args) {
        Account account = new Account();
        account.setUsername("pikachu");
        account.setPassword("123");
        account.setEmail("2931408816@qq.com");
        account.setPhone("15084909943");
        account.setCountry("China");
        account.setZip("415129");
        account.setFirstName("pikachu");
        account.setLastName("hy");
        account.setAddress1("csu");
        account.setAddress2("cs");
        account.setCity("cs");
        account.setState("cn");
        account.setLanguagePreference("Chinese");

        AccountService service = new AccountService();
        service.insertAccount(account);
    }
}
