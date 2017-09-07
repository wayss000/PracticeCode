Set objShell = CreateObject("Wscript.Shell")
strCommandLine = "C:\\HYB_VNC.exe"        '启动安装程序
objShell.Run(strCommandLine)
set WshShell = CreateObject("WScript.Shell")
WScript.Sleep 1000
WshShell.SendKeys "{ENTER}"        '模拟按下回车键执行下一步
WScript.Sleep 300
WshShell.SendKeys "{ENTER}"        '模拟按下回车键执行下一步
WScript.Sleep 300
WshShell.SendKeys "{ENTER}"        '模拟按下回车键执行下一步
