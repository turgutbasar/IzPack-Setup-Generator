/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.biz.izpack.models;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 *
 * @author basar
 */
public class Packs {
    
    @XmlElement(name="pack")
    private List<Pack> _packList = new ArrayList<Pack>();
    
    public Pack[] getPacks() {
        Pack[] tmpList = new Pack[_packList.size()];
        tmpList = _packList.toArray(tmpList);
        return tmpList;
    }
    
    public void addPack(Pack pack) {
        _packList.add(pack);
    }
    
    public void removePack(Pack pack) {
        _packList.remove(pack);
    }
    
}
