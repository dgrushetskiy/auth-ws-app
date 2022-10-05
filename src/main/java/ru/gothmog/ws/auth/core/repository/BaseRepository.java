package ru.gothmog.ws.auth.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ru.gothmog.ws.auth.core.model.AbstractEntity;

@NoRepositoryBean
public interface BaseRepository<T extends AbstractEntity, ID> extends JpaRepository<T, ID> {
}
