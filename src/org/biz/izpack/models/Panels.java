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
public class Panels {
    
    @XmlElement(name="panel")
    private List<Panel> _panelList = new ArrayList<Panel>();
    
    public void addPanel(Panel panel) {
        _panelList.add(panel);
    }
    
    public void removePanel(Panel panel) {
        _panelList.remove(panel);
    }
    
    public Panel[] getPanels() {
        Panel[] tmpList = new Panel[_panelList.size()];
        tmpList = _panelList.toArray(tmpList);
        return tmpList;
    }
}
