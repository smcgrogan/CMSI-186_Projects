REM /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM  * filename: CircleTest.sh<br />
REM  * purpose : Tests the CircleSolver.java file with at least 20 times with varying values for Circle coords
REM * <p>
REM  * @author : Summer McGrogan
REM  * @since  : 2020-04-19
REM  * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
@echo off
@del testresults.txt

@echo Testing coords in file of = 10 10 10 \n 10 10 10
@echo ...should report that one circle is on top of the other
@echo .                                                                              >> testresults.txt
@echo .                                                                              >> testresults.txt
@echo ============================================================================   >> testresults.txt
@echo Testing coords in file of = 10 10 10 \n 10 10 10                               >> testresults.txt
@echo ...should report that one circle is on top of the other                        >> testresults.txt
@echo ============================================================================   >> testresults.txt
java CircleSolver CirclesOnTop.txt

@echo Testing coords in file of = 30 20 10 \n 30 30 20
@echo ...should report that one circle is inside the other and they touch at 1 point
@echo .                                                                              >> testresults.txt
@echo .                                                                              >> testresults.txt
@echo ============================================================================   >> testresults.txt
@echo Testing coords in file of = 30 20 10 \n 30 30 20                               >> testresults.txt
@echo ...should report that one circle is inside the other and they touch at 1 point >> testresults.txt
@echo ============================================================================   >> testresults.txt
java CircleSolver CirclesIn1T.txt

@echo Testing coords in file of = 30 20 15 \n 30 30 20
@echo ...should report that one circle is inside the other and they touch at 2 points
@echo .                                                                              >> testresults.txt
@echo .                                                                              >> testresults.txt
@echo ============================================================================   >> testresults.txt
@echo Testing coords in file of = 30 20 15 \n 30 30 20                               >> testresults.txt
@echo ...should report that one circle is inside the other and they touch at 2 points >> testresults.txt
@echo ============================================================================   >> testresults.txt
java CircleSolver CircleIn2T.txt

@echo Testing coords in file of = 30 35 3 \n 30 30 10
@echo ...should report that one circle is inside the other
@echo .                                                                              >> testresults.txt
@echo .                                                                              >> testresults.txt
@echo ============================================================================   >> testresults.txt
@echo Testing coords in file of = 30 35 3 \n 30 30 10                                >> testresults.txt
@echo ...should report that one circle is inside the other                           >> testresults.txt
@echo ============================================================================   >> testresults.txt
java CircleSolver CircleInNT.txt

@echo Testing coords in file of = 30 30 20 \n 30 20 10
@echo ...should report that one circle is inside the other and 1 touch
@echo .                                                                              >> testresults.txt
@echo .                                                                              >> testresults.txt
@echo ============================================================================   >> testresults.txt
@echo Testing coords in file of = 30 30 20 \n 30 20 10                               >> testresults.txt
@echo ...should report that one circle is inside the other and 1 touch               >> testresults.txt
@echo ============================================================================   >> testresults.txt
java CircleSolver Circle2In1T.txt

@echo Testing coords in file of = 30 30 20 \n 30 20 15
@echo ...should report that one circle is inside the other and 2 touch
@echo .                                                                              >> testresults.txt
@echo .                                                                              >> testresults.txt
@echo ============================================================================   >> testresults.txt
@echo Testing coords in file of = 30 30 20 \n 30 20 15                               >> testresults.txt
@echo ...should report that one circle is inside the other and 2 touch               >> testresults.txt
@echo ============================================================================   >> testresults.txt
java CircleSolver Circle2In2T.txt

@echo Testing coords in file of = 30 30 10 \n 30 35 3
@echo ...should report that one circle is inside the other and no touch
@echo .                                                                              >> testresults.txt
@echo .                                                                              >> testresults.txt
@echo ============================================================================   >> testresults.txt
@echo Testing coords in file of = 30 30 20 \n 30 35 3                                >> testresults.txt
@echo ...should report that one circle is inside the other and no touch              >> testresults.txt
@echo ============================================================================   >> testresults.txt
java CircleSolver Circle2InNT.txt

@echo Testing coords in file of = 30 30 10 \n 30 30 10
@echo ...should report that one circle is on top of the other
@echo .                                                                              >> testresults.txt
@echo .                                                                              >> testresults.txt
@echo ============================================================================   >> testresults.txt
@echo Testing coords in file of = 30 30 10 \n 30 30 10                               >> testresults.txt
@echo ...should report that one circle is is on top of the other                     >> testresults.txt
@echo ============================================================================   >> testresults.txt
java CircleSolver CirclesON.txt

@echo Testing coords in file of = 0 0 10 \n 0 20 10
@echo ...should report that circles touch at 1 point (outside each other)
@echo .                                                                              >> testresults.txt
@echo .                                                                              >> testresults.txt
@echo ============================================================================   >> testresults.txt
@echo Testing coords in file of = 0 0 10 \n 0 20 10                                  >> testresults.txt
@echo ...should report that one circles touch at 1 point (outside each other)        >> testresults.txt
@echo ============================================================================   >> testresults.txt
java CircleSolver CirclesOut1.txt

@echo Testing coords in file of = 10 10 10 \n 20 20 10
@echo ...should report that circles touch at 2 points (outside each other)
@echo .                                                                              >> testresults.txt
@echo .                                                                              >> testresults.txt
@echo ============================================================================   >> testresults.txt
@echo Testing coords in file of = 10 10 10 \n 20 20 10                               >> testresults.txt
@echo ...should report that one circles touch at 2 points (outside each other)       >> testresults.txt
@echo ============================================================================   >> testresults.txt
java CircleSolver CirclesOut2.txt

@echo Testing coords in file of = 10 10 10 \n 40 40 10
@echo ...should report that circles do not touch (outside each other)
@echo .                                                                              >> testresults.txt
@echo .                                                                              >> testresults.txt
@echo ============================================================================   >> testresults.txt
@echo Testing coords in file of = 10 10 10 \n 40 40 10                               >> testresults.txt
@echo ...should report that one circles do not touch (outside each other)            >> testresults.txt
@echo ============================================================================   >> testresults.txt
java CircleSolver CirclesOutNT.txt

@echo Testing coords in file of = 10 AA 10 \n 40 40 10
@echo ...should report that you must enter numbers
@echo .                                                                              >> testresults.txt
@echo .                                                                              >> testresults.txt
@echo ============================================================================   >> testresults.txt
@echo Testing coords in file of = 10 AA 10 \n 40 40 10                               >> testresults.txt
@echo ...should report thatyou must enter numbers                                    >> testresults.txt
@echo ============================================================================   >> testresults.txt
java CircleSolver CirclesFalse.txt

@echo Testing coords in file of = 10 20 10 \n 4a 40 10
@echo ...should report that you must enter numbers
@echo .                                                                              >> testresults.txt
@echo .                                                                              >> testresults.txt
@echo ============================================================================   >> testresults.txt
@echo Testing coords in file of = 10 20 10 \n 4a 40 10                               >> testresults.txt
@echo ...should report that you must enter numbers                                   >> testresults.txt
@echo ============================================================================   >> testresults.txt
java CircleSolver CirclesFalse2.txt

@echo Testing coords in file of =   \n 40 40 10
@echo ...should report that the first line of file is empty
@echo .                                                                              >> testresults.txt
@echo .                                                                              >> testresults.txt
@echo ============================================================================   >> testresults.txt
@echo Testing coords in file of =   \n 40 40 10                                      >> testresults.txt
@echo ...should report that the first line of file is empty                          >> testresults.txt
@echo ============================================================================   >> testresults.txt
java CircleSolver CirclesLost.txt

@echo Testing coords in file of = 10 10 10\n
@echo ...should report that the second line of file is empty
@echo .                                                                              >> testresults.txt
@echo .                                                                              >> testresults.txt
@echo ============================================================================   >> testresults.txt
@echo Testing coords in file of = 10 10 10\n                                         >> testresults.txt
@echo ...should report that the second line of file is empty                        >> testresults.txt
@echo ============================================================================   >> testresults.txt
java CircleSolver CirclesLost2.txt

@echo Testing coords in file of = 0 0 10\n 0 0 3
@echo ...should report that one circle is inside the other
@echo .                                                                              >> testresults.txt
@echo .                                                                              >> testresults.txt
@echo ============================================================================   >> testresults.txt
@echo Testing coords in file of = 10 10 10\n 0 0 3                                   >> testresults.txt
@echo ...should report that one circle is inside the other                           >> testresults.txt
@echo ============================================================================   >> testresults.txt
java CircleSolver CirclesInNT2.txt

@echo Testing coords in file of = 0 0 10\n 15 15 6
@echo ...should report that the circles touch at two points
@echo .                                                                              >> testresults.txt
@echo .                                                                              >> testresults.txt
@echo ============================================================================   >> testresults.txt
@echo Testing coords in file of = 0 0 10\n 15 15 6                                   >> testresults.txt
@echo ...should report that the circles touch at two points                          >> testresults.txt
@echo ============================================================================   >> testresults.txt
java CircleSolver CirclesOut2T2.txt

@echo Testing coords in file of = 0 0 10\n 15 15 5
@echo ...should report that the circles touch at 1 point
@echo .                                                                              >> testresults.txt
@echo .                                                                              >> testresults.txt
@echo ============================================================================   >> testresults.txt
@echo Testing coords in file of = 0 0 10\n 15 15 5                                   >> testresults.txt
@echo ...should report that the circles touch at 1 point                             >> testresults.txt
@echo ============================================================================   >> testresults.txt
java CircleSolver CirclesOut1T2.txt

@echo Testing coords in file of = 0 0 10\n 35 35 5
@echo ...should report that the circles do not touch
@echo .                                                                              >> testresults.txt
@echo .                                                                              >> testresults.txt
@echo ============================================================================   >> testresults.txt
@echo Testing coords in file of = 0 0 10\n 35 35 5                                   >> testresults.txt
@echo ...should report that the circles do not touch                                 >> testresults.txt
@echo ============================================================================   >> testresults.txt
java CircleSolver CirclesOutNT3.txt

@echo Testing coords in file of = 2 1 15 \n 2 2 10
@echo ...should report that one circle is inside the other and they touch at 2 points
@echo .                                                                              >> testresults.txt
@echo .                                                                              >> testresults.txt
@echo ============================================================================   >> testresults.txt
@echo Testing coords in file of = 2 1 15 \n 2 2 10                                   >> testresults.txt
@echo ...should report that one circle is inside the other and they touch at 2 points >> testresults.txt
@echo ============================================================================   >> testresults.txt
java CircleSolver CircleIn2T2.txt
