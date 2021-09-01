package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.MyBeanCreator;
import se.lexicon.data.AccountDao;
import se.lexicon.data.ClientDao;
import se.lexicon.service.Factory;
import se.lexicon.service.Transaction;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyBeanCreator.class);

        AccountDao accountDao = context.getBean("accountDao", AccountDao.class);

        ClientDao clientDao = context.getBean("clientDao", ClientDao.class);

        Factory factory = context.getBean("factory", Factory.class);

        Transaction transaction = context.getBean("transaction", Transaction.class);

        factory.createAccount();
        factory.createClient("Leo", "Alcantara");

        accountDao.findAll().forEach(System.out::println);
        clientDao.findAll().forEach(System.out::println);














    }
}
