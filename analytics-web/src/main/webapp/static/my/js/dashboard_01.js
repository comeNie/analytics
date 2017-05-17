$(function(){
	$.post("./dashboard/loadChartData","type=3",function(r_data){
		console.log(r_data);
	});
	$('#dashboard_AddLoanArea').highcharts({
        chart: {
            type: 'area'
        },
        title: {
            text: '新增贷款金额趋势图'
        },
        subtitle: {
            text: '本年趋势'
        },
        xAxis: {
        	categories: [
			             '201401',
			             '201402',
			             '201403',
			             '201404',
			             '201405',
			             '201406',
			             '201407',
			             '201408',
			             '201409',
			             '201410',
			             '201411',
			             '201412'
			             ]
        },
        yAxis: {
            title: {
                text: 'Nuclear weapon states'
            },
            labels: {
            	format: '{value:,f} 万元'
            }
        },
        tooltip: {
            pointFormat: '{series.name} ：{point.y:,.3f}万元'
        },
        /*plotOptions: {
            area: {
                pointStart: 1940,
                marker: {
                    enabled: false,
                    symbol: 'circle',
                    radius: 2,
                    states: {
                        hover: {
                            enabled: true
                        }
                    }
                }
            }
        },*/
        series: [{
            name: '小微新增贷款金额',
            data: [75345345.0, 634534.9, 9.5, 14.5, 18.2, 21.5, 25.2, 2634534.5, 23.3, 18.3, 13.9, null]
        }, {
            name: '全部新增贷款金额',
            data: [33453.2, 340.8, 3435.7, 11.3, 1345347.0, 22.0, 2345344.8, 24.1, 20.1, 14.1, 8.6, null]
        }]
    });
	$('#dashboard_addLoanLine').highcharts({
		//lang:highcharts_lang,
		title: {
			text: '新增贷款金额趋势图',
			x: -20 //center
		},
		/* subtitle: {
            text: 'Source: WorldClimate.com'
        },*/
		xAxis: {
			categories: [
			             '201312',
			             '201401',
			             '201402',
			             '201403',
			             '201404',
			             '201405',
			             '201406',
			             '201407',
			             '201408',
			             '201409',
			             '201410',
			             '201411'
			             ]
		},
		yAxis: {
			title: {
				text: '新增贷款金额 (万元)'
			},
			plotLines: [{
				value: 0,
				width: 1,
				color: '#808080'
			}]
		},
		tooltip: {
			valueSuffix: '万元'
		},
		/*legend: {
			layout: 'vertical',
			align: 'center',
			verticalAlign: 'middle',
			borderWidth: 0
		},*/
		series: [{
			name: '新增全部贷款金额',
			data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
		}, {
			name: '新增小微贷款金额',
			data: [-0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5]
		}]
	});
	$('#dashboard_LoanBalancesBar').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: '结存贷款余额趋势图'
        },
        subtitle: {
            text: '本年趋势'
        },
        xAxis: {
            categories: [
                '201401',
                '201402',
                '201403',
                '201404',
                '201405',
                '201406',
                '201407',
                '201408',
                '201409',
                '201410',
                '201411'
            ]
        },
        yAxis: {
            min: 0,
            title: {
                text: '结存贷款余额(万元)'
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.1f} 万元</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{
            name: '2014结存贷款余额',
            data: [49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6]

        }]
    });
	$('#dashboard_LbGuarModePie').highcharts({
        chart: {
            type: 'pie',
            options3d: {
                enabled: true,
                alpha: 45,
                beta: 0
            }
        },
        title: {
            text: '结存贷款金额-担保方式分布图 '
        },
        subtitle: {
        	text: '统计日期：2014-11-20'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                depth: 35,
                dataLabels: {
                    enabled: true,
                    format: '{point.name}'
                }
            }
        },
        series: [{
            type: 'pie',
            name: '贷款担保方式',
            data: [
                ['保证',   45.0],
                ['信用',       26.8],
                {
                    name: '抵押',
                    y: 12.8,
                    sliced: true,
                    selected: true
                },
                ['质押',    15.4]
            ]
        }]
    });
 $('#dashboard_LbAmtPie').highcharts({
        chart: {
            type: 'pie',
            options3d: {
                enabled: true,
                alpha: 45,
                beta: 0
            }
        },
        title: {
            text: '结存贷款金额-合同金额分布图'
        },
        subtitle: {
        	text: '统计日期：2014-11-20'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                depth: 35,
                dataLabels: {
                    enabled: true,
                    format: '{point.name}'
                }
            }
        },
        series: [{
            type: 'pie',
            name: '合同金额比例',
            data: [
                ['100万元（含）以下',   45.0],
                ['(100万元,200万元 ]',       26.8],
                {
                    name: '(200万元,300万元 ]',
                    y: 12.8,
                    sliced: true,
                    selected: true
                },
                ['(300万元,400万元 ]',    8.5],
                ['(400万元,500万元 ]',     6.2],
                ['500万元以上',   0.7]
            ]
        }]
    });
})