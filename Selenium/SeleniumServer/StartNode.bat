cd SeleniumServer
java -jar selenium-server-standalone-2.50.0.jar -role node  -hub http://localhost:4445/grid/register -Dwebdriver.chrome.driver=" D:\Jars\IEDriverServer.exe” -browser browserName=iexplore,version=ANY,platform=WINDOWS,maxInstances=5
pause