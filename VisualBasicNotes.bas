' Macro Name has to match Sub Name
Sub Merge()
' 
'
    ' this code will correctly merge SVR & Bob Reports
    ' updated to include Will's name change comment
    'to further implement Filter off; Error for N/A's Agency
'
'should include variables:
lastCol = ActiveSheet.Range("a1").End(xlToRight).Column
lastRow = ActiveSheet.Cells(65536, lastCol).End(xlUp).Row
lastRowNum = Range("G2").CurrentRegion.Rows.Count
'this will allow entire ranges to be selected instead of what is limited by recording the macro
' https://stackoverflow.com/questions/4850738/how-to-select-all-the-cells-in-a-worksheet-in-excel-range-object-of-c
' https://support.microsoft.com/en-us/help/291308/how-to-select-cells-ranges-by-using-visual-basic-procedures-in-excel
' below is a recorded macro for merging p-logs process
' ActiveSheet.Range("a1", ActiveSheet.Cells(lastRow, lastCol)).Select
' alternatively : ActiveSheet.Range("a1").CurrentRegion.Select however will not work if blank rows/columns etc
'Change name to LogsReport
Windows("LogsReport.xlsx").Activate
    Rows("1:1").Select
    Selection.Delete Shift:=xlUp
    Cells.Select
    Selection.AutoFilter
        ' V replace with ActiveSheet.Range("a1", ActiveSheet.Cells(lastRow, lastCol)).Select
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
            'changing name to BOBReport
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
                        ' updating name from prelogstest to LogsReport
                        Windows("LogsReport.xlsx").Activate
    Range("G2").Select
    Application.CutCopyMode = False
    Application.CutCopyMode = False
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
                                    
                                        'search for #N/A
        Cells.Find(What:="#N/A", After:=ActiveCell, LookIn:=xlFormulas, LookAt _
        :=xlPart, SearchOrder:=xlByRows, SearchDirection:=xlNext, MatchCase:= _
        False, SearchFormat:=False).Activate
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


