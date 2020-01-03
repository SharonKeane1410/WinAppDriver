#Setup

##Tools used
###WinAppDriver v1.2 Release Candidate 
 This can be found: ```https://github.com/microsoft/WinAppDriver/releases```
``` 
 download and install WindowsApplicationDriver.msi
```

Open the AppDrive in cmd and run on port specified in the ClaculatorTest setup method.
``` 
Microsoft Windows [Version 10.0.18362.535]
(c) 2019 Microsoft Corporation. All rights reserved.

C:\Program Files (x86)\Windows Application Driver>WinAppDriver.exe 4723
Windows Application Driver listening for requests at: http://127.0.0.1:4723/
Press ENTER to exit.

```

### Windows Kit
Open the windows kit inspect application 
```
C:\Program Files (x86)\Windows Kits\10\bin\10.0.17763.0\x86\inspect.exe
```
This will help you get the Element selectors


####Locating the Application name
in the inspection tool expand
```
| "Desktop 1" pane
|- pane
|-- pane 
|--- "Running Application" tool bar
|---- The appliction to be identified 
|------| AutomationId:	"SpotifyAB.SpotifyMusic_zpdnekdrzrea0!Spotify"
```

####Locating the Elements
When the inspection tool is open, click on the element in the application you want to identify, this should open the information page in the inspection tool and then you can use the identifier you wish

##Running test cases
Ensure the WinAppDriver is running on the specified port
Run Test Class as normal JUnit test (Ctrl+Shift+F10)