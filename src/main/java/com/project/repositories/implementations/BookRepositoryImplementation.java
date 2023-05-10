package com.project.repositories.implementations;

import com.project.config.HibernateUtilConfig;
import com.project.entities.Book;
import com.project.repositories.BookRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.time.LocalDate;
import java.util.List;

@Repository
public class BookRepositoryImplementation implements BookRepository {

    @Override
    public void deleteById(int id){ //delete a specific booking instance
        Transaction transaction = null;
        try(Session session = HibernateUtilConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Book book;
            book = session.find(Book.class,id);
            session.delete(book);
            session.flush();
            transaction.commit();
        }catch(Exception e){
            if(transaction == null ){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void saveOrUpdateBook(Book book){ //change state for a specific book
        Transaction transaction = null;
        try(Session session = HibernateUtilConfig.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(book);
            session.flush();
            transaction.commit();
        }
        catch(Exception e){
            if(transaction == null ){
                e.printStackTrace();
            }
        }
    }

    public List<Book> findAll(){ //view all cars
        try (Session session = HibernateUtilConfig.getSessionFactory().openSession()){
            return  session.createQuery("from Book",Book.class).list();
        }catch (NoResultException exception){
            return null;
        }
    }

    @Override
    public List<Book> conflictingBookings(LocalDate start, LocalDate end){
        try (Session session = HibernateUtilConfig.getSessionFactory().openSession()){
            Criteria criteria = session.createCriteria(Book.class);

////////////start date is between new startDate and new endDate
            Criterion startGreaterStart = Restrictions.gt("startDate",start);
            Criterion startEqualStart = Restrictions.eq("startDate",start);
            LogicalExpression greaterOrEqualStart = Restrictions.or(startGreaterStart,startEqualStart);

            Criterion startLessEnd = Restrictions.lt("startDate",end);
            Criterion startEqualEnd = Restrictions.eq("startDate",end);
            LogicalExpression greaterOrEqualEnd = Restrictions.or(startLessEnd,startEqualEnd);

            LogicalExpression startStartEnd = Restrictions.and(greaterOrEqualStart,greaterOrEqualEnd);

////////////end date is between new startDate and new endDate
            Criterion endGreaterStart = Restrictions.gt("endDate",start);
            Criterion endEqualStart = Restrictions.eq("endDate",start);
            LogicalExpression greaterOrEqualStart1 = Restrictions.or(endGreaterStart,endEqualStart);


            Criterion endLessEnd = Restrictions.lt("endDate",end);
            Criterion endEqualEnd = Restrictions.eq("endDate",end);
            LogicalExpression greaterOrEqualEnd1 = Restrictions.or(endLessEnd,endEqualEnd);


            LogicalExpression startEndEnd = Restrictions.and(greaterOrEqualStart1,greaterOrEqualEnd1);

////////////Combination of both previous cases
            LogicalExpression startAndEnd = Restrictions.or(startStartEnd,startEndEnd);

///////////start date and end date have new startDate and new endDate between them
            Criterion startLessStart = Restrictions.lt("startDate",start);
            Criterion startEqualStart1 = Restrictions.eq("startDate",start);
            LogicalExpression lessOrEqualStart = Restrictions.or(startLessStart,startEqualStart1);

            Criterion endGreaterEnd = Restrictions.gt("endDate",end);
            Criterion endEqualEnd1 = Restrictions.eq("endDate",end);
            LogicalExpression greaterOrEqualEnd2 = Restrictions.or(endGreaterEnd,endEqualEnd1);

            LogicalExpression endAndStart = Restrictions.and(lessOrEqualStart,greaterOrEqualEnd2);

////////////Combination of this case and the previous combo
            LogicalExpression noValidation = Restrictions.or(startAndEnd,endAndStart);

////////////Make sure that the booking has been confirmed by the admin
            Criterion validation = Restrictions.eq("valid",true);

////////////Final Combination
            LogicalExpression finalCheck = Restrictions.and(noValidation,validation);

            criteria.add(finalCheck);

////////////select only the booking that are conflicting
            return criteria.list();
        }
        catch (NoResultException exception){
            return null;
        }
    }

    @Override
    public Book findById(int id){
        try(Session session = HibernateUtilConfig.getSessionFactory().openSession()){
            Book book;
            book = session.find(Book.class, id);
            return book;
        }catch (NoResultException exception){
            return null;
        }
    }
}
