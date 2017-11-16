<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Laboratory</title>
		<script src="design/static/js/vue.js"></script>
		<script src="design/static/js/axios.js"></script>
	</head>

	<body>
		<h1>我是主页，我怕谁。。。。。</h1>
		<div id="user">
			<div style="padding:10px">
				name:<input type="text" v-model="user.name" /> age:
				<input type="text" v-model="user.age" /> logName:
				<input type="text" v-model="user.logName" />
			</div>

			<div>
				<button @click="addUser">add user</button>
				<button @click="addUserEs">add user es</button>
			</div>
			<div>
				<button @click="queryUser">query user</button>
			</div>
			<div>
				<table style="border-left:1px solid #000;border-bottom:1px solid #000;" cellpadding="0" cellspacing="0">
					<tr v-for="(u,index) in ulist">
						<td style="border-right:1px solid #000; border-top:1px solid #000;width:100px;">{{u.id}} - {{ index }}</td>
						<td style="border-right:1px solid #000;border-top:1px solid #000;width:100px;">{{u.name}}</td>
						<td style="border-right:1px solid #000;border-top:1px solid #000;width:100px;">{{u.age}}</td>
						<td style="border-right:1px solid #000;border-top:1px solid #000;width:100px;">{{u.logName}}</td>
					</tr>
				</table>
			</div>

			<div>
				<h3>我是elasticsearch数据    共{{usersE.dataTotal}}条     共{{usersE.pageTotal}}页   一页{{usersE.pageSize}}条   第{{usersE.pageNumber}}页    </h3> <button @click="nextPage(usersE.pageNumber)">下一页</button>
				<table style="border-left:1px solid #000;border-bottom:1px solid #000;" cellpadding="0" cellspacing="0">
					<tr v-for="(u,index) in usersE.pageData">
						<td style="border-right:1px solid #000; border-top:1px solid #000;width:100px;">{{u.id}} - {{ index }}</td>
						<td style="border-right:1px solid #000;border-top:1px solid #000;width:100px;">{{u.name}}</td>
						<td style="border-right:1px solid #000;border-top:1px solid #000;width:100px;">{{u.age}}</td>
						<td style="border-right:1px solid #000;border-top:1px solid #000;width:100px;">{{u.logName}}</td>
					</tr>
				</table>
			</div>

			<div>
				<h3>我是mysql数据    共{{userjpa.dataTotal}}条     共{{userjpa.pageTotal}}页   一页{{userjpa.pageSize}}条   第{{userjpa.pageNumber}}页    </h3><button @click="prePageMysql(userjpa.pageNumber)">上一页</button> <button @click="nextPageMysql(userjpa.pageNumber,userjpa.pageTotal)">下一页</button>
				<table style="border-left:1px solid #000;border-bottom:1px solid #000;" cellpadding="0" cellspacing="0">
					<tr v-for="(u,index) in userjpa.pageData">
						<td style="border-right:1px solid #000; border-top:1px solid #000;width:100px;">{{u.id}} - {{ index }}</td>
						<td style="border-right:1px solid #000;border-top:1px solid #000;width:100px;">{{u.name}}</td>
						<td style="border-right:1px solid #000;border-top:1px solid #000;width:100px;">{{u.age}}</td>
						<td style="border-right:1px solid #000;border-top:1px solid #000;width:100px;">{{u.logName}}</td>
					</tr>
				</table>
			</div>

			<div style="padding:10px">
				<p> name:{{user1.name}}
					<p/>
					<p> age:{{user1.age}}
						<p/>
						<p> logName:{{user1.logName}}
							<p/>
			</div>

			{{user1.isflag}}
		</div>
	</body>

	<script>
		var v = new Vue({
			el: '#user',
			data: {
				registerUrl: "/user/getUserByRedis",
				name: 'add',
				user: "",
				user1: "",
				ulist: '',
				usersE: '',
				userjpa: ''
			},
			methods: {
				addUser: function(event) {
					axios({
						method: 'post',
						url: "/user/add",
						params: {
							name: 'abc',
							age: 33,
							id: 1,
							logName: '中文'
						}
					}).then(function(response) {
						alert(response.data);
						v.user1.isflag = response.data;
					}).catch(function(error) {
						alert(error);
					});
				},
				addUserEs: function(event) {
					for(i = 4; i < 51; i++) {
						axios({
							method: 'post',
							url: "/user/addUesrEs",
							params: {
								name: 'Es测试' + i,
								age: 33,
								id: i,
								logName: 'admin' + i
							}
						}).then(function(response) {
							alert(response.data);
							v.user1.isflag = response.data;
						}).catch(function(error) {
							alert(error);
						});
					}
				},
				nextPage: function(pageNumber) {
					axios({
						method: 'post',
						url: '/user/pageUserEs',
						params: {
							direction: 1,
							pageSize: 10,
							pageNo: pageNumber + 1
						}
					}).then(function(res) {
						v.usersE = res.data;
					}).catch(function(error) {
						alert(error);
					});
				},
				prePageMysql: function(pageNumber) {
					if(pageNumber == 1) {
						return;
					}
					axios({
						method: 'post',
						url: '/user/pageUserJpa',
						params: {
							direction: 1,
							pageSize: 3,
							pageNo: pageNumber - 1
						}
					}).then(function(res) {
						v.userjpa = res.data;
					}).catch(function(error) {
						alert(error);
					});
				},
				nextPageMysql: function(pageNumber, pageTotal) {
					if(pageNumber == pageTotal) {
						return;
					}
					axios({
						method: 'post',
						url: '/user/pageUserJpa',
						params: {
							direction: 1,
							pageSize: 3,
							pageNo: pageNumber + 1
						}
					}).then(function(res) {
						v.userjpa = res.data;
					}).catch(function(error) {
						alert(error);
					});
				},
				queryUser: function(event) {
					axios({
						method: 'post',
						url: '/customer/queryCustomerById',
						params: {
							id: '1'
						},
						headers: {
							'Content-Type': 'application/x-www-form-urlencoded'
						}
					}).then(function(response) {
						alert(JSON.stringify(response.data));
						v.user1 = response.data;
					}).catch(function(error) {
						alert(error);
					});
				}
			},
			/**
			mounted: function() {
				// this.$nextTick(function () {
				axios.post('/user/query/1').then(function(res) {
					console.log(res.data)
					v.user = res.data;
				});
				axios.post('/user/list').then(function(res) {
					console.log(res.data)
					v.ulist = res.data;
				});
				axios({
					method: 'post',
					url: '/user/pageUserEs',
					params: {
						direction: 1,
						pageSize: 10
					}
				}).then(function(res) {
					v.usersE = res.data;
				}).catch(function(error) {
					alert(error);
				});
				axios({
					method: 'post',
					url: '/user/pageUserJpa',
					params: {
						direction: 1,
						pageSize: 3
					}
				}).then(function(res) {
					v.userjpa = res.data;
				}).catch(function(error) {
					alert(error);
				});
				axios({
					method: 'post',
					url: this.registerUrl,
					params: {
						name: 'abc'
					}
				}).then(function(response) {
					v.user1 = response.data;
				}).catch(function(error) {
					alert(error + "555");
				});
			},*/
		})
	</script>

</html>