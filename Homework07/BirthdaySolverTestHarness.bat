REM /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM  * filename: BirthdaySolverTestHarness<br />
REM  * purpose : Tests the BirthdaySolver.java file with at least 20 times with varying values for N and number of experiments
REM  * <p>
REM  * @author : Summer McGrogan
REM  * @since  : 2020-04-19
REM  * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
@echo off
@del testresults.txt

@echo Testing N = 'ff'
@echo ...should ouput error messages and NumberFormatException, then quit
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing N = 'ff'                                                               >> testresults.txt
echo ...should ouput error messages and NumberFormatException, then quit            >> testresults.txt
echo ============================================================================   >> testresults.txt
java BirthdaySolver ff

@echo Testing N = 123 nExpeiments = 'abc'
@echo ...should tell you the nExperiments argument was not valid, used default
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing N = 123 nExperiments = 'abc'                                            >> testresults.txt
echo ...should tell you the nExperiments argument was not valid, used default        >> testresults.txt
echo ============================================================================   >> testresults.txt
java BirthdaySolver 123 abc

@echo Testing N = 'abc' nExperiments = 'abc'
@echo ...should output error message, throw NumberFormatException
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing N = 'abc' nExperiments = 'abc'                                         >> testresults.txt
echo ...should output error message, throw NumberFormatException                    >> testresults.txt
echo ============================================================================   >> testresults.txt
java BirthdaySolver abc abc

@echo Testing no args
@echo ...should output error message, throw ArrayIndexOutOfBoundsException
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing no args                                                                >> testresults.txt
echo ...should output error message, throw ArrayIndexOutOfBoundsException           >> testresults.txt
echo ============================================================================   >> testresults.txt
java BirthdaySolver

@echo Testing N = 123 nExp = 456
@echo ...should output Experimental Val = 100%, Actual = 99.99...%
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing N = 123 nExp = 456                                                     >> testresults.txt
echo ...should output Experimental Val = 100%, Actual = 99.99...%                   >> testresults.txt
echo ============================================================================   >> testresults.txt
java BirthdaySolver 123 456

@echo Testing N = 10000 nExp = 45600
@echo ...should output Experimental Val = 100%, Actual = 100%
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing N = 10000 nExp = 456000                                                >> testresults.txt
echo ...should output Experimental Val = 100%, Actual = 100%                        >> testresults.txt
echo ============================================================================   >> testresults.txt
java BirthdaySolver 10000 456000

@echo Testing N = 10 nExp = 13
@echo ...should output Experimental Val = 7.6923076923076925%, Actual = 14.114137832173334%
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing N = 10 nExp = 13                                                       >> testresults.txt
echo ...should output Experimental Val = 7.6923076923076925%, Actual = 14.114137832173334%                        >> testresults.txt
echo ============================================================================   >> testresults.txt
java BirthdaySolver 10 13

@echo Testing N = 29 nExp = 2000
@echo ...should output Experimental Val = 68.2%, Actual = 70.63162427192687%
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing N = 29 nExp = 2000                                                     >> testresults.txt
echo ...should output Experimental Val = 68.2%%, Actual = 70.63162427192687%        >> testresults.txt
echo ============================================================================   >> testresults.txt
java BirthdaySolver 29 2000

@echo Testing N = 300
@echo ...should output that you did not enter a valid nExpeiments AND
@echo ...should output Experimental Val = 100%, Actual = 100%
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing N = 300                                                                >> testresults.txt
echo ...should output Experimental Val = 100%%, Actual = 100%                       >> testresults.txt
echo ============================================================================   >> testresults.txt
java BirthdaySolver 300

@echo Testing N = 3000000
@echo ...should output that you did not enter a valid nExpeiments AND
@echo ...should output Experimental Val = 100%, Actual = 100%
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing N = 3000000                                                            >> testresults.txt
echo ...should output Experimental Val = 100%%, Actual = 100%                       >> testresults.txt
echo ============================================================================   >> testresults.txt
java BirthdaySolver 3000000

@echo off
@del testresults.txt

@echo Testing N = 'ff'
@echo ...should ouput error messages and NumberFormatException, then quit
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing N = 'ff'                                                               >> testresults.txt
echo ...should ouput error messages and NumberFormatException, then quit            >> testresults.txt
echo ============================================================================   >> testresults.txt
java BirthdaySolver ff

@echo Testing N = 123 nExpeiments = 'abc'
@echo ...should tell you the nExperiments argument was not valid, used default
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing N = 123 nExperiments = 'abc'                                            >> testresults.txt
echo ...should tell you the nExperiments argument was not valid, used default        >> testresults.txt
echo ============================================================================   >> testresults.txt
java BirthdaySolver 123 abc

@echo Testing N = 'abc' nExperiments = 'abc'
@echo ...should output error message, throw NumberFormatException
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing N = 'abc' nExperiments = 'abc'                                         >> testresults.txt
echo ...should output error message, throw NumberFormatException                    >> testresults.txt
echo ============================================================================   >> testresults.txt
java BirthdaySolver abc abc

@echo Testing no args
@echo ...should output error message, throw ArrayIndexOutOfBoundsException
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing no args                                                                >> testresults.txt
echo ...should output error message, throw ArrayIndexOutOfBoundsException           >> testresults.txt
echo ============================================================================   >> testresults.txt
java BirthdaySolver

@echo Testing N = 123 nExp = 456
@echo ...should output Experimental Val = 100%, Actual = 99.99...%
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing N = 123 nExp = 456                                                     >> testresults.txt
echo ...should output Experimental Val = 100%, Actual = 99.99...%                   >> testresults.txt
echo ============================================================================   >> testresults.txt
java BirthdaySolver 123 456

@echo Testing N = 10000 nExp = 45600
@echo ...should output Experimental Val = 100%, Actual = 100%
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing N = 10000 nExp = 456000                                                >> testresults.txt
echo ...should output Experimental Val = 100%, Actual = 100%                        >> testresults.txt
echo ============================================================================   >> testresults.txt
java BirthdaySolver 10000 456000

@echo Testing N = 10 nExp = 13
@echo ...should output Experimental Val = 7.6923076923076925%, Actual = 14.114137832173334%
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing N = 10 nExp = 13                                                       >> testresults.txt
echo ...should output Experimental Val = 7.6923076923076925%, Actual = 14.114137832173334%                        >> testresults.txt
echo ============================================================================   >> testresults.txt
java BirthdaySolver 10 13

@echo Testing N = 29 nExp = 2000
@echo ...should output Experimental Val = 68.2%, Actual = 70.63162427192687%
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing N = 29 nExp = 2000                                                     >> testresults.txt
echo ...should output Experimental Val = 68.2%%, Actual = 70.63162427192687%        >> testresults.txt
echo ============================================================================   >> testresults.txt
java BirthdaySolver 29 2000

@echo Testing N = 300
@echo ...should output that you did not enter a valid nExpeiments AND
@echo ...should output Experimental Val = 100%, Actual = 100%
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing N = 300                                                                >> testresults.txt
echo ...should output Experimental Val = 100%%, Actual = 100%                       >> testresults.txt
echo ============================================================================   >> testresults.txt
java BirthdaySolver 300

@echo Testing N = 50
@echo ...should output that you did not enter a valid nExpeiments AND
@echo ...should output Experimental Val =  97.024%, Actual = 97.44319933344283%
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing N = 50                                                                 >> testresults.txt
echo ...should output Experimental Val =  97.024%, Actual = 97.44319933344283%      >> testresults.txt
echo ============================================================================   >> testresults.txt
java BirthdaySolver 50

@echo Testing N = 15
@echo ...should output that you did not enter a valid nExpeiments AND
@echo ...should output Experimental Val =  25.263999999999996%, Actual = 28.360400525285023%
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing N = 15                                                                 >> testresults.txt
echo ...should output Experimental Val =  25.263999999999996%, Actual = 28.360400525285023%      >> testresults.txt
echo ============================================================================   >> testresults.txt
java BirthdaySolver 15

@echo Testing N = 459
@echo ...should output that you did not enter a valid nExpeiments AND
@echo ...should output Experimental Val =  100%, Actual = 100%
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing N = 459                                                                >> testresults.txt
echo ...should output Experimental Val =  100%, Actual = 100%                       >> testresults.txt
echo ============================================================================   >> testresults.txt
java BirthdaySolver 459
