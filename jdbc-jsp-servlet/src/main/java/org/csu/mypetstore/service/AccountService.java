package org.csu.mypetstore.service;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.persistence.AccountDAO;
import org.csu.mypetstore.persistence.impl.AccountDAOImpl;

public class AccountService {

//  @Autowired
//  private AccountMapper accountMapper;
  private AccountDAO accountDAO = new AccountDAOImpl();

  public Account getAccount(String username) {
//    return accountMapper.getAccountByUsername(username);
    return accountDAO.getAccountByUsername(username);
  }

  public Account getAccount(String username, String password) {
    Account account = new Account();
    account.setUsername(username);
    account.setPassword(password);
//    return accountMapper.getAccountByUsernameAndPassword(account);
      return accountDAO.getAccountByUsernameAndPassword(account);
  }

//  @Transactional
  public void insertAccount(Account account) {
//    accountMapper.insertAccount(account);
//    accountMapper.insertProfile(account);
//    accountMapper.insertSignon(account);
    accountDAO.insertAccount(account);
    accountDAO.insertProfile(account);
    accountDAO.insertSignon(account);
  }

//  @Transactional
  public void updateAccount(Account account) {
//    accountMapper.updateAccount(account);
//    accountMapper.updateProfile(account);

    accountDAO.updateAccount(account);
    accountDAO.updateProfile(account);
    if (account.getPassword() != null && account.getPassword().length() > 0) {
//      accountMapper.updateSignon(account);
      accountDAO.updateSignon(account);
    }
  }

}
