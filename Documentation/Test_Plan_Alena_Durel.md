# Test Plan

## Introduction

1.  Overview  
    This test plan describes the testing approach for the Realms of Mastery program.

2.  Goals  
    The goal of this testing period is to verify that the functionality of Realms of Mastery works according to the specifications and requirements previously created. The test will include playing the game and attempting to cover all possibilities that a player might encounter. This testing period will be used to identify, fix, and retest any bugs or issues found. In addition, a play testing experience conducted with a group of users in the appropriate target range will be completed during this period of testing.

    The final product of the testing period will be:

    -   A ready to play version of Realms of Mastery.

    -   User-friendly and easy to understand UI and controls.

3.  Constraints  
    This testing period will suffer from time-based constraints and scheduling concerns.

## References

1.  Documents

This test utilizes two documents: [Requirements.md](Requirements_Alena_Durel.md) & [Proposal.md](Proposal_Alena_Durel.md)

## Test Items

1.  Software
    This test will utilize several different software products:

    -   IntelliJ IDEA Community Edition 2023.2

    -   Java SE Development Kit 15.0.1 (JDK 15.0.1)

    -   Java 8

## Features to be Tested
*Note: NPC wil refer to Non-Player Character*

-   **World Navigation:** It is critical to the project that the player is able to navigate through the world, both in the main area as well as in the dungeon.
-   **Menu Navigation:** It is critical to the project the player is able to navigate the various menus that the game implements. These include the start game menu, character selection menu, pause menu, inventory menu, achievements and stats menu, help/tutorial menu, and the shop menus.
-   **Saving and Loading:** It is critical to the project that the player is able to save and load their player file. The player will only be able to save in the main area as saving will be disabled within the dungeon. In the main menu, the player will be able to start a new game or load a game.
-   **Character Selection:** The player will be able to customize their character selection at the beginning of the game and when visiting the Outfitter NPC. Any items bought from the Outfitter should remain available to the player.
-   **Inventory:** The player will be able to navigate their inventory page which will display the player's items. This menu will also allow the player to use potions when appropriate and select from their unlocked weapons. While potions and keys are dungeon specific and will be reset at the end of each run, other items should persist.
-   **Potions:** The player will be able to use potions to bolster their journey. These potions include a health potion, speed potion, strength potion, and reroll potion. The speed potion may only be used outside of an encounter while the reroll potion may only be used inside of an encounter. The health and strength potion may be used at any time.
-   **Achievements Page:** The player will be able to view their achievements in the game. These achievements include monsters defeated, chests opened, bosses slain, and questions answered correctly.
-   **Stats Page:** The player will be able to view their stats in the game. These stats will include both player stats and game stats. Player stats include the player's damage, health, and speed. Game stats include monsters defeated, bosses slain, gold collected, potions used, chests opened, number of right answers, highest streak of correct answers in a row, and the player's best category of questions.
-   **NPCs:** The player will be able to interact with several different NPCs. These NPCs include the Outfitter, the Weapon Master, the Artificer, the Doctor, and the Boss Rush Manager. Each of these NPCs will have menu for the player to navigate that will allow them to purchase items or complete other functions.
-   **Shopping Feature:** The NPCs will have shops that will allow the player to purchase things such as new outfits, potions, and weapons. Any unlockable items will be permanently unlocked on purchase.
-   **Fighting Monsters:** In the dungeon, players will encounter a variety of monsters. These monsters include zombies, skeletons, ghosts, and slimes. When the player fights a monster they will be able to choose the difficulty of their questions. Higher difficulty questions will deal more damage to the monster if the player gets the answer correct. However, if they are incorrect, they will lose more health on a higher difficulty question. Upon defeating a monster the player will be rewarded with a small amount of gold and the chance to get a potion.
-   **Treasure Collection:** In the dungeon, players will encounter chests that contain gold. Depending on the difficulty of the question the player will receive more or less gold. The player will have 3 attempts to unlock the chest, after the third failed attempt the chest will be locked for the rest of the run.
-   **Randomized Questions:** When a player interacts with a chest or a monster they will be presented with a question from a random category the corresponds to their chosen difficulty. The categories currently implemented are Multiplication, Division, Fractions, and Word Problems.
-   **Boss Rush mode:** A Boss Rush mode will allow the player to choose a category and difficulty tier in order to practice their skills against an onslaught of monsters.

## Features Not to be Tested

The below features are requirements that might not be implemented in the original version of this project, but will eventually be added. If these are implemented prior to the start of testing, they will also be within the scope of the features to be tested.

- **Auto-save:** Support for auto-saving the game.
- **Fighting Style Selection:** The player will be able to select between an ELA or Math-based fighting style.
- **ELA Questions:** Support for ELA questions to appear in the game.
- **Personalized Boss Rush:** While the questions found in the main game will remain fixed, there is the potential for the boss rush feature to be personalized with custom questions provided by teachers.

## Approach

### Testing Methods

Testing will consist of a case-by-case basis as well as testing the overall functionality of the game. Each feature will be tested individually to ensure its functionality. When a bug is found in a feature, testing will temporarily pause in order to fix the bug. Once the bug has been fixed, testing for that feature will restart to ensure that the bug fix did not cause any other unintended issues. Once each feature has been properly tested, the entire game will be play tested by the developer and others to ensure the overall cohesiveness and functionality of the game.

Testing will be done manually and will test both expected and unexpected input to see how the program handles it.

## Testing Levels

- Component testing will be used to ensure that each feature of the software functions according to its specifications and requirements.
- Integration testing will be used to ensure that certain components work together. For example, items purchased from NPCs should persist when the game is saved and reloaded. 
- System testing will be performed to ensure that all components are working together.

## Item Pass/Fail Criteria

-   **World Navigation:**
    -   Pass: The player will be able to use the 'W', 'A', 'S', and 'D' keys to move throughout the world and the dungeons.
    -   Fail: The 'W', 'A', 'S', and 'D' keys will not move the player in the appropriate way.
-   **Menu Navigation:**
    -   Pass: The player will be able to use the 'W', 'A', 'S', and 'D' to move throughout the menu and 'Enter' to select buttons. The player will be able to access menus with specific keys.
        - Pause Menu - 'P'
        - Inventory Menu - 'I'
        - Achievement/Stats Menu - 'O'
    -   Fail: Certain parts of the menu will not be accessed correctly, or the keys do not behave as expected.
-   **Saving and Loading:**
    -   Pass: The player will be able to save and load their game without loss of data.
    -   Fail: The player will not be able to successfully save or load, or there is a loss of data.
-   **Character Selection:**
    -   Pass: The player will be able to use the 'W', 'A', 'S', 'D', and 'Enter' keys to select different gender, hair color, skin color, and shirt color to customize their character. When a player selects a new customization the player image will update to reflect these changes.
    -   Fail: The player will not be able to select available options or the player image will not be updated.
-   **Inventory:**
    -   Pass: The player will be able to navigate the inventory screen using the 'W', 'A', 'S', 'D', and 'Enter' keys. They will be able to see an accurate representation of their current supplies including number of coins, keys, potions, and availability of weapons. The player will also be able to use potions and select a new weapon. Certain potions can only be used in an encounter or outside of one, the player should not be allowed to use a encounter-specific potion outside of an encounter or vice versa.
    -   Fail: The player will not be able to navigate the inventory screen or select available weapons and potions. Information being represented incorrectly after manipulation to resources will also constitute failure. Finally, if the player is able to use a potion when it is not intended that will also constitute failure.
-   **Potions:**
    -   Pass: Several conditions must be met to pass:
        -   Reroll Potion:
            -   Can only be used during an encounter
            -   Will create a new question for the player of the same difficulty
        -   Health Potion:
            -   Can be used at any time
            -   Will increase the player's health by a number but will not push it above the max health
        -   Strength Potion:
            -   Can be used at any time
            -   Will increase the player's damage by a number for three fights
            -   After three fights the player's damage will return to normal
        -   Speed Potion:
            -   Can only be used outside of an encounter
            -   Will increase the player's speed for two minutes
            -   At the end of the two minutes the player's speed will return to normal
    -   Fail: Several conditions could cause this to fail:
        -   Reroll Potion:
            -   Used outside of an encounter
            -   Creates a question of a different difficulty or fails to generate a new question
        -   Health Potion:
            -   Does not increase the player's health or increases it above the max health
        -   Strength Potion:
            -   Player's damage is not increased
            -   After three fights the player's damage is not returned to normal
        -   Speed Potion:
            -   Used inside of an encounter
            -   Does not increase player's speed
            -   At the end of the two minutes the player's speed is not returned to normal
-   **Achievements Page:**
    -   Pass: The player is able to view their achievements and see an accurate representation of the achievements they have earned and their progress towards others.
    -   Fail: The player is not able to access the achievements page or their achievements are not accurately represented.
-   **Stats Page:**
    -   Pass: The player is able to view their stats and see an accurate representation of their player stats and game stats. These stats should also update as they are manipulated. For example, a player's stats should reflect an increase in damage after using a strength potion and should reflect a return to normal damage once the potion's effect are gone.
    -   Fail: The player is no able to access the stats page or their stats are not accurately recorded.
-   **NPCs:**
    -   Pass: The player will be able to interact with all NPCs and NPCs will appear in their correct locations.
    -   Fail: The player will not be able to interact with one or more NPCs or NPCs appear in inappropriate locations.
-   **Shopping Feature:**
    -   Pass: The player will be able to purchase items from the NPCs in their shops. These unlockable items should remain available after purchase and the player should not be able to purchase items that they do not have the gold for.
    -   Fail: The player is unable to purchase an item that they have the gold for or they are able to purchase an item they cannot afford. Another failure condition is if items purchased do not remain available.
-   **Fighting Monsters:**
    -   Pass: The player will engage in a monster fight upon interacting with a monster or upon the monster running into them. The player will fight the monster in a sequence of selecting a difficulty and answering a question until either the monster or the player has been defeated. If the player answers incorrectly, the correct answer will be given to them.
    -   Fail: A player and monster running into each other does not trigger a fight. Other failure conditions include it the sequence of the fight is not followed or the incorrect answer is shown.
-   **Treasure Collection:**
    -   Pass: The player will attempt to unlock a chest upon running into it. The player will be given three chances to unlock it, after the third wrong answer the chest will be locked for the remainder of the run. The chest will give the player an amount of gold depending on the difficulty level that was chosen.
    -   Fail: The player is not able to start an unlock attempt or is locked out of the chest before the third wrong answer. Additionally, if the player receives an inappropriate amount of gold for their chosen difficulty level it will be considered a failure.
-   **Randomized Questions:**
    -   Pass: Each category (Multiplication, Division, Fractions, Word Problems) will be represented at random within a run, however, no run should consist of only one type of question.
    -   Fail: One category is never represented or only one or two categories are represented.
-   **Boss Rush mode:**
    -   Pass: The player will be able to start the boss rush mode and will able to choose a category and difficulty to practice.
    -   Fail: The player is unable to start the boss rush mode or is not able to limit questions to a category and difficulty.
  
### Student Testing

For student testing, I will coordinate with Ashlyn Durel to set a time for a center activity in her classroom. She will run the game off of her personal laptop, or the Chromebook purchased for this project, and will allow her students to play the game one or two at a time. The students will go through all of the mechanics of the game, including starting a new game and selecting a character, exploring the main world, playing through a run, interacting with NPCs, saving the game, and navigating menus. They will also fill out a short survey with feedback about the game.

## Suspension Criteria and Resumption Requirements

### Suspension Criteria

Testing will be suspended if a program-breaking bug is found. Another suspension criteria will be if the feature to be tested is not complete when needed by the test team.

### Resumption Criteria

If testing is suspended, it will resume when the problem(s) that caused the suspension has been resolved and verified.

## Test Deliverables

1.  Test Plan  
    This document itself is considered a test plan.

2.  Test Cases  
    No test cases have been created yet.

3.  Defect/Enhancement Logs  
    No Defect/Enhancement logs have been created yet.

4.  Test Reports  
    No test reports have been created yet.

## Test Environment

### Hardware

Testing will be done on the following hardware specs:

**Macbook Pro 2019**
-   Intel Core i9 CPU, 8-Core @ 2.4 GHz
-   Intel UHD Graphics 630 1536 MB (Built-in)
-   64 GB RAM DDR4 2667 MHz

**Linux Device**
-   Virtualized on Macbook Pro

**PC, built in 2022**
-   AMD Ryzen 5 5600X CPU, 6-Core @ 3.7 GHz
-   Radeon RX 6600 GPU, 8GB
-   32 GB RAM (2x16) DDR4 3200 MHz
  
**Acer N7 C731 2017 (Personal Chromebook)**
-   Intel Celeron N3060 CPU, Dual Core @ 1.6 GHz
-   Intel HD Graphics 400 (Built-in)
-   4GB LPDDR3 SDRAM

**Student Testing**
-   TBD


### Software

Testing will be done with the following software:

-   Apple MacOS, Sonoma 14.1.2
  
-   Microsoft Windows 11 Home, 22H2

-   VMWare Fusion Player Version 12.2.4 (20071091)

-   Ubuntu Linux, version 22.04.1

-   ChromeOS
  
-   IntelliJ IDEA Community Edition 2023.2

-   Java SE Development Kit 15.0.1 (JDK 15.0.1)

-   Java 8

--------------------

Student Testing will be done with the following software:
-   ChromeOS or MacOS

### Network

There will be no network requirements for testing this project.

## Estimate

### Costs and Effort

**Costs**
-   Chromebook: $50

**Efforts**
-   Multiple hours of effort will be put into the testing period of this program to ensure that it is fully functional and to an acceptable standard.
-   It is the hope of the developer that they will be able to work in conjunction with a school to provide testing results and feedback from a target user group. Communications with the school and planning to conduct this user test will take some time and effort.

## Schedule
---------------------

| Task                                                 | Start Date         | Completion Date (Estimated) |
|------------------------------------------------------|--------------------|-----------------------------|
| Create Proposal Document                             | August 23, 2023    | August 23, 2023             |
| Create Requirements Document                         | August 23, 2023    | August 23, 2023             |
| Proposal Final Draft                                 | August 23, 2023    | August 29, 2023             |
| Requirements Final Draft                             | August 23, 2023    | August 29, 2023             |
| Create Project                                       | August 23, 2023    | August 23, 2023             |
| Install Necessary Software/Libraries                 | August 23, 2023    | August 23, 2023             |
| Basic Map and Sprites                                | August 23, 2023    | September 16, 2023          |
| Tile Screen and Character Selection                  | August 26, 2023    | September 2, 2023           |
| Inventory                                            | September 2, 2023  | September 9, 2023           |
| Treasure Collection                                  | September 9, 2023  | September 16, 2023          |
| Fighting Monsters                                    | September 16, 2023 | September 30, 2023          |
| Add Questions                                        | September 2, 2023  | September 30, 2023          |
| Achievements and Stats Page                          | September 30, 2023 | October 7, 2023             |
| Shops and NPCs                                       | October 7, 2023    | October 14, 2023            |
| Saving Mechanic                                      | September 9, 2023  | October 14, 2023            |
| Boss Rush Mode                                       | October 14, 2023   | October 28, 2023            |
| Create a Test Plan                                   | October 28, 2023   | December 1, 2023            |
| Testing Project for Bugs/Issues/Etc.                 | January 1, 2024    | January 13, 2023            |
| Compile Results & Analyze/Fix Bugs                   | January 13, 2024   | January 20, 2024            |
| Outside Testing                                      | February 1, 2024   | March 1, 2024               |
| Compile Results & Analyze/Fix Bugs                   | March  2023        | March 2023                  |
| Complete Project & Defend Project                    | April 24, 2024     | April 24, 2024              |

## Staffing and Training Needs

Some testing will come from users in the targeted age range, which is 3rd and 4th grade. Therefore, I will need the assistance of Ashlyn Durel as a classroom and school contact. I will also need to provide her with thorough training in the event that I cannot attend the testing session myself.

## Responsibilities

This testing requires three team members to fulfill specialized roles:

-   Alena Durel: Lead developer, tester, and documenter

-   Professor Julie Henderson: Project advisor and documentation reviewer

-   Ashlyn Durel: Academic advisor and classroom contact

## Risks

1. Risks  
   This test plan has some assumed risks:

    -   Due to time and schedule constraints, the project might not be completed in time.

    -   Critical bugs could occur and will take some time to fix before the project can be resumed.

    -   At times, other schoolwork and work will need to take priority.

    -   Any data corruption could result in the complete loss of the project.

2. Mitigations  
    There are mitigations in place for the risks:

    -   The developer will work to ensure that the project is completed in time through the use of time management and scheduling.

    -  When bugs are encountered, the developer will work to debug and fix them as quickly and efficiently as possible.

    -   The developer will create a balance of their work and coursework to ensure that there is enough time dedicated to this project.

    -   Project code and documents will be regularly be backed up to an external hard drive and GitHub in order to ensure that any data corruption would lead to minimal loss.

## Assumptions and Dependencies

1.  Assumptions  
    This testing will have some assumptions:

    -   The progress made on the project and other factors might cause changes in deadlines.
    
    -   Due to work and schoolwork, the developer will not be able to work on this project constantly.

    -   Testing this project will uncover bugs and issues that will need to be fixed.


2.  Dependencies  
    This testing will have some dependencies:
    -   The project cannot be completed without Java.
    
    -   The project cannot be completed without IntelliJ CE for development, compilation, and debugging.
    
    -   The student testing section of this project cannot be completed without approval from the school and their teacher.

## Approvals

The people that will have to approve this plan are Alena Durel and Professor Julie Henderson.
