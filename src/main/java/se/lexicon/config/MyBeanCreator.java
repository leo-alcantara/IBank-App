package se.lexicon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.lexicon.data.AccountDao;
import se.lexicon.data.AccountDaoImpl;
import se.lexicon.data.ClientDao;
import se.lexicon.data.ClientDaoImpl;
import se.lexicon.service.Factory;
import se.lexicon.service.FactoryImpl;
import se.lexicon.service.InternalTransaction;
import se.lexicon.service.Transaction;

@Configuration
public class MyBeanCreator {

    @Bean
    public ClientDao clientDao (){
        return new ClientDaoImpl();
    }

    @Bean
    public AccountDao accountDao(){
        return new AccountDaoImpl();
    }

    @Bean
    public Factory factory(){
        return new FactoryImpl(accountDao(), clientDao());
    }

    @Bean
    public Transaction transaction(){
        return new InternalTransaction(accountDao(), clientDao());
    }





}
