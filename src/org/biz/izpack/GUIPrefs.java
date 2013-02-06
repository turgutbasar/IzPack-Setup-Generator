/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.biz.izpack;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author basar
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class GUIPrefs{
    
    @XmlAttribute(name="width")
    private int _width;
    @XmlAttribute(name="height")
    private int _height;
    @XmlAttribute(name="resizable")
    @XmlJavaTypeAdapter( BooleanAdapter.class )
    private Boolean _resizable = false;
    @XmlElement(name="modifier")
    private List<Modifier> _modifierList = new ArrayList<Modifier>();

    public int getWidth() {
        return _width;
    }

    public int getHeight() {
        return _height;
    }

    public Boolean isResizable() {
        return _resizable;
    }

    public void setWidth(int _width) {
        this._width = _width;
    }

    public void setHeight(int _height) {
        this._height = _height;
    }

    public void setResizable(Boolean _resizable) {
        this._resizable = _resizable;
    }
    
    public Modifier getModifierByKey(String key) {
        for (Modifier itr : _modifierList) {
            if (itr.getKey().equals(key)) {
                return itr;
            }
        }
        return null;
    }
    
    public void addModifier(Modifier modifier) {
        _modifierList.add(modifier);
    }
    
    public void removeModifier(Modifier modifier) {
        _modifierList.remove(modifier);
    }
}
