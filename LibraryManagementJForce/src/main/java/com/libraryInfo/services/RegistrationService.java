package com.libraryInfo.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryInfo.Entity.Registration;
import com.libraryInfo.Repositories.RegistrationRepository;

@Service
public class RegistrationService 
{	
	@Autowired
	private RegistrationRepository regirepo;
	
	public Registration saveUser(Registration r)
	{
		return regirepo.save(r);
	}
	
	public String getPassword(String user)
	{
		return regirepo.getpassword(user);
	}
	
	public String getemail(String user)
	{
		return regirepo.getemail(user);
	}
	
	public Integer getId(String user)
	{
		return regirepo.getid(user);
	}
	
	public Registration getuser(int id)
	{
		return regirepo.findById(id).orElseThrow();
	}
	
	public String getRole(String user)
	{
		return regirepo.getRole(user);
	}
}
