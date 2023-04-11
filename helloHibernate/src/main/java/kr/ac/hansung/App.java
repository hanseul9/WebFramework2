package kr.ac.hansung;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        Configuration conf = new Configuration();
//        conf.configure(); // 디폴트 "hibernate.cfg.xml"
//        SessionFactory sessionFactory = conf.buildSessionFactory();

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Product product1 = new Product();
        product1.setName("노트북1");
        product1.setPrice(2000);
        product1.setDescription("Awesome Notebook");

        session.save(product1);

        Product saveProduct = session.get(Product.class, product1.getId());
        System.out.println("saveProduct = " + saveProduct);

        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
