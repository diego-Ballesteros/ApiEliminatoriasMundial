package com.webunimag.eliminatoria.persistence.entity.AutenticationEntity;

public enum ERole {

    /* Estos son los roles que tendran los diferentes permisos en mi aplicacion
       Un Usuario no podra agregar o eliminar, solo registrarse y consultar
       un Admin si puede hacer tareas de añadir, eliminar
       los roles dependen de la logica de la app
    */
    ROLE_USER, ROLE_ADMIN
}
