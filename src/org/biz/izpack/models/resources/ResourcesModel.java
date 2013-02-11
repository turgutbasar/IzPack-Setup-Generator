/*
 * ResourcesModel represents the resources tag of install.xml
 */

package org.biz.izpack.models.resources;

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
public class ResourcesModel {
    
    @XmlElement(name="res")
    private List<ResourceModel> _resources;

    public List<ResourceModel> getResources() {
        if (_resources == null) {
            _resources = new ArrayList<ResourceModel>();
        }
        return _resources;
    }
    
}
