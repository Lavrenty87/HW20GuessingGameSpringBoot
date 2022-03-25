package ru.LearnUp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.LearnUp.servies.GuessingGame;
@Slf4j
@SpringBootApplication
public class Hw20GuessingGameSpringBootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Hw20GuessingGameSpringBootApplication.class, args);
        GuessingGame guessingGame = context.getBean(GuessingGame.class);
        guessingGame.game();
	}

}
