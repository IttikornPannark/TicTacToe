package gametest.TicTacToe;

import javax.persistence.*;

@Entity
@Table
public class TicTacToe {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "round")
    private Integer id;
    private Character turn;
    private Integer position;

    public TicTacToe() {
    }

    public TicTacToe(Character turn, Integer position) {
        this.turn = turn;
        this.position = position;
    }

    public TicTacToe(Integer id, Character turn, Integer position) {
        this.id = id;
        this.turn = turn;
        this.position = position;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Character getTurn() {
        return turn;
    }

    public void setTurn(Character turn) {
        this.turn = turn;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "TicTacToe{" +
                "id=" + id +
                ", turn=" + turn +
                ", position=" + position +
                '}';
    }
}
