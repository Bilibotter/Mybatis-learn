package dao;


import entity.User;

public interface IUserDao {

     User queryUserInfoById(Long id);

}
