import config.FactoryConfiguration;
import entity.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Main {

    /*public static void main(String[] args) {*/
        /*FactoryConfiguration factory=FactoryConfiguration.getInstance();

        Customer customer = new Customer(1,"Alice","Alice@example.com","0777777777");

        Session session= factory.getSession();
    try {
        Transaction transaction = session.beginTransaction();//save,update delete waldi aniwaren meeka one, get ekakdi awlk na

        session.save(customer);

        transaction.commit();
        session.close();
    } catch (Exception e) {
        System.out.println("Failed to save customer");
    }

        Customer customer2 = new Customer(2,"Alice","Alice@example.com","0777777777");

        Session session2= factory.getSession();
        try {
            Transaction transaction = session2.beginTransaction();//save,update delete waldi aniwaren meeka one, get ekakdi awlk na

            session2.save(customer);

            transaction.commit();
            session2.close();
        } catch (Exception e) {
            System.out.println("Failed to save customer");
        }*/
    private static FactoryConfiguration factory;
    public static void main(String[] args) {
        factory=FactoryConfiguration.getInstance();

        /*Customer customer = new Customer(2,"Vinod","vinod@gmail.com","0778193985");
        Customer customer2 = new Customer(3,"Namal","naml@gmail.com","0776453985");
        Customer customer3 = new Customer(4,"Grace","grace@gmail.com","0778194996");
        Customer customer4 = new Customer(5,"Eva","eva@gmail.com","0771714617");
        Customer customer5 = new Customer(6,"Ron","ron@gmail.com","0773403597");

        saveCustomer(customer);
        saveCustomer(customer2);
        saveCustomer(customer3);
        saveCustomer(customer4);
        saveCustomer(customer5);*/


        /*Customer customerById=getCustomerById(2);
        System.out.println(customerById);*/

        /*deleteCustomer(1);*/

        /*updateCustomer(new Customer(2,"Vinod","vinodfernando@gmail.com","0774417675")); //Old method in new version meeka wada naa*/

       /* updateCustomer(
                3,
                new Customer(3,"Praneeth","praneeth@gmail.com","0771714617")
        );*/

        List<Customer> allCustomer = getAllCustomer();
        for(Customer customer:allCustomer){
            System.out.println(customer);
        }


    }

    public static List<Customer> getAllCustomer(){
        Session session=factory.getSession();
        //Hibernate query liyanne classes padaka karan

        List<Customer> customers = session.createQuery("from Customer", Customer.class).list();//Hipernate queary language ekk sql wageema tama poddak wenas
        session.close();
        return customers;

    }

    public static boolean updateCustomer(int id,Customer newCustomerData){
        Session session=factory.getSession();
        try{
            Customer customerById=session.get(Customer.class,id);
            Transaction transaction= session.beginTransaction();
            /*session.update(newCustomerData);*/ //Don't use this

            customerById.setName(newCustomerData.getName());
            customerById.setEmail(newCustomerData.getEmail());
            customerById.setPhone(newCustomerData.getPhone());

            transaction.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Customer Not Updated");
            return false;
        }finally{
            if(session!=null){
                session.close();
            }
        }

    }

    public static boolean updateCustomer(Customer customer){
        Session session=factory.getSession();
        try{
            Transaction transaction=session.beginTransaction();
            session.update(customer);
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.out.println("Customer not updated");
            e.printStackTrace();
            return false;
        }finally{
            if(session!=null){
                session.close();
            }
        }
    }

    public static boolean deleteCustomer(Integer id) {
        Session session=factory.getSession();
        try{
            //item eka 5 wena item ekei customer ekei dekmema table dekk tibbot prashnayk wena nisa direct id eka della delete karanna ba.

            Customer customerById=getCustomerById(id);
            Transaction transaction=session.beginTransaction();//database ekata effect ekak wena ewata aniwaren transaction ekk danna one
            /*session.delete(id);*/// mehema baa

            session.delete(customerById);
            transaction.commit();
            return true;

        } catch (Exception e) {
            System.out.println("Customer Not Found");
            e.printStackTrace();
            return false;
        }finally {
            if(session!=null){
                session.close();
            }
        }

    }
    public static Customer getCustomerById(int id) {
        Session session = factory.getSession();
        Customer customer =session.get(Customer.class, id);
        return customer;

    }

    public static boolean saveCustomer (Customer customer){
        Session session = factory.getSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        finally {
            if(session!=null){
                session.close();
            }
        }

    }

}