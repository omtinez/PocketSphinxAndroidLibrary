Android Speech-to-Text
======================

This library uses CMU PocketSphinx and wraps it up into a library to be used in any android application. Modifying and recompiling this library is perfectly possible, but the difficulty of installing all the correct dependencies encourages to simply pull the binaries to use as-is.

Note: This library already includes all the files needed to perform speech recognition for the Spanish language. To modify that, simply change RecognizerTask.java to choose from a different set of files and include them in the assets folder, only the java files will beed to be recompiled.

For an example application that uses the latest version of this library, see https://github.com/omtinez/Ohphone