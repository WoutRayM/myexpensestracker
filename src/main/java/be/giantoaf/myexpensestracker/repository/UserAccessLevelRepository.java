package be.giantoaf.myexpensestracker.repository;

import be.giantoaf.myexpensestracker.model.UserAccessLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccessLevelRepository extends JpaRepository<UserAccessLevel, Long> {
}
