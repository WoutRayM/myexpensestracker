package be.giantoaf.myexpensestracker.model;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double amount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfExpense;
    @ManyToOne
    private Category category;
    @ManyToOne
    private User user;

}
