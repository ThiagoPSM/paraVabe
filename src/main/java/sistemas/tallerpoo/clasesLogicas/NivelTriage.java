/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemas.tallerpoo.clasesLogicas;

/**
 *
 * @author Thiago
 */
public enum NivelTriage 
{
    Rojo,Naranja,Amarillo,Verde,Azul
}




/* EJEMPLO DE USO DE LA CLASE ENUM
*
public enum Demarcacion{PORTERO, DEFENSA, CENTROCAMPISTA, DELANTERO}
Demarcacion delantero = Demarcacion.DELANTERO;    // Instancia de un enum de la clase Demarcación
delantero.name();    // Devuelve un String con el nombre de la constante (DELANTERO)
delantero.toString();    // Devuelve un String con el nombre de la constante (DELANTERO)
delantero.ordinal();    // Devuelve un entero con la posición del enum según está declarada (3).
delantero.compareTo(Enum otro);    // Compara el enum con el parámetro según el orden en el que están declarados lo enum
Demarcacion.values();    // Devuelve un array que contiene todos los enum
*/