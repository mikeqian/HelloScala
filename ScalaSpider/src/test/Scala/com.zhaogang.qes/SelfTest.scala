
import org.junit.Test


class SelfTest  {


  @Test def Test1 {
    val skuIds = "三级盘螺,HRB400,10;三级抗震螺纹钢,HPB400E,12*9;开平板,Q400B,1.1*1000*500;三级螺纹钢,HRB400,20*9;三级盘螺,HRB400,8;二级螺纹钢,HRB335,10*9;三级抗震螺纹钢,HPB400E,12*9;三级螺纹钢,HRB400,25*9;三级盘螺,HRB400,8;三级抗震盘螺,HRB400E,10;三级盘螺,HRB400,10;冷轧卷,0.8*1000,1*1650*C;三级盘螺,HRB400,8;三级螺纹钢,HRB400,14*9;三级盘螺,HRB400,8  "
    val spus = skuIds.split(";").map(_.trim).distinct.sortBy(a => a).toList
  }


  @Test def Test2 {

  }
}