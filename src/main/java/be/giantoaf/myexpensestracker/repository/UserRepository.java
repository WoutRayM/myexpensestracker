package be.giantoaf.myexpensestracker.repository;

import be.giantoaf.myexpensestracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
