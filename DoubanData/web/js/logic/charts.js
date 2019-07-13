layui.use(['jquery','layer'],function () {
    var layer=layui.layer,
        $=layui.jquery;

    $.post(
        "/logic/douban/analysis/rating",
        {},
        function (data) {
            var numbers=[]
            var rating=[]
            $.each(data,function (index,item) {
                rating.push(item.rating);
                numbers.push(item.mns);
            });

            var yearsCount=echarts.init($('#divRatingCount')[0]);
            var option = {
                title:{
                    text:'各个排名的评分情况'
                },
                tooltip:{},
                xAxis: {
                    name:'排名',
                    type: 'category',
                    data: numbers
                },
                yAxis: {
                    type: 'value'
                },
                series: [{
                    name:'评分',
                    data: rating,
                    type: 'line'
                }]
            };
            yearsCount.setOption(option);
        }
    )
    $.post(
        "/logic/douban/analysis/area",
        {},
        function (data) {
            var years=[]
            var totals=[]
            $.each(data,function (index,item) {
                years.push(item.country);
                totals.push(item.total);
            });
            var yearsCount=echarts.init($('#divAreaCount')[0]);
            var option = {
                title:{
                    text:'地区情况'
                },
                tooltip:{},
                legend:{
                    data:['地区人数']
                },
                xAxis: {
                    type: 'category',
                    data: years
                },
                yAxis: {
                    type: 'value'
                },
                series: [{
                    data: totals,
                    type: 'bar'
                }]
            };

            yearsCount.setOption(option);
        }
    )

    $.post(
        "/logic/douban/analysis/lan",
        {},
        function (data) {
            var numbers=[]
            var rating=[]
            $.each(data,function (index,item) {
                rating.push(item.total);
                numbers.push(item.languages);
            });
            var yearsCount=echarts.init($('#divLanCount')[0]);
            var option = {
                title:{
                    text:'语言使用情况'
                },
                tooltip:{},
                xAxis: {
                    name:'语言',
                    type: 'category',
                    data: numbers
                },
                yAxis: {
                    type: 'value'
                },
                series: [{
                    name:'数量',
                    data: rating,
                    type: 'line'
                }]
            };
            yearsCount.setOption(option);
        }
    )
    $.post(
        "/logic/douban/analysis/EleTotal",
        {},

        function (data) {
            var years=[]
            var totals=[]
            $.each(data,function (index,item) {
                years.push(item.mns);
                totals.push(item.total);
            });
            var yearsCount=echarts.init($('#divEleCount')[0]);
            var option = {
                title:{
                    text:'评论情况'
                },
                tooltip:{},
                legend:{
                    data:['评论人数']
                },
                xAxis: {
                    type: 'category',
                    data: years
                },
                yAxis: {
                    type: 'value'
                },
                series: [{
                    data: totals,
                    type: 'bar'
                }]
            };

            yearsCount.setOption(option);
        }
    )

})