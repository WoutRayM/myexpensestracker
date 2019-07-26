package be.giantoaf.myexpensestracker.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Accessors(chain = true)
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String expenseName;
    private String expenseDiscription;
    /*private LocalDate dateOfExpense;*/

    @ManyToOne
    private Category category;

}
