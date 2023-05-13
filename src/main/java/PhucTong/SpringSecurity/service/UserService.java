package PhucTong.SpringSecurity.service;

import PhucTong.SpringSecurity.dto.UserDto;
import PhucTong.SpringSecurity.entity.User;

import java.util.List;

public interface UserService {
    public void saveUser(UserDto userDto);
    User findUserByEmail(String email);
    List<UserDto> findAllUsers();
}
