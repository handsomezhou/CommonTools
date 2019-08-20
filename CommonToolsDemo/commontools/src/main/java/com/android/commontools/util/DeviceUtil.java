package com.android.commontools.util;

/**
 * Created by handsomezhou on 2019/8/21.
 * Reference: https://www.jianshu.com/p/ca869aa2fd72
 */

public class DeviceUtil {
  /*  public static String getDeviceInfo(){
        StringBuffer deviceInfoSb=new StringBuffer();
        //[Xiaomi][cepheus][Xiaomi][MI 9][cepheus][cepheus][Xiaomi/cepheus/cepheus:9/PKQ1.181121.001/9.7.22:user/release-keys]
        deviceInfoSb.append(Constant.LEFT_SQUARE_BRACKETS).append(getDeviceManufacturer()).append(Constant.RIGHT_SQUARE_BRACKETS);
        deviceInfoSb.append(Constant.LEFT_SQUARE_BRACKETS).append(getDeviceProduct()).append(Constant.RIGHT_SQUARE_BRACKETS);
        deviceInfoSb.append(Constant.LEFT_SQUARE_BRACKETS).append(getDeviceBrand()).append(Constant.RIGHT_SQUARE_BRACKETS);
        deviceInfoSb.append(Constant.LEFT_SQUARE_BRACKETS).append(getDeviceModel()).append(Constant.RIGHT_SQUARE_BRACKETS);
        deviceInfoSb.append(Constant.LEFT_SQUARE_BRACKETS).append(getDeviceBoard()).append(Constant.RIGHT_SQUARE_BRACKETS);
        deviceInfoSb.append(Constant.LEFT_SQUARE_BRACKETS).append(getDeviceDevice()).append(Constant.RIGHT_SQUARE_BRACKETS);
        deviceInfoSb.append(Constant.LEFT_SQUARE_BRACKETS).append(getDeviceFingerprint()).append(Constant.RIGHT_SQUARE_BRACKETS);
        return deviceInfoSb.toString();
    }*/
    /**
     * 获取厂商名
     * **/
    public static String getDeviceManufacturer() {
        return android.os.Build.MANUFACTURER;
    }

    /**
     * 获取产品名
     * **/
    public static String getDeviceProduct() {
        return android.os.Build.PRODUCT;
    }

    /**
     * 获取手机品牌
     */
    public static String getDeviceBrand() {
        return android.os.Build.BRAND;
    }

    /**
     * 获取手机型号
     */
    public static String getDeviceModel() {
        return android.os.Build.MODEL;
    }

    /**
     * 获取手机主板名
     */
    public static String getDeviceBoard() {
        return android.os.Build.BOARD;
    }

    /**
     * 设备名
     * **/
    public static String getDeviceDevice() {
        return android.os.Build.DEVICE;
    }

    /**
     *
     * fingerprit 信息
     *
     * **/
    public static String getDeviceFingerprint() {
        return android.os.Build.FINGERPRINT;
    }
}
