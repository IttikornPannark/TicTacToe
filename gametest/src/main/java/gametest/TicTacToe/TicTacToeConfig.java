package gametest.TicTacToe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TicTacToeConfig {

    @Bean
    CommandLineRunner commandLineRunner(TicTacToeRepository repository){
        return args -> {
            TicTacToe x = new TicTacToe(
                    'X', 10
            );

            TicTacToe o = new TicTacToe(
                    'O', 19
            );

            repository.saveAll(
                    List.of(x,o)
            );

        };
    }
}
