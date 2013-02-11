/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.biz.izpack.models;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author basar
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Pack {
    
    @XmlAttribute(name="name")
    private String _name;
    @XmlAttribute(name="required")
    @XmlJavaTypeAdapter( BooleanAdapter.class )
    private Boolean _required = false;
    @XmlElement(name="description")
    private String _description;
    @XmlElement(name="file")
    private List<File> _fileList = new ArrayList<File>();

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

    public File[] getFiles() {
        File[] tmpList = new File[_fileList.size()];
        tmpList = _fileList.toArray(tmpList);
        return tmpList;
    }
    
    public void addFile(File file) {
        _fileList.add(file);
    }
    
    public void removeFile(File file) {
        _fileList.remove(file);
    }

    @Override
    public String toString() {
        return _name + ", " + _description;
    }

}
