/*
 * Enum for all the regions of the country
 */

package models.enums;

/**
 *
 * @author Elay
 */


public enum Circle {
	Bafoulabé, Diéma, Kayes, Kéniéba, Kita, NioroDuSahel, Yélimané,Banamba, Dioïla, Kangaba, Kati, Kolokani, Koulikoro, Nara, Bougouni, Kadiolo, Kolondiéba,
        Koutiala, Sikasso, Yanfolila, Yorosso,Barouéli, Bla, Macina, Niono, San, Ségou, Tominian , Bandiagara, Bankass, Djenné, Douentza, Koro, Mopti, Ténenkou, Youwarou , 
        Diré, Goundam, GourmaRharous, Niafunké, Tombouctou, Ansongo, Bourem, Gao, Ménaka, Abeïbara, Kidal,Tessalit, TinEssako ;     
        
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
