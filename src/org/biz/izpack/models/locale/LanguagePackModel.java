/*
 * LanguagePackModel represents the langpack tag of install.xml
 */

package org.biz.izpack.models.locale;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author basar
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class LanguagePackModel {
    
    @XmlAttribute(name="iso3")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
