#let timetable = json("timetables/Timetable.json")

#set align(center)
#set page(margin: 0pt)


#let desc = text.with(size: 10pt)

#let days = ("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY")

#title(timetable.title)

#table(
    columns: 8,
    rows: (timetable.endTime - timetable.startTime) * 2 + 1,
    inset: 10pt,
    stroke: (0.5pt + rgb(191, 191, 191)),
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
                    let cellColor = none

                    for event in timetable.events {
                        if event.day == days.at(col) { // filter events on day of this table column
                            if row in range( // Cell is overlapped by event
                                int((event.startTime - timetable.startTime) * 2) + 1,
                                int((event.endTime - timetable.startTime) * 2)
                            ) {
                                overlap = true
                            } else if event.startTime == time { // cell falls on start time of event
                                cellColor = rgb(255, 255, 255)
                                if event.eventType == "CLASS" { cellColor = rgb(0, 153, 255)}
                                if event.eventType == "WORK" {cellColor = rgb(255, 64, 64)}
                                if event.eventType == "PERSONAL" {cellColor = rgb(255, 128, 255)}
                                cell = table.cell(rowspan: int(
                                    calc.round((event.endTime - event.startTime) * 2)
                                ), fill: cellColor)[*#event.title* \ #desc(event.description)]
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