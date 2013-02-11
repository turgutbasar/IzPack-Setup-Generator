/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.biz.izpack.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author basar
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Resource {
    
    @XmlAttribute(name="id")
    private String _id;
    
    @XmlAttribute(name="src")
    private String _source;

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getSource() {
        return _source;
    }

    public void setSource(String _source) {
        this._source = _source;
    }

    @Override
    public String toString() {
        return _id + ", " + _source;
    }

}
