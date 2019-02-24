package soexample.bigfly.com.myweekdemo.bean;

/**
 * <p>文件描述：<p>
 * <p>作者：${吕飞}<p>
 * <p>创建时间：2019/2/24   13:41<p>
 * <p>更改时间：2019/2/24   13:41<p>
 * <p>版本号：1<p>
 */

public class CommodityListBean {
    /**
     * commodityId : 5
     * commodityName : 双头两用修容笔
     * masterPic : http://172.17.8.100/images/small/commodity/mzhf/cz/3/1.jpg
     * price : 39
     * saleNum : 156
     */

    private int commodityId;
    private String commodityName;
    private String masterPic;
    private int price;
    private int saleNum;

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getMasterPic() {
        return masterPic;
    }

    public void setMasterPic(String masterPic) {
        this.masterPic = masterPic;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
    }
}

