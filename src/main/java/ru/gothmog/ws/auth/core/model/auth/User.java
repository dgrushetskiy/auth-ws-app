package ru.gothmog.ws.auth.core.model.auth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.NaturalId;
import ru.gothmog.ws.auth.core.model.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "auth",
        indexes = {
                @Index(name = "unq_users_email_key", columnList = "email", unique = true),
                @Index(name = "unq_users_username_key", columnList = "username", unique = true)
        },
        uniqueConstraints = {@UniqueConstraint(name = "unq_users_email_username_key", columnNames = {"email", "username"})}
)
@Builder(toBuilder = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User extends AbstractEntity {
    @NaturalId
    @NotBlank
    @Size(max = 150)
    @Column(name = "username", nullable = false, length = 100)
    private String username;
    @NaturalId
    @NotBlank
    @Size(max = 150)
    @Email
    @Column(name = "email", length = 150)
    private String email;
    @NotBlank
    @Size(max = 255)
    @Column(name = "pswd")
    private String password;
    @Column(name = "first_name", nullable = false, length = 200)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 200)
    private String lastName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return getId() != null && Objects.equals(getId(), user.getId())
                && getUsername() != null && Objects.equals(getUsername(), user.getUsername())
                && getEmail() != null && Objects.equals(getEmail(), user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getEmail());
    }
}
