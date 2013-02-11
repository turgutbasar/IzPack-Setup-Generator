/*
 * PanelsModel represents the panels tag of instal.xml
 */

package org.biz.izpack.models.panels;

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
public class PanelsModel {
    
    @XmlElement(name="panel")
    private List<PanelModel> _panels;

    public List<PanelModel> getPanels() {
        if (_panels == null) {
            _panels = new ArrayList<PanelModel>();
        }
        return _panels;
    }
    
}
