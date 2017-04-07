package model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class UserDAOImp implements UserDAO{
	EntityManagerFactory factory;
	EntityManager entityManager;
	public UserDAOImp() {
		
	}

	@Override
	public boolean addUser(User user) {
		
			try{
				factory = Persistence.createEntityManagerFactory("JpaDemo");
				 entityManager =factory.createEntityManager();
				entityManager.getTransaction().begin();
				entityManager.persist(user);
				entityManager.getTransaction().commit();
				}catch(Exception e){
					e.printStackTrace();
				}

		
		return false;
	}

	@Override
	public void deleteUser(int userId) {
		factory = Persistence.createEntityManagerFactory("JpaDemo");
		 entityManager =factory.createEntityManager();
		entityManager.getTransaction().begin();
		User user =entityManager.find(User.class,userId);
		entityManager.remove(user);
		entityManager.getTransaction().commit();
		
	}

	@Override
	public void updateUser(User user) {
		factory = Persistence.createEntityManagerFactory("JpaDemo");
		 entityManager =factory.createEntityManager();
		 entityManager.getTransaction().begin();
		 User old_user =entityManager.find(User.class,user.getId());
		 old_user.setName(user.getName());
		 old_user.setEmail(user.getEmail());
		 old_user.setPassword(user.getPassword());
		 entityManager.getTransaction().commit();
	}

	@Override
	public List<User> getAllUsers() {
		factory = Persistence.createEntityManagerFactory("JpaDemo");
		 entityManager =factory.createEntityManager();
		//List<User> users = new ArrayList<User>();
		entityManager.getTransaction().begin();
		Query query=entityManager.createQuery("select u from User u");
		List users=query.getResultList();
		entityManager.getTransaction().commit();
		return users;
	}

	@Override
	public User getUserById(int userId) {
		factory = Persistence.createEntityManagerFactory("JpaDemo");
		 entityManager =factory.createEntityManager();
		
		 User user =entityManager.find(User.class,userId);
		return user;
	}

	@Override
	public User getStudentByName(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsersLike(String name) {
		name="%"+name+"%";
		factory=Persistence.createEntityManagerFactory("JpaDemo");
		entityManager=factory.createEntityManager();
		entityManager.getTransaction().begin();
	Query query=	entityManager.createQuery("select u from User u where u.name Like :name");
	query.setParameter("name",name);
		
	List users=	query.getResultList();
		return users;
	}

}
