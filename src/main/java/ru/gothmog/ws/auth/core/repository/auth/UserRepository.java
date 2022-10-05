package ru.gothmog.ws.auth.core.repository.auth;

import org.springframework.stereotype.Repository;
import ru.gothmog.ws.auth.core.model.auth.User;
import ru.gothmog.ws.auth.core.repository.BaseRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    Optional<User> findByUsernameOrEmail(String username, String email);

    List<User> findByIdIn(List<Long> userIds);
}
