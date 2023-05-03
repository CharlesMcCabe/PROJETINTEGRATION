function action(interval, outputSize, chartType) {

  graphic(abbreviation, interval, outputSize, chartType);
  
}

function action2(abbreviation, interval, outputSize, chartType) {

  graphic(abbreviation, interval, outputSize, chartType);

}

function getSymbolUrl(name) {
  const urlParams = new URLSearchParams(window.location.search);
console.log(urlParams.get(name));
  return urlParams.get(name);
}



var ancienInterval = null;
var ancienChartType = null;


function graphic(symbol, interval, outputSize, chartType) {
  console.log("fonction exécutée");
  const apiKey = '309d8ab554114f79835de8d8c62c0404';
  // symbole de l'action pour laquelle vous voulez obtenir les données
  if (ancienInterval == null) {
    ancienInterval = '1week';
  }
  if (interval == null) {
    interval = ancienInterval;
  }
  if (outputSize == null) {
    outputSize = 50; // intervalle de temps souhaité (par exemple : 1min, 5min, 15min, 30min, 45min, 1h, 2h, 4h, 1day, 1week, 1month)
  }
  if (ancienChartType == null) {
    ancienChartType = 'area';
  }
  if (chartType == null) {
    chartType = ancienChartType;
  }

  console.log(interval);
  console.log(symbol);
  console.log(chartType);
  // construire l'URL de l'API
  const apiUrl = `https://api.twelvedata.com/time_series?symbol=${symbol}&interval=${interval}&outputsize=${outputSize}&apikey=${apiKey}&timezone=America/New_York`;

  ancienInterval = interval;
  ancienChartType = chartType;

  // envoyer la requête à l'API
  fetch(apiUrl)
    .then(response => response.json())
    .then(data1 => {

      var chartData = data1.values;
      // les données de la série temporelle sont stockées dans l'objet data

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
          type: chartType,
          height: 350
        },
        title: {
          text: 'Graphique du prix de l\'action',
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
      chart.resetSeries();
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
      const marketCapitalization = data2.MarketCapitalization;
      const bookValue = data2.BookValue;
      const profitMargin = data2.ProfitMargin;
      const priceToSalesRatio = data2.PriceToSalesRatioTTM;
      const grossProfit = data2.GrossProfitTTM;


      document.getElementById("infosActions").innerText = symbol;
      document.getElementById("actionName").innerText = companyName;
      document.getElementById("actionExchange").innerText = exchange;
      document.getElementById("actionPERatio").innerText = per;
      document.getElementById("actionDividendPerShare").innerText = dividendPerShare;
      document.getElementById("actionDividendYield").innerText = (dividendYield*100).toFixed(2) + "%";
      document.getElementById("actionRevenuePerShare").innerText = revenuePerShare;
      document.getElementById("actionMarketCapitalization").innerText = marketCapitalization;
      document.getElementById("actionBookValue").innerText = bookValue;
      document.getElementById("actionProfitMargin").innerText = profitMargin;
      document.getElementById("actionPriceToSalesRatio").innerText = priceToSalesRatio;
      document.getElementById("actionGrossProfit").innerText = grossProfit;

    })
    .catch(error => {
      console.error(error);
    });
}