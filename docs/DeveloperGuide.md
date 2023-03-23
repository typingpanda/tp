<!-- omit in toc -->
# Developer Guide

## Table of contents

- [Table of contents](#table-of-contents)
- [General Overview](#general-overview)
- [Design \& implementation](#design--implementation)
  - [PC Class Architecture](#pc-class-architecture)
  - [Placeholder 2](#placeholder-2)
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

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}



### PC Class Architecture

![PC Class Diagram](uml-pictures/PcDiagram.png)

This UML class diagram shows the classes and their relationships in a computer system, which is represented by the PC class. The PC class has several attributes, including name, isPrebuilt, cpu, cpuCooler, gpu, motherboard, ram, storage, psu, chassis, and budget.

The CPU, CPUCooler, GPU, Motherboard, RAM, Chassis, PSU and Storage classes are components that can be used to build a PC object. Each component class has its own attributes and methods specific to that component.

The Component class is an abstract class that represents a generic computer component. It has attributes such as name, brand, and price, as well as methods to get and set those attributes.

The PC class has methods to set and get the components of a PC object, as well as methods to set and get the name, isPrebuilt, and budget attributes.

Overall, this class diagram provides a high-level overview of the components that make up a computer system and their relationships to each other.


### Placeholder 2

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
