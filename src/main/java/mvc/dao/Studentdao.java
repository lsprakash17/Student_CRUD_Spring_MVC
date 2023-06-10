package mvc.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mvc.dto.Student;

//@component @ servece @controller are same for industry standards we are using repository here
@Repository
public class Studentdao 
{
//EntityManagerFactory f=Persistence.createEntityManagerFactory("dev");
//EntityManager m=f.createEntityManager();
//EntityTransaction t=m.getTransaction();
	@Autowired
	EntityManager m;

public void save(Student student)
{
	EntityTransaction t=m.getTransaction();
	t.begin();
	m.persist(student);
	t.commit();
}
public List<Student> fetchall()
{
	return m.createQuery("select a from Student a").getResultList();
}
public void delete(int id)
{
	EntityTransaction t=m.getTransaction();
	t.begin();
	m.remove(m.find(Student.class, id));
	t.commit();

}
public List<Student> Fetchbyname(String name)
{
	return m.createQuery("select a from Student a where name=?1").setParameter(1, name).getResultList();
}
public Student fetchbyid(int id) {
	return m.find(Student.class, id);
}
public void Update(Student student)
{
	EntityTransaction t=m.getTransaction();
	t.begin();
	m.merge(student);
	t.commit();
}
}
