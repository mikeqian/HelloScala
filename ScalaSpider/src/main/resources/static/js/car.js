$(function () {
    getItem();
})

function getItem() {
    $.post(util.getAbsUrl("report/car"),
        {},
        function (data) {
            show(data);
        });
};

function show(data) {
    var myChart = echarts.init(document.getElementById('main'));

    var shops = [];
    var prices = [];

    for (var i = 0; i < data.cars.length; i++) {
        var car = data.cars[i];
        shops.push(car.shopName)
        prices.push(car.price);
    }

    var option = {
        title: {
            text: '黑店报价'
        },
        tooltip: {},
        legend: {
            data: ['报价']
        },
        xAxis: {
            data: shops
        },
        yAxis: {},
        series: [{
            name: '报价',
            type: 'bar',
            data: prices
        }]
    };

    myChart.setOption(option);
}
;

