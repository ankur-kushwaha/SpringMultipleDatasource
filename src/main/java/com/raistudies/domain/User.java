package com.raistudies.domain;


import java.io.Serializable;
import java.util.List;

public class User implements Serializable{

    private static final long serialVersionUID = 3647233284813657927L;

    private String id;
    private String name = null;
    private String aid;
    private List<UserRoles> userRoles;

    //setter and getter have been omitted to make the code short

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}


	public List<UserRoles> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRoles> userRoles) {
		this.userRoles = userRoles;
	}
}