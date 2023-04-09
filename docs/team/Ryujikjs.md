# Ryuji Kow - Project Portfolio Page

## Overview

Hi I'm Ryuji Kow, an Aspiring Computer Engineer from National University Of Singapore, and I am currently enrolled in CS2113 where i am learning about Object Oriented Programming(OOP) in Java.

I have developed a product called Big PC Partpicker(BigPP) alongside my teammates and my summary of contributions to the team project Big PC Partpicker are as shown below

### Summary of Contributions
[Code Contributed](https://nus-cs2113-ay2223s2.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2023-02-17&tabOpen=true&tabType=authorship&tabAuthor=Ryujikjs&tabRepo=AY2223S2-CS2113-T12-2%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)

### Enhancements implemented:
  - `select COMPONENT_TYPE COMPONENT_INDEX` command 
    - Added functionality to select a component for the PC build in builder mode.
    - Had to handle various exceptions such as invalid components and invalid index inputs.
    - Had to make sure that selected component was successfully added to the PC object and properly displayed
  - `unselect COMPONENT_TYPE` command for builder mode to unselect a component for the PC build
    - Added functionality to unselect a component for the PC build in builder mode.
    - Had to handle various exceptions such as invalid component input.
    - Had to make sure that unselected component was successfully removed from the PC object and replaced with null.
  - `compare COMPONENT_TYPE INDEX_1 & INDEX_2` command for builder mode to compare the specifications of 2 components of the same type
    - Added functionality to compare 2 components in builder mode.
    - Had to make individual command classes for comparison within each component type, this was done to ensure code readability and also because a single command class to handle all comparisons would be too lengthy and unreadable.
    - Each individual command class has to handle various exceptions suchs as invalid components, invalid index, and also invalid command structure.
    - Each table of comparison had to be formatted individually to compare the specifications unique to each component.
  

### Contributions to the UG:
  -  `select COMPONENT_TYPE COMONENT_INDEX` command guide
     -  Detailed instructions on how to use the command along with an example code.
  - `unselect COMPONENT_TYPE` command guide
    - Detailed instructions on how to use the command along with an example code.
  - `compare COMPONENT_TYPE INDEX_1 & INDEX_2` command guide
    - Detailed instructions on how to use the command along with an example code.
  - Glossary 
  - Parameter Glossary
    - Format table for glossary to include all parameters used, explanation of the parameter, type(e.g. string\integer) and also examples of the parameter
    - Also included all possible inputs for certain parameters that have limited acceptable inputs.
  - Command Glossary
    - Format table to show commands, and command format along with all possible flags that can be used with those commands
  - Acceptable Custom Component Commands
    - Show all custom commands and the parameters that need to be specified
    
### Contributions to the DG:
  - `PC` Class Diagram
    - Overview of the PC class architecture with diagram for visualisation
  - User Stories
    - v1.0 and v2.0 user stories for different users 
  - Non-functional Requirements
  - Instructions for Manual Testing
    - Detailed and step-by-step instructions for user to test our application
