@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%"=="" @echo off
@rem ##########################################################################
@rem
@rem  ApiHug startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal enabledelayedexpansion

set DIRNAME=%~dp0
if "%DIRNAME%"=="" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS="-Xmx64m" "-Xms64m"

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if %ERRORLEVEL% equ 0 goto checkApiHugJar

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto checkApiHugJar

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:checkApiHugJar
@rem Setup the ApiHug directory
set APIHUG_DIR=%APP_HOME%.apihug
set APIHUG_JAR=%APIHUG_DIR%\it-repl.jar

@rem Maven coordinates
set GROUP_ID=com.apihug
set ARTIFACT_ID=it-repl

@rem Read version from gradle/libs.versions.toml
set "VERSION_FILE=%APP_HOME%\gradle\libs.versions.toml"
set "VERSION=0.2.6-RELEASE"
set "VERSION_RAW="
if exist "%VERSION_FILE%" (
    for /f "tokens=1,* delims==" %%a in ('findstr /C:"apihugVersion =" "%VERSION_FILE%"') do (
        set "VERSION_RAW=%%b"
    )
)

@rem Clean up version string (remove quotes and spaces)
if defined VERSION_RAW (
    set "VERSION=!VERSION_RAW:"=!"
    set "VERSION=!VERSION: =!"
)

echo ApiHug Version: %VERSION%

@rem Check if .apihug directory exists, if not create it
if not exist "%APIHUG_DIR%" mkdir "%APIHUG_DIR%"

@rem Check version and force refresh if needed
set VERSION_CACHE_FILE=%APIHUG_DIR%\.version
set NEED_DOWNLOAD=0

@rem Check if jar exists
if not exist "%APIHUG_JAR%" set NEED_DOWNLOAD=1

@rem Check if version has changed
if exist "%VERSION_CACHE_FILE%" (
    set /p CACHED_VERSION=<"%VERSION_CACHE_FILE%"
    set "CACHED_VERSION_TRIM=!CACHED_VERSION: =!"
    if not "!CACHED_VERSION_TRIM!"=="%VERSION%" (
        echo.
        echo Version changed: !CACHED_VERSION_TRIM! -^> %VERSION%
        echo.
        set NEED_DOWNLOAD=1
    )
) else (
    set NEED_DOWNLOAD=1
)

@rem If force refresh argument provided
for %%a in (%*) do (
    if "%%a"=="--refresh" set NEED_DOWNLOAD=1
    if "%%a"=="-r" set NEED_DOWNLOAD=1
    if "%%a"=="--force" set NEED_DOWNLOAD=1
)

@rem Download if needed
if %NEED_DOWNLOAD% equ 1 (
    echo Downloading it-repl.jar via gradlew hope...
    echo.

    if not exist "%APP_HOME%gradlew.bat" (
        echo ERROR: gradlew.bat not found in %APP_HOME%
        goto fail
    )

    call "%APP_HOME%gradlew.bat" :hope --console=plain -q
    if %ERRORLEVEL% neq 0 goto fail

    if not exist "%APIHUG_JAR%" (
        echo ERROR: it-repl.jar not found after running gradlew hope
        goto fail
    )

    @rem Save current version to cache
    echo %VERSION% > "%VERSION_CACHE_FILE%"
    echo.
)

:execute
@rem Execute ApiHug REPL
echo.
echo Starting ApiHug REPL...
echo.

"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% -jar "%APIHUG_JAR%" %*

:end
@rem End local scope for the variables with windows NT shell
if %ERRORLEVEL% equ 0 goto mainEnd

:fail
rem Set variable APIHUG_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
set EXIT_CODE=%ERRORLEVEL%
if %EXIT_CODE% equ 0 set EXIT_CODE=1
if not ""=="%APIHUG_EXIT_CONSOLE%" exit %EXIT_CODE%
exit /b %EXIT_CODE%

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
