package com.stationary.admin;

import com.stationary.entity.LoginUser;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Oct 17, 2019
 */
public interface AdminService {

  /**
   * @param user
   * @return
   */
  LoginUser createUser(LoginUser user);
}
