package edu.hnust.application.common.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

/**
 * 图片压缩工具类
 * 
 * @author Henry(fba02)
 * @version [版本号, 2017年11月17日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ImageThumbUtil {
    
    /** 压缩质量为100% */
    public static double PERCENT_100 = 1.0;
    
    /**
     * 图片尺寸不变,图片内存压缩 压缩图片文件大小outputQuality实现,参数1为最高质量,此处0.1f表示压缩为原内存的1/10
     * 
     * @param originalImgPath 源图片路径
     * @param targetImgPath 压缩后图片路径
     * @throws Exception
     * @author Henry(fba02)
     * @version [版本号, Jun 20, 2017]
     * @see [类、类#方法、类#成员]
     */
    public static void thumbImage(String originalImgPath, String targetImgPath)
        throws Exception {
        Thumbnails.of(originalImgPath).scale(1f).outputQuality(0.25f).toFile(targetImgPath);
    }
    
    /**
     * 缩略图片，图片质量为源图的100%
     * 
     * @param originalImgPath 源图片存储路径
     * @param w 图片压缩后的宽度
     * @param h 图片压缩后的高度
     * @param targetImgPath 缩略图的存放路径
     * @throws Exception
     * @author Henry(fba02)
     * @version [版本号, Jun 20, 2017]
     * @see [类、类#方法、类#成员]
     */
    public static void thumbImage(String originalImgPath, int w, int h, String targetImgPath)
        throws Exception {
        thumbImage(new FileInputStream(originalImgPath), w, h, targetImgPath, PERCENT_100);
    }
    
    /**
     * 缩略图片，图片质量为源图100%
     * 
     * @param originalImgData 源图片字节数
     * @param w 图片压缩后的宽度
     * @param h 图片压缩后的高度
     * @param targetImgPath 缩略图的存放路径
     * @throws Exception
     * @author Henry(fba02)
     * @version [版本号, Jun 20, 2017]
     * @see [类、类#方法、类#成员]
     */
    public static void thumbImage(byte[] originalImgData, int w, int h, String targetImgPath)
        throws Exception {
        thumbImage(new ByteArrayInputStream(originalImgData), w, h, targetImgPath, PERCENT_100);
    }
    
    /**
     * 按尺寸比例缩略
     * 
     * @param originalInputSteam 源图输入流
     * @param w 缩略宽
     * @param h 缩略高
     * @param targetImgPath 缩略图存储路径
     * @param compressQalitiy 缩略质量比例，0~1之间的数
     * @throws Exception
     * @author Henry(fba02)
     * @version [版本号, Jun 20, 2017]
     * @see [类、类#方法、类#成员]
     */
    public static void thumbImage(InputStream originalInputSteam, int w, int h, String targetImgPath, double compressQalitiy)
        throws Exception {
        thumbImage(originalInputSteam, w, h, targetImgPath, compressQalitiy, true);
    }
    
    /**
     * 
     * @param originalImgInputSteam 源图片输入流
     * @param w 图片压缩后的宽度
     * @param h 图片压缩后的高度
     * @param targetImgPath 缩略图的存放路径
     * @param compressQalitiy 压缩比例,0~1之间的double数字
     * @param keepAspectRatio 是否保持等比例压缩,是true,不是false
     * @throws Exception
     * @author Henry(fba02)
     * @version [版本号, Jun 20, 2017]
     * @see [类、类#方法、类#成员]
     */
    public static void thumbImage(InputStream originalImgInputSteam, int w, int h, String targetImgPath, double compressQalitiy, boolean keepAspectRatio)
        throws Exception {
        Thumbnails.of(originalImgInputSteam).size(w, h).outputQuality(Double.valueOf(compressQalitiy)).keepAspectRatio(true).toFile(targetImgPath);
    }
    
    /**
     * 图片裁剪
     * 
     * @param originalImgPath 源图片路径
     * @param position 位置 0正中间，1中间左边，2中间右边，3底部中间，4底部左边，5底部右边，6顶部中间，7顶部左边，8顶部右边,其他为默认正中间
     * @param w 裁剪宽度
     * @param h 裁剪高度
     * @param targetImgPath 新图片路径
     * @throws Exception
     * @author Henry(fba02)
     * @version [版本号, Jun 20, 2017]
     * @see [类、类#方法、类#成员]
     */
    public static void crop(String originalImgPath, int position, int w, int h, String targetImgPath)
        throws Exception {
        Thumbnails.of(originalImgPath).sourceRegion(getPositions(position), w, h).size(w, h).outputQuality(1).toFile(targetImgPath);
    }
    
    /**
     * 图片添加水印
     * 
     * @param originalImgPath 将被添加水印图片路径
     * @param watermarkImgPath 水印图片
     * @param position 位置 0正中间，1中间左边，2中间右边，3底部中间，4底部左边，5底部右边，6顶部中间，7顶部左边，8顶部右边，其他为默认正中间
     * @param opacity 不透明度,取0~1之间的float数字，0完全透明，1完全不透明
     * @param targetImgPath 含有水印的新图片路径
     * @throws Exception
     * @author Henry(fba02)
     * @version [版本号, Jun 20, 2017]
     * @see [类、类#方法、类#成员]
     */
    public static void watermark(String originalImgPath, String watermarkImgPath, int position, float opacity, String targetImgPath)
        throws Exception {
        Thumbnails.of(originalImgPath).watermark(getPositions(position), ImageIO.read(new File(watermarkImgPath)), opacity).scale(1.0).outputQuality(1).toFile(targetImgPath);
    }
    
    private static Positions getPositions(int position) {
        Positions p = Positions.CENTER;
        switch (position) {
            case 0: {
                p = Positions.CENTER;
                break;
            }
            case 1: {
                p = Positions.CENTER_LEFT;
                break;
            }
            case 2: {
                p = Positions.CENTER_RIGHT;
                break;
            }
            case 3: {
                p = Positions.BOTTOM_CENTER;
                break;
            }
            case 4: {
                p = Positions.BOTTOM_LEFT;
                break;
            }
            case 5: {
                p = Positions.BOTTOM_RIGHT;
                break;
            }
            case 6: {
                p = Positions.TOP_CENTER;
                break;
            }
            case 7: {
                p = Positions.TOP_LEFT;
                break;
            }
            case 8: {
                p = Positions.TOP_RIGHT;
                break;
            }
            default: {
                p = Positions.CENTER;
                break;
            }
        }
        return p;
    }
}