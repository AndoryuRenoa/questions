' using excel in vbas:
' https://support.microsoft.com/en-us/help/302084/how-to-automate-microsoft-excel-from-microsoft-visual-c-net

' to hunt down starting directory and open a file:

Dim fileName as String = "yourfile.txt"
Dim appDir as String = System.IO.Path.GetDirectoryName( _
System.Reflection.Assembly.GetExecutingAssembly().CodeBase)

Process.Start(appDir & "\" & fileName)

' code generated by Excel Macro:
'
' PreLogComb Macro
'

'
    Rows("1:1").Select
    Selection.Delete Shift:=xlUp
    Cells.Select
    Selection.AutoFilter
    ActiveSheet.Range("$A$1:$R$12227").AutoFilter Field:=1, Criteria1:="="
    Rows("12227:12227").Select
    Selection.Delete Shift:=xlUp
    ActiveSheet.Range("$A$1:$R$12226").AutoFilter Field:=1
    Columns("G:G").Select
    Selection.ClearContents
    Range("G1").Select
    ActiveCell.FormulaR1C1 = "Agency"
    Columns("G:G").Select
    Selection.NumberFormat = "General"
    Range("F19").Select
    Application.WindowState = xlNormal
    Application.Left = 214
    Application.Top = 34
    Application.ActiveProtectedViewWindow.Edit
    ActiveSheet.Shapes.Range(Array("Generic_DISH")).Select
    Selection.Delete
    Rows("1:8").Select
    Selection.Delete Shift:=xlUp
    Columns("A:A").Select
    Selection.TextToColumns Destination:=Range("A1"), DataType:=xlDelimited, _
        TextQualifier:=xlDoubleQuote, ConsecutiveDelimiter:=False, Tab:=False, _
        Semicolon:=False, Comma:=False, Space:=False, Other:=True, OtherChar _
        :="-", FieldInfo:=Array(Array(1, 1), Array(2, 1)), TrailingMinusNumbers:=True
    Windows("PreLogs 5.4.xlsx").Activate
    Range("G2").Select
    Application.CutCopyMode = False
    Application.CutCopyMode = False
    ActiveCell.FormulaR1C1 = _
        "=VLOOKUP(RC[1],'[BOBReport5.3.xlsx]2Q 2018'!C1:C11,5,FALSE)"
    Selection.AutoFill Destination:=Range("G2:G12226")
    Range("G2:G12226").Select
    Columns("G:G").Select
    Columns("G:G").EntireColumn.AutoFit
    ActiveSheet.Range("$A$1:$R$12226").AutoFilter Field:=7
    Cells.Select
    Selection.Copy
    Selection.PasteSpecial Paste:=xlPasteValues, Operation:=xlNone, SkipBlanks _
        :=False, Transpose:=False
    Range("G3").Select
    Application.CutCopyMode = False
    ActiveCell.FormulaR1C1 = "Dish Marketing/Englewood"
    ActiveWorkbook.Save
    Application.WindowState = xlNormal
    Application.Left = 38.5
    Application.Top = 40.75
    ActiveWindow.SmallScroll Down:=21
End Sub
'below is a sample macro for sending email from excel in vba
Sub SendEmail()
Dim strFile As String
Dim OutApp As Outlook.Application
Dim objOutlookMsg As Outlook.MailItem
Dim objOutlookRecip As Recipient
Dim Recipients As Recipients

  Set OutApp = CreateObject("Outlook.Application")
  Set objOutlookMsg = OutApp.CreateItem(olMailItem)

  strFile = "C:\temp\myfile.xlsx"
  ActiveWorkbook.SaveAs strFile

  Set Recipients = objOutlookMsg.Recipients
  Set objOutlookRecip = Recipients.Add("Kelly.XXX@XXX.com")
  objOutlookRecip.Type = 1

  With objOutlookMsg
    .SentOnBehalfOfName = "Andrew.Lenoir@dish.com"
    .Subject = "Testing this macro"
    .HTMLBody = "Testing this macro" & vbCrLf & vbCrLf
    'Resolve each Recipient's name.
    For Each objOutlookRecip In objOutlookMsg.Recipients
      objOutlookRecip.Resolve
    Next
    .Attachments.Add strFile
    .display
  End With

  'objOutlookMsg.Send
  Set OutApp = Nothing
End Sub


