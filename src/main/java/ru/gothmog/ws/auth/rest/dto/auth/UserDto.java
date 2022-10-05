package ru.gothmog.ws.auth.rest.dto.auth;

import lombok.EqualsAndHashCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import ru.gothmog.ws.auth.rest.dto.AbstractDto;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto extends AbstractDto {
    private String username;
    private String email;
    private String firstName;
    private String lastName;
}
