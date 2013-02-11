/*
 * InformationModel represents info tag of install.xml
 */

package org.biz.izpack.models.information;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.biz.izpack.models.modelhelpers.BooleanAdapter;

/**
 *
 * @author basar
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class InformationModel {
    
    @XmlElement(name="appname")
    private String _appName;
    
    @XmlElement(name="appversion")
    private String _version;
    
    @XmlElementWrapper(name="authors")
    @XmlElement(name="author")
    private List<AuthorModel> _authors;
    
    @XmlElement(name="url")
    private String _URL;
    
    @XmlElement(name="rebootaction")
    private String _rebootAction;
    
    @XmlElement(name="run-privilaged")
    @XmlJavaTypeAdapter(BooleanAdapter.class)
    private Boolean _runPrivilaged;

    public String getAppName() {
        return _appName;
    }

    public void setAppName(String appName) {
        this._appName = appName;
    }

    public String getVersion() {
        return _version;
    }

    public void setVersion(String version) {
        this._version = version;
    }

    public String getURL() {
        return _URL;
    }

    public void setURL(String URL) {
        this._URL = URL;
    }

    public String getRebootAction() {
        return _rebootAction;
    }

    public void setRebootAction(String _rebootAction) {
        this._rebootAction = _rebootAction;
    }

    public Boolean isRunPrivilaged() {
        return _runPrivilaged;
    }

    public void setRunPrivilaged(Boolean runPrivilaged) {
        this._runPrivilaged = runPrivilaged;
    }

    public List<AuthorModel> getAuthors() {
        if (_authors == null) {
            _authors = new ArrayList<AuthorModel>();
        }
        return _authors;
    }
     
}
