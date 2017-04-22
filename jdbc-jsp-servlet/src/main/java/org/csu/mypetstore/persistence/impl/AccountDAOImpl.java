package org.csu.mypetstore.persistence.impl;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.persistence.AccountDAO;
import org.csu.mypetstore.persistence.DAOUtil;
import org.csu.mypetstore.persistence.ResultSetManipulation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by pikachu on 2017/3/11.
 */
public class AccountDAOImpl implements AccountDAO {
    @Override
    public Account getAccountByUsername(String username) {
        List<Account> list = new LinkedList<>();
        DAOUtil.query("SELECT * FROM account a ,signon s,profile p WHERE a.userid = p.userid AND s.username=a.userid AND a.userid = ?",new Object[]{username},new FindList(list));
        if (list.size()>0){
            return list.get(0);
        }else {
        return null;

        }
    }

    @Override
    public Account getAccountByUsernameAndPassword(Account account) {
        List<Account> list = new LinkedList<>();
        DAOUtil.query("SELECT * FROM account a ,signon s,profile p WHERE a.userid = p.userid AND s.username=a.userid AND username = ? AND password = ?",new Object[]{account.getUsername(),account.getPassword()},new FindList(list));
        if (list.size()>0){
            return list.get(0);
        }else {
            return null;

        }
    }

    @Override
    public void insertAccount(Account account) {
        Object[] params=new Object[]{
account.getUsername(),account.getEmail(),account.getFirstName(),account.getLastName(),account.getAddress1(),account.getAddress2(),
                account.getStatus(),account.getCity(),account.getState(),account.getZip(),account.getCountry(),account.getPhone()
        };
        DAOUtil.update("INSERT INTO account(userid,email,firstname,lastname,addr1,addr2,status,city,state,zip,country,phone) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)",params);
    }

    @Override
    public void insertProfile(Account account) {
        Object[] params = new Object[]{
            account.getUsername(),account.getLanguagePreference(),account.getFavouriteCategoryId(),account.isListOption(),account.getBannerName()
        };
        DAOUtil.update("INSERT INTO profile(userid, langpref, favcategory, mylistopt, banneropt) VALUES (?,?,?,?,?)",params);
    }

    @Override
    public void insertSignon(Account account) {
        DAOUtil.update("INSERT into signon(username, password) VALUES (?,?)",new Object[]{account.getUsername(),account.getPassword()});
    }

    @Override
    public void updateAccount(Account account) {
        String sql = "UPDATE account SET email = ?, firstname = ?, lastname = ?, status = ?,addr1 = ?, addr2 = ?, city = ?, state = ?, zip = ?, country = ?,phone = ? WHERE userid = ?";
        Object[] params = new Object[]{
                account.getEmail(),account.getFirstName(),account.getLastName(),account.getStatus(),
                account.getAddress1(),account.getAddress2(),account.getCity(),account.getState(),
                account.getZip(),account.getCountry(),account.getPhone(),account.getUsername()
        };
        DAOUtil.update(sql,params);
    }

    @Override
    public void updateProfile(Account account) {
        String sql = "UPDATE profile SET langpref = ?, favcategory = ?, mylistopt = ?, banneropt = ? WHERE userid = ?";
        Object[] params = new Object[]{
                account.getLanguagePreference(),account.getFavouriteCategoryId(),account.isListOption(),account.isBannerOption(),account.getUsername()
        };
        DAOUtil.update(sql,params);
    }

    @Override
    public void updateSignon(Account account) {
        String sql = "UPDATE signon SET  password = ? WHERE username = ?";
        Object[] params = new Object[]{
                account.getPassword()
        };
        DAOUtil.update(sql,params);
    }
    class FindList implements ResultSetManipulation{
        List<Account> list = null;

        public FindList(List<Account> list) {
            this.list = list;
        }

        @Override
        public void manipulation(ResultSet resultSet) {
            try {
                Account account = new Account();
                account.setUsername(resultSet.getString("a.userid"));
                account.setPassword(resultSet.getString("password"));
                account.setEmail(resultSet.getString("email"));
                account.setFirstName(resultSet.getString("firstname"));
                account.setLastName(resultSet.getString("lastname"));
                account.setAddress1(resultSet.getString("addr1"));
                account.setAddress2(resultSet.getString("addr2"));
                account.setStatus(resultSet.getString("status"));
                account.setCity(resultSet.getString("city"));
                account.setState(resultSet.getString("state"));
                account.setZip(resultSet.getString("zip"));
                account.setCountry(resultSet.getString("country"));
                account.setPhone(resultSet.getString("phone"));
                account.setLanguagePreference(resultSet.getString("langpref"));
                account.setFavouriteCategoryId(resultSet.getString("favcategory"));
                account.setBannerOption(resultSet.getBoolean("banneropt"));
                account.setListOption(resultSet.getBoolean("mylistopt"));
                list.add(account);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
