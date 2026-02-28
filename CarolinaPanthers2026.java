// Members who contributed to the final project:
// A. Young (Aly3673) - Created the GUI
// B. Wilson (wilsonb2742) - Provided all players and coaches/staff along with info
// on the whole team

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Color;

public class CarolinaPanthers2026 extends JFrame {
    
    // GUI componenets.
    private JPanel mainPanel, buttonPanel, itemPanel;
    private JButton button1, button2;
    private JList<String> itemList;
    private DefaultListModel<String> listModel;

    // All Carolina Panthers players.
    private String[] players = {
        "Krys Barnes - ILB",
        "Bobby Brown III - DT",
        "Derick Brown - DT",
        "Claudin Cherelus - LB",
        "Jalen Coker - WR",
        "Austin Corbett - G",
        "Jake Curhan - T",
        "Andy Dalton - QB",
        "Rico Dowdle - RB",
        "Ikem Ekwonu - T",
        "Trevor Etienne - RS",
        "Akayleb Evans - CB",
        "Mitchell Evans - TE",
        "Ryan Fitzgerald - K",
        "Trevis Gipson - OLB",
        "Jared Harrison-Hunte - DE",
        "Jaycee Horn - CB",
        "Jimmy Horn Jr. - WR",
        "Chuba Hubbard - RB",
        "Robert Hunt - G",
        "Thomas Incoom - ST",
        "Cam Jackson - DT",
        "Mike Jackson - CB",
        "JJ Jansen - LS",
        "Xavier Legette - WR",
        "Damien Lewis - G",
        "Sam Martin - P",
        "Bam Martin-Scott - LB",
        "Cade Mays - C",
        "Tetairoa McMillan - WR",
        "James Mitchell - TE",
        "Tre'von Moehrig - S",
        "David Moore - WR",
        "Taylor Moton - T",
        "Yosh Nijman - T",
        "Maema Njongmeta - LB",
        "Lathan Ransom - S",
        "LaBryan Ray - DE",
        "A'Shawn Robinson - DT",
        "Robert Rochell - CB",
        "Christian Rozeboom - ILB",
        "Nick Samac - C",
        "Nick Scott - FS",
        "Nic Scourton - OLB",
        "Isaiah Simmons - S",
        "Chau Smith-Wade - CB",
        "Brycen Tremayne - WR",
        "Tommy Tremble - TE",
        "Princely Umanmielen - OLB",
        "Tershawn Wharton - DT",
        "D.J. Wonnum - OLB",
        "Bryce Young - QB",
        "Jonathon Brooks - RB",
        "Jared Bartlett - LB",
        "Ja'Tyre Carter - G",
        "Saahdiq Charles - G",
        "Dan Chisena - WR",
        "Tyrek Funderburk - CB",
        "Joshua Gray - G",
        "Montrell Johnson Jr. - RB",
        "Jamil Muhammad - LB",
        "Mapalo Mwansa - LB",
        "Bryce Pierre - TE",
        "Ja'seem Reed - WR",
        "Micheal Reid - CB",
        "Demani Richardson - S",
        "Ainias Smith - WR",
        "Anthony Tyus III - RB",
        "Jacoby Windmon - LB",
        "Popo Aumavae - DT",
        "Brady Christensen - OL",
        "Patrick Jones II - OLB",
        "Damarri Mathis - CB",
        "Ja'Tavion Sanders - TE",
        "Corey Thornton - CB",
        "Trevin Wallace - ILB",
        "Chandler Zavala - G"
    };

    // All Carolina Panthers coaches/staff.
    private String[] coachesStaff = {
        "Dave Canales - Head Coach",
        "Brad Idzik - Offensive Coordinator",
        "Harold Goodwin - Assistant Head Coach/Run Game Coordinator",
        "Joe Gilbert - Offensive Line",
        "Will Harriger - Quarterbacks",
        "Pat McPherson - Tight Ends",
        "Rob Moore - Wide Receivers",
        "Bernie Parmalee - Running Backs",
        "Mike Bercovici - Assistant QBs/Pass Game Specialist",
        "Ejiro Evero - Defensive Coordinator",
        "Dom Capers - Senior Defensive Assistant",
        "AC Carter - Outside Linebackers",
        "Jonathan Cooley - Defensive Passing Game Coordinator",
        "Peter Hansen - Linebackers",
        "Renaldo Hill - Secondary Coach",
        "Todd Wash - Defensive Line",
        "Mayur Chaudhari - Assistant Linebackers",
        "Tracy Smith - Special Teams Coordinator",
        "Daren Bates - Special Teams Assistant",
        "Jim Caldwell - Senior Coaching Advisor",
        "George Li - Game Management Coordinator",
        "Dean Petzing - Offensive Quality Control"
    };

    // Constructor to set up the GUI.
    public CarolinaPanthers2026() {
        setTitle("NFL Carolina Panthers 2026 Season Info");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        mainPanel = new JPanel(new CardLayout());
        buttonPanel = new JPanel();
        itemPanel = new JPanel();

        buttonPanel.setBackground(Color.WHITE);
        itemPanel.setBackground(Color.WHITE);
        mainPanel.setBackground(Color.BLACK);

        button1 = new JButton("Players");
        button2 = new JButton("Coaches/Staff");

        button1.setBackground(Color.WHITE);
        button1.setForeground(Color.BLUE);

        button2.setBackground(Color.WHITE);
        button2.setForeground(Color.BLUE);

        buttonPanel.add(button1);
        buttonPanel.add(button2);

        listModel = new DefaultListModel<>();
        itemList = new JList<>(listModel);
        itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        itemList.setVisibleRowCount(10);

        itemList.setBackground(Color.WHITE);
        itemList.setForeground(Color.BLUE);
        itemList.setSelectionBackground(Color.BLUE);
        itemList.setSelectionForeground(Color.WHITE);

        itemList.addListSelectionListener(new ItemSelectionListener());

        JScrollPane scrollPane = new JScrollPane(itemList);
        itemPanel.setLayout(new BorderLayout());
        itemPanel.add(scrollPane, BorderLayout.WEST);
        itemPanel.add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Go Back");
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(Color.BLUE);
        itemPanel.add(backButton, BorderLayout.SOUTH);

        mainPanel.add(buttonPanel, "Buttons");
        mainPanel.add(itemPanel, "Items");

        add(mainPanel, BorderLayout.CENTER);

        button1.addActionListener(new ButtonClickListener("Players"));
        button2.addActionListener(new ButtonClickListener("Coaches/Staff"));
        backButton.addActionListener(e -> showButtons());
    }

    // Listener for button clicks to switch between Players and Coaches/Staff.
    private class ButtonClickListener implements ActionListener {
        private String itemCategory;

        public ButtonClickListener(String itemCategory) {
            this.itemCategory = itemCategory;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            updateItemList();
            showItems();
        }

        private void updateItemList() {
            listModel.clear();
            String[] items = null;
            if (itemCategory.equals("Players")) {
                items = players;
            } else if (itemCategory.equals("Coaches/Staff")) {
                items = coachesStaff;
            }

            if (items != null) {
                for (String item : items) {
                    listModel.addElement(item);
                }
            }
        }
    }

    // Listener for item selections in the list.
    private class ItemSelectionListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                String selectedItem = itemList.getSelectedValue();
                if (selectedItem != null) {
                    showItemDetail(selectedItem);
                }
            }
        }
    }

    // Display detailed information about the selected player or coach/staff.
    private void showItemDetail(String selectedItem) {
        String message = "Details about " + selectedItem;
        String title = playersListContains(selectedItem) ? "Player Details" : "Coaches/Staff Details";

        if (playersListContains(selectedItem)) {
            message = getPlayerInfo(selectedItem);
        } else {
            message = getStaffInfo(selectedItem);
        }

        JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    // Check if the selected is a player or not.
    private boolean playersListContains(String selectedItem) {
        for (String player : players) {
            if (player.equals(selectedItem)) {
                return true;
            }
        }
        return false;
    }

    // Switch to show the list.
    private void showItems() {
        CardLayout cl = (CardLayout) (mainPanel.getLayout());
        cl.show(mainPanel, "Items");
    }

    // Switch to show buttons.
    private void showButtons() {
        CardLayout cl = (CardLayout) (mainPanel.getLayout());
        cl.show(mainPanel, "Buttons");
    }

    // Player info.
    private String getPlayerInfo(String player) {
        switch (player) {
            case "Krys Barnes - ILB": return "Krys Barnes, #40, ILB, 6-2, 229 lbs, 27 y/o, 6 yrs exp, UCLA";
            case "Bobby Brown III - DT": return "Bobby Brown III, #97, DT, 6-4, 332 lbs, 25 y/o, 5 yrs exp, Texas A&M";
            case "Derick Brown - DT": return "Derick Brown, #95, DT, 6-5, 320 lbs, 27 y/o, 6 yrs exp, Auburn";
            case "Claudin Cherelus - LB": return "Claudin Cherelus, #53, LB, 6-2, 230 lbs, 26 y/o, 3 yrs exp, Alcorn State";
            case "Jalen Coker - WR": return "Jalen Coker, #18, WR, 6-3, 213 lbs, 24 y/o, 2 yrs exp, Holy Cross";
            case "Austin Corbett - G": return "Austin Corbett, #63, G, 6-4, 305 lbs, 30 y/o, 8 yrs exp, Nevada";
            case "Jake Curhan - T": return "Jake Curhan, #74, T, 6-6, 316 lbs, 27 y/o, 5 yrs exp, California";
            case "Andy Dalton - QB": return "Andy Dalton, #14, QB, 6-2, 220 lbs, 38 y/o, 15 yrs exp, TCU";
            case "Rico Dowdle - RB": return "Rico Dowdle, #5, RB, 5-11, 215 lbs, 27 y/o, 6 yrs exp, South Carolina";
            case "Ikem Ekwonu - T": return "Ikem Ekwonu, #79, T, 6-4, 320 lbs, 25 y/o, 4 yrs exp, NC State";
            case "Trevor Etienne - RS": return "Trevor Etienne, #23, RS, 5-8, 198 lbs, 21 y/o, R, Georgia";
            case "Akayleb Evans - CB": return "Akayleb Evans, #29, CB, 6-2, 198 lbs, 26 y/o, 4 yrs exp, Missouri";
            case "Mitchell Evans - TE": return "Mitchell Evans, #84, TE, 6-5, 258 lbs, 22 y/o, R, Notre Dame";
            case "Ryan Fitzgerald - K": return "Ryan Fitzgerald, #10, K, 5-11, 193 lbs, 25 y/o, R, Florida State";
            case "Trevis Gipson - OLB": return "Trevis Gipson, #52, OLB, 6-4, 255 lbs, 28 y/o, 6 yrs exp, Tulsa";
            case "Jared Harrison-Hunte - DE": return "Jared Harrison-Hunte, #75, DE, 6-4, 294 lbs, 25 y/o, R, SMU";
            case "Jaycee Horn - CB": return "Jaycee Horn, #8, CB, 6-1, 200 lbs, 26 y/o, 5 yrs exp, South Carolina";
            case "Jimmy Horn Jr. - WR": return "Jimmy Horn Jr., #15, WR, 5-8, 174 lbs, 23 y/o, R, Colorado";
            case "Chuba Hubbard - RB": return "Chuba Hubbard, #30, RB, 6-1, 210 lbs, 26 y/o, 5 yrs exp, Oklahoma State";
            case "Robert Hunt - G": return "Robert Hunt, #50, G, 6-6, 323 lbs, 29 y/o, 6 yrs exp, Louisiana Lafayette";
            case "Thomas Incoom - ST": return "Thomas Incoom, #48, ST, 6-2, 265 lbs, 27 y/o, 3 yrs exp, Central Michigan";
            case "Cam Jackson - DT": return "Cam Jackson, #92, DT, 6-6, 328 lbs, 23 y/o, R, Florida";
            case "Mike Jackson - CB": return "Mike Jackson, #2, CB, 6-1, 210 lbs, 29 y/o, 5 yrs exp, Miami";
            case "JJ Jansen - LS": return "JJ Jansen, #44, LS, 6-2, 235 lbs, 40 y/o, 18 yrs exp, Notre Dame";
            case "Xavier Legette - WR": return "Xavier Legette, #17, WR, 6-3, 227 lbs, 25 y/o, 2 yrs exp, South Carolina";
            case "Damien Lewis - G": return "Damien Lewis, #68, G, 6-2, 327 lbs, 28 y/o, 6 yrs exp, LSU";
            case "Sam Martin - P": return "Sam Martin, #6, P, 6-1, 205 lbs, 35 y/o, 13 yrs exp, Appalachian State";
            case "Bam Martin-Scott - LB": return "Bam Martin-Scott, #57, LB, 6-2, 231 lbs, 25 y/o, R, South Carolina";
            case "Cade Mays - C": return "Cade Mays, #64, C, 6-6, 325 lbs, 26 y/o, 4 yrs exp, Tennessee";
            case "Tetairoa McMillan - WR": return "Tetairoa McMillan, #4, WR, 6-5, 212 lbs, 22 y/o, 3 yrs exp, Arizona";
            case "James Mitchell - TE": return "James Mitchell, #85, TE, 6-4, 249 lbs, 26 y/o, 3 yrs exp, Virginia Tech";
            case "Tre'von Moehrig - S": return "Tre'von Moehrig, #7, S, 6-2, 202 lbs, 26 y/o, 5 yrs exp, TCU";
            case "David Moore - WR": return "David Moore, #83, WR, 6-0, 220 lbs, 31 y/o, 7 yrs exp, East Central";
            case "Taylor Moton - T": return "Taylor Moton, #72, T, 6-5, 325 lbs, 31 y/o, 9 yrs exp, Western Michigan";
            case "Yosh Nijman - T": return "Yosh Nijman, #77, T, 6-7, 314 lbs, 30 y/o, 6 yrs exp, Virginia Tech";
            case "Maema Njongmeta - LB": return "Maema Njongmeta, #55, LB, 6-0, 230 lbs, 24 y/o, 2 yrs exp, Wisconsin";
            case "Lathan Ransom - S": return "Lathan Ransom, #22, S, 6-0, 206 lbs, 23 y/o, R, Ohio State";
            case "LaBryan Ray - DE": return "LaBryan Ray, #93, DE, 6-4, 290 lbs, 28 y/o, 3 yrs exp, Alabama";
            case "A'Shawn Robinson - DT": return "A'Shawn Robinson, #94, DT, 6-3, 320 lbs, 30 y/o, 10 yrs exp, Alabama";
            case "Robert Rochell - CB": return "Robert Rochell, #33, CB, 6-2, 195 lbs, 27 y/o, 5 yrs exp, Central Arkansas";
            case "Christian Rozeboom - ILB": return "Christian Rozeboom, #56, ILB, 6-2, 230 lbs, 29 y/o, 5 yrs exp, South Dakota State";
            case "Nick Samac - C": return "Nick Samac, #60, C, 6-4, 314 lbs, 24 y/o, 2 yrs exp, Michigan State";
            case "Nick Scott - FS": return "Nick Scott, #22, FS, 5-11, 200 lbs, 30 y/o, 7 yrs exp, Penn State";
            case "Nic Scourton - OLB": return "Nic Scourton, #11, OLB, 6-2, 257 lbs, 21 y/o, R, Texas A&M";
            case "Isaiah Simmons - S": return "Isaiah Simmons, #27, S, 6-4, 238 lbs, 27 y/o, 6 yrs exp, Clemson";
            case "Chau Smith-Wade - CB": return "Chau Smith-Wade, #26, CB, 5-11, 176 lbs, 23 y/o, 2 yrs exp, Washington State";
            case "Brycen Tremayne - WR": return "Brycen Tremayne, #87, WR, 6-4, 212 lbs, 26 y/o, 1 yr exp, Stanford";
            case "Tommy Tremble - TE": return "Tommy Tremble, #82, TE, 6-4, 250 lbs, 25 y/o, 5 yrs exp, Notre Dame";
            case "Princely Umanmielen - OLB": return "Princely Umanmielen, #3, OLB, 6-4, 244 lbs, 23 y/o, R, Mississippi";
            case "Tershawn Wharton - DT": return "Tershawn Wharton, #99, DT, 6-1, 280 lbs, 27 y/o, 6 yrs exp, Missouri-Rolla";
            case "D.J. Wonnum - OLB": return "D.J. Wonnum, #98, OLB, 6-5, 258 lbs, 28 y/o, 6 yrs exp, South Carolina";
            case "Bryce Young - QB": return "Bryce Young, #9, QB, 5-10, 204 lbs, 24 y/o, 3 yrs exp, Alabama";
            // Active/PUP
            case "Jonathon Brooks - RB": return "Jonathon Brooks, #24, RB, 6-0, 207 lbs, 22 y/o, 2 yrs exp, Texas";
            // Reserve/Future
            case "Jared Bartlett - LB": return "Jared Bartlett, #--, LB, 6-2, 237 lbs, 24 y/o, R, Cincinnati";
            case "Ja'Tyre Carter - G": return "Ja'Tyre Carter, #65, G, 6-3, 311 lbs, 27 y/o, 3 yrs exp, Southern";
            case "Saahdiq Charles - G": return "Saahdiq Charles, #78, G, 6-4, 321 lbs, 26 y/o, 5 yrs exp, LSU";
            case "Dan Chisena - WR": return "Dan Chisena, #88, WR, 6-3, 202 lbs, 28 y/o, 5 yrs exp, Penn State";
            case "Tyrek Funderburk - CB": return "Tyrek Funderburk, #--, CB, 6-0, 185 lbs, 25 y/o, 2 yrs exp, Appalachian State";
            case "Joshua Gray - G": return "Joshua Gray, #--, G, 6-5, 299 lbs, 25 y/o, R, Oregon State";
            case "Montrell Johnson Jr. - RB": return "Montrell Johnson Jr., #37, RB, 5-11, 217 lbs, 23 y/o, R, Florida";
            case "Jamil Muhammad - LB": return "Jamil Muhammad, #49, LB, 6-1, 260 lbs, 25 y/o, R, USC";
            case "Mapalo Mwansa - LB": return "Mapalo Mwansa, #58, LB, 6-2, 230 lbs, 21 y/o, R, --";
            case "Bryce Pierre - TE": return "Bryce Pierre, #45, TE, 6-5, 255 lbs, 25 y/o, R, UCLA";
            case "Ja'seem Reed - WR": return "Ja'seem Reed, #86, WR, 6-2, 195 lbs, 22 y/o, R, San Diego";
            case "Micheal Reid - CB": return "Micheal Reid, #25, CB, 6-2, 200 lbs, 23 y/o, R, South Dakota";
            case "Demani Richardson - S": return "Demani Richardson, #36, S, 6-1, 215 lbs, 25 y/o, 2 yrs exp, Texas A&M";
            case "Ainias Smith - WR": return "Ainias Smith, #80, WR, 5-9, 176 lbs, 24 y/o, 2 yrs exp, Texas A&M";
            case "Anthony Tyus III - RB": return "Anthony Tyus III, #34, RB, 6-1, 226 lbs, 22 y/o, R, Ohio";
            case "Jacoby Windmon - LB": return "Jacoby Windmon, #41, LB, 6-2, 250 lbs, 24 y/o, 2 yrs exp, Michigan State";
            // Reserve/Injured
            case "Popo Aumavae - DT": return "Popo Aumavae, #78, DT, 6-3, 315 lbs, 27 y/o, 2 yrs exp, Oregon";
            case "Brady Christensen - OL": return "Brady Christensen, #70, OL, 6-6, 300 lbs, 29 y/o, 5 yrs exp, BYU";
            case "Patrick Jones II - OLB": return "Patrick Jones II, #91, OLB, 6-4, 264 lbs, 27 y/o, 5 yrs exp, Pittsburgh";
            case "Damarri Mathis - CB": return "Damarri Mathis, #28, CB, 5-11, 195 lbs, 26 y/o, 4 yrs exp, Pittsburgh";
            case "Ja'Tavion Sanders - TE": return "Ja'Tavion Sanders, #0, TE, 6-4, 252 lbs, 22 y/o, 2 yrs exp, Texas";
            case "Corey Thornton - CB": return "Corey Thornton, #31, CB, 6-1, 195 lbs, 25 y/o, R, Louisville";
            case "Trevin Wallace - ILB": return "Trevin Wallace, #32, ILB, 6-1, 244 lbs, 22 y/o, 2 yrs exp, Kentucky";
            case "Chandler Zavala - G": return "Chandler Zavala, #62, G, 6-3, 322 lbs, 26 y/o, 3 yrs exp, NC State";

            default: return "Player info not available yet.";
        }
    }

    // Coaches & staff info.
    private String getStaffInfo(String staff) {
        switch (staff) {
            case "Dave Canales - Head Coach":
                return "Dave Canales – Head Coach\nCollege: Azusa Pacific University\n" +
                        "Became Panthers HC in 2024 after serving as offensive coordinator for the Buccaneers and 13 years with Seahawks.\n" +
                        "In his first season, Carolina improved by 3 wins, Bryce Young had a career year, and several players earned Pro Bowl recognition.\n" +
                        "Known for developing quarterbacks and leading productive offenses.";

            case "Brad Idzik - Offensive Coordinator":
                return "Brad Idzik – Offensive Coordinator\nSecond season with Panthers after joining in 2024.\n" +
                        "Played key role in Bryce Young’s improvement late in 2024, helped Chuba Hubbard surpass 1,000 rushing yards, and oversaw strong rookie receiving group.\n" +
                        "Previously coached wide receivers and quarterbacks in Seattle and Tampa Bay.";

            case "Harold Goodwin - Assistant Head Coach/Run Game Coordinator":
                return "Harold Goodwin – Assistant Head Coach/Run Game Coordinator\nSecond season with Panthers.\n" +
                        "Helped lead a major turnaround in Carolina’s run game in 2024.\n" +
                        "Brings over 20 years of NFL experience, including a Super Bowl title with Pittsburgh.";

            case "Joe Gilbert - Offensive Line":
                return "Joe Gilbert – Offensive Line Coach\nSecond season with Panthers.\n" +
                        "Nearly four decades of coaching experience and 13 years in the NFL.\n" +
                        "Dramatically improved Panthers offensive line in 2024, helping Chuba Hubbard reach 1,000 yards and developing Pro Bowl guard Robert Hunt.";

            case "Will Harriger - Quarterbacks":
                return "Will Harriger – Quarterbacks Coach\nSecond season with Panthers.\n" +
                        "Played key role in Bryce Young’s resurgence in 2024.\n" +
                        "Over 20 years of coaching experience, developing elite QBs including Dak Prescott, Caleb Williams, Russell Wilson, and Trevor Lawrence.";

            case "Pat McPherson - Tight Ends":
                return "Pat McPherson – Tight Ends Coach\nSecond season with Panthers, 14 years in Seahawks before.\n" +
                        "Developed rookie Ja’Tavion Sanders and helped Tommy Tremble post a career-best season.\n" +
                        "Nearly three decades of NFL coaching, including two Super Bowl titles.";

            case "Rob Moore - Wide Receivers":
                return "Rob Moore – Wide Receivers Coach\nSecond season with Panthers.\n" +
                        "Developed one of the league’s top rookie receiving groups in 2024, including Xavier Legette and Jalen Coker.\n" +
                        "Extensive NFL playing/coaching career, including Titans, Raiders, Bills, and Syracuse.";

            case "Bernie Parmalee - Running Backs":
                return "Bernie Parmalee – Running Backs Coach\nFirst season with Panthers, previously Jaguars RB coach for 3 years.\n" +
                        "Former NFL RB, strong track record developing productive backfields including Travis Etienne Jr.";

            case "Mike Bercovici - Assistant QBs/Pass Game Specialist":
                return "Mike Bercovici – Assistant QBs/Pass Game Specialist\nThird season with Panthers, first in current role.\n" +
                        "Helped Bryce Young post career-high 21 passing TDs in 2024.\n" +
                        "Background in QB development at Arizona State, Cardinals, and as former collegiate/pro QB.";

            case "Ejiro Evero - Defensive Coordinator":
                return "Ejiro Evero – Defensive Coordinator\nThird season with Panthers.\n" +
                        "Led top-10 defenses in 2 of last 3 seasons, including 4th-ranked Carolina unit in 2023.\n" +
                        "Extensive NFL experience including coordinating Denver’s top-10 defense and Super Bowl LVI win with Rams.";

            case "Dom Capers - Senior Defensive Assistant":
                return "Dom Capers – Senior Defensive Assistant\nThird season back with Panthers.\n" +
                        "First-ever Panthers head coach, 50 years coaching experience, former head coach and long-time defensive coordinator.\n" +
                        "Won Super Bowl XLV with Green Bay and developed numerous Pro Bowl/All-Pro players.";

            case "AC Carter - Outside Linebackers":
                return "AC Carter – Outside Linebackers Coach\nFirst season with Panthers.\n" +
                        "10 years coaching experience, including 4 in NFL.\n" +
                        "Developed standout defensive linemen and productive top-half run defenses.";

            case "Jonathan Cooley - Defensive Passing Game Coordinator":
                return "Jonathan Cooley – Defensive Passing Game Coordinator\nThird season with Panthers, second in current role.\n" +
                        "Key in developing Carolina’s coverage unit including Jaycee Horn.\n" +
                        "Background coaching secondary for Rams’ Super Bowl staff and NFL/college defensive backs.";

            case "Peter Hansen - Linebackers":
                return "Peter Hansen – Inside Linebackers Coach\nThird season with Panthers.\n" +
                        "17 years coaching experience, 7 in NFL.\n" +
                        "Developed productive LB play highlighted by Josey Jewell, Trevin Wallace, Frankie Luvu.";

            case "Renaldo Hill - Secondary Coach":
                return "Renaldo Hill – Secondary Coach\nFirst season with Panthers.\n" +
                        "11 years coaching experience, 10-year NFL playing career.\n" +
                        "Helped Miami field first top-10 defense in over a decade (2023), turnover-focused production.";

            case "Todd Wash - Defensive Line":
                return "Todd Wash – Defensive Line Coach\nThird season with Panthers.\n" +
                        "Three decades coaching experience, long NFL résumé.\n" +
                        "Coached elite production from front, guiding Derrick Brown and A’Shawn Robinson to top performance.";

            case "Mayur Chaudhari - Assistant Linebackers":
                return "Mayur Chaudhari – Assistant Linebackers Coach\nThird season with Panthers, first in current role.\n" +
                        "Over 20 years coaching experience, seven in NFL.\n" +
                        "Developed productive tacklers including Josey Jewell and Trevin Wallace.";

            case "Tracy Smith - Special Teams Coordinator":
                return "Tracy Smith – Special Teams Coordinator\nSecond season with Panthers.\n" +
                        "17 years NFL coaching experience, elite coverage units.\n" +
                        "In 2024, Panthers led league in opponent kickoff return average.";

            case "Daren Bates - Special Teams Assistant":
                return "Daren Bates – Special Teams Assistant\nSecond season with Panthers.\n" +
                        "Nine NFL seasons as player, transitioned into coaching.\n" +
                        "Contributed to elite coverage units including standout kicker/punter performances.";

            case "Jim Caldwell - Senior Coaching Advisor":
                return "Jim Caldwell – Senior Coaching Advisor\nThird season with Panthers.\n" +
                        "44 years coaching experience, 21 in NFL, 15 seasons as head coach.\n" +
                        "Led Colts/Lions to playoff appearances and Super Bowl win as assistant with Indianapolis/Baltimore.";

            case "George Li - Game Management Coordinator":
                return "George Li – Game Management Coordinator\nThird season with Panthers.\n" +
                        "14 years NFL experience in analytics and game management.\n" +
                        "Provides analytical support, advises on game decisions, previously with Colts/Raiders.";

            case "Dean Petzing - Offensive Quality Control":
                return "Dean Petzing – Offensive Quality Control\nSecond season with Panthers, 12 years collegiate coaching.\n" +
                        "Helped Panthers increase passing TDs by 9 in 2024 and contributed to strong rushing attack.\n" +
                        "Previously coached at LSU, Notre Dame, Maine, Villanova, Yale, St. Lawrence.";

            default:
                return "Staff info not available.";
        }
    }
    // Players & Team Stats
    private String getStatsInfo(String Stats) {
        switch (Stats)
        case Carolina Panthers Stats
            return "306 Total 1st Down "
                   "1st Downs, 109-Rushing, 170-Passing, 27-By Penalty"
                   "74/205 3RD DOWN CONVERSIONS, 27/40 4TH DOWN CONVERSIONS, 5025 TOTAL OFFENSIVE YARDS"
                   "1040 OFFENSE, 4.8 Plays, 1977 TOTAL RUSHING YARDS"
                   "46.1 RUSHING, 4.3 Plays, 3304 TOTAL PASSING YARDS"
                   "329 Passing, 515 Completions, 12 Attempts, 6.4 Interceptions"
                   "35 Sacks, 24/29 FIELD GOALS, 35 TOUCHDOWNS"
                   "9 RUSHING, 24 PASSING, 0 RETURNS, 2 DEFENSIVE, -2 TURNOVER RATIO"
        case: "Bryce Young - Passing Stats"
            return "ATT-478,COMP-304,YDS-3011,COMP%-63.6,YDS/ATT-6.3,TD-23,TD%4.8,INT-11,INT%2.3,LONG-54,SCK-27,SCK/LOST-202,RATE-87.8"
        case "Andy Dalton - Passing Stats"
            return "ATT-37,COMP-25,YDS-293,COMP%-67.6,YDS/ATT-7.9,TD-1,TD%2.7,INT-1,INT%-2.7,LONG-33,SCK-8,SCK/LOST-54,RATE-89.1"
        case "Rico Dowdle - Rushing Stats"
            return "ATT-236,YDS-1076,YDS/ATT-4.6,LNG-53,TD-6"
        case "Chuba Hubbard - Rushing Stats"
            return "ATT-134,YDS-511,YDS/ATT-3.8,LNG-14,TD-1"
        case "Bryce Young - Rushing Stats"
            return "ATT-54,YDS-216,YDS/ATT-4,LNG-24,TD-2"
        case "Trevor Etienne"
            return "ATT-20,YDS-94,YDS/ATT-4.7,LNG-22,TD-0"
        case "Jimmy Horn Jr. - Rushing Stats"
            return "ATT-8,YDS-69,YDS/ATT-8.6,LNG-25,TD-0"
        case "Andy Dalton - Rushing Stats"
            return "ATT-5,YDS--2,YDS/ATT--0.4,LNG-1,TD-0"
        case "David Moore - Rushing Stats"
            return "ATT-1,YDS-12,YDS/ATT-12,LNG-12,TD-0"
        case "Mitchell Evans - Rushing Stats"
            return "ATT-1,YDS-1,YDS/ATT-1,LNG-1,TD-0"
        case "DeeJay Dallas - Rushing Stats"
            return "ATT-1,YDS-0,YDS/ATT-0,LNG-0,TD-0"
        case "Xavier Legette - Rushing yards"
            return "ATT-1,YDS-0,YDS/ATT-0,LNG-0,TD-0"
        case "Tetairoa McMillan - Receiving yards"
            return "REC-70,YDS-1014,YDS/REC-14.5,LNG-43,TD-7"
        case "Rico Dowdle - Receiving yards"
            return "REC-39,YDS-297,YDS/REC-7.6,LNG-36,TD-1"
        case "Xavier Legette - Receiving yards"
            return "REC-35,YDS-363,YDS/REC-10.4,LNG-36,TD-3"
        case "Jalen Coker - Receiving yards"
            return "REC-33,YDS-394,YDS/REC-11.9,LNG-34,TD-3"
        case "Chuba Hubbard - Receiving yards"
            return "REC-30,YDS-223,YDS/REC-7.4,LNG-35,TD-3"
        case "Ja'Tavion Sanders - Receiving yards"
            return "REC-29,YDS-190,YDS/REC-6.6,LNG-18,TD-1"
        case "Tommy Tremble - Receiving yards"
            return "REC-27,YDS-249,YDS/REC-9.2,LNG-54,TD-2"
        case "Mitchell Evans - Receiving yards"
            return "REC-19,YDS-171,YDS/REC-9,LNG-25,TD-2"
        case "Hunter Renfrow - Receiving yards"
            return "REC-15,YDS-89,YDS/REC-5.9,LNG-15,TD-2"
        case "Bryce Tremayne - Receiving yards"
            return "REC-14,YDS-160,YDS/REC-11.4,LNG-26,TD-0"
        case "Jimmy Horn Jr. - Receiving yards"
            return "REC-11,YDS-108,YDS/REC-9.8,LNG-34,TD-0"
        case "James Mitchell - Receiving yards"
            return "REC-3,YDS-28,YDS/REC-9.3,LNG-11,TD-0"
        case "Trevor Etienne - Receiving yards"
            return "REC-3,YDS-13,YDS/REC-4.3,LNG-7,TD-0"
        case "David Moore - Receiving yards"
           return "REC-1,YDS-5,YDS/REC-5,LNG-5,TD-0"
        case "Bryce Young - Receiving yards"
            return "REC-0,YDS-0,YDS/REC-0,LNG-0,TD-0"
        case "Tre'von Moehrig - Defense stats"
           return "Total-103,Solo-65,Assist-38,SCK-3,SFTY-0,F-0"
        case "Trevin Wallace - Defense stats"
            return "Total-61,Solo-36,Assist-25,SCK-2,SFTY-0,F-0"
        case "Thomas Incoom - Defense stats"
            return "Total-17,Solo-9,Assist-8,SCK-0,SFTY-0,F-0"
        case "Tershawn Wharton - Defense Stats"
            return "Total-36,Solo-11,Assist-25,SCK-2,SFTY-0,F-0"
        case "Princely Umanmielen - Defense Stats"
            return "Total-24, Solo-13,Assist-11,SCK-1.5,SFTY-0,F-1"
        case "Nick Scott - Defense Stats"
            return "Total-111,Solo-64,Assist-47,SCK-0,SFTY-0,F-0"
        case "Nic Scourton - Defense Stats"
            return "Total-47,Solo-20,Assist-27,SCK-5,SCK-0,F-1"
        case "Mike Jackson - Defense Stats"
            return "Total-68,Solo-54,Assist-14,SCK-0,SFTY-0,F-1"
        case "Lathan Ransom - Defense Stats "
            return "Total-51,Solo-21,Assist-30,SCK-1,SFTY-0,F-1"
        case "Krys Barnes - Defense Stats"
            return "Total-23,Solo-6,Assist-17,SCK-0.5,SFTY-0,F-0"
        case "Jaycee Horn - Defense Stats"
            return "Total-37,Solo-26,Assist-11,SCK-0,SFTY-0,F-0"
        case "Derrick Brown - Defense Stats"
            return "Total-73,Solo-33,Assist-40,SCK-5,SFTY-0,F-1"
        case "D.J. Wonnum - Defense Stats"
            return "Total-42,Solo-19,Assist-23,SCK-3,SFTY-0,F-0"
        case "Claudin Cherelus - Defense Stats"
            return "Total-32,Solo-14,Assist-18,SCK-0,SFTY-0,F-0"
        case "Christian Rozeboom - Defense Stats"
            return "Total-122,Solo-59,Assist-63,SCK-2,SFTY-0,f-0"
        case "Chau Smith-Wade - Defense Stats"
            return "Total-56,Solo-43,Assist-13,SCK-0,SFTY-0,F-0"
        case "Bobby Brown III - Defense Stats"
            return "Total-31,Solo-13,Assist-18,SCK-0.5,SFTY-0,F-0"
        case "Barn Martin-Scott - Defense Stats"
           return "Total-21,Solo-7,Assist-14,SCK-0,SFTY-0,F-1"
        case "A'Shawn Robinson - Defense Stats"
           return "Total-65,Solo-21,Assist-44,SCK-2.5,SFTY-0,F-0"
        case "Jaycee Horn - Interceptions Stats"
            return "INT-5,YDS-46,YDS/REC-9.2,LNG-22,TDS-0"
        case "Mike Jackson - Interception Stats"
            return "INT-4,YDS-102,YDS/REC-25.5,LNG-54,TDS-1"
        case "Tre'von Moehrig - Interception Stats"
            return "INT-1,YDS-36,YDS/REC-36,LNG-36,TDS-0"
        case "Christon Rozeboom - Interception Stats"
            return "INT-1,YDS-20,YDS/REC-20,LNG-20,TDS-0"
        case "Chau Smith-Wade - Interception Stats"
            return "INT-1,YDS-11,YDS/REC-11,LNG-11,TDS-1"
        case "Lathan Ransom - Interception Stats"
            return "INT-1,YDS-5,YDS/REC-5,LNG-5,TDS-0"
        case "Nick Scott - Interception Stats"
            return "INT-1,YDS-0,YDS/REC-0,LNG-0,TDS-0"
        case "D.J. Wonnum - Interception Stats"
            return "INT-1,YDS-0,YDS/REC-0,LNG-0,TDS-0"
        case "Ryan Fitzgerald - Field Goals Stats"
            return "1-19 is 0-19,20-29 is 8-8, 30-39 is 8-9, 40-49 is 8-9, 50-59 is 2-5, 60+ is 0-0"
        case "Sam Martin - Punting Stats" 
            return "PUNTS-56,YDS-2642,LNG-68,AVG-47.2,BLK-0,RET-24,RETY-313,IN20-27,NET AVG-40.5"
        case "Trevor Etienne - Punt Return Stats"
            return "RET-20,FC-6,YDS/RET-8.2,LNG-16,TD-0"
        case "Hunter Renfrow - Punt Return Stats"
            return "RET-2,FC-2,YDS/RET-6.5,LNG-13,TD-0"
        case "David Moore - Punt Return Stats"
            return "Ret-1,FC-1,YDS/RET-0,LNG-0,TD-0"
        case "Brycen Tremayne - Punt Return Stats"
            return "Ret-1,FC-0,YDS/RET-0,LNG-0,TD-0"
        case "DeeJay Dallas - Punt Return Stats"
           return "Ret-0,FC-4,YDS/RET-0,LNG-0,TD-0"
        case "JimmyHorn Jr. - Punt Return Stats"
            return "Ret-0,FC-1,YDS/RET-0,LNG-0,TD-0"
        case "Trevor Etienne - Kick Return"
            return "Ret-31,FC-0,YDS-733,YDS/RET-23.6,LNG-45,TD-0"
        case "Chuba Hubbard - Kick Return"
            return "Ret-9,FC-0,YDS-233,YDS/RET-25.9,LNG-27,TD-0"
        case "Rico Dowdle - Kick Return"
            return "Ret-8,FC-0, YDS-197,YDS/RET-24.6,LNG-30,TD-0"
        case "DeeJay Dallas - Kick Return"
           return "Ret-6,FC-0,YDS-141,YDS/RET-23.5,LNG-28,TD-0"

    // Main method to launch the application.
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CarolinaPanthers2026 viewer = new CarolinaPanthers2026();
            viewer.setVisible(true);
        });
    }
}
