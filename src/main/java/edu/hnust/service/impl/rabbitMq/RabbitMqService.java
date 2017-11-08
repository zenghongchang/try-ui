package edu.hnust.service.impl.rabbitMq;

import java.io.IOException;

import edu.hnust.core.rabbitMq.MQSender;

public class RabbitMqService {
	
	public final static String MQ_NAME_QTY_MATERIAL = "tpmc_material_qty_change_material_mq";
	public final static String MQ_NAME_QTY_PRODUCT = "tpmc_product_qty_change_product_mq";

	public static void sendQtyChangeToMaterialMq(Integer materialId, Integer shelfCodeId) {
		_doSendMaterialInventoryChangeMQ(materialId, shelfCodeId, MQ_NAME_QTY_MATERIAL, null, 
				"material inventory change info for");
	}
	
	private static void _doSendMaterialInventoryChangeMQ(Integer materialId,
			Integer shelfCodeId, String mqName, String host, String messageTitle) {
		MQSender mq = null;
		try {
			mq = new MQSender(mqName, host, messageTitle);
			mq.send(materialId + "|" + shelfCodeId);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != mq) {
					mq.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void sendQtyChangeToProductMq(Integer materialId, Integer shelfCodeId) {
		_doSendProductInventoryChangeMQ(materialId, shelfCodeId, MQ_NAME_QTY_PRODUCT, null, 
				"product inventory change info for");
	}
	
	private static void _doSendProductInventoryChangeMQ(Integer productId,
			Integer shelfCodeId, String mqName, String host, String messageTitle) {
		MQSender mq = null;
		try {
			mq = new MQSender(mqName, host, messageTitle);
			mq.send(productId + "|" + shelfCodeId);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != mq) {
					mq.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
