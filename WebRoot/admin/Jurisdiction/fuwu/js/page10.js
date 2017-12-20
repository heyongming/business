layui.use([ 'form', 'layer', 'laydate' ], function() {
	var form = layui.form,
		$ = layui.jquery,
		layer = layui.layer,
		laydate = layui.laydate;
	//富文本编辑器操作
	var ue = UE.getEditor('marketContent');
	//时间
	laydate.render({
		elem : '#nowDate'
	});
	$(function() {
		form.render();
		show(); //展示数据
		addData(); //添加数据
	})
	//展示数据
	function show() {
		$.ajax({
			url : "/business/mbimcVote/getFullDataByMv",
			type : 'post',
			dataType : 'json',
			success : function(data) {
				// 渲染数据列表
				var tag = '';
				$.each(data, function(i, e) {
					tag += '<tr>' +
						'<td>' + e.mvId + '</td>' +
						'<td>' + e.mvTime + '</td>' +
						'<td>' + e.totalAssets + '</td>' +
						'<td>' + e.totalMarketValue + '</td>' +
						'<td>' + e.totalProfitAndLoss + '</td>' +
						'<td>' + e.title + '</td>' +
						'<td>' +
						'<a class="layui-btn btn1 layui-btn-mini">查看</a>' +
						'<a class="layui-btn btn2 layui-btn-mini">编辑总表</a>' +
						'<a class="layui-btn btn3 layui-btn-danger layui-btn-mini">总表删除</a>' +
						'<a class="layui-btn btn2 layui-btn-mini">当前持仓</a>' +
						'<a class="layui-btn btn2 layui-btn-mini">今日策略</a>' +
						'</td>' +
						'</tr>';
				});
				$('#content').empty().html(tag);
				// 给修改和删除按钮绑定单击事件
				$('#content tr').each(function(i, e) {
					var td = $(e).find('td:last-of-type'); //最后一个td
					var listId = $(e).find('td:eq(0)').text(); //ID
					// 查看
					td.find('a:eq(0)').click(function() {
						$.ajax({
							url : '/business/mbimcVote/getMbimcVoteByIdByMv',
							type : 'post',
							data : {
								listId : listId
							},
							dataType : 'json',
							success : function(data) {
								window.open("pageIndex.html");
							}
						})
					});
					// 编辑总表
					td.find('a:eq(1)').click(function() {
						
						//弹窗
						layer.open({
							type : 1,
							title : [ '天禄跟投产品编辑', 'font-size:18px' ],
							area : [ '1000px', '700px' ],
							content : $("#j_formAdd"),
							end : function() {
								$("#j_formAdd").hide()
							}
						})
						
						updateData(listId);
					});
					// 删除
					td.find('a:eq(2)').click(function() {
						layer.confirm('确定删除这些？', {
							btn : [ '确定', '取消' ] //按钮
						}, function() {
							del(listId);
						})
					});
					// 当前持仓
					td.find('a:eq(3)').click(function() {
						//弹窗
						layer.open({
							type : 1,
							title : [ '当前持仓情况', 'font-size:18px' ],
							area : [ '1000px', '700px' ],
							content : $("#chiCangTable"),
							end : function() {
								$("#chiCangTable").hide()
							}
						})
						//获取持仓数据
						chiCangData(listId);
					});
					/*添加持仓信息*/
					$("#addChiCang").click(function() {
						//弹窗
						layer.open({
							type : 1,
							title : [ '当前持仓情况添加数据', 'font-size:18px' ],
							area : [ '1000px', '700px' ],
							content : $("#chiCangTabAdd"),
							end : function() {
								$("#chiCangTabAdd").hide()
							}
						})
						chiCangAdd(listId) //提交
					})
					// 今日策略
					td.find('a:eq(4)').click(function() {
						//弹窗
						layer.open({
							type : 1,
							title : [ '今日策略情况', 'font-size:18px' ],
							area : [ '1000px', '700px' ],
							content : $("#jinRiTable"),
							end : function() {
								$("#jinRiTable").hide()
							}
						})
						//获取今日策略
						jinRiData(listId);
					});
					/*添加今日策略*/
					$("#addJinRi").click(function() {
						//弹窗
						layer.open({
							type : 1,
							title : [ '今日策略情况添加数据', 'font-size:18px' ],
							area : [ '1000px', '700px' ],
							content : $("#jinRiTabAdd"),
							end : function() {
								$("#jinRiTabAdd").hide()
							}
						})
						jinRiAdd(listId) //提交
					})
				});
			},
			error : function() {
				alert("获取列表失败");
			}
		});
	}
	/*添加数据*/
	function addData() {
		$("#add").click(function() {
			//弹窗
			layer.open({
				type : 1,
				title : [ '天禄跟投产品编辑', 'font-size:18px' ],
				area : [ '1000px', '700px' ],
				content : $("#j_formAdd"),
				end : function() {
					$("#j_formAdd").hide()
				}
			})
			// 给表单提交按钮绑定事件
			$("#btn").unbind('click').click(function() {
				// 获取所有的表单数据
				var marketContent = ue.getContent(); //获取富文本编辑器内容
				var formData = new FormData();
				formData.append("initialFunds", $("#beginMoney").val()); //初始资金
				formData.append("capitalBalance", $("#moneyBalance").val()); //资金余额
				formData.append("totalAssets", $("#totalAssets").val()); //总资产
				formData.append("totalMarketValue", $("#totalMarket").val()); //总市值
				formData.append("totalProfitAndLoss", $("#totalProfit").val()); //总盈亏
				formData.append("title", $("#title").val()); //标题
				formData.append("file", $("#imageUrl01")[0].files[0], $("#imageUrl01")[0].files[0].name); //资产走势图
				formData.append("vtFile", $("#imageUrl02")[0].files[0], $("#imageUrl02")[0].files[0].name); //净值走势图
				formData.append("marketAnalysis", marketContent); //市场分析
				$.ajax({
					type : 'post',
					url : '/business/mbimcVote/addmbimcVote',
					data : formData,
					processData : false,
					contentType : false,
					dataType : 'json',
					success : function(data) {
						//提交成功
						layer.msg('提交成功');
						layer.closeAll('page');
						show();
					},
					error : function() {
						layer.msg('提交失败，请联系管理员!');
					}
				});
				return false;
			});
		})
	}
	//修改
	function updateData(listId) {
		$.ajax({
			url : "/business/mbimcVote/getMbimcVoteByIdByMv",
			type : 'post',
			data : {
				mvId : listId
			},
			dataType : 'json',
			success : function(data) {
				//	alert(data)
				/*显示旧信息*/
				//	console.log(data)
				//let data=data[0];
				//console.log(data)
				ue.setContent(data[0].marketAnalysis); //市场分析
				$("#beginMoney").val(data[0].initialFunds); //初始资金
				$("#moneyBalance").val(data[0].capitalBalance); //资金余额
				$("#totalAssets").val(data[0].totalAssets); //总资产
				$("#totalMarket").val(data[0].totalMarketValue); //总市值
				$("#totalProfit").val(data[0].totalProfitAndLoss); //总盈亏
				$("#title").val(data[0].title); //标题
				$("#photoImg01").attr("src", data[0].assetChart) //资产走势图
				$("#photoImg02").attr("src", data[0].netValueTrendChart) //净值走势图
				// 给表单提交按钮绑定事件
				$("#btn").unbind('click').click(function() {
					// 获取所有的表单数据
					var marketContent = ue.getContent(); //获取富文本编辑器内容
					var formData = new FormData();

					formData.append("mvId", listId); //id
					formData.append("initialFunds", $("#beginMoney").val()); //初始资金
					formData.append("capitalBalance", $("#moneyBalance").val()); //资金余额
					formData.append("totalAssets", $("#totalAssets").val()); //总资产
					formData.append("totalMarketValue", $("#totalMarket").val()); //总市值
					formData.append("totalProfitAndLoss", $("#totalProfit").val()); //总盈亏
					formData.append("title", $("#title").val()); //标题
					if ($("#imageUrl01")[0].files[0] != null) {
						formData.append("file", $("#imageUrl01")[0].files[0], $("#imageUrl01")[0].files[0].name); //资产走势图
					}
					if ($("#imageUrl02")[0].files[0] != null) {
						formData.append("vtFile", $("#imageUrl02")[0].files[0], $("#imageUrl02")[0].files[0].name); //净值走势图
					}


					formData.append("marketAnalysis", marketContent); //市场分析
					$.ajax({
						type : 'post',
						url : '/business/mbimcVote/updateMbimcVote',
						data : formData,
						processData : false,
						contentType : false,
						dataType : 'json',
						success : function(data) {
							//提交成功
							layer.msg('修改成功');
							layer.closeAll('page');
							show();
						},
						error : function() {
							layer.msg('修改失败，请联系管理员!');
						}
					});
					return false;
				});
			}
		})
	}
	//删除
	function del(listId) {
		$(this).parent().parent().remove();
		$.ajax({
			url : '...',
			type : 'post',
			data : {
				listId : listId
			},
			dataType : 'json',
			success : function(data) {
				layer.msg('删除成功');
			},
			error : function() {
				layer.msg('删除失败，请联系管理员');
			}
		});
	}
	/*当前持仓情况添加数据弹窗*/
	function chiCangAdd(listId) {
		$("#addChiCangBtn").unbind('click').click(function() {
			// 获取所有的表单数据
			var formData = new FormData();
			formData.append("chiCangCode", $("#chiCangCode").val()); //代码
			formData.append("chiCangName", $("#chiCangName").val()); //名称
			formData.append("chiCangNum", $("#chiCangNum").val()); //持仓量
			formData.append("chiCangProportion", $("#chiCangProportion").val()); //持仓比例
			formData.append("chiCangPrice", $("#chiCangPrice").val()); //成本价
			formData.append("chiCangNew", $("#chiCangNew").val()); //最新价
			formData.append("chiCangValue", $("#chiCangValue").val()); //市值
			formData.append("chiCangProfit", $("#chiCangProfit").val()); //盈亏比例
			$.ajax({
				type : 'post',
				url : '...',
				data : formData,
				processData : false,
				contentType : false,
				dataType : 'json',
				success : function(data) {
					//提交成功
					layer.msg('提交成功');
					chiCangData(listId);
					$("#chiCangTabAdd").hide();
				},
				error : function() {
					layer.msg('提交失败，请联系管理员!');
				}
			});
			return false;
		})
	}
	//获取当前持仓情况数据
	function chiCangData(listId) {
		$.ajax({
			url : "...",
			type : 'post',
			data : {
				"listId" : listId
			},
			dataType : 'json',
			success : function(data) {
				// 渲染数据列表
				var tag = '';
				$.each(data, function(i, e) {
					tag += '<tr>' +
						'<td>id</td>' +
						'<td>代码</td>' +
						'<td>名称</td>' +
						'<td>持仓量</td>' +
						'<td>比例</td>' +
						'<td>成本价</td>' +
						'<td>最新价</td>' +
						'<td>市值</td>' +
						'<td>盈亏比例</td>' +
						'<td><a href="javascript:;" class="layui-btn layui-btn-danger layui-btn-mini">删除</a></td>' +
						'</tr>';
				});
				$('#chiCangContent').empty().html(tag);
				//操作
				$('#chiCangContent tr').each(function(i, e) {
					var td = $(e).find('td:last-of-type'); //最后一个td
					var chiCangtrId = $(e).find('td:eq(0)').text(); //ID
					// 删除
					td.find('a:eq(0)').click(function() {
						layer.confirm('确定删除这些？', {
							btn : [ '确定', '取消' ] //按钮
						}, function() {
							$(this).parent().parent().remove();
							$.ajax({
								url : '...',
								type : 'post',
								data : {
									chiCangtrId : chiCangtrId
								},
								dataType : 'json',
								success : function(data) {
									layer.msg('删除成功');
								},
								error : function() {
									layer.msg('删除失败，请联系管理员');
								}
							});
						})

					});
				});
			}
		})
	}

	/*今日策略情况添加数据弹窗*/
	function jinRiAdd(listId) {
		$("#jinRiBtn").unbind('click').click(function() {
			// 获取所有的表单数据
			var formData = new FormData();
			formData.append("nowDate", $("#nowDate").val()); //日期
			formData.append("jinRiName", $("#jinRiName").val()); //名称
			formData.append("jinRiCode", $("#jinRiCode").val()); //代码
			formData.append("jinRibuy", $("#jinRibuy").val()); //买进
			formData.append("jinRiOut", $("#jinRiOut").val()); //卖出
			formData.append("jinRiPrice", $("#jinRiPrice").val()); //价格
			formData.append("jinRiNum", $("#jinRiNum").val()); //数量
			$.ajax({
				type : 'post',
				url : '...',
				data : formData,
				processData : false,
				contentType : false,
				dataType : 'json',
				success : function(data) {
					//提交成功
					layer.msg('提交成功');
					jinRiData(listId);
					$("#jinRiTabAdd").hide();
				},
				error : function() {
					layer.msg('提交失败，请联系管理员!');
				}
			});
			return false;
		})
	}
	//获取今日策略情况数据
	function jinRiData(listId) {
		$.ajax({
			url : "...",
			type : 'post',
			data : {
				"listId" : listId
			},
			dataType : 'json',
			success : function(data) {
				// 渲染数据列表
				var tag = '';
				$.each(data, function(i, e) {
					tag += '<tr>' +
						'<td>id</td>' +
						'<td>日期</td>' +
						'<td>名称</td>' +
						'<td>代码</td>' +
						'<td>买进</td>' +
						'<td>卖出</td>' +
						'<td>价格</td>' +
						'<td>数量</td>' +
						'<td><a href="javascript:;" class="layui-btn layui-btn-danger layui-btn-mini">删除</a></td>' +
						'</tr>';
				});
				$('#jinRiContent').empty().html(tag);
				//操作
				$('#jinRiContent tr').each(function(i, e) {
					var td = $(e).find('td:last-of-type'); //最后一个td
					var jinRitrId = $(e).find('td:eq(0)').text(); //ID
					// 删除
					td.find('a:eq(0)').click(function() {
						layer.confirm('确定删除这些？', {
							btn : [ '确定', '取消' ] //按钮
						}, function() {
							$(this).parent().parent().remove();
							$.ajax({
								url : '...',
								type : 'post',
								data : {
									jinRitrId : jinRitrId
								},
								dataType : 'json',
								success : function(data) {
									layer.msg('删除成功');
								},
								error : function() {
									layer.msg('删除失败，请联系管理员');
								}
							});
						})

					});
				});
			}
		})
	}
})