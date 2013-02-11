/*
 * AuthorModel represents author tag of install.xml
 */

package org.biz.izpack.models.information;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import org.biz.izpack.EmailValidator;

/**
 *
 * @author basar
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class AuthorModel {
    
    @XmlAttribute(name="name")
    private String _name;
    
    @XmlAttribute(name="email")
    private String _email;

    
    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }
    
    public String getEmail() {
        return _email;
    }

    public boolean setEmail(String email) {
        EmailValidator validator = new EmailValidator();
        if(!validator.validate(email)) {
            return false;
        }
        this._email = email;
        return true;
    }

    @Override
    public String toString() {
        return _name;
    }
    
}
