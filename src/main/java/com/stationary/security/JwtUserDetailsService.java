package com.stationary.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.stationary.bo.LoginUserBo;
import com.stationary.entity.LoginUser;
import com.stationary.repository.LoginUserRepo;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private LoginUserRepo userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public LoginUserBo loadUserByUsername(String username) throws UsernameNotFoundException {

        LoginUser user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
//        Set<BranchBo> branches = new HashSet<>();
//        user.getBranchs().forEach(item -> {
//            BranchBo branch = new BranchBo();
//            BeanUtils.copyProperties(item, branch);
//            branches.add(branch);
//        });
        return new LoginUserBo(user.getUsername(), user.getPassword(), user.getId(),
                user.getLoginAuthorities());
    }

    public LoginUser save(LoginUser user) {

        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userDao.save(user);
    }
}