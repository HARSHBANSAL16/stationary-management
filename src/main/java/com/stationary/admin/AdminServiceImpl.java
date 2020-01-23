package com.stationary.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.stationary.entity.LoginUser;
import com.stationary.repository.LoginUserRepo;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Oct 17, 2019
 */
@Service
public class AdminServiceImpl implements AdminService {

  @Autowired
  private LoginUserRepo userRepo;

  @Autowired
  private PasswordEncoder bcryptEncoder;

  @Override
  public LoginUser createUser(final LoginUser user) {

    user.setPassword(bcryptEncoder.encode(user.getPassword()));
    return userRepo.save(user);
  }
}
