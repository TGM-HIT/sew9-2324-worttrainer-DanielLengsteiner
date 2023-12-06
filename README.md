# Worttrainer

## Overview

### Purpose

This application is a vocabulary trainer for children just learning the language. 
It focuses on image recognition; The correct word has to be typed in to progres in the program. 
The trainer tells the user the number of their correct and incorrect guesses while they progress.
The user may save and load their progress.

### Start of application

When executing the application, the user is first prompted with entering the path to a save file.
This also happens when the user never started the application before.
When first starting a program or when the user wants to create a new one, 
this step can be skipped with a simple press on the Escape-key without any input. 
This will start a brand-new program.

When pressing Enter while in that window, the application will look for the specified file.
If no file has been found, the application will also start a brand-new program.

### End of application

When entering no input while in the training program, the program will close, again asking
for a location to save the progress. If nothing is specified, the progress will be saved
to the standard location (being the folder the application is running in). 

WARNING: When pressing Escape, the game is aborted and no progres is saved.

### Additional info

**IMPORTANT**: Pressing enter with no input is **NOT** the same as pressing Escape or the Cancel-button.
Pressing enter with an empty input still counts as input, while pressing Escape or the Cancel-button counts as no input.

When stuck at a specific word during the program, the application will stay at that 
word until guessed correctly. If a typo exists, feel free to create an issue.

## Documentation

Sources I used for tasks I did not know on the top of my head. 
Useful for those who want to implement an application with gradle and JSON
and don't know where to start.

Automated Gradle-Tasks in GitHub via Actions: 
- <https://docs.gradle.org/current/userguide/github-actions.html>

JSON in Java: 
- Usage: <https://www.baeldung.com/java-org-json>
- Package versions: <https://mvnrepository.com/artifact/org.json/json>
- Saving JSON to file (WARNING: Source is about json-simple, not json): <https://crunchify.com/how-to-write-json-object-to-file-in-java/>
- Reading JSON to file (WARNING: Initialisation of InputStream has to be changed with `FileInputStream()`): <https://kodejava.org/how-do-i-read-json-file-using-json-java-org-json-library/>
