/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.biz.izpack;

import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author basar
 */
public class Modifier {
    
    
    private String key;
    
    private String value;
    
    @XmlAttribute(name="key")
    public String getKey() {
        return key;
    }
    
    @XmlAttribute(name="value")
    public String getValue() {
        return value;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }
 
}
