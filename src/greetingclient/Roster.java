/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greetingclient;


/**
 *
 * @author SHANKAR
 */

import java.util.ArrayList;
import java.util.List;

public class Roster {

    private List<FriendInfo> channels = new ArrayList<FriendInfo>();

    public List<FriendInfo> getChannels() {
        return channels;
    }

    public void setChannels(List<FriendInfo> channels) {
        this.channels = channels;
    }

}