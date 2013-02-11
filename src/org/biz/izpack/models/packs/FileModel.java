/*
 * FileModel represents the file tag of install.xml
 */

package org.biz.izpack.models.packs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author basar
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class FileModel {
    
    @XmlAttribute(name="source")
    private String _source;
    
    @XmlAttribute(name="targetdir")
    private String _targetDir;

    public String getSource() {
        return _source;
    }

    public void setSource(String _source) {
        this._source = _source;
    }

    public String getTargetDir() {
        return _targetDir;
    }

    public void setTargetDir(String _targetDir) {
        this._targetDir = _targetDir;
    }

    @Override
    public String toString() {
        return _source + ", " + _targetDir;
    }
    
}
