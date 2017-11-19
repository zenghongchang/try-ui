		<#include "management/header.ftl"/>
		<#include "page/page.ftl"/>	
		<section class="rt_wrap content mCustomScrollbar">
			<div class="rt_content">
				<section>					
					<div class="page_title">
					
					</div>
					<table class="table">
						<tr>
							<th>用户名</th>
							<th>登录名</th>
							<th>头像</th>
							<th>固定电话</th>
							<th>手机</th>
							<th>QQ</th>
							<th>邮箱</th>
							<th>创建时间</th>
							<th>更新时间</th>
							<th>系统备注</th>
						</tr>
						<#--<div class="cut_title ellipsis"></div>-->
						<#if userList??>
							<#list userList as user>
								<tr>
									<td>${user.userName!''}</td>
									<td>${user.loginName!''}</td>
									<td>${user.userName!''}</td>
									<td>${user.fixedTelephone!''}</td>
									<td>${user.mobilePhone!''}</td>
									<td>${user.qq!''}</td>
									<td></td>
									<td></td>
									<td></td>
									<td>${user.sysRemark!''}</td>
								</tr>
							</#list>
						</#if>						
					</table>
					<aside class="paging">
						<@pagination formId="search_user"/>
					</aside>
				</section>
			</div>
		</section>
	</body>
</html>