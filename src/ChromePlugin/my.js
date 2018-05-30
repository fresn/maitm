GoodYear = {
    requestDatas: [],
    timeLineTable: [],
    initTimeLineChart: function () {

        let container = document.getElementById('timeline');
        let chart = new google.visualization.Timeline(container);
        let dataTable = new google.visualization.DataTable();

        dataTable.addColumn({type: 'string', id: 'Conn'});
        dataTable.addColumn({type: 'date', id: 'Start'});
        dataTable.addColumn({type: 'date', id: 'End'});


        GoodYear.requestDatas.forEach(
            function (ele) {
                if (ele.timeOpen && ele.timeClose) {
                    GoodYear.timeLineTable.push(
                        [
                            ele.Url,
                            new Date(ele.timeOpen),
                            new Date(ele.timeClose)
                        ]
                    );
                }
            }
        );


        dataTable.addRows(GoodYear.timeLineTable);

        chart.draw(dataTable);
    },
    getRequestData: function () {
        chrome.runtime.sendMessage({command: "getAjaxReadyData"}, function (response) {
            GoodYear.requestDatas = JSON.parse(response);
            GoodYear.onRequestDateReady.fire();
        });
    },
    onRequestDateReady: {
        DataReadyHandlers: [],
        addListener: function (callback) {
            GoodYear.onRequestDateReady.DataReadyHandlers.push(callback)
        },
        fire: function () {
            GoodYear.onRequestDateReady.DataReadyHandlers.forEach(function (callbacks) {
                callbacks();
                q = TAFFY(GoodYear.requestDatas);
            })
        }
    },
    draw: function () {
        GoodYear.getRequestData();
        GoodYear.onRequestDateReady.addListener(function () {
            GoodYear.initTimeLineChart();
        })
    },
    statistics: {}
};
TAFFY.extend("avg", function (c) {
    // This runs the query or returns the results if it has already run
    this.context({
        results: this.getDBI().query(this.context())
    });
    // setup the sum
    var total = 0;
    // loop over every record in the results and sum up the column.
    TAFFY.each(this.context().results, function (r) {
        if (r.timeClose !== "" && r.timeOpen !== "") {
            console.log((r.timeClose - r.timeOpen));
            total = total + (r.timeClose - r.timeOpen);
        }

    });

    // divide the total by the number of records and return
    return total / this.context().results.length;
});
TAFFY.extend("SamplingTime", function (c) {
    this.context({
        results: this.getDBI().query(this.context())
    });

    var start, end;

    TAFFY.each(this.context().results, function (r) {
        if (start == null) {
            start = r.timeOpen;
        }
        if (end == null) {
            end = r.timeClose;
        }
        if (r.timeOpen < start) {

        }
        if (r.timeClose > end) {
            end = r.timeClose;
        }
    });
    return (end - start) / 1000;
});
var q;

google.charts.load('current', {'packages': ['timeline']});
google.charts.setOnLoadCallback(GoodYear.draw);