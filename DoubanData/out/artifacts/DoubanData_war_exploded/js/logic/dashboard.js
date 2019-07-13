layui.use(['jquery','layer'],function () {
    var layer=layui.layer,
        $=layui.jquery;
    //按年份统计-近年10年影片
    $.post(
        "/logic/imdb/analysis/10yearsTotal",
        {},
        function (data) {
            var years=[]
            var totals=[]
            $.each(data,function (index,item) {
                years.push(item.years);
                totals.push(item.total);
            });
            var yearsCount=echarts.init($('#divYearsCount')[0]);
            var option={
                title:{
                    text:'近10年影片总数据'
                },
                tooltip:{},
                legend:{
                    data:['影片数量']
                },
                xAxis:{
                    data:years
                },
                yAxis: {},
                series:[{
                    name:'数量',
                    type:'bar',
                    data:totals
                }]
            };
            yearsCount.setOption(option);
        }
    )
    $.post(
        "/logic/imdb/analysis/rating",
        {},
        function (data) {
            var numbers=[]
            var rating=[]
            $.each(data,function (index,item) {
                rating.push(item.rating);
                numbers.push(item.numbers);
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
        "/logic/imdb/analysis/area",
        {},
        function (data) {
            var yearsCount=echarts.init($('#divAreaCount')[0]);
            $.each(data,function (index,item) {
                item.name=item.area;
                item.value=item.total;
            });

            var option = {
                background:'white',
                tooltip:{
                    trigger:'item',
                    formatter:"地区<br/>{b}:{c}({d}%)"
                },
                series: [{
                    name:'area',
                    type:'pie',
                    radius:'55%',
                    center:['50%','50%'],
                    data: data.sort(function (a,b) {return a.total -b.total}),
                    itemStyle:{
                        emphasis:{
                            shadowBlur:10,
                            shadowOffsetX:0,
                            shadowColor:'rgba(0,0,0,0.5)'
                        }
                    }
                }]
            };
            yearsCount.setOption(option);
        }
    )
    $.post(
        "/logic/imdb/analysis/EleTotal",
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