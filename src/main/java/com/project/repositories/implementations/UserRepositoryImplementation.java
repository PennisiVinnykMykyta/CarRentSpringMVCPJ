package com.project.repositories.implementations;

import java.util.List;
import com.project.config.HibernateUtilConfig;
import com.project.entities.User;
import com.project.repositories.UserRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;

@Repository
public class UserRepositoryImplementation implements UserRepository {

    @Override
    public User findByEmail(String email){
        try(Session session = HibernateUtilConfig.getSessionFactory().openSession()){
            return  session.createQuery("SELECT s from User s where s.email = :email ",User.class)
                    .setParameter("email",email).getSingleResult();
        }catch(NoResultException exception){
            return null;
        }
    }
    @Override
    public void deleteById(int id){ //delete a user with a specific id
        Transaction transaction = null;
        try (Session session = HibernateUtilConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            User user;
            user = session.find(User.class,id);
            session.delete(user);
            session.flush();
            transaction.commit();
        }
        catch(Exception e){
            if(transaction == null ){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void saveOrUpdateUser(User user){ // save the user if not present else update it
        Transaction transaction = null;
        try (Session session = HibernateUtilConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(user);
            session.flush();
            transaction.commit();
        }
        catch(Exception e){
            if(transaction == null ){
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<User> findAll(){ //view all users
        try (Session session = HibernateUtilConfig.getSessionFactory().openSession()){
            return  session.createQuery("SELECT s from User s",User.class).list();
        }catch(NoResultException exception){
            return null;
        }
    }

    @Override
    public User findById(int id){ // get a specific user
        try(Session session = HibernateUtilConfig.getSessionFactory().openSession()){
            User user;
            user = session.find(User.class, id);
            return user;
        }catch(NoResultException exception){
            return null;
        }
    }

}
