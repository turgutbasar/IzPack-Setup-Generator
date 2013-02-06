/*
 * Author data type which is used in IzPack ant build script.
 */
package org.biz.izpack;

import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author basar
 */

public class Author {
    
    private String _name;
    private String _email;

    @XmlAttribute(name="name")
    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }
    @XmlAttribute(name="email")
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
