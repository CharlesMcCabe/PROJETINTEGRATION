src = "./StockChart_files/apexcharts"
var imports = new JavaImporter(java.io);

var chercheur = new Java.type("ApiChercheurTwelveData")("AAPL");
console.log(chercheur.symbole);




function createChart(jsonChart)
{

    var data = [];

    // Boucle pour ajouter chaque objet de données au tableau "data"
    for (var i = 0; i < jsonChart.length; i++) {
        data.push({
            x: new Date(jsonChart[i].date),
            y: [jsonChart[i].open, jsonChart[i].high, jsonChart[i].low, jsonChart[i].close]
        });
    }

    var options = {
        series: [{
            data: data
        }],

        chart: {
            type: 'candlestick',
            height: 350
        },
        title: {
            text: 'CandleStick Chart',
            align: 'left'
        },
        xaxis: {
            type: 'datetime'
        },
        yaxis: {
            tooltip: {
                enabled: true
            }
        }
    };
    var data = []
    data.push()

    options.get(series)
    var chart = new ApexCharts(document.querySelector("#chart"), jsonChart.options);
    chart.render();
}
function envoyerSymbole() {

    var chercheur = new Java.type("ApiChercheurTwelveData")("AAPL");
    console.log(chercheur.symbole);


}