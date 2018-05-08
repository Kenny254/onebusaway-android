/*
 * Copyright (C) 2005-2018 University of South Florida
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onebusaway.android.nav.test;

import org.apache.commons.io.IOUtils;
import org.onebusaway.android.io.test.ObaTestCase;
import org.onebusaway.android.mock.Resources;
import org.onebusaway.android.nav.NavigationSegment;
import org.onebusaway.android.nav.NavigationServiceProvider;

import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.util.Log;

import java.io.IOException;
import java.io.Reader;

/**
 * Loads previously recorded trips (GPS data) and replays them through the NavigationServiceProvider
 * via the NavigationSimulation class.
 *
 * For creating new test methods - see the file DESTINATION_REMINDERS.md
 */
public class NavigationTest extends ObaTestCase {

    private static final String TAG = "NavigationTest";

    private static final long SPEED_UP = 1000000L;

    private int getReadyID;

    private int pullCordID;


    /**
     * Started Stop: Mckinley Dr @ DOT Bldg
     * Destination Stop: University Area Transit Center
     * Recorded In: Bus (Route 5) 9 stops
     * Device Used: Nexus 5
     */
    public void testTrip1() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip1"));
        String csv = IOUtils.toString(reader);
        getReadyID = 848;
        pullCordID = 978;

        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Mckinley Dr @ DOT Bldg
     * Destination Stop: University Area Transit Center
     * Recorded In: car following Bus (Route 5) 9 stops
     * Device Used: Nexus 5
     */
    public void testTrip1C() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip1c"));
        String csv = IOUtils.toString(reader);
        getReadyID = 665;
        pullCordID = 929;

        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Alumni Dr @ Leroy Collins @ Eng Bldg
     * Destination Stop: Mckinley Dr @ Fowler Ave
     * Recorded In: Bus Route 5 - 1 stops
     * Device Used: Nexus 5
     */
    public void testTrip2() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip2"));
        String csv = IOUtils.toString(reader);
        getReadyID = 0;
        pullCordID = 14;

        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Alumni Dr @ Leroy Collins @ Eng Bldg
     * Destination Stop: Mckinley Dr @ Fowler Ave
     * Recorded In: Car following Route 5 - 1 stops
     * Device Used: Nexus 5
     */
    public void testTrip2C() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip2c"));
        String csv = IOUtils.toString(reader);
        getReadyID = 0;
        pullCordID = 64;

        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Dale Mabry Hwy @ Linebaugh Av
     * Destination Stop: Dale Mabry Hwy @ Hudson Ln @ Taco Bell
     * Recorded In: Bus (Route 36) 4 stops
     * Device Used: Nexus 5
     * FIXME - Currently fails with "Pull the cord triggered too soon"
     */
    public void testTrip3() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip3"));
        String csv = IOUtils.toString(reader);
        getReadyID = 95;
        pullCordID = 115;

        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Dale Mabry Hwy @ Linebaugh Av
     * Destination Stop: Dale Mabry Hwy @ Hudson Ln @ Taco Bell
     * Recorded In: car following Bus (Route 36) 4 stops
     * Device Used: Nexus 5
     * FIXME - Currently fails with "Pull the cord triggered too soon"
     */
    public void testTrip3C() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip3c"));
        String csv = IOUtils.toString(reader);
        getReadyID = 87;
        pullCordID = 109;

        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Gunn Hwy @ Mullis City Way
     * Destination Stop: Gunn Hwy @ Anderson Rd
     * Recorded In: Bus (Route 39)
     * Number of Stops = 7
     * Device Used: Kyocera
     */
    public void testTrip4() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip4"));
        String csv = IOUtils.toString(reader);
        getReadyID = 294;
        pullCordID = 329;

        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Gunn Hwy @ Mullis City Way
     * Destination Stop: Gunn Hwy @ Anderson Rd
     * Recorded In: car following Bus (Route 39)
     * Number of Stops = 7
     * Device Used: Nexus 5
     */
    public void testTrip4C() throws IOException {
        // Read test CSV.
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip4c"));
        String csv = IOUtils.toString(reader);
        getReadyID = 253;
        pullCordID = 329;

        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Linebaugh @ Henderson Av
     * Destination Stop: Anderson Rd @ 8110
     * Recorded In: Bus (Route 7) 4 stops
     * Device Used: Kyocera
     */
    public void testTrip5() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip5"));
        String csv = IOUtils.toString(reader);
        getReadyID = 372;
        pullCordID = 660;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Linebaugh @ Henderson Av
     * Destination Stop: Anderson Rd @ 8110
     * Recorded In: Car following Bus (Route 7) 4 stops
     * Device Used: Nexus 5
     */
    public void testTrip5C() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip5c"));
        String csv = IOUtils.toString(reader);
        getReadyID = 284;
        pullCordID = 492;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Himes Av @ Colwell Av
     * Destination Stop: Himes Av @ Hillsborough Av
     * Recorded In: Bus (Route 36) 12 stops
     * Device Used: Kyocera
     */
    public void testTrip6() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip6"));
        String csv = IOUtils.toString(reader);
        getReadyID = 801;
        pullCordID = 837;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Himes Av @ Colwell Av
     * Destination Stop: Himes Av @ Hillsborough Av
     * Recorded In: car following Bus (Route 36) 12 stops
     * Device Used: Nexus 5
     */
    public void testTrip6C() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip6c"));
        String csv = IOUtils.toString(reader);
        getReadyID = 676;
        pullCordID = 704;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Gunn Hwy @ Premier North Dr
     * Destination Stop: Bush Blvd @ Armenia Av
     * Recorded In: Bus (Route 39) 3 stops
     * Device Used: Kyocera
     */
    public void testTrip7() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip7"));
        String csv = IOUtils.toString(reader);
        getReadyID = 183;
        pullCordID = 208;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Gunn Hwy @ Premier North Dr
     * Destination Stop: Bush Blvd @ Armenia Av
     * Recorded In: Car following Bus (Route 39) 3 stops
     * Device Used: Nexus 5
     */
    public void testTrip7C() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip7c"));
        String csv = IOUtils.toString(reader);
        getReadyID = 172;
        pullCordID = 285;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Alumni Dr @ Beard
     * Destination Stop: Magnolia Dr @ Alumni Dr
     * Recorded In: Route 5 (1 stop)
     * Device Used: Nexus 5
     */
    public void testTrip8() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip8"));
        String csv = IOUtils.toString(reader);
        getReadyID = 0;
        pullCordID = 18;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Alumni Dr @ Beard
     * Destination Stop: Magnolia Dr @ Alumni Dr
     * Recorded In: Car following Route 5 (1 stop)
     * Device Used: Nexus 5
     */
    public void testTrip8C() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip8c"));
        String csv = IOUtils.toString(reader);
        getReadyID = 0;
        pullCordID = 20;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: 40 St @ E Hamilton
     * Destination Stop: Mckinley Dr @ Bougainvillea Av
     * Recorded In: Bus Route 5 (10 stops)
     * Device Used: Kyocera
     */
    public void testTrip9() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip9"));
        String csv = IOUtils.toString(reader);
        getReadyID = 1041;
        pullCordID = 1071;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: 40 St @ E Hamilton
     * Destination Stop: Mckinley Dr @ Bougainvillea Av
     * Recorded In: car following Route 5 (10 stops)
     * Device Used: Nexus 5
     */
    public void testTrip9C() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip9c"));
        String csv = IOUtils.toString(reader);
        getReadyID = 570;
        pullCordID = 634;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Mckinley Dr @ Bougainvillea Av
     * Destination Stop: 40 St @ Miller Ave
     * Recorded In: Bus Route 5 (6 stops)
     * Device Used: Kyocera
     */
    public void testTrip10() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip10"));
        String csv = IOUtils.toString(reader);
        getReadyID = 589;
        pullCordID = 605;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Mckinley Dr @ Bougainvillea Av
     * Destination Stop: 40 St @ Miller Ave
     * Recorded In: car following the bus Route 5 (6 stops)
     * Device Used: Nexus 5
     */
    public void testTrip10C() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip10c"));
        String csv = IOUtils.toString(reader);
        getReadyID = 484;
        pullCordID = 509;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: 22nd St @ Okara Rd
     * Destination Stop: 22nd St @ 111th Av
     * Recorded In: Bus route 12 (4 stops)
     * Device Used: Kyocera
     */
    public void testTrip11() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip11"));
        String csv = IOUtils.toString(reader);
        getReadyID = 331;
        pullCordID = 371;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: 22nd St @ Okara Rd
     * Destination Stop: 22nd St @ 111th Av
     * Recorded In: Car following bus route 12 (4 stops)
     * Device Used: Nexus 5
     */
    public void testTrip11C() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip11c"));
        String csv = IOUtils.toString(reader);
        getReadyID = 119;
        pullCordID = 158;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Bruce B Downs Bl @ Lakeside Commons
     * Destination Stop: Fletcher Av @Usf Banyan Cir
     * Recorded In:  Bus route 18 (2 stops)
     * Device Used: Kyocera
     */
    public void testTrip12() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip12"));
        String csv = IOUtils.toString(reader);
        getReadyID = 69;
        pullCordID = 199;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Bruce B Downs Bl @ Lakeside Commons
     * Destination Stop: Fletcher Av @Usf Banyan Cir
     * Recorded In: Car following bus route 18 (2 stops)
     * Device Used: Kyocera
     */
    public void testTrip12C() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip12c"));
        String csv = IOUtils.toString(reader);
        getReadyID = 880;
        pullCordID = 901;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Busch Blvd @ 40thSt
     * Destination Stop: Busch Blvd @ 50th St
     * Recorded In: Bus route 39 (5 stops)
     * Device Used: Kyocera
     */
    public void testTrip13() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip13"));
        String csv = IOUtils.toString(reader);
        getReadyID = 2549;
        pullCordID = 2732;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Busch Blvd @ 40thSt
     * Destination Stop: Busch Blvd @ 50th St
     * Recorded In: Bus route 39 (5 stops)
     * Device Used: Nexus 5
     */
    public void testTrip13C() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip13c"));
        String csv = IOUtils.toString(reader);
        getReadyID = 230;
        pullCordID = 519;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Busch Blvd @ 52nd St
     * Destination Stop: Busch Blvd @ 22nd St
     * Recorded In: Bus route 39 (12 stops)
     * Device Used: Kyocera
     * FIXME - This test is failing because the second to last stop in the map is not
     * in the coordinate where the actual stop is located. Hence, it appears that the
     * pool the cord is triggered to soon
     */
    public void testTrip14() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip14"));
        String csv = IOUtils.toString(reader);
        getReadyID = 548;
        pullCordID = 571;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Busch Blvd @ 52nd St
     * Destination Stop: Busch Blvd @ 22nd St
     * Recorded In: Car following bus route 39 (12 stops)
     * Device Used: Kyocera
     */
    public void testTrip14C() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip14c"));
        String csv = IOUtils.toString(reader);
        getReadyID = 387;
        pullCordID = 429;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Busch Blvd @ 12 St
     * Destination Stop: Busch Blvd @ 33 Rd St
     * Recorded In: Bus route 39 7 stops
     * Device Used: Kyocera
     */
    public void testTrip15() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip15"));
        String csv = IOUtils.toString(reader);
        getReadyID = 225;
        pullCordID = 417;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Busch Blvd @ 12 St
     * Destination Stop: Busch Blvd @ 33 Rd St
     * Recorded In: Car following bus route 39
     * Device Used: Kyocera
     */
    public void testTrip15C() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip15c"));
        String csv = IOUtils.toString(reader);
        getReadyID = 217;
        pullCordID = 287;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Library LIB
     * Destination Stop: Magnolia apartments
     * Recorded In: Bull Runner route D
     * Device Used: Kyocera
     * FIXME - this test is failing with "Get ready triggered too soon"
     */
    public void testTrip16() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip16c"));
        String csv = IOUtils.toString(reader);
        getReadyID = 142;
        pullCordID = 192;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Library LIB
     * Destination Stop: Magnolia apartments
     * Recorded In: Car following Bull Runner route D
     * Device Used: Kyocera
     */
    public void testTrip16C() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip16c"));
        String csv = IOUtils.toString(reader);
        getReadyID = 121;
        pullCordID = 168;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Marshall Student Center
     * Destination Stop: Holly at Magnolia Dr
     * Recorded In: Bull Runner route D
     * Device Used: Kyocera
     */
    public void testTrip17() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip17"));
        String csv = IOUtils.toString(reader);
        getReadyID = 100;
        pullCordID = 181;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Marshall Student Center
     * Destination Stop: Holly at Magnolia Dr
     * Recorded In: Car following Bull Runner route D
     * Device Used: Kyocera
     */
    public void testTrip17C() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip17c"));
        String csv = IOUtils.toString(reader);
        getReadyID = 86;
        pullCordID = 125;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Stop 504
     * Destination Stop: Library LIB
     * Recorded In: Bull Runner route F
     * Device Used: Nexus 5
     */
    public void testTrip18() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip18"));
        String csv = IOUtils.toString(reader);
        getReadyID = 31;
        pullCordID = 50;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Stop 504
     * Destination Stop: Library LIB
     * Recorded In: car following Bull Runner route F
     * Device Used: Kyocera
     */
    public void testTrip18C() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip18c"));
        String csv = IOUtils.toString(reader);
        getReadyID = 31;
        pullCordID = 58;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Social Science
     * Destination Stop: Library LIB
     * Recorded In: Car following Bull Runner route C
     * Device Used: Kyocera
     */
    public void testTrip20() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip20"));
        String csv = IOUtils.toString(reader);
        getReadyID = 133;
        pullCordID = 195;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Social Science
     * Destination Stop: Library LIB
     * Recorded In: Car following Bull Runner route C
     * Device Used: Kyocera
     */
    public void testTrip20C() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip20c"));
        String csv = IOUtils.toString(reader);
        getReadyID = 53;
        pullCordID = 117;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Math and Engineering
     * Destination Stop: Epsilon Hall
     * Recorded In: Bull Runner route C
     * Device Used: Nexus 5
     */
    public void testTrip21() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip21"));
        String csv = IOUtils.toString(reader);
        getReadyID = 547;
        pullCordID = 686;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Math and Engineering
     * Destination Stop: Epsilon Hall
     * Recorded In: Car following Bull Runner route C
     * Device Used: Kyocera
     */
    public void testTrip21C() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip21c"));
        String csv = IOUtils.toString(reader);
        getReadyID = 323;
        pullCordID = 402;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Marshall Student Center
     * Destination Stop: Center of Transportation Research
     * Recorded In: Bull Runner route E
     * Device Used: Nexus 5
     */
    public void testTrip22() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip22"));
        String csv = IOUtils.toString(reader);
        getReadyID = 1085;
        pullCordID = 1198;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Marshall Student Center
     * Destination Stop: Center of Transportation Research
     * Recorded In: Bull Runner route E
     * Device Used: Nexus 5
     */
    public void testTrip22C() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip22c"));
        String csv = IOUtils.toString(reader);
        getReadyID = 1032;
        pullCordID = 1099;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Marshall Student Center
     * Destination Stop: Holly Mail Room
     * Recorded In: Bull Runner route E
     * Device Used: Nexus 5
     */
    public void testTrip23() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip23"));
        String csv = IOUtils.toString(reader);
        getReadyID = 0;
        pullCordID = 24;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Marshall Student Center
     * Destination Stop: Holly Mail Room
     * Recorded In: Car following Bull Runner route E
     * Device Used: Nexus 5
     */
    public void testTrip23C() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip23c"));
        String csv = IOUtils.toString(reader);
        getReadyID = 0;
        pullCordID = 18;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: USF library LIB
     * Destination Stop: Patel Center
     * Recorded In: Bull Runner route A
     * Device Used: Nexus 5
     */
    public void testTrip24() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip24"));
        String csv = IOUtils.toString(reader);
        getReadyID = 115;
        pullCordID = 178;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: USF library LIB
     * Destination Stop: Patel Center
     * Recorded In: Car following the Bull Runner route A
     * Device Used: Nexus 5
     */
    public void testTrip24C() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip24c"));
        String csv = IOUtils.toString(reader);
        getReadyID = 203;
        pullCordID = 262;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Baseball Field
     * Destination Stop: Greek Housing
     * Recorded In: Bull Runner route A
     * Device Used: Nexus 5
     */
    public void testTrip25() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip25"));
        String csv = IOUtils.toString(reader);
        getReadyID = 209;
        pullCordID = 235;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    /**
     * Started Stop: Baseball Field
     * Destination Stop: Greek Housing
     * Recorded In: Car following Bull Runner route A
     * Device Used: Nexus 5
     */
    public void testTrip25C() throws IOException {
        // Read test CSV
        Reader reader = Resources.read(getContext(), Resources.getTestUri("tad_trip25c"));
        String csv = IOUtils.toString(reader);
        getReadyID = 217;
        pullCordID = 247;
        NavigationSimulation trip = new NavigationSimulation(csv);
        trip.runSimulation(true, true);
    }

    // Class for holding relevant details for testing.
    class NavigationSimulation {

        String mTripId;

        String mDestinationId;

        String mBeforeId;

        Location mDestinationLocation;

        Location mBeforeLocation;

        Location[] mPoints;

        long[] mTimes;

        int getReadyIndex = -1;                    //  Index which getReady should be triggered.

        int finishedIndex = -1;                    //  Index which finished should be triggered.

        boolean useElapsedNanos = false;           // Should use elapsed nanos instead of time.

        /**
         * Takes a csv string with the first row containing meta-data in the format
         * of tripId,DestinationId,dest-lat,dest-lng,beforeDestinationId,before-lat,before-lng
         * and all following rows holding data to construct location points of a trip in the format
         * time,lat,lng,altitude,speed,bearing,provider.
         *
         * @param csv string with the above format
         */
        NavigationSimulation(String csv) {
            String[] lines = csv.split("\n");

            // Setup meta data.
            String[] details = lines[0].split(",");
            mTripId = details[0];
            mDestinationId = details[1];
            mBeforeId = details[4];

            mDestinationLocation = new Location(LocationManager.GPS_PROVIDER);
            mDestinationLocation.setLatitude(Double.parseDouble(details[2]));
            mDestinationLocation.setLongitude(Double.parseDouble(details[3]));

            mBeforeLocation = new Location(LocationManager.GPS_PROVIDER);
            mBeforeLocation.setLatitude(Double.parseDouble(details[5]));
            mBeforeLocation.setLongitude(Double.parseDouble(details[6]));

            mPoints = new Location[lines.length - 1];

            // Skip header and run through csv.
            // Rows are formatted like this:
            // realtime Nanos Elapsed,time,lat,lng,altitude,speed,bearing,accurarcy,satellites,provider.
            for (int i = 1; i < lines.length; i++) {
                String[] values = lines[i].split(",");
                int coordinateIndex = Integer.parseInt(values[0]);
                String getReadyValue = values[1];
                String pullTheCordValue = values[2];
                String nanosStr = values[3];
                long time = Long.parseLong(values[4]);
                double lat = Double.parseDouble(values[5]);
                double lng = Double.parseDouble(values[6]);
                double altitude = Double.parseDouble(values[7]);
                float speed = Float.parseFloat(values[8]);
                float bearing = Float.parseFloat(values[9]);
                float accuracy = Float.parseFloat(values[10]);
                int sats = Integer.parseInt(values[11]);
                String provider = values[12];

                mPoints[i - 1] = new Location(provider);

                // Check if we can use elapsed nano seconds. Else, we'll use time.
                if (!nanosStr.equals("")
                        && Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                    useElapsedNanos = true;
                    mPoints[i - 1].setElapsedRealtimeNanos(Long.parseLong(nanosStr));
                }

                mPoints[i - 1].setTime(time);
                mPoints[i - 1].setLatitude(lat);
                mPoints[i - 1].setLongitude(lng);
                mPoints[i - 1].setAltitude(altitude);
                mPoints[i - 1].setBearing(bearing);
                mPoints[i - 1].setAccuracy(accuracy);
                mPoints[i - 1].setSpeed(speed);
            }

            // Compute index of point nearest to second to last stop.
            double minDist = Double.MAX_VALUE;
            for (int i = 0; i < mPoints.length; i++) {
                if (mPoints[i].distanceTo(mBeforeLocation) < minDist) {
                    minDist = mPoints[i].distanceTo(mBeforeLocation);
                    getReadyIndex = i;
                }
            }

            // Compute time differences between readings in ms, if realtime ns is available, use it
            // else use getTime.
            mTimes = new long[mPoints.length];
            if (useElapsedNanos && Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                for (int i = 1; i < mPoints.length; i++) {
                    mTimes[i] = (mPoints[i].getElapsedRealtimeNanos() - mPoints[i - 1]
                            .getElapsedRealtimeNanos());
                    mTimes[i] /= 1000000;
                }
            } else {
                for (int i = 1; i < mPoints.length; i++) {
                    mTimes[i] = mPoints[i].getTime() - mPoints[i - 1].getTime();
                }
            }
        }

        public String getTripId() {
            return mTripId;
        }

        public String getDestinationId() {
            return mDestinationId;
        }

        public String getBeforeId() {
            return mBeforeId;
        }

        public Location getDestinationLocation() {
            return mDestinationLocation;
        }

        public Location getBeforeLocation() {
            return mBeforeLocation;
        }

        public Location[] getPoints() {
            return mPoints;
        }

        public long[] getTimes() {
            return mTimes;
        }

        public int getGetReadyIndex() {
            return getReadyIndex;
        }

        public int getFinishedIndex() {
            return finishedIndex;
        }

        public void runSimulation(Boolean expected1, Boolean expected2) {
            NavigationServiceProvider provider = new NavigationServiceProvider(mTripId,
                    mDestinationId);

            // Construct Destination & Second-To-Last Location
            NavigationSegment segment = new NavigationSegment(mBeforeLocation, mDestinationLocation,
                    null);

            // Begin navigation & simulation
            provider.navigate(new NavigationSegment[]{segment});

            for (int i = 0; i <= getReadyID; i++) {
                Location l = mPoints[i];

                try {
                    Thread.sleep(mTimes[i] / SPEED_UP);
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
                provider.locationUpdated(l);

                if (provider.getGetReady() && i < getReadyID) {
                    fail("Get ready triggered too soon");
                }

                Log.d(TAG, String.format("%d: (%f, %f, %f)\tR:%s  F:%s", i,
                        l.getLatitude(), l.getLongitude(), l.getSpeed(),
                        Boolean.toString(provider.getGetReady()),
                        Boolean.toString(provider.getFinished())));

            }

            Boolean check1 = provider.getGetReady() && !provider.getFinished();
            assertEquals(expected1, check1);

            for (int i = getReadyID; i <= pullCordID; i++) {
                Location l = mPoints[i];
                try {
                    Thread.sleep((mTimes[i] / SPEED_UP));
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
                provider.locationUpdated(l);

                if (provider.getFinished() && i < pullCordID) {
                    fail("Pull the Cord triggered too soon");
                }

                Log.d(TAG, String.format("%d: (%f, %f, %f)\tR:%s  F:%s", i,
                        l.getLatitude(), l.getLongitude(), l.getSpeed(),
                        Boolean.toString(provider.getGetReady()),
                        Boolean.toString(provider.getFinished())));
            }

            Boolean check2 = provider.getGetReady() && provider.getFinished();
            assertEquals(expected2, check2);
        }
    }
}
