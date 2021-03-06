# User's Manual for GuessIt Beta 1.0

**Author**: Team11

## Table of Contents
1.0 General Overview<br />
⋅⋅⋅1.1 System Requirements<br />
⋅⋅⋅1.2 Known Issues and Limitations<br />
⋅⋅⋅1.3 Help and Support<br />
2.0 Getting Started<br />
⋅⋅⋅2.1 Android Studio<br />
⋅⋅⋅2.2 Installation<br />
3.0 Using the System<br />
⋅⋅⋅3.1 Logging/Signing In<br />
⋅⋅⋅3.2 Creating a Puzzle<br />
⋅⋅⋅3.3 Playing a Puzzle<br />
⋅⋅⋅3.4 Creating a Tournament<br />
⋅⋅⋅3.5 Playing a Tournament<br />
⋅⋅⋅3.6 Viewing Statistics<br />

## 1.0 - General Overview
The 'GuessIt' Android Application is a game application simulating the popular 'Wheel of Fortune' television show. More in depth usages of the application will be covered in the following document.

## 1.1 System Requirements
The following minimum system criteria must be met for the GuessIt application to run.
* 5 MB of application memory available
* Running an Android OS of Jelly Bean (4.1 onward)
* Access to a machine that has Git 2.10.1 installed 

## 1.2 Known Issues and Limitations
To see a comprehensive tracking of all completed issues see our [issues page](https://github.gatech.edu/gt-omscs-se-2018spring/6300Spring18Team11/issues). Prior to this release the team has fixed all known issues. If any issues are encountered during the use of this application do not hesitate to reach out to our support team. 

## 1.3 Help and Support
If any issues in running the GuessIt application are found, please contact Team11 through the following means:

| Contact Name   | Email                  |
| -------------- |-----------------------:| 
| Brigit Hawley  | bhawley3@gatech.edu    |
| Robert Johnson | rjohnson348@gatech.edu |
| Sahan De Silva | rsilva32@gatech.edu    |
| HaoHao Wang    | hwang404@gatech.edu    |

## 2.0 Getting Started
Full disclosure, this application is ONLY allowed to meant to be run by installing the APL. Anyone who tries to build/run the application through Android Studio will encounter undefined behavior. Please contact our support team with any questions. 

## 2.1 Git
To obtain access to the GuessIt application the user must first clone our repository. The repository can be accessed [here](https://github.gatech.edu/gt-omscs-se-2018spring/6300Spring18Team11). If a user needs access to our repository, please contact the support staff listed above. 

## 2.2 Installation
There is an APK available for installation of the GuessIt application. It can be accessed through our git repository.
1. Clone Team11's git repository
2. Import the project into Android Studio
3. Build and install the GuessIt Application onto your desired device 

## 3.0 Using the System
The following sections detail the main features of the GuessIt application. 

## 3.1 Logging/Signing In
Users may create new username accounts or login using previously created usernames. To play the GuessIt game, it is necessary for one user to be logged in at one time. A user will need to provide the following information to create a new account: 
* Player’s first name
* Player’s last name
* Player’s desired username
* Player’s email

## 3.2 Creating a Puzzle
Users may create their own puzzles within the GuessIt application. These puzzles will be available for other users of the same device to play and solve. A user will need to provide the following information to create a new puzzle: 
* A puzzle phrase
* The maximum number of allowed wrong guesses a player can make before losing the game (between 0 and 10)

## 3.3 Playing a Puzzle
Users may play puzzles that meet the following criteria: 
* Were created by another user
* Have not been played by the current user

The first puzzle meeting the above criteria will be available for the current user to play. When playing a puzzle, a user will be able to do the following: 
* Guess a consonant
* Buy a vowel
* Solve the puzzle

Each time the user makes an incorrect guess of a letter (including both consonants and vowels), the number of guesses left to the user will be decremented. Any time the user makes a correct guess, their score will be increased. The user may continue playing the puzzle until either the player solves the puzzle or the user runs out of guesses. Whatever the outcome, the player's score will be recorded for future usage. In the event of the user running out of guesses, the record will store a value of 0 for the player's score. The user may exit an in progress puzzle at any time, but this will also result in a puzzle record with a score of 0. 

## 3.4 Creating a Tournament
Users may create their own tournaments within the GuessIt application. These tournaments will be available for other users of the same device to play and solve. A user will need to provide the following information to create a new tournament: 
* Specifying  1-5 puzzles that have been created or solved by the current user
* A tournament name

## 3.5 Playing a Tournament
Users may choose to start a new tournament or continue a previously created one. A user may play a tournament if the following conditions are met:
* The tournament was created by a different user
* The tournament contains at least one puzzle currently unsolved by the user

At any point, the user may elect to leave the current tournament. The puzzle that the user is currently solving will be exited following the rules specified above for exiting puzzles early. If there are additional unsolved puzzles in the tournament, the user will be able to continue the tournament the next time they select 'Play Tournament'.

## 3.6 Viewing Statistics
Upon completing some puzzles and tournaments, the user may become curious about the statistics recorded by the GuessIt application. The user may view records of puzzles tournaments in the following ways:
* The complete list of puzzles solved by the current user. Includes uncompleted puzzles with a score of 0.
* The complete list of tournaments completed by the current user. 
* For each puzzle the number of users who have played it and which user has the highest score for that puzzle. 
* For each tournament the number of users who have played it and which user has the highest score for that tournament. 



