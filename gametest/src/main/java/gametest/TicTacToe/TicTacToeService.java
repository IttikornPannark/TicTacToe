package gametest.TicTacToe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TicTacToeService {

    private  TicTacToeRepository ticTacToeRepository;

    @Autowired
    public TicTacToeService(TicTacToeRepository ticTacToeRepository) {
        this.ticTacToeRepository = ticTacToeRepository;
    }

    public List<TicTacToe> getTicTacToe(){
        return ticTacToeRepository.findAll();
    }


}

