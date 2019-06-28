package com.elegion.characterCreate;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class CharacterCreator extends Observable  implements Serializable{

    public enum Specialization {
        WARRIOR, ARCHER, MAGE
    }

    public enum Race {
        HUMAN, ELF, ORC, DWARF
    }

    public enum Attribute {
        STRENGTH, AGILITY, INTELLECT, STAMINA, LUCK
    }

    public enum Perk {
        BERSERK, CALM, LIGHTWEIGHT, HEAVYARMORED, OBSERVANT, MEDITATIONS
    }

    private String mName;
    private Specialization mSpecialization;
    private Race mRace;
    private int mAvailablePoints;

    private Map<String, Integer> mAttributesMap = new HashMap<>();
    private Map<String, Boolean> mPerksMap = new HashMap<>();

    private static String[] getNamesFromEnum(Class<? extends Enum> in) {
        String[] res = new String[in.getEnumConstants().length];
        int i = 0;
        for (Enum a : in.getEnumConstants()) {
            String tmp = a.toString();
            res[i++] = tmp.substring(0, 1).toUpperCase() + tmp.substring(1).toLowerCase();
        }
        return res;
    }

    private static int setBetween(int value, int min, int max) {
        if (value < min)
            value = min;
        else if (value >= max)
            value = max - 1;
        return value;
    }


    public CharacterCreator() {
        mRace = Race.HUMAN;
        mSpecialization = Specialization.WARRIOR;
        mAvailablePoints = 5;
        mAttributesMap.put(Attribute.STRENGTH.name(), 5);
        mAttributesMap.put(Attribute.AGILITY.name(), 5);
        mAttributesMap.put(Attribute.INTELLECT.name(), 5);
        mAttributesMap.put(Attribute.STAMINA.name(), 5);
        mAttributesMap.put(Attribute.LUCK.name(), 5);
    }

    public String[] getSpecializations() {
        return CharacterCreator.getNamesFromEnum(Specialization.class);

    }


    public void setSpecialization(int position) {
        Specialization[] specs = Specialization.values();
        position = setBetween(position, 0, specs.length);
        mSpecialization = specs[position];

    }

    public String[] getRaces() {
        return CharacterCreator.getNamesFromEnum(Race.class);
    }

    public void setRace(int position) {
        Race[] races = Race.values();
        position = setBetween(position, 0, races.length);
        mRace = races[position];
    }

    public String[] getAttributes() {
        return CharacterCreator.getNamesFromEnum(Attribute.class);

    }

    public String[] getPerks() {
        return CharacterCreator.getNamesFromEnum(Perk.class);

    }
    public void updateAttributeValue(int position, int updateTo) {
        Attribute[] attrs = Attribute.values();
        position = setBetween(position, 0, attrs.length);
        int value = mAttributesMap.get(attrs[position].name());
        if ((mAvailablePoints >= updateTo) && (value + updateTo >= 0)){
            value += updateTo;
            mAvailablePoints -= updateTo;
            mAttributesMap.put(attrs[position].name(), value);
        }
        setChanged();
        notifyObservers();
    }

    public void setName(String name) {
        mName = name;
    }

    public String getAvailablePoints() {
        return String.valueOf(mAvailablePoints);
    }

    public Map<String, Integer> getAttributesMap() {
        return mAttributesMap;
    }

    public void checkPerk(String text, boolean isChecked) {
        mPerksMap.put(text, isChecked);
    }

    public Character create() {
        Character character = new Character();
        character.setName(mName);
        character.setRace(mRace);
        character.setSpecialization(mSpecialization);
        character.setAttributes(mAttributesMap);
        character.setPerks(mPerksMap);
        character.calculateParameters();
        return character;
    }

    public Specialization getSpecialization() {
        return mSpecialization;
    }

    public Race getRace() {
        return mRace;
    }

    public Map<String, Boolean> getPerksMap() {
        return mPerksMap;
    }

    public void setAvailablePoints(int availablePoints) {
        mAvailablePoints = availablePoints;
    }

    public int getRacePosition() {
        return mRace.ordinal();
    }

    public int getSpecializationPosition() {
        return mSpecialization.ordinal();
    }
}
