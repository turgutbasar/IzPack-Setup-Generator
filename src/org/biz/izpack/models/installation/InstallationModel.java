/*
 * InstallationModel represents the whole installation structure which 
 * represented by install.XML. We are using JAXB to do these marshaling 
 * and unmarshaling ops.
 */

package org.biz.izpack.models.installation;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.biz.izpack.models.guiprefs.GUIPreferiencesModel;
import org.biz.izpack.models.information.InformationModel;
import org.biz.izpack.models.jars.JarModel;
import org.biz.izpack.models.locale.LocaleModel;
import org.biz.izpack.models.packs.PacksModel;
import org.biz.izpack.models.panels.PanelsModel;
import org.biz.izpack.models.resources.ResourcesModel;

/**
 *
 * @author basar
 */

/* Root Element for whole model is installation tag. */
@XmlRootElement(name="installation")
/* This annotation makes fields our entities not getter methods. */
@XmlAccessorType(XmlAccessType.FIELD)
public class InstallationModel {
    
    @XmlAttribute(name="version")
    private final String _version = "1.0";
    
    @XmlElement(name="info")
    private InformationModel _informationModel;
    
    @XmlElement(name="guiprefs")
    private GUIPreferiencesModel _guiPreferiencesModel;
    
    @XmlElement(name="locale")
    private LocaleModel _localeModel;
    
    @XmlElement(name="resources")
    private ResourcesModel _resourcesModel;
    
    // TODO : Make a research for an unmapped wrapper setting
    @XmlElement(name="jar")
    private List<JarModel> _jarsModel;
    
    @XmlElement(name="panels")
    private PanelsModel _panelsModel;
    
    @XmlElement(name="packs")
    private PacksModel _packsModel;

    public InformationModel getInformationModel() {
        if (_informationModel == null) {
            _informationModel = new InformationModel();
        }
        return _informationModel;
    }

    public GUIPreferiencesModel getGuiPreferiencesModel() {
        if (_guiPreferiencesModel == null) {
            _guiPreferiencesModel = new GUIPreferiencesModel();
        }
        return _guiPreferiencesModel;
    }

    public LocaleModel getLocaleModel() {
        if (_localeModel == null) {
            _localeModel = new LocaleModel();
        }
        return _localeModel;
    }

    public ResourcesModel getResourcesModel() {
        if (_resourcesModel == null) {
            _resourcesModel = new ResourcesModel();
        }
        return _resourcesModel;
    }

    public List<JarModel> getJarsModel() {
        if (_jarsModel == null) {
            _jarsModel = new ArrayList<JarModel>();
        }
        return _jarsModel;
    }

    public PanelsModel getPanelsModel() {
        if (_panelsModel == null) {
            _panelsModel = new PanelsModel();
        }
        return _panelsModel;
    }

    public PacksModel getPacksModel() {
        if (_packsModel == null) {
            _packsModel = new PacksModel();
        }
        return _packsModel;
    }

}
