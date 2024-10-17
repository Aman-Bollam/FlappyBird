# Flappy Bird (Java Version)

A Java-based recreation of the popular game *Flappy Bird*, developed as a solo assignment for the Advanced Object-Oriented Design (AOOD) course during the senior year of high school. The game utilizes object-oriented principles and Java Swing for the graphical user interface (GUI).

## Author

- [@amanbollam](https://github.com/Aman-Bollam)

## Features

- Classic Flappy Bird gameplay
- Simple, intuitive controls
- Obstacle generation with increasing difficulty
- Score tracking based on how far the player progresses
- Collision detection to determine game over

## Tech Stack

- **Java Swing**: For rendering the game UI
- **Java AWT**: For handling graphical components

## Installation

To run the project, you have two options:

### Option 1: Running the JAR File

1. Download the precompiled JAR file from the [releases](https://github.com/Aman-Bollam/FlappyBird/releases) section.
2. Run the JAR file using the following command:
```bash
java -jar FlappyBird.jar
```

### Option 2: Compiling from Source

1. Clone the repository:
```bash
git clone https://github.com/Aman-Bollam/FlappyBird.git
```
2. Navigate to the project directory:
```bash
cd FlappyBird
```
3. Compile and run the game:
```bash
javac src/*.java
java src.Main
```

## How to Play

1. Press the space bar to make the bird fly upwards.
2. Avoid hitting the pipes by timing your jumps correctly.
3. The game ends when the bird collides with a pipe or the ground.
