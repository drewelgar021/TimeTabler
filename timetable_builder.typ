#let timetable = json("timetables/Timetable.json")

#set align(center)

#let days = ("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY")

#title(timetable.title)

#table(
    columns: 8,
    rows: (timetable.endTime - timetable.startTime) * 2 + 1,
    inset: 10pt,
    stroke: 0.5pt,
    [],
    [Mon], [Tue], [Wed], [Thu], [Fri], [Sat], [Sun],

    ..(
        for row in range(0, (timetable.endTime - timetable.startTime) * 2) {
            let time = timetable.startTime + row / 2
            if time == calc.floor(time) {
                (table.cell(rowspan: 2)[#time],)
            }
            (
                ..(for i in range(0, 7) {
                    (table.cell()[#i],)
                })
            )
        }
    )
)