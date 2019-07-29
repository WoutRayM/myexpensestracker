package be.giantoaf.myexpensestracker.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Accessors(chain = true)
public class UserAccessLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accessLevelName;
    @OneToMany(mappedBy = "userAccessLevel")
    private List<User> users = new ArrayList<>();

    public void addUserToAccessLevel(User user) {
        users.add(user);
        user.setUserAccessLevel(this);
    }

}
