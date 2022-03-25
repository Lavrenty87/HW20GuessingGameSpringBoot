package ru.LearnUp.servies;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import ru.LearnUp.Hw20GuessingGameSpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

@Slf4j
@Service

public class GuessingGame implements ApplicationContextAware {
    private int secretNumb;
    private ApplicationContext context;

    public GuessingGame(ApplicationContext context) {
        this.context = context;
    }

    @Bean
    public void game(){
        int secretNumb = (int) (Math.random() * 1000);
        Locale locale = Locale.US;
        Integer secretNam = (int) (Math.random() * 1000);
        System.out.println(secretNam);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            //System.out.println(context.getMessage("hi", null, locale.ENGLISH));
            log.info(context.getMessage("hi", null, locale));
           //pub.pubEvent(context.getMessage("hi", null, locale));
            int read = Integer.parseInt(reader.readLine());

            while (read != secretNam) {
                if (read < secretNam) {
                    //System.out.println(context.getMessage("bigger", null, locale));
                    log.info(context.getMessage("bigger", null, locale));
                   // pub.pubEvent(context.getMessage("bigger", null, locale));
                }
                if (read > secretNam){
                    //System.out.println(context.getMessage("less", null, locale));
                    log.info(context.getMessage("less", null, locale));
                 //   pub.pubEvent(context.getMessage("less", null, locale));
                }
                //System.out.println(context.getMessage("try", null, locale));
                log.info(context.getMessage("try", null, locale));
              //  pub.pubEvent(context.getMessage("try", null, locale));
                read = Integer.parseInt(reader.readLine());
            }
            System.out.println(context.getMessage("guessed", new Object[]{"" + secretNam}, locale) + secretNam);
            //log.info(context.getMessage("guessed", new Object[]{secretNam.toString()}, locale));
           // pub.pubEvent(context.getMessage("guessed", new Object[]{secretNam.toString()}, locale));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

 /*   @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }*/
}
