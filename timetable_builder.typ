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
        {
            let cells = ()
            for row in range(0, (timetable.endTime - timetable.startTime) * 2) {
                let time = timetable.startTime + row / 2
                if time == calc.floor(time) {
                    cells.push(table.cell(rowspan: 2)[#time])
                }

                for col in range(0, 7) {
                    let cell = none
                    let overlap = false

                    for event in timetable.events {
                        if event.day == days.at(col) { // filter events on day of this table column
                            if row in range( // Cell is overlapped by event
                                int((event.startTime - timetable.startTime) * 2) + 1,
                                int((event.endTime - timetable.startTime) * 2)
                            ) {
                                overlap = true
                            } else if event.startTime == time { // cell falls on start time of event
                                cell = table.cell(rowspan: int(
                                    calc.round((event.endTime - event.startTime) * 2)
                                ))[#event.title]
                            }
                        }
                    }
                    
                    if cell != none {
                        cells.push(cell)
                    } else if overlap == false { // push empty cell only if not overlapping with 
                        cells.push([])           // an event
                    }
                }
            }
            cells
        }
    )
)