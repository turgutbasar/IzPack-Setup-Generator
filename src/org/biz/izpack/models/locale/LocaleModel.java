/*
 * LocaleModel represents the locale tag of install.xml
 */

package org.biz.izpack.models.locale;

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
public class LocaleModel {
    
    @XmlElement(name="langpack")
    private List<LanguagePackModel> _langPacks;

    public List<LanguagePackModel> getLangPacks() {
        if (_langPacks == null) {
            _langPacks = new ArrayList<LanguagePackModel>();
        }
        return _langPacks;
    }
  
}
