Highcharts.setOptions({
			lang:{
				printChart: '打印图表',
				downloadPNG: '下载PNG图片',
				downloadJPEG: '下载JPEG图片',
				downloadPDF: '下载PDF文档',
				downloadSVG: '下载SVG矢量图',
				exportButtonTitle: '导出图片',
				contextButtonTitle:'图表菜单'
			}
		});
var dashboard={
		init:function(){
			var orgName=$("#orgName").val();
			var picture1=$("#picture1").val();
			var picture2=$("#picture2").val();
			var picture3=$("#picture3").val();
			var picture4=$("#picture4").val();
			var picture5=$("#picture5").val();
			if(picture1=='yes'){
			$.post("./dashboard/loadChartData","type=4",function(r_data){
				$('#picture1_1').css('width','959px');
				$('#picture1_1').highcharts({
					
					chart: {
			            zoomType: 'xy'
			        },
			        credits: {                                                         
				        enabled: false                                                 
				    }, 

			        title: {
			            text: '各月结存贷款情况'
			        },
			        subtitle: {
						text: orgName
					},
			        xAxis: r_data.xAxis,
			        yAxis: [{ 
			        	min:0,
			            labels: {
			                format: '{value:,f} 户',
			                style: {
			                    color: '#89A54E'
			                }
			            },
			            title: {
			                text: '结存贷款户数',
			                style: {
			                    color: '#89A54E'
			                }
			            }
			        }, { 
			            title: {
			                text: '结存贷款金额',
			                style: {
			                    color: '#4572A7'
			                }
			            },
			            labels: {
			                format: '{value:,f} 万元',
			                style: {
			                    color: '#4572A7'
			                }
			            },
			            opposite: true
			        }],
			        tooltip: {
			            shared: true
			        },
			        series: [{
			            name: '结存贷款金额',
			            color: '#4572A7',
			            type: 'column',
			            yAxis: 1,
			            data: r_data.seriesColumn,
			            tooltip: {
			            	valueDecimals: 0,
			                valueSuffix: ' 万元'
			            }

			        }, {
			            name: '结存贷款户数',
			            color: '#89A54E',
			            type: 'spline',
			            data: r_data.seriesLine,
			            tooltip: {
			                valueSuffix: ' 户'
			            }
			        }]

				});
			});
			
			$.post("./dashboard/loadChartData","type=44",function(r_data){
				$('#picture1_2').css('width','959px');
				$('#picture1_2').highcharts({
					
					chart: {
			            zoomType: 'xy'
			        },
			        credits: {                                                         
				        enabled: false                                                 
				    }, 
			        title: {
			            text: $("#currentMonth").val(),
			        },
			        subtitle: {
						text: orgName
					},
			        xAxis: r_data.xAxis,
			        yAxis: [{ 
			        	min:0,
			        	allowDecimals:false ,
			            labels: {
			                format: '{value:,f} 户',
			                style: {
			                    color: '#89A54E'
			                }
			            },
			            title: {
			                text: '结存贷款户数',
			                style: {
			                    color: '#89A54E'
			                }
			            }
			        }, { 
			            title: {
			                text: '结存贷款金额',
			                style: {
			                    color: '#4572A7'
			                }
			            },
			            labels: {
			                format: '{value:,f} 万元',
			                style: {
			                    color: '#4572A7'
			                }
			            },
			            opposite: true
			        }],
			        tooltip: {
			            shared: true
			        },
			        series: [{
			            name: '结存贷款金额',
			            color: '#4572A7',
			            type: 'column',
			            yAxis: 1,
			            data: r_data.seriesColumn,
			            tooltip: {
			            	valueDecimals: 0,
			                valueSuffix: ' 万元'
			            }

			        }, {
			            name: '结存贷款户数',
			            color: '#89A54E',
			            type: 'spline',
			            data: r_data.seriesLine,
			            tooltip: {
			                valueSuffix: ' 户'
			            }
			        }]

				});
			});
			
			}
			if(picture2=='yes'){
			$.post("./dashboard/loadChartData","type=0",function(r_data){
				$('#picture2_1').css('width','959px');
				$('#picture2_1').highcharts({
					
					chart: {
			            zoomType: 'xy'
			        },
			        credits: {                                                         
				        enabled: false                                                 
				    }, 
			        title: {
			            text: '各月投放贷款情况'
			        },
			        subtitle: {
						text: orgName
					},
			        xAxis: r_data.xAxis,
			        yAxis: [{ 
			        	min:0,
			            labels: {
			                format: '{value:,f} ',
			                style: {
			                    color: '#89A54E'
			                }
			            },
			            title: {
			                text: '投放贷款户数',
			                style: {
			                    color: '#89A54E'
			                }
			            }
			        }, { 
			            title: {
			                text: '投放贷款金额',
			                style: {
			                    color: '#4572A7'
			                }
			            },
			            labels: {
			                format: '{value:,f} 万元',
			                style: {
			                    color: '#4572A7'
			                }
			            },
			            opposite: true
			        },{ 
			            labels: {
			                format: '{value:,f} 笔数',
			                style: {
			                    color: '#89A54E'
			                }
			            },
			            title: {
			                text: '投放贷款笔数',
			                style: {
			                    color: '#9F4D95'
			                }
			            }
			        }
			        
			        ],
			        tooltip: {
			            shared: true
			        },
			        series: [{
			            name: '投放贷款金额',
			            color: '#4572A7',
			            type: 'column',
			            yAxis: 1,
			            data: r_data.seriesColumn,
			            tooltip: {
			            	valueDecimals: 0,
			                valueSuffix: ' 万元'
			            }

			        }, {
			            name: '投放贷款户数',
			            color: '#89A54E',
			            type: 'spline',
			            data: r_data.seriesLine,
			            tooltip: {
			                valueSuffix: ' 户'
			            }
			        },{
			            name: '投放贷款笔数',
			            color: '#9F4D95',
			            type: 'spline',
			            data: r_data.seriesCount,
			            tooltip: {
			                valueSuffix: ' 笔'
			            }
			        }
			        ]

				});
			});
			
			$.post("./dashboard/loadChartData","type=00",function(r_data){
				$('#picture2_2').css('width','959px');
				$('#picture2_2').highcharts({
					
					chart: {
			            zoomType: 'xy'
			        },
			        title: {
			            text: $("#currentMonth").val(),
			        },
			        credits: {                                                         
				        enabled: false                                                 
				    }, 
			        subtitle: {
						text: orgName
					},
			        xAxis: r_data.xAxis,
			        yAxis: [{ 
			        	min:0,
			        	allowDecimals:false ,
			            labels: {
			                format: '{value:,f} 笔',
			                style: {
			                    color: '#9F4D95'
			                }
			            },
			            title: {
			                text: '投放贷款笔数',
			                style: {
			                    color: '#9F4D95'
			                }
			            }
			        }, { 
			            title: {
			                text: '投放贷款金额',
			                style: {
			                    color: '#4572A7'
			                }
			            },
			            labels: {
			                format: '{value:,f} 万元',
			                style: {
			                    color: '#4572A7'
			                }
			            },
			            opposite: true
			        }],
			        tooltip: {
			            shared: true
			        },
			        series: [{
			            name: '投放贷款金额',
			            color: '#4572A7',
			            type: 'column',
			            yAxis: 1,
			            data: r_data.seriesColumn,
			            tooltip: {
			            	valueDecimals: 0,
			                valueSuffix: ' 万元'
			            }

			        }, {
			            name: '投放贷款笔数',
			            color: '#9F4D95',
			            type: 'spline',
			            data: r_data.seriesLine,
			            tooltip: {
			                valueSuffix: ' 笔'
			            }
			        }]

				});
			});
			}
			if(picture3=='yes'){
				
			$.post("./dashboard/loadChartData","type=1",function(r_data){
				$('#picture3_1').css('width','959px');
				$('#picture3_1').highcharts({
					
					chart: {
			            zoomType: 'xy'
			        },
			        credits: {                                                         
				        enabled: false                                                 
				    }, 
			        title: {
			            text: '各月回收贷款情况'
			        },
			        subtitle: {
						text: orgName
					},
			        xAxis: r_data.xAxis,
			        yAxis: [{ 
			        	min:0,
			            labels: {
			                format: '{value:,f} 万元',
			                style: {
			                    color: '#89A54E'
			                }
			            },
			            title: {
			                text: '回收贷款利息+罚息（万元）',
			                style: {
			                    color: '#89A54E'
			                }
			            }
			        }, { 
			            title: {
			                text: '回收贷款本金（万元）',
			                style: {
			                    color: '#4572A7'
			                }
			            },
			            labels: {
			                format: '{value:,f} 万元',
			                style: {
			                    color: '#4572A7'
			                }
			            },
			            opposite: true
			        }],
			        tooltip: {
			            shared: true
			        },
			        series: [{
			            name: '回收贷款本金（万元）',
			            color: '#4572A7',
			            type: 'column',
			            yAxis: 1,
			            data: r_data.seriesColumn,
			            tooltip: {
			            	valueDecimals: 0,
			                valueSuffix: ' 万元'
			            }

			        }, {
			            name: '回收贷款利息+罚息（万元）',
			            color: '#89A54E',
			            type: 'spline',
			            data: r_data.seriesPercent,
			            tooltip: {
			            	valueDecimals: 0,
			                valueSuffix: ' 万元'
			            }
			        }]

				});
			});
			
			$.post("./dashboard/loadChartData","type=11",function(r_data){
				$('#picture3_2').css('width','959px');
				$('#picture3_2').highcharts({
					
					chart: {
			            zoomType: 'xy'
			        },
			        credits: {                                                         
				        enabled: false                                                 
				    }, 
			        title: {
			            text: $("#currentMonth").val(),
			        },
			        subtitle: {
						text: orgName
					},
			        xAxis: r_data.xAxis,
			        yAxis: [{ 
			        	min:0,
			        	allowDecimals:false ,
			            labels: {
			                format: '{value:,f} 万元',
			                style: {
			                    color: '#89A54E'
			                }
			            },
			            title: {
			                text: '回收贷款利息+罚息（万元）',
			                style: {
			                    color: '#89A54E'
			                }
			            }
			        }, { 
			            title: {
			                text: '回收贷款本金（万元）',
			                style: {
			                    color: '#4572A7'
			                }
			            },
			            labels: {
			                format: '{value:,f} 万元',
			                style: {
			                    color: '#4572A7'
			                }
			            },
			            opposite: true
			        }],
			        tooltip: {
			            shared: true
			        },
			        series: [{
			            name: '回收贷款本金（万元）',
			            color: '#4572A7',
			            type: 'column',
			            yAxis: 1,
			            data: r_data.seriesColumn,
			            tooltip: {
			            	valueDecimals: 0,
			                valueSuffix: ' 万元'
			            }

			        }, {
			            name: '回收贷款利息+罚息（万元）',
			            color: '#89A54E',
			            type: 'spline',
			            data: r_data.seriesPercent,
			            tooltip: {
			            	valueDecimals: 0,
			                valueSuffix: ' 万元'
			            }
			        }]

				});
			});
			}
			if(picture4=='yes'){
			$.post("./dashboard/loadChartData","type=2",function(r_data){
				if(!r_data){
					return;
				}
				$('#picture4_1').css('width','959px');
				$('#picture4_1').highcharts({
					
					chart: {
			            zoomType: 'xy'
			        },
			        credits: {                                                         
				        enabled: false                                                 
				    }, 
			        title: {
			            text: '预计各月回收贷款情况'
			        },
			        subtitle: {
						text: orgName
					},
			        xAxis: r_data.xAxis,
			        yAxis: [{ 
			        	min:0,
			            labels: {
			                format: '{value:,f} 万元',
			                style: {
			                    color: '#89A54E'
			                }
			            },
			            title: {
			                text: '预计回收贷款利息（万元）',
			                style: {
			                    color: '#89A54E'
			                }
			            }
			        }, { 
			            title: {
			                text: '预计回收贷款金额（万元）',
			                style: {
			                    color: '#4572A7'
			                }
			            },
			            labels: {
			                format: '{value:,f} 万元',
			                style: {
			                    color: '#4572A7'
			                }
			            },
			            opposite: true
			        }],
			        tooltip: {
			            shared: true
			        },
			        series: [{
			            name: '预计回收贷款金额（万元）',
			            color: '#4572A7',
			            type: 'column',
			            yAxis: 1,
			            data: r_data.seriesColumn,
			            tooltip: {
			            	valueDecimals: 0,
			                valueSuffix: ' 万元'
			            }

			        }, {
			            name: '预计回收贷款利息（万元）',
			            color: '#89A54E',
			            type: 'spline',
			            data: r_data.seriesPercent,
			            tooltip: {
			            	valueDecimals: 0,
			                valueSuffix: ' 万元'
			            }
			        }]

				});
			});
			
			$.post("./dashboard/loadChartData","type=22",function(r_data){
				$('#picture4_2').css('width','959px');
				$('#picture4_2').highcharts({
					
					chart: {
			            zoomType: 'xy'
			        },
			        credits: {                                                         
				        enabled: false                                                 
				    }, 
			        title: {
			            text: $("#nextMonth").val(),
			        },
			        subtitle: {
						text: orgName
					},
			        xAxis: r_data.xAxis,
			        yAxis: [{ 
			        	min:0,
			        	allowDecimals:false ,
			            labels: {
			                format: '{value:,f} 万元',
			                style: {
			                    color: '#89A54E'
			                }
			            },
			            title: {
			                text: '预计回收贷款利息（万元）',
			                style: {
			                    color: '#89A54E'
			                }
			            }
			        }, { 
			            title: {
			                text: '预计回收贷款金额（万元）',
			                style: {
			                    color: '#4572A7'
			                }
			            },
			            labels: {
			                format: '{value:,f} 万元',
			                style: {
			                    color: '#4572A7'
			                }
			            },
			            opposite: true
			        }],
			        tooltip: {
			            shared: true
			        },
			        series: [{
			            name: '预计回收贷款金额（万元）',
			            color: '#4572A7',
			            type: 'column',
			            yAxis: 1,
			            data: r_data.seriesColumn,
			            tooltip: {
			            	valueDecimals: 0,
			                valueSuffix: ' 万元'
			            }

			        }, {
			            name: '预计回收贷款利息（万元）',
			            color: '#89A54E',
			            type: 'spline',
			            data: r_data.seriesPercent,
			            tooltip: {
			            	valueDecimals: 0,
			                valueSuffix: ' 万元'
			            }
			        }]

				});
			});
			}
			if(picture5=='yes'){
			$.post("./dashboard/loadChartData","type=3",function(r_data){
				if(!r_data){
					return;
				}
				$('#picture5_1').css('width','959px');
				$('#picture5_1').highcharts({
					
//					chart: {
//			            zoomType: 'xy'
//			        },
					chart: { type: 'column' },
			        credits: {                                                         
				        enabled: false                                                 
				    }, 
			        title: {
			            text: '各月贷款逾期情况'
			        },
			        subtitle: {
						text: orgName
					},
			        xAxis: r_data.xAxis,
//			        yAxis: [{ 
//			        	min:0,
//			            labels: {
//			                format: '{value:,f} %',
//			                style: {
//			                    color: '#89A54E'
//			                }
//			            },
//			            title: {
//			                text: '不良率（%）',
//			                style: {
//			                    color: '#89A54E'
//			                }
//			            }
//			        }, { 
//			            title: {
//			                text: '逾期率（%）',
//			                style: {
//			                    color: '#4572A7'
//			                }
//			            },
//			            labels: {
//			                format: '{value:,f} %',
//			                style: {
//			                    color: '#4572A7'
//			                }
//			            },
//			            opposite: true
//			        }],
			        yAxis: { 
			        	min: 0, title: { text: '' },
					    labels: {
			                format: '{value:,f} %',
			                style: {
			                    color: '#89A54E'
			                       }
			                    },
					},
			        tooltip: { pointFormat: 
			           '<span style="font-size:10px">{point.key}</span>'+'<table>'+
     		           '<tr>'+
    	               '<td style="color:{series.color};padding:0"><tspan style="fill:#4572A7" x="8" dy="16">●</tspan>{series.name}: </td>'+
    		           '<td style="padding:0">'+
    	                 '<b>{point.y:.2f} %</b>'+
    		           '</td></tr></table>', 
			        	shared: true, 
			        	useHTML: true }, 
			        	plotOptions: { column: { 
			        		pointPadding: 0.2, 
			        		borderWidth: 0 
			        		} 
			        	},
//			        tooltip: {
//			            shared: true
//			        },
			        series: [{
			            name: '逾期率（%）',
			            color: '#4572A7',
//			            type: 'column',
//			            yAxis: 1,
			            data: r_data.seriesColumn,
//			            tooltip: {
//			            	valueDecimals: 2,
//			                valueSuffix: ' %'
//			            }

			        }, {
			            name: '不良率（%）',
			            color: '#89A54E',
//			            type: 'column',
			            data: r_data.seriesPercent,
//			            tooltip: {
//			            	valueDecimals: 2,
//			                valueSuffix: ' %'
//			            }
			        }]

				});
			});
			
			$.post("./dashboard/loadChartData","type=33",function(r_data){
				$('#picture5_2').css('width','959px');
				$('#picture5_2').highcharts({
					
//					chart: {
//			            zoomType: 'xy'
//			        },
					chart: { type: 'column' },
			        credits: {                                                         
				        enabled: false                                                 
				    }, 
			        title: {
			            text: $("#currentMonth").val(),
			        },
			        subtitle: {
						text: orgName
					},
			        xAxis: r_data.xAxis,

			        yAxis: { 
			        	min: 0, title: { text: '' },
					    labels: {
			                format: '{value:,f} %',
			                style: {
			                    color: '#89A54E'
			                       }
			                    },
					},
			        tooltip: { pointFormat: 
			           '<span style="font-size:10px">{point.key}</span>'+'<table>'+
     		           '<tr>'+
    	               '<td style="color:{series.color};padding:0"><tspan style="fill:#4572A7" x="8" dy="16">●</tspan>{series.name}: </td>'+
    		           '<td style="padding:0">'+
    	                 '<b>{point.y:.2f} %</b>'+
    		           '</td></tr></table>', 
			        	shared: true, 
			        	useHTML: true }, 
			        	plotOptions: { column: { 
			        		pointPadding: 0.2, 
			        		borderWidth: 0 
			        		} 
			        	},
			        series: [{
			            name: '逾期率（%）',
			            color: '#4572A7',
//			            type: 'column',
//			            yAxis: 1,
			            data: r_data.seriesColumn,
//			            tooltip: {
//			            	valueDecimals: 2,
//			                valueSuffix: ' %'
//			            }

			        }, {
			            name: '不良率（%）',
			            color: '#89A54E',
//			            type: 'column',
			            data: r_data.seriesPercent,
//			            tooltip: {
//			            	valueDecimals: 2,
//			                valueSuffix: ' %'
//			            }
			        }]

				});
			});
			}
		},
		test:function(){
			console.log("dashboard test ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		}
};
