# Gaussian Elimination Solver

This Java project provides an implementation of Gaussian elimination for solving systems of linear equations.

## Table of Contents
- [Overview](#overview)
- [Usage](#usage)
- [Getting Started](#getting-started)
- [Testing](#testing)
- [Contributing](#contributing)

## Overview

The project consists of two main classes: `GaussianElimination` and `EquationSolver`. `GaussianElimination` contains the core logic for performing Gaussian elimination and back substitution, while `EquationSolver` is a simple command-line application for solving linear equations.

## Usage

To use the equation solver, provide the coefficients of the linear equations as command-line arguments. For example:

javac linear/EquationSolver.java to compile the file
java linear.EquationSolver.java  2,3,5,8 1,2,3,5 4,6,8,12 to run the program
This will solve the system of equations represented by the matrix:

2x + 3y + 5z = 8

1x + 2y + 3z = 5

4x + 6y + 8z = 12

The result will be printed to the console.

## Getting Started
Clone the repository:
git clone https://github.com/your-username/gaussian-elimination-solver.git

To run the tests:
Run compile.bat

## Testing
The project includes both structural and functional tests using JUnit. These tests ensure the correctness of the implementation and help catch any regressions.

To run the tests, follow the instructions in the "Getting Started" section.

Contributing
If you'd like to contribute to the project, please fork the repository, make your changes, and submit a pull request. Ensure that your code passes all existing tests and consider adding new tests for any additional functionality.
