/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.enums;

/**
 *
 * @author Elay
 */
public enum Region {
    Bamako, Kayes, Koulikoro, Sikasso, Ségou, Mopti, Gao, Tombouctou, Kidal;
    
    public String getLabel() {
		return play.i18n.Messages.get(name());
	}

	public String getName() {
		return name();
	}

	@Override
	public String toString() {
		return getLabel();
	}
}
