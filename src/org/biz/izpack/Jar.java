/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.biz.izpack;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author basar
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Jar {
    
    @XmlAttribute(name="src")
    private String _source;
    @XmlAttribute(name="stage")
    private String _stage;

    public String getSource() {
        return _source;
    }

    public void setSource(String _source) {
        this._source = _source;
    }

    public String getStage() {
        return _stage;
    }

    public void setStage(String _stage) {
        this._stage = _stage;
    }

    @Override
    public String toString() {
        return _source + ", " + _stage;
    }
    
}
