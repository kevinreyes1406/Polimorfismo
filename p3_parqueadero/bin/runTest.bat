@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM $Id$
REM Universidad de los Andes (Bogot� - Colombia)
REM Departamento de Ingenier�a de Sistemas y Computaci�n
REM Licenciado bajo el esquema Academic Free License version 2.1
REM
REM Proyecto Cupi2
REM Ejercicio: n3_parqueadero
REM Autor: Mario S�nchez - 20-Jun-2005
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM/


REM ---------------------------------------------------------
REM Ejecuci�n de la prueba
REM Archivo de ejecucion: parqueaderoTest.jar
REM ---------------------------------------------------------

java -classpath ../lib/parqueadero.jar;../test/lib/parqueaderoTest.jar;../test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.parqueadero.test.CarroTest
java -classpath ../lib/parqueadero.jar;../test/lib/parqueaderoTest.jar;../test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.parqueadero.test.ParqueaderoTest
java -classpath ../lib/parqueadero.jar;../test/lib/parqueaderoTest.jar;../test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.parqueadero.test.PuestoTest