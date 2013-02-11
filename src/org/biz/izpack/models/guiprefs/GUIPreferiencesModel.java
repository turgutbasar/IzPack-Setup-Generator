/*
 * GUIPreferiencesModel represents the guiprefs tag of install.xml
 */

package org.biz.izpack.models.guiprefs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.biz.izpack.models.modelhelpers.BooleanAdapter;

/**
 *
 * @author basar
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class GUIPreferiencesModel{
    
    @XmlAttribute(name="width")
    private int _width;
    @XmlAttribute(name="height")
    private int _height;
    @XmlAttribute(name="resizable")
    @XmlJavaTypeAdapter( BooleanAdapter.class )
    private Boolean _resizable = false;
    @XmlElement(name="modifier")
    private List<ModifierModel> _modifiers;

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
    
    public ModifierModel getModifierByKey(String key) {
        if (_modifiers == null) {
            _modifiers = new ArrayList<ModifierModel>();
        }
        for (ModifierModel itr : _modifiers) {
            if (itr.getKey().equals(key)) {
                return itr;
            }
        }
        return null;
    }
    
    public void addModifier(ModifierModel modifier) {
        _modifiers.add(modifier);
    }
    
    public void removeModifier(ModifierModel modifier) {
        _modifiers.remove(modifier);
    }
    
}
