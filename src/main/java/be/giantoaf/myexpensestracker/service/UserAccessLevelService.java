package be.giantoaf.myexpensestracker.service;

import be.giantoaf.myexpensestracker.repository.UserAccessLevelRepository;
import org.springframework.stereotype.Service;

@Service
public class UserAccessLevelService {

    private final UserAccessLevelRepository userAccessLevelRepository;

    public UserAccessLevelService(UserAccessLevelRepository userAccessLevelRepository) {
        this.userAccessLevelRepository = userAccessLevelRepository;
    }

}

