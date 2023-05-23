package com.project.repositories.implementations;

import com.project.config.HibernateUtilConfig;
import com.project.entities.Car;
import com.project.repositories.CarRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepositoryImplementation implements CarRepository {

    @Override
    public void deleteById(int id) { //delete a car with a specific id
        Transaction transaction = null;
        try (Session session = HibernateUtilConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Car car;
            car = session.find(Car.class, id);
            session.delete(car);
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction == null) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void saveOrUpdateCar(Car car) { //change state for a specific car
        Transaction transaction = null;
        try (Session session = HibernateUtilConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(car);
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction == null) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Car> findAll() { //view all cars
        try (Session session = HibernateUtilConfig.getSessionFactory().openSession()) {
            return session.createQuery("SELECT s from Car s", Car.class).list();
        } catch (Exception e) {
            return null;
        }
    }

    public Car findById(int id) { // get the specific car
        try (Session session = HibernateUtilConfig.getSessionFactory().openSession()) {
            Car car;
            car = session.find(Car.class, id);
            return car;
        }
    }

    @Override
    public List<Car> availableCars(List<Integer> bookedCars) {
        List<Car> carList = findAll();
        List<Car> availableCars = new ArrayList<>();

        for (Car car : carList) {
            if (!bookedCars.contains(car.getId())) {
                availableCars.add(car);
            }
        }
        return availableCars;

    }
}
