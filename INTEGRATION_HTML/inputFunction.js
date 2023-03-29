function action() {
  var input;
  var abbreviation;
  element = document.getElementById("txtActions");
  if (element != null) {
    input = element.value;
    abbreviation = input.substring(0, input.indexOf(' '));
    //console.log(abbreviation);
    document.getElementById("infosActions").innerText = abbreviation;
    console.log(abbreviation);
    graphic(abbreviation);
  }
  else {
    input = null;
    abbreviation = null;
    console.log(abbreviation);
    return null;
  }

}
console.log(action());
window.onload = action();

function graphic(symbole) {
const apiKey = '309d8ab554114f79835de8d8c62c0404';
const symbol = symbole; // symbole de l'action pour laquelle vous voulez obtenir les données
const interval = '5min'; // intervalle de temps souhaité (par exemple : 1min, 5min, 1hour, 1day, 1week, 1month)
const outputSize = 30; // nombre de points de données à récupérer

// construire l'URL de l'API
const apiUrl = `https://api.twelvedata.com/time_series?symbol=${symbol}&interval=${interval}&outputsize=${outputSize}&apikey=${apiKey}&timezone=America/New_York`;



// envoyer la requête à l'API
fetch(apiUrl)
  .then(response => response.json())
  .then(data1 => {

    var chartData = data1.values;
    // les données de la série temporelle sont stockées dans l'objet data
    console.log(data1);
    var data = [];
    // Boucle pour ajouter chaque objet de données au tableau "data"
    for (var i = 0; i < chartData.length; i++) {
      data.push({
        x: new Date(chartData[i].datetime),
        y: [chartData[i].open, chartData[i].high, chartData[i].low, chartData[i].close]
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


    var chart = new ApexCharts(document.querySelector("#chart"), options);
    chart.render();

  })
  .catch(error => {
    console.log(error);
  });











const apiKey2 = "G7JEWLBGCCURCQX8";
// Remplacez AAPL par le symbole boursier de l'entreprise dont vous souhaitez récupérer les informations

fetch(`https://www.alphavantage.co/query?function=OVERVIEW&symbol=${symbol}&apikey=${apiKey2}`)
  .then(response => response.json())
  .then(data2 => {
    console.log(data2);
    // Faites ce que vous voulez avec les données, par exemple :
    const companyName = data2.Name;
    const description = data2.Description;
    const exchange = data2.Exchange;
    const currency = data2.Currency;
    const industry = data2.Industry;
    const country = data2.Country;
    const per = data2.PERatio;
    const dividendPerShare = data2.DividendPerShare;
    const dividendYield = data2.DividendYield;
    const revenuePerShare = data2.RevenuePerShareTTM;


    document.getElementById("actionDescription").innerText = description;
  })
  .catch(error => {
    console.error(error);
  });
}