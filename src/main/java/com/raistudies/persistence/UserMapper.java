package com.raistudies.persistence;

import java.util.List;

import com.raistudies.domain.User;
import com.raistudies.domain.UserRoles;

public interface UserMapper {
	public List<User> getAllUser();
	public List<UserRoles> getUserRole();
}