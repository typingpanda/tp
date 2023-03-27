<!-- omit in toc -->
# User Guide
<!-- omit in toc -->
## Table of contents
- [Introduction](#introduction)
- [Getting Started](#getting-started)
- [Commands](#commands)
  - [In PCViewer Mode](#in-pcviewer-mode)
    - [`add PC_NAME`](#add-pc_name)
    - [`view PC_INDEX`](#view-pc_index)
    - [`edit PC_INDEX`](#edit-pc_index)
    - [`delete PC_INDEX`](#delete-pc_index)
    - [`bye`](#bye)
  - [In PCBuilder Mode](#in-pcbuilder-mode)
    - [`list COMPONENT_TYPE`](#list-component_type)
    - [`select COMPONENT_TYPE INDEX`](#select-component_type-index)
    - [`budget INTEGER`](#budget-integer)
    - [`name NEW_NAME`](#name-new_name)
    - [`back`](#back)
- [Additional Features](#additional-features)
  - [Compatibility Check](#compatibility-check)
  - [Glossary](#glossary)

## Introduction

Welcome to Big PC Part-Picker (BigPP)
BigPP is a command-line application designed for PC enthusiasts and professional PC builders who aim to:

 - streamline the [process](#commands) of managing computer builds 
 - verify the [compatibility](#compatibility-check) of selected components.

This developer-oriented guide offers a comprehensive overview of the various commands and features available in BigPP. It is intended for users who are familiar with command-line interfaces.
If you encounter unfamiliar terminology in this guide, please refer to the [Glossary](#glossary) for a list of terms and their definitions, or consult a search engine or even ask ChatGPT.
Text formatted like `this` represents commands that can be entered into the command line or output displayed in the terminal.

## Getting Started

1. Install [Java 11](https://www.oracle.com/java/technologies/downloads/#java11) for your operating system. If you are unsure about how to do this, you can refer to the [Java installation guide](https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html) or consult a search engine.
2. Download the latest version of `BigPP` from 
[the releases page](https://github.com/AY2223S2-CS2113-T12-2/tp/releases).
3. Copy the file to an empty folder you want to use as the _home folder_ This will be the folder in which BigPP will store all of its user data.
4. Right click inside the _home folder_ and open a terminal at that location
5. Run the command `java -jar BigPP.jar` to start the app.
6. Refer to the [Commands](#Commands) below to try out the application!


Upon successful initialization of the program for the first time, you would be greeted by the following, assuming you do not currently have a user.json file in your _home folder_
```
User file does not exist. Creating new user file.
User PCs found, loading...
          _____                    _____                    _____                            _____                    _____
         /\    \                  /\    \                  /\    \                          /\    \                  /\    \
        /::\    \                /::\    \                /::\    \                        /::\    \                /::\    \        
       /::::\    \               \:::\    \              /::::\    \                      /::::\    \              /::::\    \       
      /::::::\    \               \:::\    \            /::::::\    \                    /::::::\    \            /::::::\    \      
     /:::/\:::\    \               \:::\    \          /:::/\:::\    \                  /:::/\:::\    \          /:::/\:::\    \     
    /:::/__\:::\    \               \:::\    \        /:::/  \:::\    \                /:::/__\:::\    \        /:::/__\:::\    \    
   /::::\   \:::\    \              /::::\    \      /:::/    \:::\    \              /::::\   \:::\    \      /::::\   \:::\    \   
  /::::::\   \:::\    \    ____    /::::::\    \    /:::/    / \:::\    \            /::::::\   \:::\    \    /::::::\   \:::\    \  
 /:::/\:::\   \:::\ ___\  /\   \  /:::/\:::\    \  /:::/    /   \:::\ ___\          /:::/\:::\   \:::\____\  /:::/\:::\   \:::\____\ 
/:::/__\:::\   \:::|    |/::\   \/:::/  \:::\____\/:::/____/  ___\:::|    |        /:::/  \:::\   \:::|    |/:::/  \:::\   \:::|    |
\:::\   \:::\  /:::|____|\:::\  /:::/    \::/    /\:::\    \ /\  /:::|____|        \::/    \:::\  /:::|____|\::/    \:::\  /:::|____|
 \:::\   \:::\/:::/    /  \:::\/:::/    / \/____/  \:::\    /::\ \::/    /          \/_____/\:::\/:::/    /  \/_____/\:::\/:::/    / 
  \:::\   \::::::/    /    \::::::/    /            \:::\   \:::\ \/____/                    \::::::/    /            \::::::/    /  
   \:::\   \::::/    /      \::::/____/              \:::\   \:::\____\                       \::::/    /              \::::/    /   
    \:::\  /:::/    /        \:::\    \               \:::\  /:::/    /                        \::/____/                \::/____/    
     \:::\/:::/    /          \:::\    \               \:::\/:::/    /                          ~~                       ~~
      \::::::/    /            \:::\    \               \::::::/    /
       \::::/    /              \:::\____\               \::::/    /
        \::/____/                \::/    /                \::/____/
         ~~                       \/____/


Welcome to BigPP!
===================================================
PC viewer
Here is the list of PC Builds:
1.Prebuilt-PC: [beginner] - $813.29/infinite - Complete
2.Prebuilt-PC: [intermediate] - $1499.36/infinite - Complete
3.Prebuilt-PC: [advanced] - $2149.75/infinite - Complete
What would you like to do?
===================================================

```

## Commands

### In PCViewer Mode
#### `add PC_NAME`
**Functionality:** Adds a PC with the name `PC_NAME` to your PC list

#### `view PC_INDEX`
**Functionality:** Views the PC with index `PC_INDEX`

#### `edit PC_INDEX`
**Functionality:** Enters PCBuilder mode for the PC with index `PC_INDEX`

#### `delete PC_INDEX`
**Functionality:** Deletes the PC with index `PC_INDEX`

#### `bye`
**Functionality:** Exits the application

### In PCBuilder Mode
#### `list COMPONENT_TYPE`
**Functionality:** Lists all components of type `COMPONENT_TYPE`

#### `select COMPONENT_TYPE INDEX`
**Functionality:** Adds the component of type `COMPONENT_TYPE` with index `INDEX` to the current PC Build

#### `budget INTEGER`
**Functionality:** Sets the budget of the current PC build to `INTEGER`

#### `name NEW_NAME`
**Functionality:** Sets the name of the current PC build to `NEW_NAME`

#### `back`
**Functionality:** Goes back to PCViewer menu

## Additional Features

### Compatibility Check
`Coming soon`


### Glossary