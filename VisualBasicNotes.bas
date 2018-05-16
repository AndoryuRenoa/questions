' Good Practice to have Macro Name match Sub Name
Sub Merge()
'
'
    ' this code will correctly merge SVR & Bob Reports
    ' updated to include Will's name change comment
    ' updated to include Message for if N/As are present or not (current method is dangerous anything that throws error #91 will produce
    ' this message *For future development*)
    ' updated to run check to see if both windows are open, pop message now prompts user to check both windows and file names if this fails
    ' requires update to include name changes for dates
    ' requires update to change cell title Q2 2018 with variable so this does not need to be updated every quarter

' using error reference to give indication as to possible reasons the program will not save
On Error GoTo RefErr:

'Changing name to LogsReport
Windows("LogsReport.xlsx").Activate
'activating both windows first so error throws prior to formatting if one isn't present or misnamed
Windows("BOBReport.xlsx").Activate
    ' can initialize a variable here to replace Q2 2018 while BOBReport is active
Windows("LogsReport.xlsx").Activate

    'variables (for LogsReport):
lastCol = ActiveSheet.Range("a1").End(xlToRight).Column
lastRow = ActiveSheet.Cells(65536, lastCol).End(xlUp).Row
lastRowNum = Range("G2").CurrentRegion.Rows.Count
'^this will allow entire ranges to be selected

'Formatting begins below
    Rows("1:1").Select
    Selection.Delete Shift:=xlUp
    Cells.Select
    Selection.AutoFilter
' V I think this line is redundant, remove and test w.out
    ActiveSheet.Range("a1", ActiveSheet.Cells(lastRow, lastCol)).AutoFilter Field:=1, Criteria1:="="
        ' V replace with Rows (lastRow) however need to check if last row is actually last row i think it is due to .End(xlUp)
    ActiveSheet.Range("a1", ActiveSheet.Cells(lastRow, lastCol)).AutoFilter Field:=1
    Columns("G:G").Select
    Selection.ClearContents
    Range("G1").Select
    ActiveCell.FormulaR1C1 = "Agency"
    Columns("G:G").Select
    Selection.NumberFormat = "General"
    Range("F19").Select
    Application.WindowState = xlNormal
   
            'changing active window to BOBReport
    Windows("BOBReport.xlsx").Activate
    ActiveSheet.Shapes.Range(Array("Generic_DISH")).Select
    Selection.Delete
    Rows("1:8").Select
    Selection.Delete Shift:=xlUp
    Columns("A:A").Select
    Selection.TextToColumns Destination:=Range("A1"), DataType:=xlDelimited, _
        TextQualifier:=xlDoubleQuote, ConsecutiveDelimiter:=False, Tab:=False, _
        Semicolon:=False, Comma:=False, Space:=False, Other:=True, OtherChar _
        :="-", FieldInfo:=Array(Array(1, 1), Array(2, 1)), TrailingMinusNumbers:=True
                        
                        ' changes active window to LogsReport
                        Windows("LogsReport.xlsx").Activate
    Range("G2").Select
    Application.CutCopyMode = False
    Application.CutCopyMode = False
                            '!critical! BOB Report name must match VLOOKUP 2nd Parameter
                            ' The below includes "2Q 2018" Need to find a way to replace it prior to quarter change via variable"
                            ActiveCell.FormulaR1C1 = _
                                            "=VLOOKUP(RC[1],'[BOBReport.xlsx]2Q 2018'!C1:C11,5,FALSE)"
                            'notice "-1" due to deleting the report's header
    Selection.AutoFill Destination:=Range("G2:G" & lastRowNum - 1)
    ActiveSheet.Range("G2").End(xlDown).Select
    Columns("G:G").Select
    Columns("G:G").EntireColumn.AutoFit
    ActiveSheet.Range("a1", ActiveSheet.Cells(lastRow, lastCol)).AutoFilter Field:=7
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
                  ' Cannot use try catch statments in VBA macro so instead we will use the error number to go to a command line
                                    'Note this is dangerous anything throwing an error will now GoTo RefErr and if value is present in a
                                    'case it will run that script
                                    'search for #N/A will throw an error if not present
        Cells.Find(What:="#N/A", After:=ActiveCell, LookIn:=xlFormulas, LookAt _
        :=xlPart, SearchOrder:=xlByRows, SearchDirection:=xlNext, MatchCase:= _
        False, SearchFormat:=False).Activate
                                    MsgBox "N/A'S ARE PRESENT. THIS REPORT IS NOT OKAY FOR PICKLE CHECK BOBREPORT"
RefErr:
                                    Select Case Err.Number
                                    Case 91
                                        MsgBox "No N/As Present. Report is good for Pickle!"
                                        End
                                    Case 9
                                        MsgBox "Either Both Windows are not open or they have not been saved correctly as BOBReport.xlsx and LogsReport.xlsx"
                                        End
                                        End Select
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
    .SentOnBehalfOfName = "Andrew.XXX@XXX.com"
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


