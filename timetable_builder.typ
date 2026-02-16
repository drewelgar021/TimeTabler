#let timetable = json("timetables/Timetable.json")

#set align(center)

#let days = ("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY")

#title(timetable.title)

#table(
    columns: 8,
    rows: (timetable.endTime - timetable.startTime) + 1,
    inset: 10pt,
    stroke: 0.5pt,
    [],
    [Mon], [Tue], [Wed], [Thu], [Fri], [Sat], [Sun],

    ..(
        for time in range(timetable.startTime, timetable.endTime) {
            (
                table.cell(colspan: 1)[#time],
                ..(for i in range(0, 7) {
                    (table.cell()[#i],)
                })
            )
        }
    )
)