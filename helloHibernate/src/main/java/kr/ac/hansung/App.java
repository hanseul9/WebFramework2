package kr.ac.hansung;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

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

        Category category1 = new Category();
        category1.setName("컴퓨터");

        Category category2 = new Category();
        category1.setName("자동차");

        Product product1 = new Product();
        product1.setName("노트북1");
        product1.setPrice(2000);
        product1.setDescription("Awesome Notebook");
        product1.setCategory(category1);
        category1.getProducts().add(product1);

        Product product2 = new Product();
        product2.setName("노트북2");
        product2.setPrice(1000);
        product2.setDescription("Powerful Notebook");
        product2.setCategory(category1);
        category1.getProducts().add(product2);

        Product product3 = new Product();
        product3.setName("소나타");
        product3.setPrice(20000);
        product3.setDescription("Popular Car");
        product3.setCategory(category2);
        category2.getProducts().add(product3);


        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

//        session.save(product1);
//        session.save(product2);
//        session.save(product3);
//
        Serializable cid1 = session.save(category1);
        Serializable cid2 = session.save(category2);

//        Product saveProduct = session.get(Product.class, product1.getId());
//        System.out.println("saveProduct = " + saveProduct);

//        Query<Product> aQuery = session.createQuery("from Product order by name ", Product.class);
//        List<Product> products = aQuery.getResultList();
//        System.out.println("products = " + products);

        tx.commit();
        session.close();

        Session session2 = sessionFactory.openSession();
        Transaction tx2 = session2.beginTransaction();

        System.out.println("helloHibernate " + "getting a category");
        Category aCategory = session2.get(Category.class, cid1);

        System.out.println("helloHibernate " + "getting Products");
        Set<Product> products = aCategory.getProducts();

        System.out.println("helloHibernate " + "printing Products");
        for (Product p : products)
        {
            System.out.println(p.getName());
        }

        tx2.commit();
        session2.close();

        sessionFactory.close();
    }
}
