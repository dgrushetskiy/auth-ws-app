package ru.gothmog.ws.auth.core.service.auth;

import ru.gothmog.ws.auth.core.model.auth.User;
import ru.gothmog.ws.auth.core.service.BaseCRUDService;
import ru.gothmog.ws.auth.rest.dto.auth.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService extends BaseCRUDService<UserDto> {

    Optional<UserDto> findByEmail(String email);

    Optional<UserDto> findByUsername(String username);

    List<UserDto> findByIdIn(List<Long> userIds);
}
