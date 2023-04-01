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
    - [`filter -name PC_NAME -price /from PC_START_COST /to PC_END_COST -built PC_isComplete`](#filter--name-pc_name--cost-from-pc_start_cost-to-pc_end_cost--built-pc_iscomplete)
  - [In PCBuilder Mode](#in-pcbuilder-mode)
    - [`list COMPONENT_TYPE [-COMPONENT_FLAG FLAG]`](#list-component_type--component_flag-flag)
    - [`select COMPONENT_TYPE INDEX`](#select-component_type-index)
    - [`unselect COMPONENT_TYPE`](#unselect-component_type)
    - [`compare COMPONENT_TYPE INDEX_1 & INDEX_2`](#compare-component_type-index_1--index_2)
    - [`budget INTEGER`](#budget-integer)
    - [`name NEW_NAME`](#name-new_name)
    - [`custom COMPONENT_TYPE SPEC_1,SPEC_2, ...`](#custom-component_type-spec_1spec_2-)
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
If the ASCII art of BIG PP does not look correct, it is due to your terminal size being too small, if so you can disregard this issue.

## Commands
Our commands are split up for two modes, PCViewer and PCBuilder. The commands for each mode will only be recognised for the specific mode that you are currently in. The modes will specifically be stated at the top of each printout in the terminal. 

For reference,
 - PCViewer looks like this:
```
===================================================
PC viewer
Here is the list of PC Builds:
1.Prebuilt-PC: [beginner] - $917.28/infinite - Complete
2.Prebuilt-PC: [intermediate] - $1710.74/infinite - Complete
3.Prebuilt-PC: [expert] - $2339.74/infinite - Complete
What would you like to do?
===================================================
```
 - PCBuilder looks like this
```
===================================================
PC builder
Custom-PC: [expert (copy)] - $2339.74/infinite - Complete
Components:
CPU        : AMD Ryzen 9 7950X
CPU Cooler : Cooler Master MASTERLIQUID ML120L RGB V2
GPU        : MSI GAMING Z TRIO RTX3080
Motherboard: Gigabyte B650I AORUS ULTRA
RAM        : Corsair Vengeance RGB Pro 32 GB
Storage    : Samsung 980 Pro
PSU        : SeaSonic FOCUS PLUS 850 Gold
Chassis    : Corsair iCUE 4000X RGB

What would you like to do?
===================================================
```
---
### Common Commands
Common commands will be the commands that the user will be able to use in both the modes

#### **Bye command**
Usage: `bye`
Functionality: Exits the application and saves all user data that has currently been changed since the opening of the application

<span style="color:red">**IMPORTANT:** the user MUST execute this command to save the data that has been edited, if the user decides to end the program using ctrl+c or other methods, their edited data would be lost!</span> 

#### **Help command**
Usage: `help`
Functionality: Displays the valid commands in the respective modes
Example:
 - Entering the help command in the PCViewer mode will show the following output:
```
Here are the list of valid commands: 
Add <name> - Add a new PC of a given name 
Delete <index> -  Delete the PC of a given index 
Edit <index> - Edit the PC of a given index 
View <index> - Display all the components of the PC of a given index 
```

 - Entering the help command in the PCBuilder mode will show the following output:
```
Here are the list of valid commands: 
list <component> - List all components of a certain type
name <new_name> - Change the name of the PC currently being edited to <new_name>
budget <new_budget> - Change the budget of the PC currently being edited to <new_budget> 
select <component_type> <index> -  Add the component of type <component_type> with index <index> to the PC currently being edited 
info <component_type> - View all the specifications of the component of type <component_type> currently selected for the build
unselect <component_type> - Remove the component of type <component_type> from the PC currently beingedited
custom <component_type> <component_specifications...> - Creates a custom component of type <component_type> with all the <component_specifications> and adds it to the list of components of that type
compare <component_type> <index_1>&<index_2> Compares all the specifications between the components oftype <component_type> with indices <index_1> and <index_2>
```
Notes: Entering the help command in either PCViewer mode or PCBuilder mode will present different sets of valid commands

---
### PCViewer Mode Commands
PCViewer Mode commands will be the commands that the user will be able to use in the PCViewer Mode

#### **Add command**
Usage: `add PC_NAME`
Functionality: Adds a PC with the name `PC_NAME` to your PC list
Example:
```
===================================================
PC viewer
Here is the list of PC Builds:
1.Prebuilt-PC: [beginner] - $917.28/infinite - Complete
2.Prebuilt-PC: [intermediate] - $1710.74/infinite - Complete
3.Prebuilt-PC: [expert] - $2339.74/infinite - Complete
4.Custom-PC: [NEWPC] - $0.0/infinite - Incomplete
What would you like to do?
===================================================
Custom PC: [ NEWPC ] has been created
```
Notes: newly added PCs will always begin with infinite budget

#### View command
Usage: `view PC_INDEX`
Functionality: Views the PC with index `PC_INDEX`
Example:

#### Edit command
Usage: `edit PC_INDEX`
Functionality: Enters PCBuilder mode for the PC with index `PC_INDEX`. If the PC that the user has selected to edit is a **prebuilt PC**, the application would create a copy of it and mark it as a **custom PC**. This is we provide the prebuilts as a reference for the user.

#### Delete command
Usage: `delete PC_INDEX`
Functionality: Deletes the PC with index `PC_INDEX`

#### Filter command
Usage: `filter FLAGS`

Available flags:
 - `-name PC_NAME`
 - `-price /from PC_START_COST /to PC_END_COST`
 - `-built PC_ISCOMPLETE`
 - `-clear`

Functionality:
 - Filter u `-name PC_NAME` to filter the PC List by the given name

Example: filter the PC List by the name of intermediate, in the range of starting price from 1000 to 3000 and is a completed build
```
input: filter -name intermediate -price /from 1000 /to 3000 -built complete

output:

===================================================
PC viewer
Here is the list of PC Builds:
2.Prebuilt-PC: [intermediate] - $1499.36/infinite - Complete
What would you like to do?
===================================================
Filter completed
```
Notes: 
#### `filter -clear`
Functionality: Clears all filters and shows all PCs currently in the list
Example:

---
### PCBuilder Mode Commands
PCBuilder Mode commands will be the commands that the user will be able to use in the PCBuilder Mode

#### List command
Usage: `list COMPONENT_TYPE [-COMPONENT_FLAG FLAG]`
Functionality: Lists all components of type `COMPONENT_TYPE` with optional flags. These are the following common flags `-name`, `-brand` and `-price` for all components. Flags that are unique to each components can be used too, such as `-power`, `-formfactor`, `socket`, `-core`, `-thread`, `-baseclock`, `-boostclock`, `-size`, `-rpm`, `-noise`, `memory`, `-sticks`, `-speed`, `-type` and `-efficiency`. Noise, power, rpm, price, boostclock and baseclock requires an input range by using /from and /to flags. Multiple flags can be used together.

Example:
```
input: list cpu -name intel -price /from 1 /to 100

output:
Here are all available components of type 'cpu':
meeting the following criteria:
name: intel
price: 1 to 100
1.
NAME: Intel core i3-10100
BRAND: Intel
PRICE: 99.5
CORES: 4
THREADS: 8
BASECLOCK: 3.6
BOOSTCLOCK: 4.3
POWER: 65.0
SOCKET: LGA1200
================
```

Notes: Arguments with missing flags will be ignored.

#### Select command
Usage: `select COMPONENT_TYPE INDEX`
Functionality: Adds the component of type `COMPONENT_TYPE` with index `INDEX` to the current PC Build

Example: add component of type `GPU` with index `4` to the current PC Build.
```
input: select gpu 4

output:

===================================================
PC builder
Custom-PC: [pc] - $934.06/infinite - Incomplete
Components:
CPU        : - Not Selected -
CPU Cooler : - Not Selected -
GPU        : MSI GAMING Z TRIO RTX3080
Motherboard: - Not Selected -
RAM        : - Not Selected -
Storage    : - Not Selected -
PSU        : - Not Selected -
Chassis    : - Not Selected -

```

#### Unselect command
Usage: `unselect COMPONENT_TYPE`
Functionality: Removes the component of type `COMPONENT_TYPE` from your PC Build.

Example: remove compoennt of type `GPU` from the current PC Build.
```
Previous PC compoenent list:
===================================================
PC builder
Custom-PC: [pc] - $934.06/infinite - Incomplete
Components:
CPU        : - Not Selected -
CPU Cooler : - Not Selected -
GPU        : MSI GAMING Z TRIO RTX3080
Motherboard: - Not Selected -
RAM        : - Not Selected -
Storage    : - Not Selected -
PSU        : - Not Selected -
Chassis    : - Not Selected -
```
```
input: unselect gpu

output:

===================================================
PC builder
Custom-PC: [pc] - $0.0/infinite - Incomplete
Components:
CPU        : - Not Selected -
CPU Cooler : - Not Selected -
GPU        : - Not Selected -
Motherboard: - Not Selected -
RAM        : - Not Selected -
Storage    : - Not Selected -
PSU        : - Not Selected -
Chassis    : - Not Selected -

```

#### Compare command
Usage: `compare COMPONENT_TYPE INDEX_1 & INDEX_2`
Functionality: Compares 2 components,`INDEX_1` and `INDEX_2` of type `COMPONENT_TYPE` with one another. Compares each specification in a table format

Example: Compare 2 components of type `CPU`. Comparison between indexes `1` and `2`.
```
input: compare cpu 1 & 2

output:
________________________________________________________________________________________________
|NAME        |Intel core i3-10100                     |Intel core i5-10600k                    |
|------------|----------------------------------------|----------------------------------------|
|PRICE       |$99.5                                   |$182.47                                 |
|SOCKET      |LGA1200                                 |LGA1200                                 |
|CORES       |4                                       |6                                       |
|THREADS     |8                                       |12                                      |
|BASE CLOCK  |3.6GHz                                  |4.1GHz                                  |
|BOOST CLOCK |4.3GHz                                  |4.8GHz                                  |
|POWER       |65.0W                                   |125.0W                                  |
________________________________________________________________________________________________

```



#### Budget command
Usage: `budget INTEGER`
Functionality: Sets the budget of the current PC build to `INTEGER`

Example Set budget of Prebuilt-PC [Beginner] to be $1000
```
input: budget 1000

output: 
===================================================
PC builder
Custom-PC: [beginner (copy)] - $813.29/$1000.00 - Complete
Components:
CPU        : Intel core i3-10100
CPU Cooler : Thermalright AXP90-X36
GPU        : Gigabyte GAMING OC RTX3050
Motherboard: Asus Prime Z590-P WiFi
RAM        : Kingston FURY Beast 16 GB
Storage    : ADATA XPG SPECTRIX S40G RGB
PSU        : SeaSonic FOCUS PLUS 850 Gold
Chassis    : Fractal Design Pop XL Air

What would you like to do?
===================================================
Current build budget is now: $1000.00

```

#### Name command
Usage: `name NEW_NAME`
Functionality: Sets the name of the current PC build to `NEW_NAME`

Example Set the name of Prebuilt-PC [Beginner] to be MyPC
```
input: name MyPC

output: 
===================================================
PC builder
Custom-PC: [MyPc] - $813.29/$1000.00 - Complete
Components:
CPU        : Intel core i3-10100
CPU Cooler : Thermalright AXP90-X36
GPU        : Gigabyte GAMING OC RTX3050
Motherboard: Asus Prime Z590-P WiFi
RAM        : Kingston FURY Beast 16 GB
Storage    : ADATA XPG SPECTRIX S40G RGB
PSU        : SeaSonic FOCUS PLUS 850 Gold
Chassis    : Fractal Design Pop XL Air

What would you like to do?
===================================================
Current build name is now: MyPc
```

#### Custom command
Usage: `custom COMPONENT_TYPE SPEC_1|SPEC_2|...`
Functionality: Adds a custom component of type COMPONENT_TYPE with the specs SPEC_1, SPEC_2, ... to the current PC build
```
input: custom cpu Intel-new-cpu|Intel|99.5|4|8|3.5|4.6|122|LGA1200

output:
===================================================
PC builder
Custom-PC: [pc-1] - $99.5/infinite - Incomplete
Components:
CPU        : Intel-new-cpu
CPU Cooler : - Not Selected -
GPU        : - Not Selected -
Motherboard: - Not Selected -
RAM        : - Not Selected -
Storage    : - Not Selected -
PSU        : - Not Selected -
Chassis    : - Not Selected -

What would you like to do?
===================================================
CPU added: Intel-new-cpu
```

#### `back`
Functionality: Goes back to PCViewer menu


## Additional Features

### Compatibility Check
BigPP will check if your components that you added are compatible with each other.

If your chassis is mini size but you want to use an atx size gpu, it will result in an incompatibility error and suggest changes to you.

If your total items have power that exceeds 80% of your power supply rated power, it will result in incompatibility errors.

if your the item you want to add exceeds your total budget, it will not allow you to add the component.

If your CPU has a different socket than your Motherboard or vice versa, it will not allow you to add it.


### Glossary
