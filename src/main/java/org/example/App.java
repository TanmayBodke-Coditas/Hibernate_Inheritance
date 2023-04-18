package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();


        Employee e1 = new Employee(1, "Aarti");
        PartTimeEmp e2 = new PartTimeEmp(2, "Kriti", 500, 30);
        FullTimeEmp e3 = new FullTimeEmp(3, "Preeti", 25000, 12, 400);

        session.save(e1);
        session.persist(e1);
        session.save(e2);
        session.persist(e2);
        session.save(e3);
        session.persist(e3);
        tx.commit();

        session.close();
    }
}
