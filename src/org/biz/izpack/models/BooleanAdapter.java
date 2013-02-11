/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.biz.izpack.models;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author basar
 */
public class BooleanAdapter extends XmlAdapter<String, Boolean>
{
    @Override
    public Boolean unmarshal( String s )
    {
        return s.equals("") ? null : s.equals("yes");
    }
    @Override
    public String marshal(Boolean v) {
        return v == null ? "" : v ? "yes" : "no";
    }
}