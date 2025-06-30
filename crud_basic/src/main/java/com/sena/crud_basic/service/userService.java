package com.sena.crud_basic.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.RequestLoginDTO;
import com.sena.crud_basic.DTO.RequestRegisterUserDTO;
import com.sena.crud_basic.DTO.ResponseLogin;
import com.sena.crud_basic.DTO.responseDTO;
import com.sena.crud_basic.DTO.userDTO;
import com.sena.crud_basic.jwt.jwtServices;
import com.sena.crud_basic.model.roles;
import com.sena.crud_basic.model.user;
import com.sena.crud_basic.repository.Iuser;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class userService {

    private final Iuser data;
    private final jwtServices jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public List<user> findAll() {
        return data.findAll();
    }

    public Optional<user> findById(int id) {
        return data.findById(id);
    }

    public Optional<user> findByUsername(String username) {
        return data.findByUsername(username);
    }

    public Optional<user> findByEmail(String email) {
        return data.findByEmail(email);
    }

    public responseDTO deleteUser(int id) {
        Optional<user> usuario = findById(id);
        if (!usuario.isPresent()) {
            return new responseDTO(HttpStatus.NOT_FOUND, "El usuario no existe");
        }

        data.deleteById(id);
        return new responseDTO(HttpStatus.OK, "Usuario eliminado correctamente");
    }

    public responseDTO save(RequestRegisterUserDTO userDTO) {
        user usuario = convertToModelRegister(userDTO);
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        data.save(usuario);
        return new responseDTO(HttpStatus.OK, "Usuario guardado correctamente");
    }

    public ResponseLogin login(RequestLoginDTO login) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        login.getUsername(),
                        login.getPassword()));
        UserDetails userDetails = data.findByUsername(login.getUsername()).orElseThrow();
        return new ResponseLogin(jwtService.getToken(userDetails));
    }

    public responseDTO updateUser(int id, userDTO userDTO) {
        Optional<user> usuario = findById(id);
        if (!usuario.isPresent()) {
            return new responseDTO(HttpStatus.NOT_FOUND, "El usuario no existe");
        }

        user updatedUser = usuario.get();
        updatedUser.setUsername(userDTO.get_name());
        updatedUser.setPassword(passwordEncoder.encode(userDTO.get_password()));
        updatedUser.setEmail(userDTO.getEmail());
        updatedUser.setStatus(userDTO.getStatus());
        updatedUser.setRole(userDTO.getRole());

        data.save(updatedUser);
        return new responseDTO(HttpStatus.OK, "Usuario actualizado correctamente");
    }

    public user convertToModelRegister(RequestRegisterUserDTO usuarioDTO) {
        roles rol = new roles();
        rol.setid_roles(1); 
        return new user(
                0,
                usuarioDTO.getUsername(),
                usuarioDTO.getEmail(),
                usuarioDTO.getPassword(),
                usuarioDTO.getNumber(),
                LocalDateTime.now(),
                true,
                rol
        );
    }

    public user convertToModel(userDTO userDTO) {
        roles rol = new roles();
        rol.setid_roles(1);
        return new user(
                0,
                userDTO.get_name(),
                userDTO.getEmail(),
                userDTO.get_password(),
                userDTO.get_number(),
                userDTO.get_registration_date(),
                userDTO.getStatus(),
                rol
        );
    }
}
