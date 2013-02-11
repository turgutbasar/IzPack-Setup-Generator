/*
 * ModifierModel represents the modifier tag of install.xml
 */

package org.biz.izpack.models.guiprefs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author basar
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class ModifierModel {
    
    @XmlAttribute(name="key")
    private String key;
    @XmlAttribute(name="value")
    private String value;

    public String getKey() {
        return key;
    }

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
