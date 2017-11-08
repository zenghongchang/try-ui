<style>
#page_number{
    text-align: center;
    width: 24px;
    margin-top: 2px;
    border: none;
    outline: 0;
    height: 25px;
    line-height: 25px;
    border-radius: 0;
}
</style>
<@spring.page pager=pager  toURL="${toURL}"/>
<ul class="view_log_container2 page  right_float">
		<@tpmcAuth name="tpmc_user_center_menu_management_add">
			<li class="right_float"><a class="fbt_btn68_green user_search" href="/user/editAddMenu" type="button"><@spring.message "new.save"/></a></li>
		</@tpmcAuth>	
</ul>