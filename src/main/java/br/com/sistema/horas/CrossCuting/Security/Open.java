package br.com.sistema.horas.CrossCuting.Security;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Open {
}
