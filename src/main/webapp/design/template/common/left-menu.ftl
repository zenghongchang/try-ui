<aside class="tpmc_aside_l  dis_ib">
	<div class="" >
		<div class="lf dis_ib pa div_nav_left"  >
			<ul class="tpmc_left_ul">
			    <@tpmcAuth name="tpmc.user.management.center">
				<li  attr="user|index"><b class="img_com img_postion1"></b></li>
				</@tpmcAuth>
				<@tpmcAuth name="tpmc.product.manage.center">
				<li  attr="product" ><b class="img_com img_postion2"></b></li>
				</@tpmcAuth>
				<@tpmcAuth name="tpmc.material.warehouse.management.center">
				<li attr="material|materialStock"><b class="img_com img_postion3"></b></li>
				</@tpmcAuth>
				<#--
				<@tpmcAuth name="manageUser">
				<li ><b class="img_com img_postion4"></b></li>
				</@tpmcAuth>
				-->
				<#--
				<@tpmcAuth name="manageUser">
				<li ><b class="img_com img_postion5"></b></li>
				</@tpmcAuth>
				-->
				
				<@tpmcAuth name="tpmc.finished.warehouse.management.center">
				<li attr="productStock" ><b class="img_com img_postion6"></b></li>
				</@tpmcAuth>
				<#--
				<@tpmcAuth name="manageUser">
				<li ><b class="img_com img_postion7"></b></li>
				</@tpmcAuth>
				-->
				<@tpmcAuth name="tpmc.supply.chain">
				<li attr="supply"><b class="img_com img_postion8"></b></li>
				</@tpmcAuth>
				<@tpmcAuth name="tpmc.production">
				<li attr="production" ><b class="img_com img_postion9"></b></li>
				</@tpmcAuth>
				<#--
				<@tpmcAuth name="manageUser">
				<li ><b class="img_com img_postion10"></b></li>
				</@tpmcAuth>
				-->
			</ul>
		</div>
		
		<div class="lf dis_ib pa tpmc_left_div_box vx_top" style="left: 62px;">
		    <@tpmcAuth name="tpmc.user.management.center"> 
			<div class="tpmc_left_div " style="display: block;">
				<div>
					<span class="user_center lf" ><@spring.message "user.center"/></span>
					<span class="rt shouqi"></span>
				</div>
				<ul class="nav_ul clear_only">
					<@tpmcAuth name="tpmc.user.management">
						<li style="" class="word_else"><a href="/user/manageUserList" ><@spring.message "manage.user"/></a></li>
					</@tpmcAuth>	
					<@tpmcAuth name="tpmc.user.management.group">
					    <li style="" class="word_else"><a href="/user/groupList" ><@spring.message "manage.user.group"/></a></li>
					</@tpmcAuth>
                    <@tpmcAuth name="tpmc.user.login.log">
						<li style="" class="word_else">
							   <a href="/user/manageUserLoginLog"><@spring.message "user.login.log"/></a>
	                    </li>
                    </@tpmcAuth>
                    <@tpmcAuth name="tpmc.user.center.menu.management">
						<li style="" class="word_else">
							   <a href="/user/listMenu"><@spring.message "menu.manage"/></a>
	                    </li>
                    </@tpmcAuth>
				</ul>
			</div>
			</@tpmcAuth>
			
			<@tpmcAuth name="tpmc.product.manage.center">
			<div class="tpmc_left_div" >
				<div>
					<span class="user_center lf" ><@spring.message "product.center"/></span>
					<span class="rt shouqi"></span>
				</div>
				<ul class="nav_ul clear_only">
					<@tpmcAuth name="tpmc.product.center.sku.management">
						<li style="" class="word_else"><a href="/product/listProduct" ><@spring.message "sku.manage"/></a></li>
					</@tpmcAuth>
					<@tpmcAuth name="tpmc.product.center.sku.prop.management">
						<li><a href="/product/listSkuAttributeKind" ><@spring.message "sku.attribute.manage"/></a></li>
					</@tpmcAuth>
					<@tpmcAuth name="tpmc.product.center.sku.category.management">
						<li><a href="/product/categoryManagement" ><@spring.message "product.category.manage"/></a></li>
					</@tpmcAuth>
					<@tpmcAuth name="tpmc.product.center.unit.management">
						<li style="" class="word_else"><a href="/product/unitManageList" ><@spring.message "unit.manage"/></a></li>
					</@tpmcAuth>
					<@tpmcAuth name="tpmc.product.center.materiel.management">
						<li style="" class="word_else">
						      <a href="/product/listMaterial"><@spring.message "list.material"/></a>
						</li>
                    </@tpmcAuth>
                    <@tpmcAuth name="tpmc.product.center.materiel.category.management">
						<li style="" class="word_else">
						      <a href="/product/listMaterialCategory"><@spring.message "list.material.category"/></a>
						</li>
                    </@tpmcAuth>
               </ul>
			</div>
			</@tpmcAuth>
			
		    <@tpmcAuth name="tpmc.material.warehouse.management.center">
			  <div class="tpmc_left_div" >
				<div>
					<span class="user_center lf" ><@spring.message "manage.material.stock"/></span>
					<span class="rt shouqi"></span>
				</div>
				<ul class="nav_ul clear_only">
				    <@tpmcAuth name="tpmc.material.warehouse.in.out.record">
						<li style="" class="word_else">
						      <a href="/material/manageMaterialStockRecord"><@spring.message "in.out.stock.record"/></a>
						   
						</li>
                    </@tpmcAuth>
                    <@tpmcAuth name="tpmc.material.warehouse.transposition">
						<li style="" class="word_else">
						      <a href="/materialStock/listDisseatStock"><@spring.message "list.disseat.stock"/></a>
						</li>
                    </@tpmcAuth>
                    <@tpmcAuth name="tpmc.material.warehouse.invntory">
						<li style="" class="word_else">
						      <a href="/materialStock/listInventoryStock"><@spring.message "list.inventory.stock"/></a>
						</li>
                    </@tpmcAuth>
                    <@tpmcAuth name="tpmc.material.warehouse.material.storage">
						<li style="" class="word_else">
						      <a href="/materialStock/materialInStock"><@spring.message "material.in.stock"/></a>
						</li>
                    </@tpmcAuth>
                    <@tpmcAuth name="tpmc.material.warehouse.material.delivery">
						<li style="" class="word_else">
						      <a href="/materialStock/materialOutStock"><@spring.message "material.out.stock"/></a>
						</li>
                    </@tpmcAuth>
				</ul>
				
				<@tpmcAuth name="tpmc.material.warehouse.config">
					<div>
						<span class="user_center lf" ><@spring.message "configuration"/></span>
					</div>
					<ul class="nav_ul clear_only">
					    <@tpmcAuth name="tpmc.material.warehouse.in.out.type.management">
							<li style="" class="word_else">
							      <a href="/material/manageMaterialInoutType"><@spring.message "manage.in.out.type"/></a>
							</li>
	                    </@tpmcAuth>
	                    <@tpmcAuth name="tpmc.material.warehouse.position.management">
							<li style="" class="word_else">
							      <a href="/materialStock/listStorage"><@spring.message "list.storage"/></a>
							</li>
	                    </@tpmcAuth>
	                    <@tpmcAuth name="tpmc.material.warehouse.stock.code.management">
							<li style="" class="word_else">
							      <a href="/materialStock/listStockCode"><@spring.message "list.stock.code"/></a>
							</li>
	                    </@tpmcAuth>
					</ul>
				 </@tpmcAuth>
			</div>
		    </@tpmcAuth>
		    <#--
            <@tpmcAuth name="manageUser">	
			  <div class="tpmc_left_div" >
				 4
			   </div>
			</@tpmcAuth>-->
			<#--
            <@tpmcAuth name="manageUser">	
			   <div class="tpmc_left_div" >
					5
			   </div>
			</@tpmcAuth>
			-->
			<@tpmcAuth name="tpmc.finished.warehouse.management.center">
			<div class="tpmc_left_div" >
			    <div>
					<span class="user_center lf" ><@spring.message "finish.product.stock.manage"/></span>
					<span class="rt shouqi"></span>
				</div>
				<ul class="nav_ul clear_only">
				    <@tpmcAuth name="tpmc.finished.warehouse.management.center.position.management">
						<li style="" class="word_else"><a href="/productStock/manageProductShelfCode" ><@spring.message "list.storage"/></a></li>
					</@tpmcAuth>
					 <@tpmcAuth name="tpmc.finished.warehouse.management.center.in.out.record">
						<li style="" class="word_else">
						      <a href="/product/manageProductStockRecord"><@spring.message "in.out.stock.record"/></a>
						</li>
                    </@tpmcAuth>
                    <@tpmcAuth name="tpmc.finished.warehouse.finished.storage">
						<li style="" class="word_else">
						      <a href="/productStock/productInStock"><@spring.message "product.in.stock"/></a>
						</li>
                    </@tpmcAuth>
                    <@tpmcAuth name="tpmc.finished.warehouse.finished.delivery">
						<li style="" class="word_else">
						      <a href="/productStock/productOutStock"><@spring.message "product.out.stock"/></a>
						</li>
                    </@tpmcAuth>	
				</ul>
			</div>
			</@tpmcAuth>
			<#--
            <@tpmcAuth name="manageUser">	
			   <div class="tpmc_left_div" >
				 7
			   </div>
			</@tpmcAuth>-->
			<@tpmcAuth name="tpmc.supply.chain">
			<div class="tpmc_left_div " >
				<div>
					<span class="user_center lf" ><@spring.message "supply.chain"/></span>
					<span class="rt shouqi"></span>
				</div>
				<ul class="nav_ul clear_only">
					<@tpmcAuth name="tpmc.supply.chain.provider.management">
						<li style="" class="word_else"><a href="/supply/manageProvider" >
						<@spring.message "manage.provider"/>
						</a></li>
					</@tpmcAuth>
				</ul>
				
				<@tpmcAuth name="tpmc.supply.chain.factory.management">
					<ul class="nav_ul clear_only">
							<li style="" class="word_else"><a href="/supply/manageFactory" >
							<@spring.message "manage.factory"/>
							</a></li>
					</ul>
				</@tpmcAuth>
				
				<@tpmcAuth name="tpmc.supply.chain.material.purchasing">
				<ul class="nav_ul clear_only">
						<li style="" class="word_else">
						<@spring.message "material.purchase"/>
						</li>
					<@tpmcAuth name="tpmc.supply.chain.material.purchasing.order.management">
						<li><a href="/supply/listMaterialPurchaseOrder?flag=view" ><@spring.message "manage.material.purchase.order"/></a></li>
					</@tpmcAuth>
					<@tpmcAuth name="tpmc.supply.chain.material.purchasing.order.audit.by.supervisor">
						<li><a href="/supply/listMaterialPurchaseOrder?reviewStatus=20" ><@spring.message "manage.director.material.purchase.order"/></a></li>
					</@tpmcAuth>
					<@tpmcAuth name="tpmc.supply.chain.material.purchasing.order.audit.by.manager">
						<li><a href="/supply/listMaterialPurchaseOrder?reviewStatus=30" ><@spring.message "manage.manager.material.purchase.order"/></a></li>
					</@tpmcAuth>
					<@tpmcAuth name="tpmc.supply.chain.material.purchasing.order.audit.by.director">
						<li><a href="/supply/listMaterialPurchaseOrder?reviewStatus=40" ><@spring.message "manage.inspector.material.purchase.order"/></a></li>
					</@tpmcAuth>
					<@tpmcAuth name="tpmc.supply.chain.material.purchasing.order.audit.by.ceo">
						<li><a href="/supply/listMaterialPurchaseOrder?reviewStatus=50" ><@spring.message "manage.general.manager.material.purchase.order"/></a></li>
					</@tpmcAuth>
					<@tpmcAuth name="tpmc.supply.chain.material.purchasing.order.audit.by.financial">
						<li><a href="/supply/listMaterialPurchaseOrder?reviewStatus=60" ><@spring.message "manage.finance.material.purchase.order"/></a></li>
					</@tpmcAuth>
						<@tpmcAuth name="tpmc.supply.chain.material.purchasing.order.wait.for.recieving">
						<li><a href="/supply/waitGetGoodsMaterialPurchaseOrderListing" ><@spring.message "wait.get.goods.material.purchase.order"/></a></li>
					</@tpmcAuth>
					<@tpmcAuth name="tpmc.supply.chain.material.purchasing.order.wait.for.pay">
						<li><a href="/supply/listMaterialPurchaseOrder?reviewStatus=70" ><@spring.message "manage.pay.material.purchase.order"/></a></li>
					</@tpmcAuth>
					<@tpmcAuth name="tpmc.supply.chain.material.purchasing.order.finished">
						<li><a href="/supply/listMaterialPurchaseOrder?reviewStatus=80" ><@spring.message "manage.finish.material.purchase.order"/></a></li>
					</@tpmcAuth>
					<@tpmcAuth name="tpmc.supply.chain.material.purchasing.order.wait.for.in.stock">
						<li><a href="/supply/waitInStockMaterialListing" ><@spring.message "wait.in.stock.material.listing"/></a></li>
					</@tpmcAuth>
				</ul>
			   </@tpmcAuth>
			</div>
			</@tpmcAuth>
			<@tpmcAuth name="tpmc.production">
			<div class="tpmc_left_div" >
			    <div>
					<span class="user_center lf" ><@spring.message "production"/></span>
					<span class="rt shouqi"></span>
				</div>
				<ul class="nav_ul clear_only">
				    <@tpmcAuth name="tpmc.production.order.management">
						<li style="" class="word_else"><a href="/production/manageProductionOrder" >
						<@spring.message "manage.production.order"/></a></li>
					</@tpmcAuth>
					 <@tpmcAuth name="tpmc.production.cutting.sheet">
						<li style="" class="word_else"><a href="/production/manageCutMaterialOrder" >
						<@spring.message "cut.bed.order.manage"/></a></li>
					</@tpmcAuth>
					 <@tpmcAuth name="tpmc.production.check.bar.management">
						<li style="" class="word_else"><a href="/production/manageCutFeItem" >
						<@spring.message "cut.bed.fe.item.manage"/></a></li>
					</@tpmcAuth>
					 <@tpmcAuth name="tpmc.production.check.bar.in.stock">
						<li style="" class="word_else"><a href="/production/cutFeItemInStock" >
						<@spring.message "cut.fe.item.in.stock"/></a></li>
					</@tpmcAuth>
				</ul>
			</div>
			</@tpmcAuth>
			<#--
            <@tpmcAuth name="manageUser">
				<div class="tpmc_left_div" >
					10
				</div>
			</@tpmcAuth>-->
		   </div>
		</div>			
	</div>
</aside>
