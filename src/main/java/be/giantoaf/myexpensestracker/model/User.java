package be.giantoaf.myexpensestracker.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Accessors(chain = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @ManyToOne
    private UserAccessLevel userAccessLevel;
    @OneToMany(mappedBy = "user")
    private List<Expense> expenses = new ArrayList<>();

    public void addNewExpense(Expense expense) {
        expenses.add(expense);
        expense.setUser(this);
    }

}
