package com.libraryInfo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.libraryInfo.Entity.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer>
{	
	@Query("select r.password from Registration r where r.username = ?1")
	public String getpassword(String user);
	
	@Query("select r.username from Registration r where r.username = ?1")
	public String getemail(String user);
	
	@Query("select r.id from Registration r where r.username = ?1")
	public Integer getid(String user);
	
	@Query("select r.role from Registration r where r.username = ?1")
	public String getRole(String user);
}
