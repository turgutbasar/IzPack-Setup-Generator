/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.biz.izpack;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author basar
 */
public class Resources {
    
    @XmlElement(name="res")
    private List<Resource> _resourceList = new ArrayList<Resource>();

    public Resource[] getAllResources() {
        Resource[] tmpList = new Resource[_resourceList.size()];
        tmpList = _resourceList.toArray(tmpList);
        return tmpList;
    }
    
    public void addResource(Resource resource) {
        _resourceList.add(resource);
    }
    
    public void removeResource(Resource resource) {
        _resourceList.remove(resource);
    }
    
}
