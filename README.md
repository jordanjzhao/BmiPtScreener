# BMI Patient Screener

BMI Screener aims to provide a solution to patient monitoring 
during follow-up visits by calculating and 
flagging concerning body mass index (BMI) interpretations. This app is 
designed to provide medical health professionals a screening log 
for their patients. 

This project is of interest as it would be a readily accessible tool
that could provide valuable source documentation
and raise awareness to the potential risks of 
cardiovascular disease (CVD). Higher BMI categories
and overweight is found to be associated with 
increased risk of developing CVD at an earlier age (Khan et al.)

*BMI Score Interpretations* <br />
| BMI | Weight Status | 
 --- | --- 
| Below 18.5 | Underweight |
| 18.5 - 24.9 | Healthy Weight |
| 25.0 - 29.9 | Overweight |
| 30.0 and Above | Obesity |

## Functionality

*Tasks:*
- Create a patient screen log to add patients seen
- Read new patients into the log with a calculated BMI score
- Update patient values and produce new calculation per each follow-up visit (under construction)
- Delete patients who are no longer being followed

## User Stories

*Specific outcomes:*
- As a user, I want to be able to add a new patient, calculate their BMI, and add them the screen log
- As a user, I want to be able to select a patient and view the BMI score logged for that patient
- As a user, I want to be able to view a user-friendly log of all the screened patients and their logged scores
- As a user, I want to be able to remove a patient that is no longer being followed-up from the screen log
- As a user, I want to be able to pull a single log of all patients screened for export
- As a user, I want to be able to save my BMI patient list to file
- As a user, I want to be able to load my BMI patient list from file

*GUI Implementation:*
- Include a panel in which all the patients added to the patient list are displayed
- Two related events related to the patients and patient list
  - option to add another patient
  - option remove a patient button
  - display and select patient on click
- Option to save and load
  - option to save/load patient screen log data
- Visual Component
  - displaying splash screen gif on app start
  - displaying an image and confirmation on confirmation of button click event

*Phase 4: Task 2* 

Wed Mar 30 15:34:35 PDT 2022
Patient Jordan Zhao added to screen log.

Wed Mar 30 15:34:35 PDT 2022
Patient Candy added to screen log.

Wed Mar 30 15:34:35 PDT 2022
Patient Shaquille O'Neal added to screen log.

Wed Mar 30 15:34:35 PDT 2022
Patient Luka Dončić added to screen log.

Wed Mar 30 15:34:35 PDT 2022
Patient Boban Marjanović added to screen log.

Wed Mar 30 15:34:35 PDT 2022
Patient Zion Williamson added to screen log.

Wed Mar 30 15:34:35 PDT 2022
Patient Giannis Antetokounmpo added to screen log.

Wed Mar 30 15:34:35 PDT 2022
Patient Kobe Bryant added to screen log.

Wed Mar 30 15:34:35 PDT 2022
Patient Nikola Jokić added to screen log.

Wed Mar 30 15:34:35 PDT 2022
Patient Rudy Gobert added to screen log.

Wed Mar 30 15:34:35 PDT 2022
Patient Ja Morant added to screen log.

Wed Mar 30 15:34:35 PDT 2022
Patient Devin Booker added to screen log.

Wed Mar 30 15:34:35 PDT 2022
Patient LeBron James added to screen log.

Wed Mar 30 15:34:35 PDT 2022
Patient Dirk Nowitzki added to screen log.

Wed Mar 30 15:34:35 PDT 2022
Patient Allen Iverson added to screen log.

Wed Mar 30 15:34:35 PDT 2022
Patient Damian Lillard added to screen log.

Wed Mar 30 15:34:35 PDT 2022
Patient Stephen Curry added to screen log.

Wed Mar 30 15:34:35 PDT 2022
Patient Zach LaVine added to screen log.

Wed Mar 30 15:34:35 PDT 2022
Patient jz added to screen log.

Wed Mar 30 15:34:44 PDT 2022
Patient jz removed from screen log.

Wed Mar 30 15:34:46 PDT 2022
Patient Zach LaVine removed from screen log.

*Phase 4: Task 3*
- Reflection on the UML design layout produced:
- refactor BmiAppGui such to separate functionality of responsibilities required to build GUI
- make separate classes to handle GUI Panels, buttons, layout, images, etc.
- implementation of Observer pattern such that the Screen Log can update on changes via addition/removal of patients

## Programming 

*Purpose:*
- Design and develop a functional program using Java (IntelliJ)
- Incorporate testing with the use of JUnit
- Implementation GUI with the use of JSwing

## Works Cited

Khan, Sadiya S., et al. "Association of Body Mass Index with Lifetime <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Risk of Cardiovascular Disease and Compression of Morbidity."<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*JAMA Cardiology*, vol. 3, no. 4, 2018, p. 280., <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;https://doi.org/10.1001/jamacardio.2018.0022.

