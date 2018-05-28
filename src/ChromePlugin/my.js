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
google.charts.setOnLoadCallback(drawChart);
var Raws = [];

function drawChart() {
    let container = document.getElementById('timeline');
    let chart = new google.visualization.Timeline(container);
    let dataTable = new google.visualization.DataTable();

    dataTable.addColumn({type: 'string', id: 'President'});
    dataTable.addColumn({type: 'date', id: 'Start'});
    dataTable.addColumn({type: 'date', id: 'End'});

    chrome.runtime.sendMessage({command: "getAjaxReadyData"}, function (response) {
        let reJ = JSON.parse(response);
        if (Array.isArray(reJ)) {
            reJ.forEach(
                function (element) {
                    if (element.timeOpen && element.timeClose) {

                        if (Raws.length < 3) {
                            Raws.push(["conn " + element.requestId, new Date(element.timeOpen), new Date(element.timeClose)]);
                        }
                    }
                }
            )
        }

    });

    // dataTable.addRows(Raws);
    dataTable.addRows([
        ['conn 318953', new Date(1789, 3, 30), new Date(1797, 2, 4)],
        ['conn 318952', new Date(1797, 2, 4), new Date(1801, 2, 4)],
        ['conn 318951', new Date(1801, 2, 4), new Date(1809, 2, 4)]]);
    chart.draw(dataTable);
}

function f() {

}