javac -d . -cp .;checkthat.jar;junit5all.jar linear\algebra\GaussianElimination.java linear\EquationSolver.java linear\GaussianEliminationStructureTest.java  linear\GaussianEliminationTest.java linear\GaussianEliminationTestSuite.java

java -jar junit5all.jar --disable-banner --disable-ansi-colors -cp . -cp checkthat.jar -c linear.GaussianEliminationTestSuite