/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greetingclient;

import javax.xml.bind.annotation.XmlID;

/**
 *
 * @author SHANKAR
 */
public class FriendInfo {

    private String Name;
    private String Presence;
    private String Status;

    @XmlID
    public String getName() {
        return Name;
    }

    public void setname(String name) {
        this.Name = name;
    }

    public String getPresence() {
        return Presence;
    }

    public void setType(String presence) {
        this.Presence = presence;
    }

    public String getStatus() {
        return Status;
    }

    public void setName(String status) {
        this.Status = status;
    }

}
