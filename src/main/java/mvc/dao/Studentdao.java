package mvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import mvc.dto.Student;

//@component @ servece @controller are same for industry standards we are using repository here
@Repository
public class Studentdao 
{
EntityManagerFactory f=Persistence.createEntityManagerFactory("dev");
EntityManager m=f.createEntityManager();
EntityTransaction t=m.getTransaction();

public void save(Student student)
{
	t.begin();
	m.persist(student);
	t.commit();
}
public List<Student> fetchall()
{
	return m.createQuery("select a from Train a").getResultList();
}
}
