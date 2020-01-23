package com.stationary.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stationary.entity.LoginUser;
import com.stationary.util.ApplicationUtil;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Oct 17, 2019
 */
@RestController
@RequestMapping("admin")
public class AdminController {

  @Autowired
  private AdminService service;

  /**
   * @param user
   * @return
   */
  @PostMapping(value = "create-user")
  public ResponseEntity<?> createUser(@RequestBody final LoginUser user) {

    return ApplicationUtil.getResponseEntity("User created successfully.",
        service.createUser(user));
  }
}
