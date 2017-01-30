package com.ufuk.service;

import com.ufuk.security.JwtUserDetail;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Map<String,JwtUserDetail> users = new HashMap<>();
    private static final Collection<SimpleGrantedAuthority> adminCollections = new ArrayList<>();
    private static final Collection<SimpleGrantedAuthority> userCollections = new ArrayList<>();
    static
    {
        adminCollections.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        adminCollections.add(new SimpleGrantedAuthority("ROLE_USER"));
        userCollections.add(new SimpleGrantedAuthority("ROLE_USER"));
        users.put("admin", new JwtUserDetail(1,"admin","admin","admin","admin@admin.com","$2a$06$hO1pxXJYD12rzCpKozWeEOzk4EqTySMefwXGyvnx2HUyXXU1yLCni",adminCollections,true, new Date()));
        users.put("user", new JwtUserDetail(2,"user","user","user","user@user.com","$2a$06$VHHcR4aLPUmwgyz.gwsH7OcKwSeH3ecyVk7iu8DJAntpqJQYA9j9u",userCollections,true, new Date()));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        JwtUserDetail jtwUserDetail = users.get(username);
        return jtwUserDetail;
    }
}
