/*
 * PacksModel represents packs tag of install.xml
 */

package org.biz.izpack.models.packs;

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
public class PacksModel {
    
    @XmlElement(name="pack")
    private List<PackModel> _packs;

    public List<PackModel> getPacks() {
        if (_packs == null) {
            _packs = new ArrayList<PackModel>();
        }
        return _packs;
    }
    
}
