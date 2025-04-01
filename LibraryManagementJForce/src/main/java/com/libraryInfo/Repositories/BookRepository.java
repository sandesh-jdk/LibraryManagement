package com.libraryInfo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.libraryInfo.Entity.Books;

@Repository
public interface BookRepository extends JpaRepository<Books, Integer>
{	
	@Query("select b from Books b where b.user.id = ?1")
	public List<Books> bookUser(Integer id);
	

}
