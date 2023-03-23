<!-- omit in toc -->
# Developer Guide
<!-- omit in toc -->
## Table of contents

- [General Overview](#general-overview)
- [Design \& implementation](#design--implementation)
  - [UI class](#ui-class)
  - [Parser class](#parser-class)
  - [PC Class Architecture](#pc-class-architecture)
  - [Command class](#command-class)
    - [`list [COMPONENT]` Command (builder mode)](#list-component-command-builder-mode)
- [Appendix: Requirements](#appendix-requirements)
  - [Product scope](#product-scope)
    - [Target user profile](#target-user-profile)
    - [Value proposition](#value-proposition)
    - [Problem Addressed](#problem-addressed)
  - [User Stories](#user-stories)
  - [Non-Functional Requirements](#non-functional-requirements)
  - [Glossary](#glossary)
  - [Instructions for manual testing](#instructions-for-manual-testing)


## General Overview
below is the overall architecture diagram for how BigPP works.

![Architecture Diagram](uml-pictures/ArchitectureDiagram.png)

The program will first load the `UserJson` and files in the `Resources` folder to populate its internal memory of `PCLists` and `ComponentLists`. This will be stored in its `DataStorage`. The `User`'s interaction with the `UI` will be `parsed` into a `command` which would update the `DataStorage` and eventually update the `Menu` which is displayed back to the `User`. This would continue until the `User` exits the program, which would result in the data stored in `DataStorage` being saved into the `UserJson`.

## Design & implementation

### UI class
Below is the Class diagram for the UI class

![UI Class Diagram](uml-pictures/UIClassDiagram.png)

The class will first initialize its `UIState` to `PCVIEWER`. It will also initialize the `PCViewerMenu` class. `showWelcome` will print out the logos and welcome message. `updateUI` will call `printMenu` on `PCViewerMenu`  or `PCBuilderMenu` depending on the `UIState`. `setPCViewerMode` will update `UIState` to `PCVIEWER` and set `pcBuilderMenu` to null. `setPCBuilderMode` will update the `UIState` to `PCBuilder` and create a new instance of `PCBuilderMenu`. 

### Parser class
The UML class diagram shows the features of the Parser class:
![Parser Class Diagram](uml-pictures/ParserClass.png)
The purpose of the Parser class is to parse the user input into commands for execution. With reference to the diagram,
the Parser class does not have any attributes and only contains public methods for parsing of the user input.
The methods in the Parser class creates a subclass which inherits from the abstract superclass Command class. 
From the diagram, Command class has a private attribute named arguments which stores the user inputs as a String. The Command class
contains methods that help to set and retrieve the private attribute in the class. 
Overall, this class diagram provides an overview of the purpose of the Parser class.

### PC Class Architecture

![PC Class Diagram](uml-pictures/PcDiagram.png)

This UML class diagram shows the classes and their relationships in a computer system, which is represented by the `PC` class. The PC class has several attributes, including name, isPrebuilt, cpu, cpuCooler, gpu, motherboard, ram, storage, psu, chassis, and budget.

The `CPU`, `CPUCooler`, `GPU`, `Motherboard`, `RAM`, `Chassis`, `PSU` and `Storage` classes are components that can be used to build a `PC` object. Each component class has its own attributes and methods specific to that component.

The `Component` class is an abstract class that represents a generic computer component. It has attributes such as name, brand, and price, as well as methods to get and set those attributes.

The `PC` class has methods to set and get the components of a `PC` object, as well as methods to set and get the name, isPrebuilt, and budget attributes.

Overall, this class diagram provides a high-level overview of the components that make up a computer system and their relationships to each other.

### Command class
#### `list [COMPONENT]` Command (builder mode)
The `list [COMPONENT]` command prints out a formatted list of all available components of type `[COMPONENT]`.

When the user inputs a command of the form `list [COMPONENT]` in builder mode,
it is parsed by the `Parser.parseBuilderCommand` method which recognizes the first word as
`list` and creates a new `BuilderListComponentCommand` object while passing as argument the component
which was part of the command.

The `BuilderListComponentCommand.executeCommand()` method is then executed as part of the loop
inside `BigPP.runLoopUntilExit()`.

It first verifies:
- That the component argument is not empty. If it is then it throws a `BuilderMissingComponentException()`
- That the component given by the user exists in the database. If it doesn't then it throws a
  `BuilderMissingComponentException()`

It then uses the `stringToComponentListMap` HashMap from data storage to get the ComponentList associated
with the component string input by the user (e.g. `cpu`). The `stringToComponentListMap` HashMap is initialized and
filled when the program is first run using `DataStorage.initStringToComponentListMap()` and maps component names
(e.g. `cpu`) to their corresponding `ComponentList` object (e.g. an object of type `CPUList`).

The `ComponentList` class inherits from `ArrayList` but additionally implements the `getListString()` method which
returns a formatted list of all the components in the `ComponentList` object.

The `ComponentList` objects for each component are instantiated and populated in the `DataStorage.loadAll` method
by loading the data in `resources/COMPONENT_NAME.json` using the `GSON` library.

The program then checks if the user provided any flags to filter the output of the component command (e.g. by name,
brand, price, etc.). If they did, then the program filters out the components not meeting the provided flags and
creates a `ComponentList` containing all the components which do meet the provided flags.

The program then uses the `ComponentList.getListString()` method to get a formatted list of the components
of the desired type, which it then outputs to the user.

A UML sequence diagram showing the interactions between the different objects involved in handling this command can be
found below:

![List Component Command](./uml-pictures/listComponentCommand.png)


## Appendix: Requirements
### Product scope
#### Target user profile

{Describe the target user profile}

#### Value proposition

{Describe the value proposition: what problem does it solve?}

#### Problem Addressed

### User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list|

### Non-Functional Requirements

{Give non-functional requirements}

### Glossary

* *glossary item* - Definition

### Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
