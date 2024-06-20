package com.exo2.Exercice2.service;

import com.exo2.Exercice2.dto.UserDto;
import com.exo2.Exercice2.mapper.UserMapper;
import com.exo2.Exercice2.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private UserMapper userMapper;

    public List<UserDto> findAll(Pageable pageable) {
        return userRepository.findAll(pageable).map(userMapper::toDto).getContent();
    }


    @Cacheable(value = "users", key = "#id")
    public UserDto findById(Long id) {
        return userMapper.toDto(userRepository.findById(id).orElse(null));
    }

    public UserDto save(UserDto userDto) {
        return userMapper.toDto(userRepository.save(userMapper.toEntity(userDto)));
    }

    public UserDto update(Long id, UserDto userDto) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    userDto.setId(id);
                    return userMapper.toDto(userRepository.save(userMapper.toEntity(userDto)));
                })
                .orElse(null);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
