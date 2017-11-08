<table class="user_tab chanpin_xz_tab" style="clear: both;" attr='{"totalPages":"${pager.totalPages}","totalRecords":"${pager.totalRecords}"}'>
				<tr class="user_tr_one">
					<td style="width: 10%"><div class="td_div1"><@spring.message "user.name"/></div></td>
					<td style="width: 10%"><@spring.message  "ip.address"/></td>
					<td style="width: 10%"><@spring.message "login.address"/></td>
					<td style="width: 10%"><@spring.message "user.agent"/></td>
					<td style="width: 10%"><@spring.message "login.time"/></td>
					<td style="width: 10%"><@spring.message "logout.time"/></td>
					<td style="width: 15%"  class="user_td"><@spring.message "online.time"/></td>
				</tr> 
				<tr id="tp_tr">
					<td colspan="7"></td>
				</tr>
				<#if pager??&&pager.pageList??>
				   <#list pager.pageList as row>
				        <#assign id = row.id />
						<tr>
							<td><div class="td_div1">${row.loginName!''}</div></td>
							<td>${row.ipAddress!''}</td>
							<td>${row.loginAddress!''}</td>
							<td style="width: 5%">${row.userAgent!''}</td>
							<td> 
							   <#if row.loginTime?? && ""!=row.loginTime> 
                                     ${row.loginTime?datetime} 
                               </#if>
                            </td>
							<td>
							   <#if row.logoutTime?? && ""!=row.logoutTime>
							      ${row.logoutTime?datetime}
                               </#if>
							</td>
							<td>
							   <#if row.duration??>
							      <#assign duration=row.duration!0/>
							      <#assign day=(duration/(24*60*60*1000))?int/>
							      <#assign hour=(duration/(60*60*1000)-(day*24))?int/>
							      <#assign min=((duration/(60*1000))-(day*24*60)-(hour*60))?int/>
							      <#assign s=((duration/1000)-(day*24*60*60)-(hour*60*60)-(min*60))?int/>
							      ${day}<@spring.message "day"/>
                                  ${hour}<@spring.message "hour"/>
                                  ${min}<@spring.message "min"/>
                                  ${s}<@spring.message "s"/>
                               </#if>
							</td>
						</tr>
				  </#list>
                </#if>				
</table>