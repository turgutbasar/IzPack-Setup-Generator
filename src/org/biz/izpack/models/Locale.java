/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.biz.izpack.models;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author basar
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Locale {
    
    @XmlElement(name="langpack")
    private List<LangPack> _langPackList = new ArrayList<LangPack>();
    
    public boolean isLangPackExist(String name) {
        for (LangPack itr : _langPackList) {
            if (itr.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    
    public void addLangPack(LangPack language) {
        _langPackList.add(language);
    }
    
    public void removeLangPack(LangPack language) {
        _langPackList.remove(language);
    }
    
}
