package ru.gothmog.ws.auth.core.service.auth.impl;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gothmog.ws.auth.core.exception.ConflictException;
import ru.gothmog.ws.auth.core.model.auth.User;
import ru.gothmog.ws.auth.core.repository.auth.UserRepository;
import ru.gothmog.ws.auth.core.service.auth.UserService;
import ru.gothmog.ws.auth.rest.dto.auth.UserDto;
import ru.gothmog.ws.auth.rest.mapper.auth.UserMapper;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Autowired
    public UserServiceImpl(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UserDto create(@NonNull UserDto dto) {
        final String email = dto.getEmail();
        if (repository.existsByEmail(email)) {
            throw new ConflictException("Record user by email already exists", "email", email);
        }
        final String username = dto.getUsername();
        if (repository.existsByUsername(username)) {
            throw new ConflictException("Record user by username already exists", "username", username);
        }
        final User user = repository.save(mapper.toEntity(dto));
        log.info("User created : {}", user);
        return dto;
    }

    @Override
    public UserDto getById(long id) {
        return null;
    }

    @Override
    public UserDto delete(UserDto dto) {
        return null;
    }

    @Override
    public UserDto update(long id, UserDto dto) {
        return null;
    }

    @Override
    public List<UserDto> getListPageToLimit(int page, int limit) {
        return null;
    }

    @Override
    public List<UserDto> getList() {
        return null;
    }

    @Override
    public Optional<UserDto> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Optional<UserDto> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public List<UserDto> findByIdIn(List<Long> userIds) {
        return null;
    }
}
