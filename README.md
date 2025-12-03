COMP2042 Coursework

This is my coursework project for COMP2042. I made a Tetris game using JavaFX and add some new features to make it better.

## Table of Contents
- [GitHub Repository](#github-repository)
- [Features](#features)
- [Compilation Instructions](#compilation-instructions)
- [How to Play](#how-to-play)
- [Project Structure](#project-structure)
- [Implemented and Working Properly](#implemented-and-working-properly)
- [New Java Classes](#new-java-classes)
- [Modified Java Classes](#modified-java-classes)
- [Testing](#testing)
- [Technologies Used](#technologies-used)

## GitHub Repository

My GitHub repository link: [https://github.com/yugu52599-sketch/CW2025](https://github.com/yugu52599-sketch/CW2025)

## Features

### Basic Game Functions
- Normal Tetris game with 7 types of blocks (I, J, L, O, S, T, Z)
- Can move and rotate the blocks
- When line is full, it will disappear and you get score
- Game over when blocks reach top
- Score will show on screen

### New Features I Added
1. **Ghost Piece** - You can see where the block will fall, it help you play better
2. **Pause Function** - Press 'P' key or click Pause button to pause game
3. **Hard Drop** - Press Space key to make block fall down immediately (you get more points: 2 points for each row)
4. **Fast Mode** - Hold Shift key to make block fall faster (4 times speed)
5. **Difficulty Levels** - I made 3 difficulty levels you can choose:
   - **Easy**: Block fall slower (600ms), good for beginners
   - **Normal**: Normal speed (400ms), this is default
   - **Hard**: Block fall very fast (200ms), for expert players
6. **Score Display** - Score always show on the screen

## Compilation Instructions

### What You Need
- **Java JDK**: Need Java 23 or newer version
- **JavaFX**: Version 21.0.6 (Maven will download automatically, don't worry)
- **Maven**: Version 3.8.5 or higher (I already include Maven wrapper in project)

### How to Build and Run

#### For Windows Users
```powershell
# First clean and compile
.\mvnw.cmd clean compile

# Run the game
.\mvnw.cmd javafx:run

# Run tests
.\mvnw.cmd test

### If You Only Want to Run Tests
```powershell
# Run all tests
.\mvnw.cmd test

# Run tests with less information
.\mvnw.cmd test -q
```

## How to Play

### Game Controls

#### Move the Block
- **Left Arrow** or **A** key: Move block to left
- **Right Arrow** or **D** key: Move block to right
- **Up Arrow** or **W** key: Rotate the block
- **Down Arrow** or **S** key: Make block fall faster (you get 1 point)

#### Special Controls
- **Space** key: Block fall to bottom immediately (you get 2 points for each row)
- **Shift** key (keep pressing): Block fall 4 times faster
- **P** key: Pause or continue the game
- **N** key: Start new game

#### Buttons on Screen
- **Pause Button**: Click to pause game (button become red when paused)
- **Easy/Normal/Hard Buttons**: Click to change difficulty (selected button will light up)

### How Score Works
- **Soft drop** (Press Down or S): Get 1 point for each row
- **Hard drop** (Press Space): Get 2 points for each row the block fall down
- **Clear lines**: Get bonus points when you clear lines (more lines = more points)

### About Difficulty
- **Easy**: Block fall slow (600ms between each step), good for practice
- **Normal**: Medium speed (400ms), this is the default difficulty
- **Hard**: Very fast (200ms), very difficult!

## Project Structure

Here is my project file structure:

```
CW2025-master/
├── src/
│   ├── main/
│   │   ├── java/com/comp2042/
│   │   │   ├── logic/bricks/          # All brick class here
│   │   │   │   ├── Brick.java         # Parent class for all bricks
│   │   │   │   ├── BrickGenerator.java
│   │   │   │   ├── RandomBrickGenerator.java
│   │   │   │   ├── IBrick.java        # I shape brick
│   │   │   │   ├── JBrick.java        # J shape brick
│   │   │   │   ├── LBrick.java        # L shape brick
│   │   │   │   ├── OBrick.java        # O shape (square) brick
│   │   │   │   ├── SBrick.java        # S shape brick
│   │   │   │   ├── TBrick.java        # T shape brick
│   │   │   │   └── ZBrick.java        # Z shape brick
│   │   │   ├── Board.java             # Board interface
│   │   │   ├── SimpleBoard.java       # Board class implementation
│   │   │   ├── GameController.java    # Control game logic
│   │   │   ├── GuiController.java     # Control UI
│   │   │   ├── Main.java              # Program start from here
│   │   │   ├── Position.java          # NEW: I create this class
│   │   │   ├── MatrixOperations.java  # Helper functions for matrix
│   │   │   ├── BrickRotator.java      # For rotating bricks
│   │   │   ├── Score.java             # Manage score
│   │   │   ├── InputEventListener.java
│   │   │   ├── GameOverPanel.java
│   │   │   ├── NotificationPanel.java
│   │   │   └── ... (other files)
│   │   └── resources/
│   │       ├── gameLayout.fxml        # UI layout file
│   │       ├── window_style.css       # CSS style
│   │       └── ... (pictures, fonts etc)
│   └── test/
│       └── java/com/comp2042/
│           ├── MatrixOperationsTest.java  # NEW: Test for MatrixOperations
│           └── SimpleBoardTest.java       # NEW: Test for SimpleBoard
├── pom.xml                            # Maven configuration
└── README.md                          # This file you are reading
```

## Implemented and Working Properly

### What I Successfully Made

1. **Ghost Piece System**
   - You can see a transparent block show where current block will land
   - It update when you move block
   - Very helpful to know where block will go

2. **Pause and Resume**
   - Can use P key or click button to pause
   - When pause, button turn red color
   - When paused, you cannot move block

3. **Hard Drop**
   - Press Space to make block fall to bottom immediately
   - You get bonus score (2 points for each row)
   - Block will lock immediately after drop

4. **Fast Mode**
   - Hold Shift key to make block fall 4 times faster
   - When you release Shift, speed go back to normal
   - Work with all difficulty levels

5. **Difficulty Selection**
   - I made 3 difficulty you can choose
   - Selected button will change color so you know which one
   - Difficulty will keep same even when you start new game

6. **Score Display**
   - Score always show on screen
   - Update immediately when you get point
   - Use same yellow color style like other game elements

### Code Improvements I Did

1. **Refactoring**
   - I create new `Position` class to replace `java.awt.Point` 
   - Make `SimpleBoard` better by hiding internal variables
   - Fix important bug in `MatrixOperations` (was using wrong array index)
   - Add defensive copy for position data

2. **Unit Tests**
   - I write 9 unit tests for important functions
   - 6 tests for `MatrixOperations` class
   - 3 tests for `SimpleBoard` class
   - All tests pass successfully (100%)

3. **Bug Fixing**
   - Fix bug in `MatrixOperations.intersect()` method (brick[j][i] should be brick[i][j])
   - Improve boundary check to prevent crash
   - Fix ghost block position calculation problem

## New Java Classes

These are new classes I created for this project:

### 1. `Position.java`

**What it does**:
- Store x and y coordinate for position
- Has `translate()` method to change position
- Has copy constructor for make copy of position
- More clear than using Point class from AWT

**Where to find**: `src/main/java/com/comp2042/Position.java`

### 2. `MatrixOperationsTest.java`
**Why I make this**: Need to test if MatrixOperations work correctly

**What it test**:
- Test if brick hit the board correctly
- Test if brick merge to background correctly
- Test if can detect which row should be removed
- Test if deep copy work properly
- Test if boundary check work
- Test some special cases

**Where to find**: `src/test/java/com/comp2042/MatrixOperationsTest.java`

**Test result**: 6 tests, all pass

### 3. `SimpleBoardTest.java`
**Why I make this**: Need to test if game board work correctly

**What it test**:
- Test if board initialize correctly
- Test if brick can move and detect collision
- Test if brick merge work correctly
- Test if game state manage correctly

**Where to find**: `src/test/java/com/comp2042/SimpleBoardTest.java`

**Test result**: 3 tests, all pass

## Modified Java Classes

These are classes I modified to add new features:

### 1. `SimpleBoard.java`
**What I changed**:
- Change from using `java.awt.Point` to my `Position` class
- Change variable name from `width`/`height` to `rows`/`cols` (more clear)
- Add `getOffset()` method that return copy of position (defensive copy)
- Add `getGhostViewData()` method to calculate where ghost piece should be
- Make internal variables more private (encapsulation)

**Why important**: Code is more maintainable now and less coupled

### 2. `MatrixOperations.java`
**What I changed**:
- **IMPORTANT BUG FIX**: Change `brick[j][i]` to `brick[i][j]` in `intersect()` method (this was big bug!)
- Make boundary check stronger in `checkOutOfBound()` method
- Add more null check to prevent crash
- Add more validation

**Why important**: Fix game breaking bug in collision detection

### 3. `GuiController.java`
**What I changed**:
- Add code to render ghost piece (transparent block)
- Add pause button handler and manage pause state
- Add hard drop function
- Add fast mode support (Shift key)
- Add difficulty selection handlers
- Connect scoreboard to show score
- Add visual effect when pause (button turn red)
- Improve keyboard event handling

**New methods I added**:
- `hardDrop()` - Handle when player press Space
- `togglePause()` - Handle pause and resume
- `setGameSpeed()` - Change game speed dynamically
- `setDifficulty()` - Manage difficulty level
- `setEasyDifficulty()`, `setNormalDifficulty()`, `setHardDifficulty()` - For difficulty buttons

**Why important**: This is where all new features work

### 4. `GameController.java`
**What I changed**:
- Add `getGhostView()` method to calculate ghost piece position
- Add `onHardDropEvent()` method with bonus point calculation
- Improve score calculation
- Improve how brick lifecycle is managed

**Why important**: Support ghost preview and hard drop features

### 5. `InputEventListener.java`
**What I changed**:
- Add `onHardDropEvent()` method to interface
- Extend event handling

**Why important**: Make hard drop feature work properly

### 6. `Board.java`
**What I changed**:
- Add `getGhostViewData()` method to interface
- Extend board interface

**Why important**: Define ghost preview at interface level

### 7. `gameLayout.fxml`
**What I changed**:
- Add `pauseButton` (ToggleButton)
- Add `scoreLabel` to show score
- Add difficulty buttons (`easyButton`, `normalButton`, `hardButton`)
- Update position for all new UI elements

**Why important**: Provide UI for all new features

### 8. `window_style.css`
**What I changed**:
- Add style for `.pause-button` and `.pause-button:selected`
- Add style for `.difficulty-button` and `.difficulty-button:hover`
- Make buttons look better

**Why important**: Make UI look nicer and give feedback to player

### 9. `Main.java`
**What I changed**:
- Make window maximize when game start
- Detect screen size better
- Better window setup

**Why important**: Better user experience with good window size

## Testing

### How to Run Tests
```powershell
.\mvnw.cmd test
```

### Test Results
- **Total number of tests**: 9
- **How many pass**: 9 (all pass, 100%)
- **Test files**: 2 files
  - `MatrixOperationsTest.java` (has 6 tests)
  - `SimpleBoardTest.java` (has 3 tests)

### What I Test
1. **Matrix Operations Tests**
   - Test if can detect brick hit board
   - Test if brick merge correctly
   - Test if can find which row to clear
   - Test if boundary check work

2. **Board Logic Tests**
   - Test if board create correctly
   - Test if brick can fall
   - Test if collision detection work

## Technologies Used

Here are the technologies I use in this project:

- **Programming Language**: Java 23
- **UI Framework**: JavaFX 21.0.6
- **Build Tool**: Maven 3.8.5
- **Testing Framework**: JUnit 5.12.1
- **Version Control**: Git and GitHub

## Some Notes

### What I Learn from Refactoring
1. **Use custom Position class instead of AWT**
2. **Fix matrix bug** - The array index was wrong (brick[j][i] should be brick[i][j]), this cause collision not work properly
3. **Better encapsulation** - I make variables more private and add defensive copy
4. **Add tests** - I write unit tests to make sure code work correctly

### How I Implement Features
1. For ghost preview, I use same brick rendering but make it transparent
2. For difficulty, it change the base speed, and fast mode multiply by 4
3. For hard drop, I calculate how far to ghost position and give bonus points
4. When pause, it stop all input except pause button and new game button

## About This Coursework

- **Course**: COMP2042 - Developing Maintainable Software
- **Project**: Tetris Game Enhancement
- **My Repository**: [https://github.com/yugu52599-sketch/CW2025](https://github.com/yugu52599-sketch/CW2025)

---

Last update: December 3, 2025