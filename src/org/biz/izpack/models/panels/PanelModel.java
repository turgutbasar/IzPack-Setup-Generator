/*
 * PanelModel represents the panel tag of the install.xml
 */

package org.biz.izpack.models.panels;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author basar
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class PanelModel {
    
    @XmlAttribute(name="classname")
    private String _className;

    public String getClassName() {
        return _className;
    }

    public void setClassName(String _className) {
        this._className = _className;
    }

    @Override
    public String toString() {
        return _className;
    }

}
