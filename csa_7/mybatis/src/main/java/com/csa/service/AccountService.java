package com.csa.service;

import com.csa.dao.AccountDao;
import com.csa.pojo.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccountService {
    private InputStream inputStream;
    private SqlSession sqlSession;
    private AccountDao accountDao;
    //初始化
    public AccountService() throws IOException {
        inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = factory.openSession();
        accountDao = sqlSession.getMapper(AccountDao.class);
    }
    //释放资源
    private void destroy() {
        try {
            sqlSession.commit();
            sqlSession.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 1查询所有记录
    List<Account> findAll() {
        List<Account> findAll = accountDao.findAll();
        destroy();
        return findAll;
    }
    // 2通过id删除记录
    void deleteByPrimaryKey(String id) {
        accountDao.deleteByPrimaryKey(id);
        destroy();
    }
    // 3插入记录
    void insert(Account record) {
        accountDao.insert(record);
        destroy();
    }
    // 4通过id查找对象
    Account selectByPrimaryKey(String id) {
        Account selectByPrimaryKey = accountDao.selectByPrimaryKey(id);
        destroy();
        return selectByPrimaryKey;
    }
    // 5更新Account
    void updateByPrimaryKey(Account record) {
        accountDao.updateByPrimaryKey(record);
        destroy();
    }
    // 6转账功能 输入转出人id，转入人id，转账金额 实现转账
    void transfer(String remitterId,String remitteeId,int money) {
        try {
            if (remitteeId == remitterId) {
                throw new Exception("转入、转出人重复。");
            }
            Account remitter = accountDao.selectByPrimaryKey(remitterId);
            Account remittee = accountDao.selectByPrimaryKey(remitteeId);
            int remitterMoney = remitter.getMoney();
            int remitteeMoney = remittee.getMoney();
            if (remitterMoney >= money){
                remitter.setMoney(remitterMoney - money);
                remittee.setMoney(remitteeMoney + money);
                accountDao.updateByPrimaryKey(remitter);
                accountDao.updateByPrimaryKey(remittee);
            } else {
                throw new Exception("余额不足。");
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            destroy();
        }
    }
}