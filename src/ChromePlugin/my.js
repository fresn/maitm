/*
 this.requestId = "";
 this.timeOpen = "";
 this.timeSendReq = "";
 this.timeRep = "";
 this.timeClose = "";
 this.Url = "";
 this.RedirectUrl = "";
 this.state = ""
*/
google.charts.load('current', {'packages': ['timeline']});
google.charts.setOnLoadCallback(Init);

function getTimeRunning() {
    var min = 0, max = 0;
    Raws.forEach(function (item) {
        console.log(item[0] + " " + (item[1] - item[2]));
        if (min > item[1]) {
            min = item[1]
        }
        if (min === 0) {
            min = item[1]
        }
        if (max < item[2]) {
            max = item[2]
        }
    });
    console.log(min);
    console.log(max);
    console.log(max - min)
}

function Init() {
    chrome.runtime.sendMessage({command: "getAjaxReadyData"}, function (response) {
        let timeLineTable = [];
        let reJ = JSON.parse(response);
        if (Array.isArray(reJ)) {
            reJ.forEach(
                function (element) {
                    if (element.timeOpen && element.timeClose) {
                        timeLineTable.push(
                            [
                                "ReqID: " + element.requestId,
                                new Date(element.timeOpen),
                                new Date(element.timeClose)
                            ]
                        );
                    }
                }
            );
            drawChart(timeLineTable);
        }

    });

}

function drawChart(tablearray) {
    let container = document.getElementById('timeline');
    let chart = new google.visualization.Timeline(container);
    let dataTable = new google.visualization.DataTable();

    dataTable.addColumn({type: 'string', id: 'Conn'});
    dataTable.addColumn({type: 'date', id: 'Start'});
    dataTable.addColumn({type: 'date', id: 'End'});
    dataTable.addRows(tablearray);
    // Res=[
    //     ['conn 318953', new Date(1527610850611), new Date(1527610850612)],
    //     ['conn 318952', new Date(1527610850633), new Date(1527610850637)],
    //     ['conn 318951', new Date(1527610850652), new Date(1527610851659)]];

    // dataTable.addRows(Res)

    // dataTable.addRows([
    //         ["conn 1243", new Date("2018-05-29T15:08:49"), new Date("2018-05-29T15:08:49")],
    //         ["conn 1244", new Date("2018-05-29T15:08:49"), new Date("2018-05-29T15:08:49")],
    //         ["conn 1245", new Date("2018-05-29T15:08:49"), new Date("2018-05-29T15:08:49")]
    //     ]
    // );
    chart.draw(dataTable);
}
