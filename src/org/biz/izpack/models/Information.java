/*
 * Information tag representation for IzPack Install.xml 
 * Ant build script.
 */
package org.biz.izpack.models;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author basar
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Information {
    
    @XmlElement(name="appname")
    private String _appName;
    
    @XmlElement(name="appversion")
    private String _version;
    
    @XmlElementWrapper(name="authors")
    @XmlElement(name="author")
    private List<Author> _authors = new ArrayList<Author>();
    
    @XmlElement(name="url")
    private String _URL;
    
    @XmlElement(name="rebootaction")
    private String _rebootAction;
    
    @XmlElement(name="run-privilaged")
    @XmlJavaTypeAdapter( BooleanAdapter.class )
    private Boolean _runPrivilaged = false;

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
    
    public Author[] getAuthors() {
        Author[] tmpList = new Author[_authors.size()];
        tmpList = _authors.toArray(tmpList);
        return tmpList;
    }
    
    public void addAuthor(Author author) {
        _authors.add(author);
    }
    
    public void removeAuthor(Author author) {
        _authors.remove(author);
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
     
}
