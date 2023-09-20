package com.upc.practice.Model.Security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    String username;
    String apellidoUsuario;
    String nombreUsuario;
    String correoUsuario; //se podría quitar y solo quedarnos con el usuario
    String password; //si o si debe ser password para que el UserDetailsfuncione
}
