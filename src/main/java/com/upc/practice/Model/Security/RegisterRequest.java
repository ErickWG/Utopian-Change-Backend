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
    String password; //si o si debe ser password para que el UserDetailsfuncione
    String nombreUsuario;
    String apellidoUsuario;
    String correoUsuario; //se podría quitar y solo quedarnos con el usuario
}
