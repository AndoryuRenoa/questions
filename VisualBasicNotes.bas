' to hunt down starting directory and open a file:

Dim fileName as String = "yourfile.txt"
Dim appDir as String = System.IO.Path.GetDirectoryName( _
System.Reflection.Assembly.GetExecutingAssembly().CodeBase)

Process.Start(appDir & "\" & fileName)
