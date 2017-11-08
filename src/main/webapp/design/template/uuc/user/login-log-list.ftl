<aside class="tpmc_aside_r  dis_ib">
        <#include "uuc/user/login-log-query.ftl"/>
        <div style="clear: both;">
            <@spring.page pager=pager  toURL="${toURL}"/>
        </div>
        <section class="user_tab_box  wl_guanli shang_tab_box" >
	      <#include "uuc/user/login-log-result.ftl"/>
	    </section>
</aside>