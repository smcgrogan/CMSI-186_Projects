/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * filename: ClockSolverTestHarness<br />
 * @author : Summer McGrogan
 * @since  : 2020-04-19
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
@echo off
@del testresults.txt

@echo Testing args = '10:10:59'
@echo ...should output *o*o, *o*o, ***o**
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing args = '10:10:59'                                                      >> testresults.txt
echo ...should output output *o*o, *o*o, ***o**                                     >> testresults.txt
echo ============================================================================   >> testresults.txt
@java BinaryClockSolver 10:10:10

@echo Testing args = '23:30:10'
@echo ...should output o*o***, o****o, *o*o
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing args = '10:10:59'                                                      >> testresults.txt
echo ...should output o*o***, o****o, *o*o                                            >> testresults.txt
echo ============================================================================   >> testresults.txt
@java BinaryClockSolver 23:30:10

@echo Testing args = '05:45:13'
@echo ...should output *o*, ****o, *o*o
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing args = '05:45:13'                                                      >> testresults.txt
echo ...should output *o***, *o**o*, **o*                                           >> testresults.txt
echo ============================================================================   >> testresults.txt
@java BinaryClockSolver 05:45:13

@echo Testing args = '20:20:20'
@echo ...should output o*o*oo, o*o*oo, o*o*oo
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing args = '20:20:20'                                                      >> testresults.txt
echo ...should output o*o*oo, o*o*oo, o*o*oo                                           >> testresults.txt
echo ============================================================================   >> testresults.txt
@java BinaryClockSolver 20:20:20

@echo Testing args = '23:23:23'
@echo ...should output o*o***, o*o***, o*o***
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing args = '23:23:23'                                                      >> testresults.txt
echo ...should output o*o***, o*o***, o*o***                                           >> testresults.txt
echo ============================================================================   >> testresults.txt
@java BinaryClockSolver 23:23:23

@echo Testing args = '03:29:34'
@echo ...should output **, o***o*, *ooo*o
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing args = '03:29:34'                                                      >> testresults.txt
echo ...should output **, o***o*, *ooo*o                                            >> testresults.txt
echo ============================================================================   >> testresults.txt
@java BinaryClockSolver 03:29:34

@echo Testing args = '22:50:28'
@echo ...should output o*o**o, **oo*o, **oo*o
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing args = '22:50:28'                                                      >> testresults.txt
echo ...should output o*o**o, **oo*o, **oo*o                                        >> testresults.txt
echo ============================================================================   >> testresults.txt
@java BinaryClockSolver 22:50:28

@echo Testing args = '01:15:38'
@echo ...should output *, ****, *oo**o
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing args = '01:15:38'                                                      >> testresults.txt
echo ...should output *, ****, *oo**o                                               >> testresults.txt
echo ============================================================================   >> testresults.txt
@java BinaryClockSolver 01:15:38

@echo Testing args = '04:56:17'
@echo ...should output *oo, ***ooo, o*ooo*
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing args = '04:56:17'                                                      >> testresults.txt
echo ...should output *oo, ***ooo, o*ooo*                                           >> testresults.txt
echo ============================================================================   >> testresults.txt
@java BinaryClockSolver 04:56:17

echo Testing args = '07:13:29'
@echo ...should output ***, **o*, o***o*
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing args = '07:13:29'                                                      >> testresults.txt
echo ...should output ***, **o*, o***o*                                             >> testresults.txt
echo ============================================================================   >> testresults.txt
@java BinaryClockSolver 07:13:29

echo Testing args = '09:54:16'
@echo ...should output *oo*, **o**o, o*oooo
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing args = '09:54:16'                                                      >> testresults.txt
echo ...should output *oo*, **o**o, o*oooo                                            >> testresults.txt
echo ============================================================================   >> testresults.txt
@java BinaryClockSolver 09:54:16

echo Testing args = '14:44:55'
@echo ...should output ***o, *o**oo, **o***
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing args = '14:44:55'                                                      >> testresults.txt
echo ...should output ***o, *o**oo, **o***                                          >> testresults.txt
echo ============================================================================   >> testresults.txt
@java BinaryClockSolver 14:44:55

echo Testing args = '17:13:57'
@echo ...should output o*ooo*, **o*, ***oo*
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing args = '17:13:57'                                                      >> testresults.txt
echo ...should output o*ooo*, **o*, ***oo*                                          >> testresults.txt
echo ============================================================================   >> testresults.txt
@java BinaryClockSolver 17:13:57

echo Testing args = '20:34:36'
@echo ...should output o*o*oo, *ooo*o, *oo*oo
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing args = '20:34:36'                                                      >> testresults.txt
echo ...should output o*o*oo, *ooo*o, *oo*oo                                        >> testresults.txt
echo ============================================================================   >> testresults.txt
@java BinaryClockSolver 20:34:36

echo Testing args = '21:17:47'
@echo ...should output o*o*o*, o*ooo*, *o****
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing args = '21:17:47'                                                      >> testresults.txt
echo ...should output o*o*o*, o*ooo*, *o****                                        >> testresults.txt
echo ============================================================================   >> testresults.txt
@java BinaryClockSolver 21:17:47

echo Testing args = '23:53:27'
@echo ...should output o*o***, **o*o*, o**o**
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing args = '23:53:27'                                                      >> testresults.txt
echo ...should output o*o***, **o*o*, o**o**                                        >> testresults.txt
echo ============================================================================   >> testresults.txt
@java BinaryClockSolver 23:53:27

echo Testing args = '02:35:56'
@echo ...should output *o, *ooo**, ***ooo
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing args = '02:35:56'                                                      >> testresults.txt
echo ...should output *o, *ooo**, ***ooo                                            >> testresults.txt
echo ============================================================================   >> testresults.txt
@java BinaryClockSolver 02:35:56

echo Testing args = '05:16:22'
@echo ...should output *o*, o*oooo, o*o**o
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing args = '05:16:22'                                                      >> testresults.txt
echo ...should output *o*, o*oooo, o*o**o                                          >> testresults.txt
echo ============================================================================   >> testresults.txt
@java BinaryClockSolver 05:16:22

echo Testing args = '08:18:43'
@echo ...should output *ooo, o*oo*o, *o*o**
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing args = '08:18:43'                                                      >> testresults.txt
echo ...should output *ooo, o*oo*o, *o*o**                                          >> testresults.txt
echo ============================================================================   >> testresults.txt
@java BinaryClockSolver 08:18:43

echo Testing args = '09:34:56'
@echo ...should output *oo*, *ooo*o, ***ooo
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing args = '09:34:56'                                                      >> testresults.txt
echo ...should output *oo*, *ooo*o, ***ooo                                          >> testresults.txt
echo ============================================================================   >> testresults.txt
@java BinaryClockSolver 09:34:56

echo Testing args = '24:34:56'
@echo ...should output error that tells you entered an hour value too high
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing args = '24:34:56'                                                      >> testresults.txt
echo ...should output error that tells you entered an hour value too high           >> testresults.txt
echo ============================================================================   >> testresults.txt
@java BinaryClockSolver 24:34:56

echo Testing args = '20:60:18'
@echo ...should output error that tells you entered a minute value too high
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing args = '20:60:18'                                                      >> testresults.txt
echo ...should output error that tells you entered a minute value too high          >> testresults.txt
echo ============================================================================   >> testresults.txt
@java BinaryClockSolver 20:60:18

echo Testing args = '02:45:60'
@echo ...should output error that tells you entered a second value too high
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing args = '02:45:60'                                                      >> testresults.txt
echo ...should output error that tells you  entered a second value too high         >> testresults.txt
echo ============================================================================   >> testresults.txt
@java BinaryClockSolver 02:45:60

echo Testing args = '0245:40'
@echo ...should output error that tells you did not enter using : properly
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing args = '0245:40'                                                       >> testresults.txt
echo ...should output error that tells you did not enter using : properly           >> testresults.txt
echo ============================================================================   >> testresults.txt
@java BinaryClockSolver 0245:40

echo Testing args = '13:'
@echo ...should output error that tells you did not enter enough values
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing args = '13:'                                                           >> testresults.txt
echo ...should output error that tells you did not enter enough values              >> testresults.txt
echo ============================================================================   >> testresults.txt
@java BinaryClockSolver 13:
