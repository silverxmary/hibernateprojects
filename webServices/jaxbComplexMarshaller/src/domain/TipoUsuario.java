/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Diego
 */
@XmlType
@XmlEnum
public enum TipoUsuario {
    
    PREMIUM,
    REGULAR
    
}
