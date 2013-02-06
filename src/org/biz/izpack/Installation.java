/*
 * Installation tag representation
 */
package org.biz.izpack;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author basar
 */
@XmlRootElement(name="installation")
@XmlAccessorType(XmlAccessType.FIELD)
public class Installation {
    
    @XmlAttribute(name="version")
    private String _version = "1.0";
    
    @XmlElement(name="info")
    private Information _info = new Information();
    
    @XmlElement(name="guiprefs")
    private GUIPrefs _guiPrefs = new GUIPrefs();
    
    @XmlElement(name="locale")
    private Locale _locale = new Locale();
    
    @XmlElement(name="resources")
    private Resources _resources = new Resources();
    
    @XmlElement(name="jar")
    private List<Jar> _jars = new ArrayList<Jar>();
    
    @XmlElement(name="panels")
    private Panels _panels = new Panels();
    
    @XmlElement(name="packs")
    private Packs _packs = new Packs();

    public Information getInfo() {
        return _info;
    }

    public String getVersion() {
        return _version;
    }

    public GUIPrefs getGuiPrefs() {
        return _guiPrefs;
    }

    public Locale getLocale() {
        return _locale;
    }

    public Resources getResources() {
        return _resources;
    }

    public Jar[] getJars() {
        Jar[] tmpList = new Jar[_jars.size()];
        tmpList = _jars.toArray(tmpList);
        return tmpList;
    }
    
    public void addJar(Jar jar) {
        _jars.add(jar);
    }
    
    public void removeJar(Jar jar) {
        _jars.remove(jar);
    }

    public Packs getPacks() {
        return _packs;
    }

    public Panels getPanels() {
        return _panels;
    }
    
    
    
}
