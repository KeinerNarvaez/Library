package com.sena.crud_basic.controller;

import org.springframework.web.bind.annotation.RestController;

import com.sena.crud_basic.DTO.responseDTO;
import com.sena.crud_basic.DTO.userDTO;

import com.sena.crud_basic.service.userService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.sena.crud_basic.service.recapchatService;


@RestController
@RequestMapping("/api/v1/user")
public class userController {

    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private userService userService;
    @Autowired
    private recapchatService recapchatService;

    @PostMapping("/")
    public ResponseEntity<Object> registerUser(@RequestBody userDTO user,@RequestParam("g-recaptcha-response") String captchaToken) {
        boolean isCaptchaValid = recapchatService.validateRecaptcha(captchaToken);
        if (!isCaptchaValid) {
            return new ResponseEntity<>("reCAPTCHA inválido", HttpStatus.UNAUTHORIZED);
        }
    
        responseDTO respuesta = userService.save(user);
        return new ResponseEntity<>(respuesta, respuesta.getStatus());
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllUser() {
        var listaUsuario = userService.findAll();
        return new ResponseEntity<>(listaUsuario, HttpStatus.OK);
    }

    /*
     * Se requiere un dato, el ID
     * PathVariable=captura de información por la URL
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneUser(@PathVariable int id) {
        var usuario = userService.findById(id);
        if (!usuario.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping("/filter/{email}/{password}")
    public ResponseEntity<Object> getListUserForName(@PathVariable String email, @PathVariable String password) {
        var userList = userService.getListUserForName(email, password);
        if (userList.isEmpty()) {
            return new ResponseEntity<>("Credenciales incorrectas", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }
    @GetMapping("/filter/{filter}")
    public ResponseEntity<Object> getname(@PathVariable String filter) {
        var userList = userService.getname(filter);
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable int id) {
        var message = userService.deleteUser(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}