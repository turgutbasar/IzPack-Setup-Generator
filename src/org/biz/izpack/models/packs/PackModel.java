/*
 * PackModel represents the pack tag of install.xml
 */

package org.biz.izpack.models.packs;

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
public class PackModel {
    
    @XmlAttribute(name="name")
    private String _name;
    @XmlAttribute(name="required")
    @XmlJavaTypeAdapter( BooleanAdapter.class )
    private Boolean _required = false;
    @XmlElement(name="description")
    private String _description;
    @XmlElement(name="file")
    private List<FileModel> _files;

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public Boolean isRequired() {
        return _required;
    }

    public void setRequired(Boolean _required) {
        this._required = _required;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String _description) {
        this._description = _description;
    }

    public List<FileModel> getFiles() {
        if (_files == null) {
            _files = new ArrayList<FileModel>();
        }
        return _files;
    }

    @Override
    public String toString() {
        return _name + ", " + _description;
    }

}
