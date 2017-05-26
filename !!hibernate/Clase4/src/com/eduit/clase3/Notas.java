package com.eduit.clase3;

public class Notas 
{
    /*
    
    El objeto THIS y el objeto SUPER son IGUALES.
    En el ejemplo de abajo, un objeto cliente contiene también un objeto persona.
    HIBERNATE simula la herencia realizando una funcion 1 a 1 con tablas SQL.
    
    Persona
    Long ID
    String Nombre
    String Apellido
    
    Empleado(!)
    Float sueldo
    
    Cliente(!)
    Float Credito
    
    1) Realizar todo en una sola tabla. No se realiza la division 1 a 1.
    (SINGLE TABLE)
    Ej:
    Personas:
    ID \\ Nombre \\ Apellido \\ Credito \\Sueldo \\ Dis (<-- columna discriminadora)
    1       Juan    Perez       3000        NULL    CC
    2       Coco    Sanchez     NULL        5000    EM
    
    2) Tabla por clase concreta.
    Se crea una tabla por clase, ej, una tabla para Persona, una tabla para Empleado
    (otra para Cliente) con los atributos de Persona.
    Ej:
    
    Personas:
    Id || nombre || apellido
    
    Empleados:
    Id || nombre || apellido || sueldo
    
    Cliente:
    id || nombre || apellido || credito
    
    Al guardar un registro en cada tabla, habría conflicto porque estos tendrían
    id's iguales. En oracle utilizan un secuenciador pero en otras DB necesita
    crearse una tabla que maneje los ids (GENERATOR TYPE TABLE)
    
    (ES LA MENOS USADA)
    
    3) TABLE PER CLASS
    (Tabla por clase)
    
    PERSONAS
    id || nombre || apellido
    1       juan    perez
    2       coco    sanchez
    
    EMPLEADO            CLIENTE
    id || sueldo        id || credito
    1       3000        2       3000
    2       4000        
    
    EL ID FUNCIONA COMO PRIMARY Y FOREIGN KEY AL MISMO TIEMPO
    
    Para mapear en Hibernate primero se inicia por la clase Super porque allì se
    determina que tipo de herencia se utilizará
    
    NUNCA HAGAN SUPER TO STRING
    Puede dar un stackoverflow
    
    */
}
