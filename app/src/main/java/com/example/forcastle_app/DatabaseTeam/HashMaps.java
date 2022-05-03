package com.example.forcastle_app.DatabaseTeam;

import java.util.HashMap;

public class HashMaps {

    private HashMap<String, String> busNo, operators, returnJourney, station, directChange;
    private HashMap<String, Integer> journeyTimes;

    // constructor builds all required hashmaps when called
    public HashMaps() {
        buildBusNo();
        buildOperators();
        buildDepartureStation();
        buildReturnJourney();
        buildJourneyTimes();
        buildDirectChange();
    }

    //maps journey to direct or one change needed
    public void buildDirectChange() {
        directChange = new HashMap<>();

        directChange.put("NCALN", "Direct");
        directChange.put("ALNNC", "Direct");
        directChange.put("NCBAM1", "1 change");
        directChange.put("NCBAM2", "1 change");
        directChange.put("BAMNC1", "1 change");
        directChange.put("BAMNC2", "1 change");
        directChange.put("NCAUK", "Direct");
        directChange.put("AUKNC", "Direct");
        directChange.put("NCBAR1", "1 change");
        directChange.put("NCBAR2", "1 change");
        directChange.put("BARNC1", "1 change");
        directChange.put("BARNC2", "1 change");
    }

    //maps journey to how long it takes
    public void buildJourneyTimes() {
        journeyTimes = new HashMap<>();

        journeyTimes.put("NCALN", 120);
        journeyTimes.put("ALNNC", 120);
        journeyTimes.put("NCBAM1", 113);
        journeyTimes.put("NCBAM2", 14);
        journeyTimes.put("BAMNC1", 14);
        journeyTimes.put("BAMNC2", 113);
        journeyTimes.put("NCAUK", 97);
        journeyTimes.put("AUKNC", 97);
        journeyTimes.put("NCBAR1", 115);
        journeyTimes.put("NCBAR2", 34);
        journeyTimes.put("BARNC1", 34);
        journeyTimes.put("BARNC2", 115);

    }

    //maps journey to bus station name
    public void buildDepartureStation() {
        station = new HashMap<>();

        station.put("NCALN", "Haymarket");
        station.put("ALNNC", "Alnwick Bus Station");
        station.put("NCBAM1", "Haymarket");
        station.put("NCBAM2", "Belford Craft Gallery");
        station.put("BAMNC1", "Bamburgh The Grove");
        station.put("BAMNC2", "Belford Fire Station");
        station.put("NCAUK", "Eldon Square");
        station.put("AUKNC", "Bishop Auckland Bus Station");
        station.put("NCBAR1", "Eldon Square");
        station.put("NCBAR2", "Tindale Cresent Club");
        station.put("BARNC1", "Galgate");
        station.put("BARNC2", "Tindale Cresent Club");
    }

    //maps journey to return journey
    public void buildReturnJourney() {
        returnJourney = new HashMap<>();

        returnJourney.put("NCALN", "ALNNC");
        returnJourney.put("NCBAM1", "BAMNC2");
        returnJourney.put("NCBAM2", "BAMNC1");
        returnJourney.put("NCAUK", "AUKNC");
        returnJourney.put("NCBAR1", "BARNC2");
        returnJourney.put("NCBAR2", "BARNC1");
    }

    //maps journey to bus operator
    public void buildOperators() {
        operators = new HashMap<>();

        operators.put("NCALN", "Arriva North East");
        operators.put("ALNNC", "Arriva North East");
        operators.put("NCBAM1", "Arriva North East");
        operators.put("NCBAM2", "Arriva North East");
        operators.put("BAMNC1", "Arriva North East");
        operators.put("BAMNC2", "Arriva North East");
        operators.put("NCAUK", "Go North East");
        operators.put("AUKNC", "Go North East");
        operators.put("NCBAR1", "Go North East");
        operators.put("NCBAR2", "Scarlet Band");
        operators.put("BARNC1", "Scarlet Band");
        operators.put("BARNC2", "Go North East");
    }

    //maps journey to Bus Number
    public void buildBusNo() {
        busNo = new HashMap<>();

        busNo.put("NCALN", "X15 MAX");
        busNo.put("ALNNC", "X15 MAX");
        busNo.put("NCBAM1", "X15 MAX");
        busNo.put("NCBAM2", "X18");
        busNo.put("BAMNC1", "X18");
        busNo.put("BAMNC2", "X5 MAX");
        busNo.put("NCAUK", "X21");
        busNo.put("AUKNC", "X21");
        busNo.put("NCBAR1", "X21");
        busNo.put("NCBAR2", "85");
        busNo.put("BARNC1", "85");
        busNo.put("BARNC2", "X21");
    }

    /************** Getter methods ************************/
    public HashMap<String, Integer> getJourneyTimes() {
        return journeyTimes;
    }

    public HashMap<String, String> getBusNo() {
        return busNo;
    }

    public HashMap<String, String> getOperators() {
        return operators;
    }

    public HashMap<String, String> getReturnJourney() {
        return returnJourney;
    }

    public HashMap<String, String> getStation() {
        return station;
    }

    public HashMap<String, String> getDirectChange() {
        return directChange;
    }
}
